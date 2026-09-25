[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](02_What_Is_Java.md) · [Next](04_JDK_JRE_JVM.md)

---

# Lesson 3: How Java Code Runs

## Simple Explanation

When you write Java code, it doesn't just magically run. It goes through a **process** with several steps. Let's walk through each one.

## The Journey of Java Code

### Step 1: You Write Code

You write your Java code in a plain text file. This file must have the extension `.java`.

For example: `Main.java`

The code inside looks something like this (don't worry about understanding it yet):

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
```

This is called **source code** — the human-readable instructions you write.

### Step 2: The Compiler Translates It

You use a tool called `javac` (which stands for **Java Compiler**) to translate your `.java` file.

In the terminal (a text-based window where you type commands), you would type:

```
javac Main.java
```

- `javac` is the command to run the Java compiler.
- `Main.java` is the file you want to compile.

The compiler checks your code for errors. If there are errors, it tells you. If there are no errors, it creates a new file called `Main.class`.

The `.class` file contains **bytecode** — the middle format we talked about in the last lesson.

### Step 3: The JVM Runs It

Now you use the `java` command to run your program:

```
java Main
```

- `java` is the command that starts the **Java Virtual Machine (JVM)**.
- `Main` is the name of the class you want to run (without the `.class` extension).

The JVM reads the bytecode in `Main.class` and executes it. Your program runs!

## The Full Picture

```
You write code     →    Compiler translates    →    JVM runs it
(Main.java)              (javac Main.java)          (java Main)
                         Creates Main.class
                         (bytecode)
```

## Everyday Analogy

Think of it like cooking a foreign recipe:

1. **You write the recipe** in English (source code — `.java` file).
2. **A translator** converts it into a universal cooking language (compiler creates `.class` bytecode).
3. **Any chef** who understands the universal language can cook the meal (JVM runs the bytecode on any computer).

## Key Terms

| Term | Meaning |
|------|---------|
| **Source code** | The Java code you write in a `.java` file. |
| `.java` file | The file where you write your Java source code. |
| `javac` | The Java compiler command. |
| `.class` file | The file containing bytecode, created by the compiler. |
| `java` | The command that starts the JVM to run your program. |

## What Happens If There's an Error?

If your code has a mistake (like a missing semicolon), the **compiler** will catch it and show you an error message. It will **not** create the `.class` file. You must fix the error and compile again.

This is actually helpful! The compiler is like a proofreader that checks your work before it goes out.

## Common Beginner Mistakes

1. **Forgetting to compile before running** — You must run `javac` first, then `java`.
2. **Including `.class` when running** — You type `java Main`, NOT `java Main.class`.
3. **Including `.java` when running** — You type `java Main`, NOT `java Main.java`.
4. **File name doesn't match class name** — If your class is called `Main`, your file must be called `Main.java`. (We'll explain classes later.)
5. **Not being in the right folder** — You must be in the folder where your `.java` file is located.

## Mini Practice Exercise

**Question:** Put these steps in the correct order:
- a) The JVM runs the bytecode
- b) The compiler creates a `.class` file
- c) You write Java code in a `.java` file

**Answer:** c → b → a

1. You write Java code in a `.java` file.
2. The compiler creates a `.class` file (bytecode).
3. The JVM runs the bytecode.

## Quiz

1. What file extension does Java source code use?
   - a) `.txt`
   - b) `.java` ✅
   - c) `.class`

2. What does the `javac` command do?
   - a) Runs a Java program
   - b) Compiles Java source code into bytecode ✅
   - c) Deletes Java files

3. What does the `java` command do?
   - a) Compiles Java code
   - b) Starts the JVM and runs a Java program ✅
   - c) Creates a new Java file

4. What happens if your code has an error?
   - a) The compiler ignores it
   - b) The compiler shows an error and does not create a `.class` file ✅
   - c) The computer crashes

---
**Next Lesson:** [Lesson 4 — JDK, JRE, JVM Explained](04_JDK_JRE_JVM.md)
