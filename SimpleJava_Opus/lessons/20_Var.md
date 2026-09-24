# Lesson 20: `var` in Java

## Simple Explanation

Starting from Java 10, you can use the keyword `var` instead of writing the specific data type. Java will **figure out** the type automatically based on the value you assign.

This is called **type inference** — Java "infers" (figures out) the type for you.

## Before `var` (Explicit Type)

```java
int age = 25;
double price = 9.99;
String name = "Alex";
boolean isActive = true;
```

## With `var` (Type Inference)

```java
var age = 25;          // Java knows this is an int
var price = 9.99;      // Java knows this is a double
var name = "Alex";     // Java knows this is a String
var isActive = true;   // Java knows this is a boolean
```

Both versions do **exactly the same thing**. With `var`, Java looks at the value on the right side and determines the type automatically.

### Symbol breakdown of `var age = 25;`:
- `var` — A special keyword that tells Java: "figure out the type from the value."
- `age` — The name of the variable.
- `=` — Assignment operator (store this value).
- `25` — The value. Java sees this is a whole number, so it makes the variable an `int`.
- `;` — End of statement.

## Rules for Using `var`

### Rule 1: You MUST assign a value immediately

```java
var age = 25;     // ✅ OK — Java can see the type from 25
var age;          // ❌ Error — Java can't figure out the type without a value
```

### Rule 2: `var` only works for local variables

**Local variables** are variables declared inside a method:

```java
public class Main {
    // var name = "Alex";  // ❌ Error — can't use var for class-level variables

    public static void main(String[] args) {
        var name = "Alex";   // ✅ OK — inside a method
        System.out.println(name);
    }
}
```

### Rule 3: The type is fixed after creation

```java
var x = 10;        // x is an int
x = 20;            // ✅ OK — still an int
x = "Hello";       // ❌ Error — can't change an int to a String
```

Once Java decides the type, you cannot change it. `var` does NOT mean the variable can hold any type.

## When to Use `var`

### Good uses (type is clear):
```java
var name = "Alex";                    // Clearly a String
var count = 42;                       // Clearly an int
var isReady = true;                   // Clearly a boolean
```

### Avoid when type is unclear:
```java
var result = doSomething();           // What type is result? Hard to tell.
```

**Tip for beginners:** It's perfectly fine to always use explicit types (`int`, `String`, etc.) instead of `var`. Use whatever makes your code clearest.

## Common Beginner Mistakes

1. **Using `var` without a value** — `var x;` doesn't work. You must assign a value.
2. **Thinking `var` means "any type"** — `var` is NOT like `var` in JavaScript. The type is fixed once assigned.
3. **Using `var` for class fields** — `var` only works inside methods.
4. **Thinking `var` is a data type** — `var` is not a type; it's a shortcut that lets Java figure out the type.

## Mini Practice Exercise

**Task:** Rewrite these lines using `var`:

```java
int count = 100;
String message = "Hello";
double pi = 3.14;
boolean done = false;
```

**Answer:**
```java
var count = 100;
var message = "Hello";
var pi = 3.14;
var done = false;
```

## Quiz

1. What does `var` do?
   - a) Creates a variable that can hold any type
   - b) Lets Java figure out the type from the assigned value ✅
   - c) Creates a variable with no type

2. Is `var x;` valid?
   - a) Yes
   - b) No ✅ — You must assign a value when using `var`.

3. Can you use `var` outside a method?
   - a) Yes
   - b) No ✅ — `var` only works for local variables inside methods.

4. After `var x = 10;`, can you write `x = "Hello";`?
   - a) Yes
   - b) No ✅ — `x` is an `int` and cannot hold a String.

---
**Next Lesson:** [Lesson 21 — Operators](21_Operators.md)
