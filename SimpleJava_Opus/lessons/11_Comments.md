# Lesson 11: Comments

## Simple Explanation

A **comment** is a note you write in your code **for humans to read**. Java completely **ignores** comments — they don't affect how your program runs.

Comments are like sticky notes on a recipe: they help you (or someone else) understand what the code is doing.

## Three Types of Comments

### Type 1: Single-Line Comment `//`

```java
// This is a single-line comment
System.out.println("Hello");
```

- `//` — Two forward slashes. Everything **after** `//` on that line is a comment.
- Java ignores everything from `//` to the end of the line.

You can also put a comment at the end of a line of code:

```java
System.out.println("Hello");  // This prints Hello
```

- `System.out.println("Hello");` — This is the code. Java runs this.
- `//` — Start of the comment.
- `This prints Hello` — The comment. Java ignores this.

### Type 2: Multi-Line Comment `/* */`

```java
/* This is a multi-line comment.
   It can span several lines.
   Java ignores all of it. */
System.out.println("Hello");
```

- `/*` — Starts the comment (a forward slash followed by an asterisk).
- Everything between `/*` and `*/` is a comment, even across multiple lines.
- `*/` — Ends the comment (an asterisk followed by a forward slash).

### Type 3: Documentation Comment `/** */`

```java
/**
 * This is a documentation comment.
 * It is used to describe classes and methods.
 * Special tools can read these to create documentation.
 */
public class Main {
    // ...
}
```

- `/**` — Starts a documentation comment (forward slash, two asterisks).
- `*/` — Ends the documentation comment.
- The `*` at the beginning of each middle line is optional but conventional (makes it look neat).
- These are used for generating automatic documentation. We'll learn more about these later.

## Full Example

```java
public class Main {
    public static void main(String[] args) {
        // Print a greeting message
        System.out.println("Hello!");

        /* The next two lines
           print numbers */
        System.out.println(1);
        System.out.println(2);

        System.out.println("Done");  // End of program
    }
}
```

### Line-by-line breakdown:

- `// Print a greeting message` — A single-line comment. Java ignores this. It helps us understand the next line.
- `System.out.println("Hello!");` — A statement that prints "Hello!".
- (blank line) — Java ignores blank lines. They improve readability.
- `/* The next two lines print numbers */` — A multi-line comment (even though it's on two lines here).
- `System.out.println(1);` — Prints the number 1.
- `;` — End of statement.
- `System.out.println(2);` — Prints the number 2.
- `System.out.println("Done");` — Prints "Done".
- `// End of program` — An inline comment.

**Output:**
```
Hello!
1
2
Done
```

Notice: None of the comments appear in the output. They are only for the programmer.

## Why Use Comments?

1. **Explain complex code** — Help others (and your future self) understand what the code does.
2. **Leave reminders** — `// TODO: fix this later`
3. **Temporarily disable code** — "Comment out" code you don't want to run:

```java
System.out.println("This runs");
// System.out.println("This does NOT run");
System.out.println("This also runs");
```

**Output:**
```
This runs
This also runs
```

The second line is "commented out" — Java treats it as a comment and skips it.

## Common Beginner Mistakes

1. **Forgetting to close a multi-line comment** — If you write `/*` but forget `*/`, Java will treat everything after it as a comment!
2. **Nesting multi-line comments** — You cannot put `/* */` inside another `/* */`. This causes errors.
3. **Over-commenting** — Don't comment every single line. Comment only when something needs explanation.
4. **Writing wrong comments** — A comment that says "adds 1" next to code that subtracts 1 is worse than no comment.

## Mini Practice Exercise

**Task:** Add comments to this code:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome");
        System.out.println(2024);
    }
}
```

**Example Answer:**

```java
// This program prints a welcome message and the year
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome");   // Print welcome text
        System.out.println(2024);        // Print the year
    }
}
```

## Quiz

1. What does `//` do?
   - a) Divides two numbers
   - b) Starts a single-line comment ✅
   - c) Ends a statement

2. How do you start a multi-line comment?
   - a) `//`
   - b) `/*` ✅
   - c) `<!--`

3. Do comments affect how the program runs?
   - a) Yes, they slow it down
   - b) No, Java ignores them completely ✅
   - c) Yes, they make it faster

4. What is "commenting out" code?
   - a) Deleting code
   - b) Turning code into a comment so it doesn't run ✅
   - c) Adding notes about bugs

---
**Next Lesson:** [Lesson 12 — Printing with `System.out.println`](12_Printing.md)
