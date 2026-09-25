[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](60_Exceptions.md) · [Next](62_Checked_Unchecked.md)

**Runnable companion:** [Phase6_Exceptions](../../examples/06-exceptions-and-concurrency/01-exceptions/Phase6_Exceptions.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 61: `try`, `catch`, `finally`

## Simple Explanation

`try-catch` lets you **handle exceptions** gracefully instead of crashing. You "try" risky code, and "catch" any errors that happen.

## Basic Syntax

```java
try {
    int result = 10 / 0;    // This throws an exception
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
System.out.println("Program continues!");
```

**Output:**
```
Error: / by zero
Program continues!
```

### Symbol-by-symbol breakdown:
- `try` — Keyword meaning "try to run this code."
- `{` — Start of try block.
- `10 / 0` — Risky code that might cause an error.
- `}` — End of try block.
- `catch` — Keyword meaning "if an error happens, catch it here."
- `(` — Start of catch parameter.
- `ArithmeticException` — The type of exception to catch.
- `e` — A variable name for the exception object. You can use it to get details.
- `)` — End of catch parameter.
- `{` — Start of catch block.
- `e.getMessage()` — Returns the error message as a String.
- `}` — End of catch block.

## Multiple Catch Blocks

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[10]);
    int x = 10 / 0;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Bad index: " + e.getMessage());
} catch (ArithmeticException e) {
    System.out.println("Math error: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Some other error: " + e.getMessage());
}
```

Java checks catch blocks **top to bottom** and runs the **first one that matches**. Put more specific exceptions first, general `Exception` last.

## The `finally` Block

`finally` runs **no matter what** — whether an exception occurred or not:

```java
try {
    System.out.println("Trying...");
    int x = 10 / 0;
} catch (Exception e) {
    System.out.println("Caught: " + e.getMessage());
} finally {
    System.out.println("This ALWAYS runs");
}
```

**Output:**
```
Trying...
Caught: / by zero
This ALWAYS runs
```

`finally` is used for **cleanup** — closing files, releasing resources, etc.

## Try-with-Resources (Java 7+)

For resources that need closing (files, connections), use try-with-resources:

```java
try (Scanner scanner = new Scanner(System.in)) {
    String input = scanner.nextLine();
    System.out.println("You typed: " + input);
}    // Scanner is automatically closed here
```

### Symbol breakdown:
- `try` — Try keyword.
- `(` — Start of resource declaration.
- `Scanner scanner = new Scanner(System.in)` — The resource to auto-close.
- `)` — End of resource declaration.
- `{ }` — Try block. When it ends, the resource is automatically closed.

## Throwing Exceptions

You can throw your own exceptions:

```java
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = age;
}
```

### Symbol breakdown of `throw new IllegalArgumentException("Age cannot be negative")`:
- `throw` — Keyword meaning "create and send this exception."
- `new` — Create a new exception object.
- `IllegalArgumentException` — The exception type.
- `("Age cannot be negative")` — The error message.
- `;` — End of statement.

## Common Beginner Mistakes

1. **Catching `Exception` too broadly** — Catch specific exceptions when possible.
2. **Empty catch blocks** — `catch (Exception e) { }` silently swallows errors. At least log the error.
3. **Forgetting that `finally` always runs** — Even if there's a `return` in the try block.

## Quiz

1. What does `try` do?
   - a) Catches errors
   - b) Wraps code that might throw an exception ✅
   - c) Stops the program

2. When does `finally` run?
   - a) Only when there's an error
   - b) Only when there's no error
   - c) Always ✅

3. What does `throw` do?
   - a) Catches an exception
   - b) Creates and sends an exception ✅
   - c) Ends the program

---
**Next Lesson:** [Lesson 62 — Checked vs Unchecked Exceptions](62_Checked_Unchecked.md)
