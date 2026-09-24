# Lesson 60: Exceptions

## Simple Explanation

An **exception** is an error that happens while your program is running. Instead of crashing silently, Java creates an exception **object** that describes what went wrong.

**Analogy:** If a recipe step fails (like "oven is broken"), you get an exception — an alert that tells you what went wrong so you can handle it.

## Common Exceptions

```java
// ArithmeticException: division by zero
int x = 10 / 0;

// NullPointerException: using a null reference
String s = null;
s.length();

// ArrayIndexOutOfBoundsException: bad array index
int[] arr = {1, 2, 3};
System.out.println(arr[10]);

// NumberFormatException: bad string-to-number conversion
int n = Integer.parseInt("abc");
```

## What Happens Without Handling?

The program **crashes** and prints a **stack trace** — an error message showing where the error occurred:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Main.main(Main.java:4)
```

- `ArithmeticException` — The type of exception.
- `/ by zero` — The message describing the problem.
- `Main.java:4` — The file and line number where it happened.

## The Exception Hierarchy

```
Throwable
├── Error (serious problems — don't catch these)
│   ├── OutOfMemoryError
│   └── StackOverflowError
└── Exception (problems you can handle)
    ├── RuntimeException (unchecked — optional to handle)
    │   ├── NullPointerException
    │   ├── ArithmeticException
    │   └── ArrayIndexOutOfBoundsException
    └── IOException (checked — MUST handle)
        └── FileNotFoundException
```

## Quiz

1. What is an exception?
   - a) A syntax error
   - b) A runtime error that can be handled ✅
   - c) A type of variable

2. What happens if you don't handle an exception?
   - a) Nothing
   - b) The program crashes ✅
   - c) Java handles it automatically

---
**Next Lesson:** [Lesson 61 — `try`, `catch`, `finally`](61_Try_Catch_Finally.md)
