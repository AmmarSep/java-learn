# Your Java learning path

[Home](../README.md) · [Setup](setup.md) · [Progress tracker](progress.md)

Use the short lessons as your main route. Each numbered lesson has **Previous / Next** links. The detailed guides are an alternative explanation, not a second course you must finish before writing code.

Short lessons use numbers **01–71**; examples and detailed guides retain their original **phases 0–7**. They are two views of the same material, not matching number systems.

## Read → run → practise

| Stage | Read in order | Run / study | You are ready to move on when… |
| --- | --- | --- | --- |
| 1. Setup | [Lessons 01–05](../lessons/01-intro/README.md) | [Getting started](../examples/00-getting-started/README.md) | You can explain source → bytecode → JVM and run a greeting. |
| 2. First steps | [Lessons 06–12](../lessons/02-first-steps/README.md) | `HelloWorld`, `Phase0_HelloWorld`, `Phase0_CommandLineArgs` | You can write `main`, print text, and pass arguments. |
| 3. Values and types | [Lessons 13–20](../lessons/03-values-types/README.md) | [Variables](../examples/01-fundamentals/01-variables/Phase1_Variables.java), [tiny calculation](../examples/00-getting-started/03-simple-calculation/SimpleCalculation.java) | You can choose a type and explain integer division and casts. |
| 4. Decisions and repetition | [Lessons 21–27](../lessons/04-operators-control/README.md) | [Fundamentals](../examples/01-fundamentals/README.md) | You can write FizzBuzz and calculate an array's statistics. |
| 5. Methods | [Lessons 28–31](../lessons/05-methods/README.md) | [Methods and memory](../examples/02-methods-and-memory/README.md) | You can return a value and explain mutation versus reassignment. |
| 6. Classes | [Lessons 32–42](../lessons/06-oop-basics/README.md) | [Classes and encapsulation](../examples/03-object-oriented-programming/README.md), [static/final](../examples/04-language-features/02-static-and-final/Phase4_Static_Final.java) | You can create independent objects and protect their state. |
| 7. Strings and collections | [Lessons 43–50](../lessons/07-strings-collections/README.md) | [Collections](../examples/05-collections/README.md) | You can choose between a list, set, and map for a problem. |
| 8. Object-oriented design | [Lessons 51–59](../lessons/08-advanced-oop/README.md) | [Inheritance and abstract classes](../examples/03-object-oriented-programming/README.md), [interfaces](../examples/04-language-features/README.md) | You can call different implementations through a shared type. |
| 9. Handling failures | [Lessons 60–63](../lessons/09-errors-files/README.md) | [Exceptions](../examples/06-exceptions-and-concurrency/01-exceptions/Phase6_Exceptions.java) | You can handle bad input and explain checked vs unchecked exceptions. |
| 10. Beyond the basics | [Lessons 64–71](../lessons/10-advanced/README.md) | [Collections/generics](../examples/05-collections/README.md), [code quality](../examples/07-code-quality/README.md) | You can build a small project and explain how you would test it. |

**Bonus after stage 9:** read the [concurrency guide](../guides/06-exceptions-and-concurrency.md), then run [the threads example](../examples/06-exceptions-and-concurrency/02-threads/Phase6_Threads.java). A race condition may not appear on every run; do not expect a fixed output order or unsafe counter value.

For any named program, use this command from the repository root:

```bash
python3 scripts/java.py run Phase1_Variables
```

## A manageable study session

- Read one or two lessons, not an entire folder at once.
- Spend at least as much time changing/running code as reading it.
- Pick the matching challenge in [Practice](../practice/README.md).
- Write one thing you learned and one thing you still cannot explain in [Progress](progress.md).
- Revisit earlier stages whenever a later example assumes knowledge you do not yet have.

## What is runnable, and what is reading only?

- All **21 `.java` files in `examples/`** are standalone runnable programs.
- Markdown code blocks are teaching snippets. Some omit imports, surrounding classes, or setup; they are not all standalone files.
- File I/O, enums, streams, date/time, and the project lesson currently have reading/snippets, not dedicated runnable companion projects.
- Lambdas appear in the collections/concurrency material, but there is no separate lambda or stream application.
- The unit-testing lesson discusses JUnit. No JUnit dependency or Java test project is bundled; the Python tests in `scripts/tests/` test the learning tools, not that lesson.
- Package/import examples describe language features; the supplied standalone programs intentionally remain in the default package.

Finish with a [small project](../practice/README.md) before adding frameworks or build tools.