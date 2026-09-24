# Lesson 9: Statements

## Simple Explanation

A **statement** is a single, complete instruction that tells Java to do something.

Think of it like a sentence in English. Just as a sentence expresses one complete thought, a statement tells Java to perform one complete action.

## Examples of Statements

```java
System.out.println("Hello");
```
This is **one statement**. It tells Java: "Print the text Hello."

```java
int age = 25;
```
This is **one statement**. It tells Java: "Create a variable called `age` and set it to 25." (We'll learn about variables soon.)

```java
age = age + 1;
```
This is **one statement**. It tells Java: "Take the value of `age`, add 1, and store the result back in `age`."

## Rules for Statements

### Rule 1: Every Statement Ends with a Semicolon `;`

```java
System.out.println("Hello");   // ✅ Correct — has a semicolon
System.out.println("Hello")    // ❌ Error — missing semicolon
```

The semicolon `;` is like a period `.` at the end of an English sentence. It tells Java: "This instruction is complete."

### Rule 2: Statements Run Top to Bottom

Java executes statements in order, from the first one to the last one:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("First");    // Runs 1st
        System.out.println("Second");   // Runs 2nd
        System.out.println("Third");    // Runs 3rd
    }
}
```

**Output:**
```
First
Second
Third
```

### Rule 3: One Statement Per Line (Convention)

You *can* put multiple statements on one line:

```java
System.out.println("A"); System.out.println("B");
```

But **don't do this**. It makes code hard to read. Put one statement per line.

### Rule 4: Statements Go Inside a Method

For now, all your statements go inside the `main` method, between its curly braces `{` and `}`.

```java
public class Main {
    public static void main(String[] args) {
        // Statements go here
        System.out.println("I am a statement");
    }
}
```

## What Is NOT a Statement?

- `public class Main {` — This is a **class declaration**, not a statement. It doesn't end with `;`.
- `public static void main(String[] args) {` — This is a **method declaration**, not a statement. It doesn't end with `;`.
- `{` and `}` — These are **braces** that group code. They are not statements.
- `// This is a comment` — This is a **comment** (we'll learn about these next). Not a statement.

**Notice the pattern:** Declarations and structural elements use `{` and `}`. Executable instructions (statements) end with `;`.

## Common Beginner Mistakes

1. **Forgetting the semicolon** — This is the #1 beginner mistake. Every statement needs `;`.
2. **Adding a semicolon after a class or method declaration** — `public class Main {};` is wrong (the `;` is unnecessary).
3. **Writing statements outside a method** — Statements must be inside a method (like `main`).
4. **Thinking blank lines are statements** — Blank lines are ignored by Java. They're just for readability.

## Mini Practice Exercise

**Task:** How many statements are in this code?

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("One");
        System.out.println("Two");
        System.out.println("Three");
    }
}
```

**Answer:** **3 statements** — the three `System.out.println(...)` lines. The class declaration and method declaration are not statements.

## Quiz

1. What marks the end of a statement in Java?
   - a) A period `.`
   - b) A semicolon `;` ✅
   - c) A new line

2. In what order does Java execute statements?
   - a) Bottom to top
   - b) Random order
   - c) Top to bottom ✅

3. Where do statements go?
   - a) Outside the class
   - b) Inside a method ✅
   - c) Anywhere in the file

4. Is `public class Main {` a statement?
   - a) Yes
   - b) No ✅ — It's a class declaration, not a statement.

---
**Next Lesson:** [Lesson 10 — Semicolons](10_Semicolons.md)
