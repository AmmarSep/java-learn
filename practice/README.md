# Practice: build it yourself

[Home](../README.md) · [Learning path](../docs/learning-path.md) · [Progress](../docs/progress.md)

Keep your own solutions here in numbered, descriptive folders such as `01-greeting/` and `02-calculator/`. Do not mix unrelated default-package classes into one compilation unit. These are **prompts**, not completed programs.

The example runner only discovers `examples/`; your experiments stay separate from the verified teaching examples. For a new `practice/01-greeting/Greeting.java`, run from the repository root:

```bash
mkdir -p .build/practice-greeting
javac --release 17 -d .build/practice-greeting practice/01-greeting/Greeting.java
java -cp .build/practice-greeting Greeting
```

Create the source file first. In IntelliJ, add each new exercise as its own module/source folder with no dependency on the sample modules, or use the terminal commands above. Add new exercises with the next continuous two-digit number.

## Small challenges

| Challenge | After learning | Check your result |
| --- | --- | --- |
| 01 Greeting | First programs | No arguments gives a friendly default; `Ammar` gives a personalized greeting. |
| 02 Calculator | Types and operators | `5 + 3` is `8`; compare `5 / 2` with `5.0 / 2`. |
| 03 FizzBuzz | Conditions and loops | Print 1–30; 3 → Fizz, 5 → Buzz, 15 → FizzBuzz. |
| 04 Array statistics | Arrays and methods | For `[2, 4, 6]`, min = 2, max = 6, average = 4.0; decide what an empty array means. |
| 05 Pass-by-value experiment | Methods and memory | Show why changing an array element is visible to the caller but reassigning the parameter is not. |
| 06 Library book | Classes and encapsulation | Borrow and return a book; borrowing an already borrowed book must not silently succeed. |
| 07 Word frequencies | Strings and collections | `java java code` produces java → 2, code → 1; handle empty input. |
| 08 Shapes | Interfaces and polymorphism | Calculate areas for two shapes through one interface; reject negative dimensions. |
| 09 Safe number parser | Exceptions | Accept `42`, handle `oops`, and decide how to handle empty input. |
| 10 File-backed notes | File I/O | Save and reload two notes; handle a missing file without losing existing data. |

For every challenge: predict the output, run it, try an edge case, and explain one mistake you fixed.

## Projects after the basics

Choose one; do not start all three at once.

- **Command-line todo list:** add/list/complete tasks, then save/load them. Test an empty list and an invalid task number.
- **Contact book:** store contacts in a map, search by name, and handle duplicates explicitly. Add file storage only after the in-memory version works.
- **Quiz game:** model questions as objects, calculate a score, and validate answers. Start with fixed question order so results are repeatable.

Use the [project lesson](../lessons/10-advanced/71_Projects.md) for more guidance. Before adding frameworks, explain your classes, error handling, collection choices, and how you would test the project.