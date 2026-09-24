# Lesson 28: Methods

## Simple Explanation

A **method** is a named block of code that performs a specific task. You can **call** (use) a method whenever you need it, instead of writing the same code over and over.

**Analogy:** A method is like a recipe. You write the recipe once, and then you can follow it (call it) any time you want to make that dish.

## Why Use Methods?

1. **Reuse code** — Write once, use many times.
2. **Organize code** — Break big problems into small, named pieces.
3. **Readability** — `calculateTotal()` is clearer than 10 lines of math.

## Defining a Method

```java
public class Main {
    public static void sayHello() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        sayHello();    // Call the method
        sayHello();    // Call it again
        sayHello();    // And again!
    }
}
```

**Output:**
```
Hello!
Hello!
Hello!
```

### Symbol-by-symbol breakdown of `public static void sayHello()`:

- `public` — Access modifier. Everyone can use this method.
- `static` — Belongs to the class, not an object. (For now, always use `static` in methods inside `main`'s class.)
- `void` — This method **returns nothing**. It does work but doesn't give a value back.
- `sayHello` — The **name** of the method. You choose this. Convention: use camelCase starting with lowercase.
- `(` — Opening parenthesis. Start of the parameter list.
- `)` — Closing parenthesis. No parameters — this method takes no input.
- `{` — Opening curly brace. Start of the method body.
- `System.out.println("Hello!");` — The code inside the method.
- `}` — Closing curly brace. End of the method body.

### Symbol-by-symbol breakdown of `sayHello();`:

- `sayHello` — The name of the method to call.
- `(` — Opening parenthesis.
- `)` — Closing parenthesis. No arguments (inputs) given.
- `;` — End of statement.

## Method Placement

Methods are defined **inside the class** but **outside** other methods:

```java
public class Main {

    // ✅ Method defined inside the class, outside main
    public static void greet() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        greet();    // Call it from main

        // ❌ You CANNOT define a method inside another method
        // public static void wrong() { }  // ERROR!
    }
}
```

## Methods with Parameters

We'll cover this in detail next lesson, but here's a preview:

```java
public static void greet(String name) {
    System.out.println("Hello, " + name + "!");
}

// Calling it:
greet("Alex");     // Output: Hello, Alex!
greet("Sam");      // Output: Hello, Sam!
```

## Methods that Return Values

Also covered in detail soon:

```java
public static int add(int a, int b) {
    return a + b;
}

// Calling it:
int result = add(5, 3);
System.out.println(result);    // 8
```

## Naming Conventions for Methods

- Start with a **lowercase** letter.
- Use **camelCase**: `calculateTotal`, `getAge`, `isValid`.
- Use **verbs** — methods do things: `print`, `calculate`, `get`, `set`, `check`, `is`.

## Common Beginner Mistakes

1. **Forgetting parentheses when calling** — `sayHello;` is wrong. Use `sayHello();`.
2. **Defining a method inside another method** — Methods go inside the class, not inside `main`.
3. **Forgetting `static`** — For now, methods called from `main` must be `static`.
4. **Calling before defining** — In Java, the order of method definitions doesn't matter (unlike some languages), but the method must exist.
5. **Forgetting to actually call the method** — Defining a method doesn't run it. You must call it.

## Mini Practice Exercise

**Task:** Write a method called `printLine` that prints a line of 20 dashes `--------------------`, then call it 3 times from `main`.

**Answer:**
```java
public class Main {
    public static void printLine() {
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        printLine();
        System.out.println("Section 1");
        printLine();
        System.out.println("Section 2");
        printLine();
    }
}
```

## Quiz

1. What is a method?
   - a) A type of variable
   - b) A named block of reusable code ✅
   - c) A Java keyword

2. What does `void` mean in a method?
   - a) The method takes no parameters
   - b) The method returns nothing ✅
   - c) The method is empty

3. How do you call a method named `doStuff` with no parameters?
   - a) `doStuff;`
   - b) `doStuff();` ✅
   - c) `call doStuff();`

4. Where do you define methods?
   - a) Inside `main`
   - b) Inside the class, outside other methods ✅
   - c) Outside the class

---
**Next Lesson:** [Lesson 29 — Parameters and Arguments](29_Parameters_Arguments.md)
