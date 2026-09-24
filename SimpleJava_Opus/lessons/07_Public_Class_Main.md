# Lesson 7: Understanding `public class Main`

## Simple Explanation

Every Java program starts with a **class**. Let's deeply understand what `public class Main` means.

## The Code

```java
public class Main {
    // code goes here
}
```

## Word-by-Word Breakdown

### `public`

- `public` is an **access modifier**.
- An access modifier controls **who can see and use** this piece of code.
- `public` means "**everyone** can see this class."
- Other access modifiers exist (like `private` and `protected`), but we'll learn those later.
- **Rule:** If a class is `public`, the file name **must** match the class name. So a `public class Main` must be in a file called `Main.java`.

**Analogy:** Think of `public` like a shop with an "OPEN" sign. Anyone can come in.

### `class`

- `class` is a **keyword** — a word with a special meaning in Java. You cannot use it for anything else.
- It tells Java: "I am defining a class."
- A **class** is a **container** for your code. Think of it as a blueprint or a box that holds related code together.
- Every piece of Java code must live inside a class.

**Analogy:** A class is like a recipe card. It has a name and contains instructions.

### `Main`

- `Main` is the **name** you gave to this class.
- You can name your class almost anything, but there are rules:
  - Must start with a **letter**, underscore `_`, or dollar sign `$` (but always use a letter).
  - Cannot start with a number.
  - Cannot contain spaces.
  - Cannot be a Java keyword (like `class`, `public`, `static`, etc.).
  - By **convention**, class names use **PascalCase** — each word starts with a capital letter: `Main`, `MyProgram`, `StudentRecord`.

**Examples of valid class names:**
- `Main`
- `HelloWorld`
- `Calculator`
- `MyFirstProgram`

**Examples of invalid class names:**
- `123Main` — starts with a number ❌
- `my program` — contains a space ❌
- `class` — it's a keyword ❌

### `{` and `}`

- The opening brace `{` means "the body (contents) of this class starts here."
- The closing brace `}` means "the body of this class ends here."
- Everything between `{` and `}` belongs to this class.

**Analogy:** The braces are like the covers of a book. Everything between the front cover `{` and back cover `}` is the content of the book.

## Can You Have Multiple Classes?

Yes! But only **one public class per file**, and the file name must match that public class.

```java
// File: Main.java

public class Main {
    // This is the public class. File must be named Main.java.
}

class Helper {
    // This is another class in the same file.
    // It's not public, so it doesn't need its own file.
}
```

Most of the time, beginners put **one class per file**. That's the best practice.

## Important Rules Summary

| Rule | Example |
|------|---------|
| Every Java file must contain a class | `public class Main { }` |
| File name must match the public class name | `Main.java` for `public class Main` |
| Class names start with an uppercase letter (convention) | `Main`, `Calculator`, `Student` |
| Code lives between `{` and `}` | `public class Main { ... }` |

## Common Beginner Mistakes

1. **File name doesn't match class name** — `public class Hello` must be in `Hello.java`, not `Main.java`.
2. **Forgetting `class` keyword** — You can't just write `public Main { }`.
3. **Starting class name with lowercase** — It works, but it breaks convention. Always use uppercase: `Main`, not `main`.
4. **Forgetting the closing brace** `}` — Every `{` needs its partner `}`.
5. **Having two public classes in one file** — Only one public class per `.java` file.

## Mini Practice Exercise

**Task:** Write a class called `Greeting` that is public and has nothing inside.

**Answer:**
```java
// File must be named: Greeting.java
public class Greeting {

}
```

- `public` — everyone can see it.
- `class` — we're defining a class.
- `Greeting` — the name of the class (starts with uppercase, matches the file name).
- `{` — start of the class body.
- `}` — end of the class body.

## Quiz

1. What does `public` mean?
   - a) Only this file can use the class
   - b) Everyone can access the class ✅
   - c) The class is hidden

2. What is a `class`?
   - a) A type of variable
   - b) A container for code ✅
   - c) A Java command to run programs

3. Which class name is valid?
   - a) `123Program` ❌
   - b) `my program` ❌
   - c) `MyProgram` ✅

4. If your class is called `public class Calculator`, what must the file be named?
   - a) `calculator.java`
   - b) `Calculator.java` ✅
   - c) `Program.java`

---
**Next Lesson:** [Lesson 8 — Understanding the `main` Method](08_Main_Method.md)
