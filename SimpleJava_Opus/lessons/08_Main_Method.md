# Lesson 8: Understanding `public static void main(String[] args)`

## Simple Explanation

This line is the **entry point** of every Java program. When you run a Java program, the JVM looks for this exact method and starts executing code from there.

Think of it like the front door of a building — it's where everyone enters.

## The Code

```java
public static void main(String[] args) {
    // Your code starts here
}
```

## Word-by-Word Breakdown

### `public`

- An **access modifier**.
- Means "anyone can access this method."
- The JVM needs to access `main` from outside your class to start your program, so it **must** be `public`.

### `static`

- A **keyword** that means "this method belongs to the class itself, not to an object."
- What does that mean? Normally, you need to create an **object** (an instance) of a class before you can use its methods. But `static` means you can use this method **without** creating an object.
- Why is `main` static? Because when your program starts, no objects exist yet! The JVM needs to call `main` before anything else happens, so `main` must be available without creating an object.

**Analogy:** A `static` method is like a public phone booth — anyone can use it without owning the building it's attached to.

### `void`

- A **keyword** that means "this method does not return (give back) any value."
- Some methods do work and give you a result back (like a calculator gives you an answer). A `void` method does work but gives **nothing** back.
- The `main` method runs your program but doesn't need to give a value back to the JVM.

**Analogy:** `void` is like a delivery person. They deliver your package (do work) but don't bring anything back.

### `main`

- This is the **name** of the method.
- The name `main` is **special** — it's the name the JVM looks for when starting your program.
- You **must** spell it exactly `main` (all lowercase). `Main`, `MAIN`, `mAiN` will not work.
- This is not a keyword — it's a name that Java has given special meaning to.

### `(`

- An **opening parenthesis**.
- It starts the list of **parameters** — inputs that can be given to this method.

### `String`

- A **data type** that represents text (like "Hello" or "Goodbye").
- `String` starts with a capital `S` — it's actually a class, not a primitive type. We'll learn the difference later.

### `[]`

- **Square brackets**.
- They mean "an array of" — which means "a list of multiple items."
- `String[]` means "a list of text values."
- So `String[]` = "an array (list) of Strings (text values)."

### `args`

- The **name** of the parameter.
- Short for "arguments."
- These are the values you can pass to your program when you start it from the command line.
- For example: `java Main hello world` would pass `"hello"` and `"world"` as arguments.
- For now, you won't use `args`, but it must be there.
- You could name it anything (like `parameters` or `input`), but `args` is the convention everyone uses.

### `)`

- A **closing parenthesis**.
- It ends the parameter list.

### `{`

- An **opening curly brace**.
- It starts the body (contents) of the method.
- All the code you want to run goes between `{` and `}`.

### `}`

- A **closing curly brace**.
- It ends the body of the method.

## The Full Signature

The combination `public static void main(String[] args)` is called the **method signature**. It tells Java:

1. **Who can use it:** `public` — everyone.
2. **How it's called:** `static` — without creating an object.
3. **What it returns:** `void` — nothing.
4. **What it's named:** `main` — the special entry point.
5. **What it receives:** `String[] args` — a list of text values.

## What If You Change Something?

| What you change | What happens |
|----------------|--------------|
| Remove `public` | JVM might not find it (error) |
| Remove `static` | JVM can't call it without an object (error) |
| Change `void` to `int` | JVM won't recognize it as the entry point |
| Change `main` to `start` | JVM won't find the entry point (error) |
| Remove `String[] args` | JVM won't recognize the method signature (error) |

**The signature must be exactly:** `public static void main(String[] args)`

## Multiple Print Statements

You can put many lines of code inside `main`:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Line 1");
        System.out.println("Line 2");
        System.out.println("Line 3");
    }
}
```

**Output:**
```
Line 1
Line 2
Line 3
```

Java runs the code **from top to bottom**, one line at a time.

## Common Beginner Mistakes

1. **Writing `Main` instead of `main`** — The method name must be lowercase `main`.
2. **Forgetting `static`** — The method must be `static`.
3. **Writing `string` instead of `String`** — Capital `S` is required.
4. **Forgetting `[]`** — It must be `String[]`, not just `String`.
5. **Writing code outside `main`** — For now, all your code should be inside the `main` method.
6. **Forgetting braces** — The method body needs `{` and `}`.

## Mini Practice Exercise

**Task:** Write a complete Java program that prints three lines: your name, your city, and your favorite color.

**Example Answer:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("My name is Alex");
        System.out.println("I live in New York");
        System.out.println("My favorite color is blue");
    }
}
```

### Breakdown of every symbol in the first print line:
- `System` — built-in class for system access.
- `.` — access something inside System.
- `out` — the standard output stream (your screen).
- `.` — access something inside out.
- `println` — method to print text and move to a new line.
- `(` — start of what we're giving to println.
- `"My name is Alex"` — the text (String) to print. Double quotes mark it as text.
- `)` — end of what we're giving to println.
- `;` — end of this statement.

## Quiz

1. Why must `main` be `static`?
   - a) Because it looks nice
   - b) Because the JVM needs to call it without creating an object ✅
   - c) Because all methods must be static

2. What does `void` mean?
   - a) The method returns a number
   - b) The method returns nothing ✅
   - c) The method is empty

3. What does `String[] args` represent?
   - a) A single text value
   - b) A list of text values passed to the program ✅
   - c) The program's name

4. What is the correct order of keywords?
   - a) `static public void main`
   - b) `public void static main`
   - c) `public static void main` ✅

---
**Next Lesson:** [Lesson 9 — Statements](09_Statements.md)
