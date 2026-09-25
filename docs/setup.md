# Setup and running examples

[Home](../README.md) · [Learning path](learning-path.md) · [Runner reference](../scripts/README.md)

## Requirements

- A **JDK 17 or newer**, with both `java` and `javac` on `PATH`. The runner targets Java 17; newer JDKs can compile that target.
- **Python 3.9+** for the convenience scripts. No Python packages need installing.
- IntelliJ IDEA is optional. You can also compile a single example directly without Python.

Check your tools in a terminal:

```bash
java -version
javac -version
python3 --version
```

If `javac` is missing, install/select a JDK, not just a runtime. If the versions do not match, correct `PATH`/`JAVA_HOME` to select the intended JDK. An `invalid target release: 17` message means the compiler is too old.

## Recommended: one command per example

Open a terminal at the `java-learn` repository root:

```bash
python3 scripts/java.py list
python3 scripts/java.py run Phase0_HelloWorld
python3 scripts/java.py run Phase0_CommandLineArgs hello "Java learner"
python3 scripts/java.py check
python3 scripts/java.py smoke
```

The argument example receives two arguments: `hello` and `Java learner`. Each example is compiled in its own temporary directory under `.build/`; its run also uses that temporary working directory. Runtime files made there are temporary, so put persistent exercise data in your own practice folder and use explicit paths.

The runner locates examples relative to its own script, not your terminal directory. From elsewhere, call it using its full path. `list` and help do not need Java installed.

## IntelliJ IDEA

1. Open **the `java-learn` root folder**, not an individual example or archived project.
2. In **File → Project Structure → Project**, select an installed JDK 17+. The existing SDK name `23` is retained for this machine; choose your own SDK if IntelliJ cannot resolve it. Language/bytecode level is 17.
3. Use the shared **Hello Java** or **Java Arguments** run configuration for a first run.
4. For other programs, open a source file and use the run icon beside `main`.
5. A breakpoint beside a line and **Debug** let you step through the example and inspect variables.

Each example folder has its own module under `.idea/modules/`, with its own compiler output and no dependency on sibling examples. The root module is only a content/navigation container. Do not merge them into a single Java source root: helper names such as `Dog`, `Animal`, and `Counter` recur intentionally.

If a saved personal run configuration refers to the old root module, choose the module named after that example instead. Shared module XML is versioned; personal workspace state is ignored. Archived IDE files are historical, not a second project to import.

## Direct `javac` / `java`, without Python

From the repository root:

```bash
mkdir -p .build/manual-hello
javac --release 17 -encoding UTF-8 -d .build/manual-hello examples/00-getting-started/04-program-structure/Phase0_HelloWorld.java
java -cp .build/manual-hello Phase0_HelloWorld
```

Use a **different clean output directory for each example**. Do not use `javac` on every lesson at once. Commands in the old source comments assume that you are inside that individual example's folder; the runner is the easier way to avoid leaving `.class` files there.

## Verify the repository

```bash
python3 scripts/java.py smoke
python3 scripts/check_structure.py
python3 -m unittest discover -s scripts/tests -v
```

Compilation and smoke checks apply to the runnable examples, not every Markdown snippet. The thread demonstration has intentionally variable output; the exception demonstration catches and prints expected exceptions.