[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](18_Variables.md) · [Next](20_Var.md)

**Runnable companion:** [Phase1_Variables](../../examples/01-fundamentals/01-variables/Phase1_Variables.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 19: Data Types — `int`, `double`, `char`, `boolean`, `String`

## Simple Explanation

A **data type** tells Java what kind of value a variable can hold. Just like boxes come in different shapes for different things (a shoe box for shoes, a lunch box for food), variables have types for different kinds of data.

## The Two Categories

Java has two categories of data types:

### 1. Primitive Types (Built-in, Simple)

These are the basic building blocks. There are 8 primitive types, but you'll mostly use these 4:

| Type | What It Holds | Example | Default |
|------|--------------|---------|---------|
| `int` | Whole numbers | `int age = 25;` | `0` |
| `double` | Decimal numbers | `double price = 9.99;` | `0.0` |
| `char` | A single character | `char grade = 'A';` | `'\u0000'` |
| `boolean` | `true` or `false` | `boolean isActive = true;` | `false` |

The other 4 primitives (used less often): `byte`, `short`, `long`, `float`.

### 2. Reference Types (Objects)

These are more complex types. The most common one for beginners is:

| Type | What It Holds | Example |
|------|--------------|---------|
| `String` | Text (a sequence of characters) | `String name = "Alex";` |

**Key difference:** Primitive types start with a **lowercase** letter (`int`, `double`, `char`, `boolean`). `String` starts with an **uppercase** letter because it's a class (reference type).

## Complete Code Example

```java
public class Main {
    public static void main(String[] args) {
        // Primitive types
        int age = 25;
        double temperature = 98.6;
        char initial = 'A';
        boolean isRaining = false;

        // Reference type
        String city = "New York";

        // Print all variables
        System.out.println("Age: " + age);
        System.out.println("Temperature: " + temperature);
        System.out.println("Initial: " + initial);
        System.out.println("Is it raining? " + isRaining);
        System.out.println("City: " + city);
    }
}
```

**Output:**
```
Age: 25
Temperature: 98.6
Initial: A
Is it raining? false
City: New York
```

### Line-by-line breakdown:

- `int age = 25;` — `int` = type (whole number), `age` = name, `=` = assign, `25` = value, `;` = end.
- `double temperature = 98.6;` — `double` = type (decimal number), `temperature` = name, `98.6` = value.
- `char initial = 'A';` — `char` = type (single character), `initial` = name, `'A'` = value (note: single quotes).
- `boolean isRaining = false;` — `boolean` = type (true/false), `isRaining` = name, `false` = value.
- `String city = "New York";` — `String` = type (text), `city` = name, `"New York"` = value (note: double quotes, capital S).

## Type Safety

Java is **strongly typed** — you cannot put the wrong type of value into a variable:

```java
int age = 25;          // ✅ Correct: int holds a whole number
int age = 25.5;        // ❌ Error: int cannot hold a decimal
int age = "twenty";    // ❌ Error: int cannot hold text

double price = 9.99;   // ✅ Correct
double price = 10;     // ✅ Correct: Java converts 10 to 10.0 automatically

String name = "Alex";  // ✅ Correct
String name = 42;      // ❌ Error: String cannot hold a number

boolean done = true;   // ✅ Correct
boolean done = 1;      // ❌ Error: boolean cannot hold a number
```

## Type Conversion (Widening)

Java can automatically convert a "smaller" type to a "bigger" type:

```java
int whole = 10;
double decimal = whole;     // ✅ OK: int → double (10 becomes 10.0)
System.out.println(decimal); // Prints: 10.0
```

But NOT the other way around without explicit conversion:

```java
double decimal = 10.5;
int whole = decimal;        // ❌ Error: might lose the .5
int whole = (int) decimal;  // ✅ OK with "casting": whole = 10 (decimal part cut off)
```

- `(int)` — This is called a **cast**. It tells Java: "I know I might lose data, but do it anyway."
- The parentheses `()` around `int` are required for casting.

## When to Use Which Type

| I want to store... | Use this type |
|--------------------|---------------|
| A whole number (age, count, score) | `int` |
| A decimal number (price, weight, average) | `double` |
| A single letter or symbol | `char` |
| Yes/no, true/false | `boolean` |
| Text (name, address, message) | `String` |

## Common Beginner Mistakes

1. **Using the wrong type** — `int price = 9.99;` won't work. Use `double`.
2. **Forgetting that String has a capital S** — `string name = "Alex";` is wrong. It's `String`.
3. **Mixing up char and String quotes** — `char` uses `'single'`, `String` uses `"double"`.
4. **Thinking `int` can hold decimals** — It cannot. `int x = 3.5;` is an error.

## Mini Practice Exercise

**Task:** What data type would you use for each?

1. The number of students in a class → ?
2. The price of a product → ?
3. Someone's first initial → ?
4. Whether the store is open → ?
5. A person's full name → ?

**Answers:**
1. `int` (whole number)
2. `double` (decimal number)
3. `char` (single character)
4. `boolean` (true/false)
5. `String` (text)

## Quiz

1. Which type stores decimal numbers?
   - a) `int`
   - b) `double` ✅
   - c) `boolean`

2. Why does `String` start with a capital letter?
   - a) It's a style choice
   - b) Because it's a class (reference type), not a primitive ✅
   - c) It doesn't matter

3. What happens with `int x = 3.14;`?
   - a) x becomes 3
   - b) x becomes 3.14
   - c) Compilation error ✅

4. What type should you use for `true` or `false` values?
   - a) `int`
   - b) `String`
   - c) `boolean` ✅

---
**Next Lesson:** [Lesson 20 — `var` in Java](20_Var.md)
