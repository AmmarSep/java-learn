[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](29_Parameters_Arguments.md) · [Next](31_Scope.md)

**Runnable companion:** [Phase2_Methods](../../examples/02-methods-and-memory/01-methods/Phase2_Methods.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 30: Return Values

## Simple Explanation

A method can **return** (give back) a value to whoever called it. Think of it like asking someone a question — they do some thinking and give you an **answer** back.

- `void` methods do work but give nothing back (like asking someone to turn off the lights).
- Methods with a **return type** do work AND give a value back (like asking "What is 5 + 3?" and getting back `8`).

## The `return` Keyword

```java
public class Main {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(5, 3);
        System.out.println(result);    // 8
    }
}
```

### Symbol-by-symbol breakdown of `public static int add(int a, int b)`:
- `public` — Access modifier.
- `static` — Belongs to the class.
- `int` — The **return type**. This method gives back an `int` value. (Previously we used `void` which means "nothing.")
- `add` — Method name.
- `(int a, int b)` — Two parameters, both integers.

### Symbol-by-symbol breakdown of `return a + b;`:
- `return` — A Java **keyword** that means "send this value back to whoever called the method, and stop the method."
- `a + b` — The value to return. Java calculates `5 + 3 = 8` and sends `8` back.
- `;` — End of statement.

### Symbol-by-symbol breakdown of `int result = add(5, 3);`:
- `int result` — Declare a variable to store the returned value.
- `=` — Assign.
- `add(5, 3)` — Call the method. It returns `8`.
- `;` — End of statement.

After this line, `result` contains `8`.

## Different Return Types

```java
public static int multiply(int a, int b) {
    return a * b;
}

public static double divide(double a, double b) {
    return a / b;
}

public static String greet(String name) {
    return "Hello, " + name + "!";
}

public static boolean isAdult(int age) {
    return age >= 18;
}
```

The return type in the method declaration **must match** the type of value you return:
- `int` method → must return an `int`
- `double` method → must return a `double`
- `String` method → must return a `String`
- `boolean` method → must return a `boolean`

## Using Return Values

You can use a returned value in several ways:

```java
// 1. Store in a variable
int sum = add(5, 3);

// 2. Use directly in println
System.out.println(add(5, 3));

// 3. Use in another expression
int doubled = add(5, 3) * 2;    // 8 * 2 = 16

// 4. Use as an argument to another method
System.out.println("Sum: " + add(5, 3));
```

## `return` Stops the Method

Once `return` is reached, the method **immediately stops**. Code after `return` never runs:

```java
public static int getNumber() {
    return 42;
    System.out.println("This NEVER prints!");  // ❌ Unreachable code — error!
}
```

## `void` Methods and `return`

`void` methods can use `return;` (with no value) to exit early:

```java
public static void printIfPositive(int number) {
    if (number < 0) {
        return;    // Exit the method early — no value returned
    }
    System.out.println(number);
}
```

## Common Beginner Mistakes

1. **Returning the wrong type** — `int` method must return an `int`, not a `String`.
2. **Forgetting to return** — If a method has a return type (not `void`), every path must return a value.
3. **Not using the returned value** — `add(5, 3);` works but wastes the result. Store it or use it.
4. **Code after return** — Anything after `return` is unreachable and causes a compile error.
5. **Returning in a `void` method with a value** — `return 5;` in a `void` method is an error.

## Mini Practice Exercise

**Task:** Write a method `max` that takes two integers and returns the larger one.

**Answer:**
```java
public class Main {
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        System.out.println(max(10, 20));   // 20
        System.out.println(max(7, 3));     // 7
        System.out.println(max(5, 5));     // 5
    }
}
```

## Quiz

1. What does `return` do?
   - a) Prints a value
   - b) Sends a value back to the caller and stops the method ✅
   - c) Creates a variable

2. What return type means "no value returned"?
   - a) `int`
   - b) `null`
   - c) `void` ✅

3. What happens to code after a `return` statement?
   - a) It runs normally
   - b) It never runs (unreachable) ✅
   - c) It runs first

4. What is `add(5, 3)` if the `add` method returns `a + b`?
   - a) `53`
   - b) `8` ✅
   - c) `void`

---
**Next Lesson:** [Lesson 31 — Scope](31_Scope.md)
