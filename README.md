# Java learning, one topic at a time

**Start here → [Learning path](docs/learning-path.md)** · [Setup](docs/setup.md) · [Progress](docs/progress.md)

One home for **71 short lessons**, **8 detailed guide chapters**, and **21 runnable examples**. Read a little, predict the output, run one program, then change it yourself.

## Your first session

1. Follow the [setup guide](docs/setup.md): JDK 17+ and Python 3.9+ for the optional runner.
2. Read [What is programming?](lessons/01-intro/01_What_Is_Programming.md), then follow **Next** through the lessons.
3. From this repository's root, run your first example:

```bash
python3 scripts/java.py run Phase0_HelloWorld
python3 scripts/java.py run Phase0_CommandLineArgs hello "Java learner"
```

The first command prints `Hello, Java!`. IntelliJ users can open this folder and select the shared **Hello Java** run configuration instead.

## Find what you need

| Location | Use it for |
| --- | --- |
| [Learning path](docs/learning-path.md) | What to study next, with reading → code → practice |
| [Short lessons](lessons/README.md) | Small, numbered explanations grouped into ten topics |
| [Detailed guides](guides/README.md) | Deeper explanations, split by phase instead of one huge file |
| [Runnable examples](examples/README.md) | 3 tiny starters and 18 explained programs, ordered by phase |
| [Reference](reference/README.md) | Syntax lookup and the detailed code index |
| [Practice](practice/README.md) | Exercises and project prompts for your own solutions |
| [Progress tracker](docs/progress.md) | Record what you can actually explain and build |
| [Scripts](scripts/README.md) | List, compile, and run examples without class-name conflicts |
| [Archive](archive/README.md) | Historical overviews and old IDE settings; not the learning path |

## A repeatable learning loop

1. **Read** one lesson; use the detailed guide only when you need more depth.
2. **Predict** what its companion program will print.
3. **Run** it and explain any difference.
4. **Modify** a value, condition, or method and run again.
5. **Build** the small exercise without copying, then tick off [your progress](docs/progress.md).

## Keep lessons independent

Examples deliberately reuse helper names such as `Dog`, `Animal`, and `Counter`. **Do not compile all Java files together or mark all of `examples/` as one source root.** The runner and IntelliJ modules isolate each example while preserving the original Java code.

```bash
python3 scripts/java.py list    # Find a program
python3 scripts/java.py check   # Compile every example independently
python3 scripts/java.py smoke   # Compile and run every example
python3 scripts/check_structure.py
```

Build products stay in ignored `.build/` or `out/`. There is no Maven/Gradle dependency to learn before your first program. Later Markdown lessons include snippets and project ideas, not additional ready-to-run projects; JUnit setup is not bundled.

Looking for an old path? Use the [migration map](docs/migration-map.md). Original lesson numbers and Java filenames are preserved. Twenty Java files are unchanged; one invalid `instanceof` demonstration was corrected so the inheritance example compiles.