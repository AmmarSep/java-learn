[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](28_Methods.md) · [Next](30_Return_Values.md)

**Runnable companion:** [Phase2_Methods](../../examples/02-methods-and-memory/01-methods/Phase2_Methods.java), [Phase2_PassByValue](../../examples/02-methods-and-memory/02-pass-by-value/Phase2_PassByValue.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 29: Parameters and Arguments

## Simple Explanation

**Parameters** are inputs that a method can receive. They let you give information to a method so it can use that information to do its work.

**Analogy:** A blender (method) needs ingredients (parameters) to make a smoothie (result).

## Key Terms

- **Parameter** = the variable listed in the method definition. It's the "placeholder."
- **Argument** = the actual value you pass when calling the method. It's the "real value."

```java
//                  parameter
//                     ↓
public static void greet(String name) {
    System.out.println("Hello, " + name);
}

// In main:
greet("Alex");    // "Alex" is the argument
//     ↑
//  argument
```

## One Parameter

```java
public class Main {
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        greet("Alex");
        greet("Sam");
        greet("Jordan");
    }
}
```

**Output:**
```
Hello, Alex!
Hello, Sam!
Hello, Jordan!
```

### Symbol-by-symbol breakdown of `public static void greet(String name)`:
- `public static void` — Access, static, returns nothing (we know these).
- `greet` — Method name.
- `(` — Start of parameter list.
- `String` — The **type** of the parameter. This method expects text.
- `name` — The **name** of the parameter. Inside the method, you use this name to refer to the value.
- `)` — End of parameter list.

### Symbol-by-symbol breakdown of `greet("Alex")`:
- `greet` — The method to call.
- `(` — Start of arguments.
- `"Alex"` — The **argument**: the actual value being passed. This value goes into the `name` parameter.
- `)` — End of arguments.
- `;` — End of statement.

## Multiple Parameters

Separate parameters with **commas** `,`:

```java
public class Main {
    public static void introduce(String name, int age) {
        System.out.println(name + " is " + age + " years old.");
    }

    public static void main(String[] args) {
        introduce("Alex", 25);
        introduce("Sam", 30);
    }
}
```

**Output:**
```
Alex is 25 years old.
Sam is 30 years old.
```

### Symbol breakdown of `(String name, int age)`:
- `(` — Start of parameter list.
- `String name` — First parameter: text, named `name`.
- `,` — A **comma** separating parameters.
- `int age` — Second parameter: whole number, named `age`.
- `)` — End of parameter list.

### Symbol breakdown of `introduce("Alex", 25)`:
- `"Alex"` — First argument → goes into `name`.
- `,` — Comma separating arguments.
- `25` — Second argument → goes into `age`.

**Important:** Arguments must match parameters in **order** and **type**:
- First argument → first parameter
- Second argument → second parameter

## Parameter Types Must Match

```java
introduce("Alex", 25);     // ✅ String, int — matches
introduce(25, "Alex");     // ❌ int, String — wrong order!
introduce("Alex");         // ❌ Missing second argument!
introduce("Alex", 25, 5);  // ❌ Too many arguments!
```

## Common Beginner Mistakes

1. **Wrong number of arguments** — Must match the number of parameters exactly.
2. **Wrong order** — `introduce(25, "Alex")` puts the int where the String should be.
3. **Wrong type** — `greet(42)` when the parameter expects a String.
4. **Confusing parameters and arguments** — Parameters are in the definition; arguments are in the call.
5. **Forgetting commas between parameters** — `(String name int age)` is wrong. Need a comma: `(String name, int age)`.

## Mini Practice Exercise

**Task:** Write a method `printSum` that takes two `int` parameters and prints their sum.

**Answer:**
```java
public class Main {
    public static void printSum(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    public static void main(String[] args) {
        printSum(5, 3);      // Output: 5 + 3 = 8
        printSum(10, 20);    // Output: 10 + 20 = 30
    }
}
```

## Quiz

1. What is a parameter?
   - a) The value you pass to a method
   - b) A variable in the method definition that receives a value ✅
   - c) The return value of a method

2. What is an argument?
   - a) The actual value passed when calling a method ✅
   - b) A variable in the method definition
   - c) A type of loop

3. In `greet("Hi")`, what is `"Hi"`?
   - a) A parameter
   - b) An argument ✅
   - c) A return value

4. What separates multiple parameters?
   - a) Semicolons `;`
   - b) Commas `,` ✅
   - c) Dots `.`

---
**Next Lesson:** [Lesson 30 — Return Values](30_Return_Values.md)
