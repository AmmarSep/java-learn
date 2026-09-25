# Java example runner

Return to the [root learning map](../README.md) for the recommended study order.
The repository has **21 isolated examples** under
`examples/<NN-topic>/<NN-example>/<OriginalClassName>.java`.
Each source is a standalone, default-package program. Repeated helper names such
as `Dog`, `Animal`, and `Counter` are intentional: **never compile all examples
together**.

## Requirements

- **Python 3.9+**, standard library only; no dependencies to install.
- **JDK 17+** with `javac` and `java` on `PATH`. `list` and help need no JDK;
  `check` only needs `javac`.
- Prefer direct JDK commands? Follow the [direct `javac` fallback](../docs/setup.md).

## Commands

Run these from the repository root:

```sh
python3 scripts/java.py --help
python3 scripts/java.py list
python3 scripts/java.py check
python3 scripts/java.py smoke
python3 scripts/java.py run CLASS
python3 scripts/java.py run CLASS "argument with spaces" --flag
```

Replace `CLASS` with an exact, case-sensitive name from `list`, without `.java`.
`list` reports class names, source paths, and a count in sorted learning order.
Unknown names fail with guidance; ambiguous names fail with all matching paths
rather than silently selecting a file. To run an ambiguous name, use the direct
compilation instructions linked above for the desired source.

- `check` compiles each example independently without running it.
- `smoke` compiles and runs each example independently, continues after failures,
  and reports passed/failed/total counts. Compilation has a **30-second timeout**
  per example; smoke execution has a **10-second timeout** per example, allowing
  the threading demonstrations to finish. Smoke input is closed (`DEVNULL`), so
  an interactive example sees EOF rather than waiting for input.
- `run` compiles one example and allows normal interactive input with no runtime
  timeout. Every argument after `CLASS` is forwarded literally, including spaces,
  empty strings, dash-prefixed arguments, `--help`, and `--`. These are program
  arguments, **not JVM options**. Use `run --help` for runner help.

The runner locates the repository from its own file, not the current directory.
From any other directory, invoke `python3 "/path with spaces/java-learn/scripts/java.py" list`.

## Isolation and failures

Every compilation uses `javac --release 17 -encoding UTF-8`, with one source file
and a fresh temporary output directory under the repository's `.build/`.
The compiler's classpath and source path, and the runtime classpath, point only
to that directory; no previous example's classes or ambient `CLASSPATH` are reused.
Compilation and execution both use this directory as their working directory.
Relative output files stay there and are removed along with the classes on
completion, including after failures or smoke timeouts. An empty `.build/`
directory may remain. This is build isolation, not a security sandbox: programs
can still access absolute paths or explicitly navigate outside their working directory.

Compiler diagnostics and program output remain visible. A compilation failure
prevents that example from running. `check` and `smoke` aggregate example failures
and return a nonzero exit status if any fail. Missing tools, unknown or ambiguous
classes, and runtime failures also return nonzero; invalid command syntax exits
with status `2`. Empty discovery is valid for `list`, but fails `check`/`smoke`
instead of misleadingly reporting success.

## Structure checks and tests

Validate the lesson sequence, local Markdown links/headings, and isolated IntelliJ module paths:

```sh
python3 scripts/check_structure.py
```

From the repository root, with Python 3.9+ and a real JDK 17+ installed:

```sh
python3 -B -m unittest discover -s scripts/tests -v
```

Runner tests create and clean up tiny temporary repositories under `.build/`. They cover discovery and selection,
help/list without a JDK, errors, Java 17 compilation, exact argument forwarding,
paths with spaces and unrelated working directories, duplicate helper names,
file cleanup, input handling, smoke timeouts, and aggregated failures. They use
the real `javac` and `java` from `PATH`, not substitute compilers or runtimes.

Navigation tests check valid and broken links, heading anchors, and teaching code fences. A learning-example regression test compiles and runs the inheritance example and checks its runtime type tests and method dispatch. Use `smoke` to execute the full set of examples.