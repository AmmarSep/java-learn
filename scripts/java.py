#!/usr/bin/env python3
"""Compile and run the repository's default-package examples independently."""

import argparse
from pathlib import Path
import shutil
import subprocess
import sys
import tempfile
from typing import List, Optional, Sequence


REPO_ROOT = Path(__file__).resolve().parent.parent
COMPILE_TIMEOUT = 30
SMOKE_TIMEOUT = 10


class RunnerError(Exception):
    """An actionable discovery, tool, compilation, or execution failure."""


def discover_examples(root: Path) -> List[Path]:
    return sorted(
        (path for path in (root / "examples").rglob("*.java") if path.is_file()),
        key=lambda path: path.relative_to(root).as_posix(),
    )


def select_example(examples: Sequence[Path], class_name: str, root: Path) -> Path:
    matches = [source for source in examples if source.stem == class_name]
    if not matches:
        raise RunnerError(
            "Unknown class {!r}. Use 'python3 scripts/java.py list' to see class names."
            .format(class_name)
        )
    if len(matches) > 1:
        paths = "\n".join("  " + source.relative_to(root).as_posix() for source in matches)
        raise RunnerError(
            "Ambiguous class {!r}; matching examples:\n{}\n"
            "Class names must be unique for 'run'; see docs/setup.md to compile one directly."
            .format(class_name, paths)
        )
    return matches[0]


def require_tool(name: str) -> str:
    executable = shutil.which(name)
    if executable is None:
        raise RunnerError(
            "Required tool {!r} not found on PATH. Install JDK 17+ and add its bin directory to PATH."
            .format(name)
        )
    return str(Path(executable).resolve())


def run_process(
    command: Sequence[str],
    build: Path,
    stage: str,
    timeout: Optional[float],
    stdin=None,
) -> None:
    try:
        result = subprocess.run(command, cwd=build, stdin=stdin, timeout=timeout)
    except subprocess.TimeoutExpired as error:
        raise RunnerError("{} timed out after {} seconds.".format(stage, timeout)) from error
    except OSError as error:
        raise RunnerError("{} could not start: {}".format(stage, error)) from error
    if result.returncode != 0:
        raise RunnerError("{} failed (exit code {}).".format(stage, result.returncode))


def execute_example(
    source: Path,
    root: Path,
    javac: str,
    java: Optional[str] = None,
    arguments: Sequence[str] = (),
    smoke: bool = False,
) -> None:
    build_root = root / ".build"
    build_root.mkdir(exist_ok=True)
    with tempfile.TemporaryDirectory(prefix=source.stem + "-", dir=build_root) as directory:
        build = Path(directory)
        run_process(
            [
                javac, "--release", "17", "-encoding", "UTF-8",
                "-classpath", str(build), "-sourcepath", str(build),
                "-d", str(build), str(source),
            ],
            build,
            "Compilation",
            COMPILE_TIMEOUT,
            stdin=subprocess.DEVNULL,
        )
        if java is not None:
            run_process(
                [java, "-cp", str(build), source.stem, *arguments],
                build,
                "Runtime",
                SMOKE_TIMEOUT if smoke else None,
                stdin=subprocess.DEVNULL if smoke else None,
            )


def make_parser() -> argparse.ArgumentParser:
    parser = argparse.ArgumentParser(
        description="Compile and run Java examples in separate temporary build directories.",
        epilog="Requires Python 3.9+ and JDK 17+ on PATH (list/help need no JDK).",
    )
    commands = parser.add_subparsers(dest="command", required=True)
    commands.add_parser("list", help="list class names and source paths in learning order")
    commands.add_parser("check", help="compile every example separately; do not run it")
    commands.add_parser("smoke", help="compile and run every example separately with timeouts")
    run = commands.add_parser("run", help="compile and run one class, forwarding its arguments")
    run.add_argument("class_name", metavar="CLASS", help="exact class name from list (without .java)")
    run.add_argument(
        "arguments", metavar="args", nargs=argparse.REMAINDER,
        help="program arguments; everything after CLASS is passed unchanged, including --help and --",
    )
    return parser


def main(argv: Optional[Sequence[str]] = None) -> int:
    parser = make_parser()
    arguments = list(sys.argv[1:] if argv is None else argv)
    forwarded = []
    if arguments[:1] == ["run"] and len(arguments) >= 2:
        # argparse otherwise consumes a literal -- immediately following CLASS.
        forwarded = arguments[2:]
        arguments = arguments[:2]
    options = parser.parse_args(arguments)
    try:
        examples = discover_examples(REPO_ROOT)
        if options.command == "list":
            for source in examples:
                print("{}\t{}".format(source.stem, source.relative_to(REPO_ROOT).as_posix()))
            print("{} example(s).".format(len(examples)))
            return 0

        if options.command == "run":
            source = select_example(examples, options.class_name, REPO_ROOT)
            try:
                execute_example(
                    source, REPO_ROOT, require_tool("javac"), require_tool("java"), forwarded,
                )
            except (RunnerError, OSError) as error:
                raise RunnerError("{}: {}".format(source.relative_to(REPO_ROOT).as_posix(), error)) from error
            return 0

        if not examples:
            raise RunnerError("No Java examples found under {}.".format(REPO_ROOT / "examples"))
        javac = require_tool("javac")
        java = require_tool("java") if options.command == "smoke" else None
        failures = 0
        for source in examples:
            relative_path = source.relative_to(REPO_ROOT).as_posix()
            print("{}: {}".format(options.command, relative_path), flush=True)
            try:
                execute_example(source, REPO_ROOT, javac, java, smoke=options.command == "smoke")
            except (RunnerError, OSError) as error:
                failures += 1
                print("FAIL {}: {}".format(relative_path, error), file=sys.stderr, flush=True)
            else:
                print("PASS {}".format(relative_path), flush=True)
        print("{}: {} passed, {} failed ({} total).".format(
            options.command, len(examples) - failures, failures, len(examples),
        ))
        return 1 if failures else 0
    except (RunnerError, OSError) as error:
        print("error: {}".format(error), file=sys.stderr)
        return 1
    except KeyboardInterrupt:
        print("Interrupted.", file=sys.stderr)
        return 130


if __name__ == "__main__":
    sys.exit(main())