# Lesson 16: Numbers

## Simple Explanation

Java has two main categories of numbers:
1. **Integers** — whole numbers (no decimal point): `42`, `-7`, `0`
2. **Floating-point numbers** — decimal numbers: `3.14`, `-0.5`, `100.0`

## Integer Types

Java has four integer types, each holding a different range of numbers:

| Type | Size | Range | Example |
|------|------|-------|---------|
| `byte` | 1 byte | -128 to 127 | `byte b = 100;` |
| `short` | 2 bytes | -32,768 to 32,767 | `short s = 30000;` |
| `int` | 4 bytes | about -2.1 billion to 2.1 billion | `int x = 42;` |
| `long` | 8 bytes | extremely large range | `long big = 9999999999L;` |

**For beginners: just use `int`.** It covers most needs.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(42);         // An int value
        System.out.println(-7);         // A negative int
        System.out.println(0);          // Zero
        System.out.println(1000000);    // One million
    }
}
```

### About `long`:
When a number is too big for `int`, use `long`. You must add `L` at the end:

```java
System.out.println(9999999999L);    // The L tells Java this is a long
```

- `9999999999` — This number is too big for `int`.
- `L` — The letter L (uppercase) at the end tells Java: "treat this as a `long`."

## Floating-Point Types

Java has two decimal number types:

| Type | Size | Precision | Example |
|------|------|-----------|---------|
| `float` | 4 bytes | ~7 decimal digits | `float f = 3.14f;` |
| `double` | 8 bytes | ~15 decimal digits | `double d = 3.14;` |

**For beginners: just use `double`.** It's the default for decimal numbers.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(3.14);       // A double value
        System.out.println(-0.5);       // A negative double
        System.out.println(100.0);      // 100 as a double
        System.out.println(0.001);      // A small double
    }
}
```

### About `float`:
If you specifically want a `float`, add `f` at the end:

```java
System.out.println(3.14f);     // The f tells Java this is a float
```

- `3.14` — Without `f`, Java treats this as a `double`.
- `3.14f` — With `f`, Java treats this as a `float`.

## Basic Math Operations

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(10 + 3);     // Addition: 13
        System.out.println(10 - 3);     // Subtraction: 7
        System.out.println(10 * 3);     // Multiplication: 30
        System.out.println(10 / 3);     // Division: 3 (not 3.333!)
        System.out.println(10 % 3);     // Modulus (remainder): 1
    }
}
```

### Symbol breakdown:
- `+` — Addition. Adds two numbers.
- `-` — Subtraction. Subtracts the right number from the left.
- `*` — Multiplication. An asterisk `*`, not the letter `x`.
- `/` — Division. A forward slash.
- `%` — Modulus (remainder). Gives the leftover after division. `10 % 3` = `1` because 10 ÷ 3 = 3 remainder **1**.

## Integer Division (Important!)

When you divide two integers, Java gives you an **integer result** — it cuts off the decimal part:

```java
System.out.println(10 / 3);      // 3 (not 3.333...)
System.out.println(7 / 2);       // 3 (not 3.5)
System.out.println(1 / 2);       // 0 (not 0.5)
```

To get a decimal result, at least one number must be a `double`:

```java
System.out.println(10.0 / 3);    // 3.3333333333333335
System.out.println(7 / 2.0);     // 3.5
System.out.println(1.0 / 2.0);   // 0.5
```

## Order of Operations

Java follows standard math rules (PEMDAS/BODMAS):

1. Parentheses `()` first
2. Multiplication `*`, Division `/`, Modulus `%` second
3. Addition `+`, Subtraction `-` last

```java
System.out.println(2 + 3 * 4);       // 14 (not 20!) — multiplication first
System.out.println((2 + 3) * 4);     // 20 — parentheses force addition first
```

## Common Beginner Mistakes

1. **Integer division surprise** — `10 / 3` gives `3`, not `3.333`. Use `10.0 / 3` for decimals.
2. **Forgetting `L` for long** — `9999999999` without `L` causes an error.
3. **Forgetting `f` for float** — `3.14` is a `double`, not a `float`. Use `3.14f` for float.
4. **Using `x` for multiplication** — It's `*` (asterisk), not `x`.
5. **Division by zero** — `10 / 0` causes an error! You cannot divide by zero with integers.

## Mini Practice Exercise

**Task:** What does each line print?

```java
System.out.println(15 + 5);
System.out.println(15 - 5);
System.out.println(15 * 5);
System.out.println(15 / 5);
System.out.println(15 % 5);
System.out.println(7 / 2);
System.out.println(7.0 / 2);
```

**Answers:**
1. `20`
2. `10`
3. `75`
4. `3`
5. `0` (15 ÷ 5 = 3 with no remainder)
6. `3` (integer division cuts off .5)
7. `3.5` (double division keeps decimals)

## Quiz

1. What is the default type for whole numbers in Java?
   - a) `long`
   - b) `int` ✅
   - c) `short`

2. What does `10 / 3` give?
   - a) `3.333`
   - b) `3` ✅
   - c) `4`

3. What does the `%` operator do?
   - a) Calculates a percentage
   - b) Gives the remainder after division ✅
   - c) Multiplies by 100

4. What letter do you add to make a number a `long`?
   - a) `D`
   - b) `F`
   - c) `L` ✅

---
**Next Lesson:** [Lesson 17 — Booleans](17_Booleans.md)
