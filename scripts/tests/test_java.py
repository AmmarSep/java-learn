"""Focused runner tests using temporary repositories and real JDK tools."""

import contextlib
import importlib.util
import io
import os
from pathlib import Path
import shutil
import subprocess
import sys
import tempfile
import unittest
from unittest import mock


RUNNER = Path(__file__).resolve().parents[1] / "java.py"
SPEC = importlib.util.spec_from_file_location("java_runner", RUNNER)
java_runner = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(java_runner)


class RunnerTests(unittest.TestCase):
    def setUp(self):
        build_root = RUNNER.parent.parent / ".build"
        build_root.mkdir(exist_ok=True)
        temporary = tempfile.TemporaryDirectory(prefix="runner tests ", dir=build_root)
        self.addCleanup(temporary.cleanup)
        self.root = Path(temporary.name) / "repository with spaces"
        self.runner = self.root / "scripts" / "java.py"
        self.runner.parent.mkdir(parents=True)
        shutil.copyfile(RUNNER, self.runner)
        self.other_cwd = Path(temporary.name) / "unrelated working directory"
        self.other_cwd.mkdir()

    def source(self, relative_path, content):
        path = self.root / "examples" / relative_path
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(content, encoding="utf-8")
        return path

    def cli(self, *arguments, env=None, input=None):
        return subprocess.run(
            [sys.executable, "-B", str(self.runner), *arguments],
            cwd=self.other_cwd,
            env=env,
            input=input,
            capture_output=True,
            text=True,
            timeout=30,
        )

    def assert_success(self, result):
        self.assertEqual(result.returncode, 0, result.stdout + result.stderr)

    def assert_clean_build(self):
        self.assertEqual(list((self.root / ".build").iterdir()), [])
        self.assertEqual(list(self.root.rglob("*.class")), [])

    def test_sorted_discovery_and_selection(self):
        last = self.source("02-topic/01-example/Alpha.java", "class Alpha {}")
        middle = self.source("01-topic/02-example/Zeta.java", "class Zeta {}")
        first = self.source("01-topic/01-example/Beta.java", "class Beta {}")
        (self.root / "Ignored.java").write_text("class Ignored {}", encoding="utf-8")
        examples = java_runner.discover_examples(self.root)
        self.assertEqual(examples, [first, middle, last])
        self.assertEqual(java_runner.select_example(examples, "Zeta", self.root), middle)

    def test_help_and_list_need_no_jdk(self):
        self.source("02-topic/01-example/Alpha.java", "class Alpha {}")
        self.source("01-topic/01-example/Beta.java", "class Beta {}")
        env = dict(os.environ, PATH="")
        for arguments in [("--help",), ("run", "--help"), ("check", "--help")]:
            with self.subTest(arguments=arguments):
                result = self.cli(*arguments, env=env)
                self.assert_success(result)
                self.assertIn("usage:", result.stdout)
        result = self.cli("list", env=env)
        self.assert_success(result)
        self.assertLess(result.stdout.index("Beta"), result.stdout.index("Alpha"))
        self.assertIn("examples/01-topic/01-example/Beta.java", result.stdout)
        self.assertIn("2 example(s)", result.stdout)
        self.assertFalse((self.root / ".build").exists())

    def test_unknown_and_ambiguous_class_fail_before_tool_lookup(self):
        first = self.source("01-topic/01-example/Duplicate.java", "class Duplicate {}")
        second = self.source("02-topic/01-example/Duplicate.java", "class Duplicate {}")
        env = dict(os.environ, PATH="")
        result = self.cli("run", "Missing", env=env)
        self.assertNotEqual(result.returncode, 0)
        self.assertIn("Unknown class 'Missing'", result.stderr)
        self.assertIn("list", result.stderr)
        result = self.cli("run", "Duplicate", env=env)
        self.assertNotEqual(result.returncode, 0)
        self.assertIn("Ambiguous class 'Duplicate'", result.stderr)
        self.assertIn(first.relative_to(self.root).as_posix(), result.stderr)
        self.assertIn(second.relative_to(self.root).as_posix(), result.stderr)

    def test_invalid_usage(self):
        for arguments in [(), ("unknown",), ("run",), ("list", "--unknown")]:
            with self.subTest(arguments=arguments):
                result = self.cli(*arguments)
                self.assertEqual(result.returncode, 2)
                self.assertIn("usage:", result.stderr)
                self.assertNotIn("Traceback", result.stderr)

    def test_empty_discovery(self):
        result = self.cli("list", env=dict(os.environ, PATH=""))
        self.assert_success(result)
        self.assertIn("0 example(s)", result.stdout)
        for command in ["check", "smoke"]:
            with self.subTest(command=command):
                result = self.cli(command)
                self.assertNotEqual(result.returncode, 0)
                self.assertIn("No Java examples", result.stderr)

    def test_missing_tools(self):
        self.source("01-topic/01-example/Hello.java", "class Hello {}")
        result = self.cli("check", env=dict(os.environ, PATH=""))
        self.assertNotEqual(result.returncode, 0)
        self.assertIn("javac", result.stderr)
        self.assertIn("PATH", result.stderr)
        self.assertIn("JDK 17+", result.stderr)
        with mock.patch.dict(os.environ, {"PATH": ""}):
            with self.assertRaisesRegex(java_runner.RunnerError, "java.*PATH"):
                java_runner.require_tool("java")

    def test_exact_arguments_unicode_and_independent_cwd(self):
        self.source(
            "01-topic/01-example/Arguments.java",
            '''public class Arguments {
                public static void main(String[] args) {
                    System.out.println("café ☃");
                    for (String arg : args) System.out.println("[" + arg + "]");
                }
            }''',
        )
        arguments = ["--", "two words", "-x", "--help", "", "☃", "--name=value"]
        result = self.cli("run", "Arguments", *arguments)
        self.assert_success(result)
        self.assertEqual(result.stdout.splitlines(), ["café ☃"] + ["[" + arg + "]" for arg in arguments])
        self.assert_clean_build()

    def test_check_compiles_without_running_and_targets_java_17(self):
        self.source(
            "01-topic/01-example/Version.java",
            '''import java.nio.file.Files;
            import java.nio.file.Path;
            public class Version {
                public static void main(String[] args) throws Exception {
                    byte[] bytes = Files.readAllBytes(Path.of("Version.class"));
                    int major = (bytes[6] & 255) * 256 + (bytes[7] & 255);
                    if (major != 61) throw new AssertionError("class version " + major);
                    System.out.println("version-17");
                }
            }''',
        )
        result = self.cli("check")
        self.assert_success(result)
        self.assertIn("1 passed, 0 failed", result.stdout)
        self.assertNotIn("version-17", result.stdout)
        result = self.cli("run", "Version")
        self.assert_success(result)
        self.assertEqual(result.stdout.strip(), "version-17")
        self.assert_clean_build()

    def test_same_named_helpers_are_isolated(self):
        for index, name in enumerate(["First", "Second"], start=1):
            self.source(
                "01-topic/{:02d}-example/{}.java".format(index, name),
                '''public class %s {
                    public static void main(String[] args) {
                        if (!Dog.value().equals("%s")) throw new AssertionError();
                        System.out.println(Dog.value());
                    }
                }
                class Dog { static String value() { return "%s"; } }''' % (name, name, name),
            )
        result = self.cli("smoke", env=dict(os.environ, CLASSPATH=str(self.root)))
        self.assert_success(result)
        self.assertIn("First", result.stdout.splitlines())
        self.assertIn("Second", result.stdout.splitlines())
        self.assertIn("2 passed, 0 failed", result.stdout)
        self.assert_clean_build()

    def test_compile_failures_aggregate_and_do_not_run_broken_class(self):
        self.source(
            "01-topic/01-example/Broken.java",
            '''public class Broken {
                public static void main(String[] args) { System.out.println("must-not-run"); }
                this is invalid Java
            }''',
        )
        self.source(
            "01-topic/02-example/Healthy.java",
            '''public class Healthy {
                public static void main(String[] args) { System.out.println("healthy-ran"); }
            }''',
        )
        for command in ["check", "smoke"]:
            with self.subTest(command=command):
                result = self.cli(command)
                self.assertNotEqual(result.returncode, 0)
                self.assertIn("Compilation failed", result.stderr)
                self.assertIn("Broken.java", result.stderr)
                self.assertIn("1 passed, 1 failed", result.stdout)
                self.assertNotIn("must-not-run", result.stdout)
                if command == "smoke":
                    self.assertIn("healthy-ran", result.stdout)
                self.assert_clean_build()
        result = self.cli("run", "Broken")
        self.assertNotEqual(result.returncode, 0)
        self.assertIn("Compilation failed", result.stderr)
        self.assert_clean_build()

    def test_runtime_failure_aggregates_and_returns_nonzero(self):
        self.source(
            "01-topic/01-example/Failure.java",
            '''public class Failure {
                public static void main(String[] args) { System.exit(7); }
            }''',
        )
        self.source(
            "01-topic/02-example/Healthy.java",
            '''public class Healthy {
                public static void main(String[] args) { System.out.println("still-ran"); }
            }''',
        )
        result = self.cli("run", "Failure")
        self.assertNotEqual(result.returncode, 0)
        self.assertIn("Runtime failed (exit code 7)", result.stderr)
        result = self.cli("smoke")
        self.assertNotEqual(result.returncode, 0)
        self.assertIn("Runtime failed (exit code 7)", result.stderr)
        self.assertIn("still-ran", result.stdout)
        self.assertIn("1 passed, 1 failed", result.stdout)
        self.assert_clean_build()

    def test_fresh_build_contains_and_cleans_file_artifacts(self):
        self.source(
            "01-topic/01-example/Writer.java",
            '''import java.nio.file.Files;
            import java.nio.file.Path;
            public class Writer {
                public static void main(String[] args) throws Exception {
                    Path artifact = Path.of("artifact.txt");
                    if (Files.exists(artifact)) throw new AssertionError("stale artifact");
                    Files.writeString(artifact, "temporary");
                    System.out.println(Path.of("").toAbsolutePath());
                }
            }''',
        )
        working_directories = []
        for _ in range(2):
            result = self.cli("run", "Writer")
            self.assert_success(result)
            cwd = Path(result.stdout.strip())
            self.assertEqual(cwd.parent, self.root / ".build")
            self.assertFalse(cwd.exists())
            working_directories.append(cwd)
            self.assert_clean_build()
        self.assertNotEqual(*working_directories)
        self.assertEqual(list(self.root.rglob("artifact.txt")), [])
        self.assertEqual(list(self.other_cwd.iterdir()), [])

    def test_normal_run_inherits_stdin_but_smoke_gets_eof(self):
        self.source(
            "01-topic/01-example/Input.java",
            '''public class Input {
                public static void main(String[] args) throws Exception {
                    System.out.println(System.in.read());
                }
            }''',
        )
        result = self.cli("run", "Input", input="A")
        self.assert_success(result)
        self.assertEqual(result.stdout.strip(), "65")
        result = self.cli("smoke", input="A")
        self.assert_success(result)
        self.assertIn("-1", result.stdout.splitlines())
        self.assertIn("1 passed, 0 failed", result.stdout)
        self.assert_clean_build()

    def test_smoke_timeout_is_reported_and_next_example_still_runs(self):
        self.source(
            "01-topic/01-example/Slow.java",
            '''public class Slow {
                public static void main(String[] args) throws Exception {
                    Thread.sleep(60000);
                }
            }''',
        )
        self.source(
            "01-topic/02-example/Healthy.java",
            '''public class Healthy { public static void main(String[] args) {} }''',
        )
        stdout, stderr = io.StringIO(), io.StringIO()
        with mock.patch.object(java_runner, "REPO_ROOT", self.root):
            with mock.patch.object(java_runner, "SMOKE_TIMEOUT", 1):
                with contextlib.redirect_stdout(stdout), contextlib.redirect_stderr(stderr):
                    status = java_runner.main(["smoke"])
        self.assertNotEqual(status, 0)
        self.assertIn("Runtime timed out", stderr.getvalue())
        self.assertIn("Slow.java", stderr.getvalue())
        self.assertIn("1 passed, 1 failed", stdout.getvalue())
        self.assert_clean_build()


if __name__ == "__main__":
    unittest.main()