[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](../01-intro/05_Installing_Java.md) · [Next](07_Public_Class_Main.md)

**Runnable companion:** [HelloWorld](../../examples/00-getting-started/01-hello-world/HelloWorld.java), [Phase0_HelloWorld](../../examples/00-getting-started/04-program-structure/Phase0_HelloWorld.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 6: Writing Your First Java Program

## Simple Explanation

It's time to write your very first Java program! By tradition, the first program every programmer writes is called **"Hello, World!"** — it simply displays the text "Hello, World!" on the screen.

## The Code

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Don't panic!** This looks complicated, but we'll explain every single character. For now, just type it exactly as shown.

## What Does This Program Do?

It prints the text `Hello, World!` on the screen. That's it!

## How to Run It

### Method 1: Using the Terminal

1. Open a text editor (Notepad, TextEdit, or any editor).
2. Type the code above **exactly** as shown.
3. Save the file as `Main.java` (the name **must** match the class name, and it **must** end with `.java`).
4. Open your terminal and navigate to the folder where you saved the file.
5. Compile: `javac Main.java`
6. Run: `java Main`

You should see:
```
Hello, World!
```

### Method 2: Using IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Create a new project.
3. Create a new Java class called `Main`.
4. Type the code.
5. Click the green "Run" button (▶).

## Line-by-Line Breakdown

Let's go through every single line and symbol:

### Line 1: `public class Main {`

- `public` — This is an **access modifier** (a keyword that controls who can see this code). `public` means "everyone can access this." We'll learn more about this later. For now, just always write it.
- A space ` ` separates the words. Spaces matter for readability but Java mostly ignores extra spaces.
- `class` — This is a Java **keyword** that means "I am defining a class." A **class** is like a container that holds your code. Every Java program needs at least one class. We'll explain classes in detail later.
- Another space ` `.
- `Main` — This is the **name** of the class. You chose this name. It must match the file name (`Main.java`). By convention (a common rule programmers follow), class names start with a capital letter.
- A space ` `.
- `{` — This is an **opening curly brace**. It means "the contents of this class start here." Think of it like opening a box — everything inside the braces belongs to this class.

### Line 2: `    public static void main(String[] args) {`

- `    ` — These spaces at the beginning are called **indentation**. They make the code easier to read. They show that this line is *inside* the class. Java doesn't require them, but programmers always use them.
- `public` — Again, an access modifier. This method can be accessed by anyone.
- `static` — A keyword meaning this method belongs to the class itself, not to a specific object. We'll explain this much later. For now, just always write it.
- `void` — A keyword meaning this method does **not give back** (return) any value. Think of it as: "this method does something, but doesn't hand you anything back." We'll explain return values later.
- `main` — This is the **name** of the method. The name `main` is special in Java — it's the **entry point**. When you run a Java program, Java looks for a method called `main` and starts there. You must spell it exactly `main` (all lowercase).
- `(` — An **opening parenthesis**. It starts the list of **parameters** (inputs) for this method.
- `String` — A data type that represents text. `String` starts with a capital `S`.
- `[` — An **opening square bracket**.
- `]` — A **closing square bracket**. Together, `[]` means "an array of" — meaning a list of multiple items. So `String[]` means "a list of text values."
- A space ` `.
- `args` — This is the name of the parameter. Short for "arguments." These are inputs that can be passed to your program when it starts. We'll use this later.
- `)` — A **closing parenthesis**. It ends the list of parameters.
- A space ` `.
- `{` — Another **opening curly brace**. The contents of this method start here.

### Line 3: `        System.out.println("Hello, World!");`

- `        ` — More indentation (deeper this time, because we're inside the method, which is inside the class).
- `System` — A built-in Java **class** that provides access to the system (your computer). You don't create it — it's already there.
- `.` — A **dot** (period). In Java, the dot means "go inside" or "access something that belongs to." Here, it means "access something inside System."
- `out` — A **static field** (a variable) inside `System`. It represents the standard output — usually your screen/terminal.
- `.` — Another dot. It means "access something inside `out`."
- `println` — A **method** (an action) that prints text and then moves to a new line. The name stands for "print line."
- `(` — An opening parenthesis. It means "we are calling (using) this method" and starts the list of what we're giving it.
- `"` — An opening **double quote**. It marks the beginning of a **String** (text).
- `Hello, World!` — The actual text we want to print. This is called a **String literal** — text written directly in the code.
- `"` — A closing **double quote**. It marks the end of the String.
- `)` — A closing parenthesis. It ends the method call.
- `;` — A **semicolon**. In Java, every **statement** (a complete instruction) must end with a semicolon. Think of it like a period at the end of a sentence.

### Line 4: `    }`

- `    ` — Indentation.
- `}` — A **closing curly brace**. It means "the contents of the method end here." This matches the `{` on line 2.

### Line 5: `}`

- `}` — A closing curly brace. It means "the contents of the class end here." This matches the `{` on line 1.

## Matching Braces

Every `{` must have a matching `}`:

```java
public class Main {          // Opening brace for the CLASS
    public static void main(String[] args) {  // Opening brace for the METHOD
        System.out.println("Hello, World!");
    }                        // Closing brace for the METHOD
}                            // Closing brace for the CLASS
```

## Common Beginner Mistakes

1. **Forgetting the semicolon** `;` — Every statement needs one.
2. **Using `system` instead of `System`** — Java is case-sensitive! `System` (capital S) is correct.
3. **Using `Main` instead of `main` for the method** — The method must be lowercase `main`.
4. **File name doesn't match class name** — If the class is `Main`, the file must be `Main.java`.
5. **Forgetting a curly brace** — Every `{` needs a `}`.
6. **Using single quotes instead of double quotes** — Strings use double quotes `"Hello"`, not single quotes `'Hello'`.

## Mini Practice Exercise

**Task:** Modify the program to print your name instead of "Hello, World!"

**Example Answer:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, my name is Alex!");
    }
}
```

## Quiz

1. What is the special method Java looks for when starting a program?
   - a) `start`
   - b) `run`
   - c) `main` ✅

2. What does the semicolon `;` do?
   - a) Starts a new line
   - b) Marks the end of a statement ✅
   - c) Separates words

3. What do curly braces `{ }` do?
   - a) Mark the start and end of a block of code ✅
   - b) Mark the start and end of text
   - c) Nothing, they're optional

4. What does `System.out.println` do?
   - a) Reads input from the user
   - b) Prints text and moves to a new line ✅
   - c) Saves a file

---
**Next Lesson:** [Lesson 7 — Understanding `public class Main`](07_Public_Class_Main.md)
