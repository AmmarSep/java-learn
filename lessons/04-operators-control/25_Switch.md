[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](24_If_Else.md) · [Next](26_Loops.md)

**Runnable companion:** [Phase1_ControlFlow](../../examples/01-fundamentals/03-control-flow/Phase1_ControlFlow.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 25: `switch`

## Simple Explanation

A **`switch` statement** checks a single variable against multiple possible values. It's an alternative to writing many `if-else if` chains when you're comparing one value against several options.

**Analogy:** Think of a vending machine — you press button 1, 2, 3, or 4, and each button gives you a different snack.

## Basic `switch` Statement

```java
public class Main {
    public static void main(String[] args) {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
                break;
        }
    }
}
```

**Output:** `Wednesday`

### Symbol-by-symbol breakdown:

- `switch` — A Java **keyword** that starts a switch statement. It means "look at this value and match it."
- `(` — Opening parenthesis.
- `day` — The variable being checked.
- `)` — Closing parenthesis.
- `{` — Opening curly brace. Start of the switch block.
- `case 1:` — The keyword `case` followed by a value and a **colon** `:`. It means "if `day` equals `1`, start running code here."
- `System.out.println("Monday");` — The code to run for this case.
- `break;` — A **keyword** that means "stop here and exit the switch." Without `break`, Java keeps running the next cases too!
- `case 2:` — Another case to check.
- `default:` — A **keyword** meaning "if none of the cases matched, run this." It's like the `else` of a switch.
- `}` — Closing curly brace. End of the switch block.

## The `break` Statement (Important!)

`break` tells Java to **stop** and exit the switch block. Without it, Java "falls through" to the next case:

```java
int x = 2;

// WITHOUT break (fall-through — usually a bug!)
switch (x) {
    case 1:
        System.out.println("One");
    case 2:
        System.out.println("Two");
    case 3:
        System.out.println("Three");
}
// Output:
// Two
// Three    ← This also prints! Java "fell through" from case 2 to case 3.
```

**Always use `break` unless you intentionally want fall-through!**

## Switch with Strings

You can also switch on Strings:

```java
String color = "red";

switch (color) {
    case "red":
        System.out.println("Stop!");
        break;
    case "yellow":
        System.out.println("Caution!");
        break;
    case "green":
        System.out.println("Go!");
        break;
    default:
        System.out.println("Unknown color");
        break;
}
```

**Output:** `Stop!`

## Modern Switch (Java 14+) — Switch Expressions

Java 14 introduced a cleaner syntax using arrows `->`:

```java
int day = 3;

switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    case 3 -> System.out.println("Wednesday");
    case 4 -> System.out.println("Thursday");
    case 5 -> System.out.println("Friday");
    default -> System.out.println("Weekend");
}
```

### Symbol breakdown of `case 3 -> System.out.println("Wednesday");`:
- `case 3` — If the value is 3.
- `->` — An **arrow**. It means "then do this." No `break` needed with arrows!
- `System.out.println("Wednesday");` — The code to run.

You can also use switch as an **expression** that returns a value:

```java
int day = 3;
String name = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    case 4 -> "Thursday";
    case 5 -> "Friday";
    default -> "Weekend";
};    // Note the semicolon after the closing brace!

System.out.println(name);    // Wednesday
```

## What Types Can You Use with Switch?

- `int`, `byte`, `short`, `char` — numeric types
- `String` — text
- `enum` — a special type we'll learn later
- You **cannot** use `double`, `float`, `boolean`, or `long` with switch.

## Common Beginner Mistakes

1. **Forgetting `break`** — Causes fall-through (runs the next case too).
2. **Forgetting `default`** — Not required, but good practice to handle unexpected values.
3. **Using `==` in case** — It's `case 5:`, not `case == 5:`.
4. **Forgetting the colon** — It's `case 5:` (with a colon), not `case 5`.
5. **Using types switch doesn't support** — `switch` doesn't work with `double` or `boolean`.

## Mini Practice Exercise

**Task:** Write a switch that takes a grade letter (A, B, C, D, F) and prints a message.

**Answer:**
```java
public class Main {
    public static void main(String[] args) {
        char grade = 'B';

        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
                System.out.println("Good job!");
                break;
            case 'C':
                System.out.println("Not bad");
                break;
            case 'D':
                System.out.println("Needs improvement");
                break;
            case 'F':
                System.out.println("Failed");
                break;
            default:
                System.out.println("Invalid grade");
                break;
        }
    }
}
```

## Quiz

1. What does `break` do in a switch?
   - a) Breaks the program
   - b) Exits the switch block ✅
   - c) Skips to the next case

2. What is `default` in a switch?
   - a) The first case
   - b) Runs if no case matches ✅
   - c) Required in every switch

3. What happens without `break`?
   - a) Nothing
   - b) Java falls through to the next case ✅
   - c) Compilation error

4. Can you use `double` in a switch?
   - a) Yes
   - b) No ✅

---
**Next Lesson:** [Lesson 26 — Loops: `for`, `while`, `do while`](26_Loops.md)
