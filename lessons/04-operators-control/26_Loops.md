[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](25_Switch.md) · [Next](27_Arrays.md)

**Runnable companion:** [Phase1_ControlFlow](../../examples/01-fundamentals/03-control-flow/Phase1_ControlFlow.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 26: Loops — `for`, `while`, `do while`

## Simple Explanation

A **loop** repeats a block of code multiple times. Instead of writing the same code 100 times, you write it once inside a loop.

**Analogy:** "Do 10 push-ups" is a loop — you repeat the same action 10 times.

## The `for` Loop

The most common loop. Use it when you **know how many times** to repeat.

```java
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello " + i);
        }
    }
}
```

**Output:**
```
Hello 0
Hello 1
Hello 2
Hello 3
Hello 4
```

### Symbol-by-symbol breakdown of `for (int i = 0; i < 5; i++)`:

- `for` — A Java **keyword** that starts a for loop.
- `(` — Opening parenthesis. Inside are three parts, separated by semicolons.
- `int i = 0` — **Part 1: Initialization**. Create a variable `i` starting at `0`. This runs once at the beginning.
- `;` — Semicolon separating part 1 from part 2.
- `i < 5` — **Part 2: Condition**. Before each repeat, check: is `i` less than 5? If `true`, run the loop body. If `false`, stop the loop.
- `;` — Semicolon separating part 2 from part 3.
- `i++` — **Part 3: Update**. After each repeat, add 1 to `i`. This moves us toward the end.
- `)` — Closing parenthesis.
- `{` — Opening curly brace. Start of the loop body.
- `System.out.println("Hello " + i);` — The code that repeats.
- `}` — Closing curly brace. End of the loop body.

### How it executes step by step:

| Step | `i` value | `i < 5`? | Action |
|------|-----------|----------|--------|
| 1 | 0 | true | Print "Hello 0", then i++ |
| 2 | 1 | true | Print "Hello 1", then i++ |
| 3 | 2 | true | Print "Hello 2", then i++ |
| 4 | 3 | true | Print "Hello 3", then i++ |
| 5 | 4 | true | Print "Hello 4", then i++ |
| 6 | 5 | false | **Stop!** Loop ends. |

## The `while` Loop

Use it when you **don't know** how many times to repeat — you just have a condition.

```java
public class Main {
    public static void main(String[] args) {
        int count = 0;

        while (count < 3) {
            System.out.println("Count: " + count);
            count++;
        }
    }
}
```

**Output:**
```
Count: 0
Count: 1
Count: 2
```

### Symbol-by-symbol breakdown:

- `while` — A Java **keyword** that starts a while loop.
- `(` — Opening parenthesis.
- `count < 3` — The **condition**. Before each repeat, check: is `count` less than 3?
- `)` — Closing parenthesis.
- `{` — Opening curly brace. Start of the loop body.
- `System.out.println("Count: " + count);` — Code that repeats.
- `count++` — **Update** the variable. Without this, the loop would run forever!
- `}` — Closing curly brace.

**Important:** A `while` loop checks the condition **before** running. If the condition is `false` from the start, the body never runs.

## The `do-while` Loop

Same as `while`, but it runs the body **at least once** before checking the condition.

```java
public class Main {
    public static void main(String[] args) {
        int count = 5;

        do {
            System.out.println("Count: " + count);
            count++;
        } while (count < 3);
    }
}
```

**Output:**
```
Count: 5
```

Even though `count` (5) is not less than 3, the body ran once because `do-while` checks the condition **after** running.

### Symbol-by-symbol breakdown:

- `do` — A Java **keyword** meaning "do this first."
- `{` — Opening curly brace.
- Code to run.
- `}` — Closing curly brace.
- `while` — Then check the condition.
- `(count < 3)` — The condition.
- `;` — **Semicolon!** A `do-while` ends with a semicolon after the condition. This is different from a regular `while` loop.

## `break` and `continue`

### `break` — Exit the loop immediately

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;    // Stop the loop when i is 5
    }
    System.out.println(i);
}
// Output: 0 1 2 3 4
```

### `continue` — Skip to the next iteration

```java
for (int i = 0; i < 5; i++) {
    if (i == 2) {
        continue;    // Skip the rest of this iteration when i is 2
    }
    System.out.println(i);
}
// Output: 0 1 3 4  (2 is skipped!)
```

## Infinite Loops (Be Careful!)

A loop that never stops:

```java
// DON'T DO THIS (unless intentional):
while (true) {
    System.out.println("This never stops!");
}

// Also infinite:
for (;;) {
    System.out.println("Forever!");
}
```

If your program seems "stuck," you might have an infinite loop. Press `Ctrl+C` in the terminal to stop it.

## Common Beginner Mistakes

1. **Infinite loop** — Forgetting to update the variable (`count++`), so the condition is always true.
2. **Off-by-one error** — Using `<=` instead of `<` (or vice versa), causing one extra or one fewer iteration.
3. **Forgetting the semicolon in `do-while`** — `} while (condition);` needs the `;`.
4. **Using the wrong loop** — Use `for` when you know the count. Use `while` when you have a condition.
5. **Modifying the loop variable inside the loop** — This can cause unexpected behavior.

## Mini Practice Exercise

**Task:** Write a loop that prints all even numbers from 2 to 10.

**Answer:**
```java
public class Main {
    public static void main(String[] args) {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
        }
    }
}
```

**Output:** `2 4 6 8 10` (each on its own line)

## Quiz

1. How many times does `for (int i = 0; i < 3; i++)` run?
   - a) 2
   - b) 3 ✅
   - c) 4

2. What is the difference between `while` and `do-while`?
   - a) They are the same
   - b) `do-while` always runs at least once ✅
   - c) `while` always runs at least once

3. What does `break` do in a loop?
   - a) Skips one iteration
   - b) Exits the loop completely ✅
   - c) Restarts the loop

4. What does `continue` do?
   - a) Exits the loop
   - b) Skips to the next iteration ✅
   - c) Stops the program

---
**Next Lesson:** [Lesson 27 — Arrays](27_Arrays.md)
