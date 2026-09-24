# Lesson 10: Semicolons

## Simple Explanation

The **semicolon** `;` is one of the most important symbols in Java. It marks the **end of a statement** — just like a period marks the end of a sentence in English.

## The Rule

**Every statement in Java must end with a semicolon `;`.**

```java
System.out.println("Hello");    // ✅ Correct
int x = 5;                      // ✅ Correct
x = x + 1;                      // ✅ Correct
```

## What Happens Without a Semicolon?

```java
System.out.println("Hello")     // ❌ ERROR!
```

The compiler will give you an error message like:
```
error: ';' expected
```

This means: "I was looking for a semicolon but didn't find one."

## Where to Put Semicolons

### DO use semicolons after:
- Print statements: `System.out.println("Hi");`
- Variable declarations: `int age = 25;`
- Variable assignments: `age = 30;`
- Method calls: `doSomething();`
- Return statements: `return 5;`

### DO NOT use semicolons after:
- Class declarations: `public class Main {` — NO semicolon here
- Method declarations: `public static void main(String[] args) {` — NO semicolon here
- `if`, `for`, `while` lines (we'll learn these later): `if (x > 5) {` — NO semicolon here
- Opening braces `{` or closing braces `}`

## Quick Visual Guide

```java
public class Main {                              // NO semicolon
    public static void main(String[] args) {     // NO semicolon
        System.out.println("Hello");             // YES semicolon
        int number = 42;                         // YES semicolon
        System.out.println(number);              // YES semicolon
    }                                            // NO semicolon
}                                                // NO semicolon
```

**Simple rule:** If the line is "doing something" (an action/instruction), it needs `;`. If the line is "declaring structure" (class, method, block), it does NOT need `;`.

## Multiple Statements

Each statement gets its own semicolon:

```java
System.out.println("A");
System.out.println("B");
System.out.println("C");
```

Three statements, three semicolons.

## Common Beginner Mistakes

1. **Forgetting the semicolon** — The most common Java error for beginners.
2. **Putting a semicolon after a curly brace** — `}` does not need `;` (in most cases).
3. **Putting a semicolon after a class declaration** — `public class Main {;` is wrong.
4. **Double semicolons** — `System.out.println("Hi");;` — The extra `;` creates an empty statement. It won't cause an error, but it's unnecessary and messy.

## Mini Practice Exercise

**Task:** Which lines need a semicolon? Add them where needed.

```
public class Main {
    public static void main(String[] args) {
        System.out.println("One")
        System.out.println("Two")
        int x = 10
    }
}
```

**Answer:**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("One");    // Added ;
        System.out.println("Two");    // Added ;
        int x = 10;                   // Added ;
    }
}
```

## Quiz

1. What does a semicolon do in Java?
   - a) Starts a new line
   - b) Marks the end of a statement ✅
   - c) Separates words

2. Does `public class Main {` need a semicolon?
   - a) Yes
   - b) No ✅

3. What error do you get when you forget a semicolon?
   - a) "missing brace"
   - b) "';' expected" ✅
   - c) "unknown symbol"

4. How many semicolons are needed for three statements?
   - a) 1
   - b) 2
   - c) 3 ✅

---
**Next Lesson:** [Lesson 11 — Comments](11_Comments.md)
