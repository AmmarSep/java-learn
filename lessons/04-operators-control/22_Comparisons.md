[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](21_Operators.md) · [Next](23_Logical_Operators.md)

**Runnable companion:** [Phase1_Operators](../../examples/01-fundamentals/02-operators/Phase1_Operators.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 22: Comparisons

## Simple Explanation

**Comparison operators** compare two values and give you a **boolean** result: `true` or `false`.

Think of them as questions: "Is 5 greater than 3?" → `true`.

## Comparison Operators

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `==` | Equal to | `5 == 5` | `true` |
| `!=` | Not equal to | `5 != 3` | `true` |
| `>` | Greater than | `5 > 3` | `true` |
| `<` | Less than | `5 < 3` | `false` |
| `>=` | Greater than or equal to | `5 >= 5` | `true` |
| `<=` | Less than or equal to | `3 <= 5` | `true` |

## Code Example

```java
public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(a == b);    // false (10 is not equal to 20)
        System.out.println(a != b);    // true (10 is not equal to 20)
        System.out.println(a > b);     // false (10 is not greater than 20)
        System.out.println(a < b);     // true (10 is less than 20)
        System.out.println(a >= 10);   // true (10 is greater than or equal to 10)
        System.out.println(a <= 5);    // false (10 is not less than or equal to 5)
    }
}
```

### Symbol breakdown of `a == b`:
- `a` — The variable `a` (value: 10).
- `==` — Two equals signs. The comparison operator meaning "is equal to?"
- `b` — The variable `b` (value: 20).
- The result is `false` because 10 is not equal to 20.

### Symbol breakdown of `a != b`:
- `a` — Variable `a`.
- `!=` — Exclamation mark followed by equals sign. Means "is NOT equal to?"
- `b` — Variable `b`.
- The result is `true` because 10 is indeed not equal to 20.

### Symbol breakdown of `a >= 10`:
- `a` — Variable `a`.
- `>=` — Greater-than sign followed by equals sign. Means "is greater than OR equal to?"
- `10` — The number to compare against.
- The result is `true` because 10 is equal to 10.

## Comparing Strings (Special Case!)

For Strings, **do NOT use `==`**. Use the `.equals()` method instead:

```java
String name1 = "Alex";
String name2 = "Alex";

// ❌ Don't do this for Strings:
System.out.println(name1 == name2);      // Might give wrong results!

// ✅ Do this instead:
System.out.println(name1.equals(name2)); // true
```

### Why?
- `==` compares whether two variables point to the **same object in memory** (not the content).
- `.equals()` compares the **actual text content**.

### Symbol breakdown of `name1.equals(name2)`:
- `name1` — The first String variable.
- `.` — Access something inside name1.
- `equals` — A method that checks if two Strings have the same text.
- `(` — Start of what we're giving to the method.
- `name2` — The String to compare against.
- `)` — End of what we're giving to the method.

## Storing Comparison Results

You can store a comparison result in a `boolean` variable:

```java
int age = 20;
boolean isAdult = age >= 18;       // true
boolean isTeenager = age < 18;     // false

System.out.println("Is adult: " + isAdult);       // Is adult: true
System.out.println("Is teenager: " + isTeenager); // Is teenager: false
```

## Common Beginner Mistakes

1. **Using `=` instead of `==`** — `=` assigns, `==` compares. `if (x = 5)` is wrong; use `if (x == 5)`.
2. **Using `==` for Strings** — Use `.equals()` for String comparison.
3. **Confusing `>=` with `=>`** — It's `>=` (greater-than first), not `=>`.
4. **Confusing `<=` with `=<`** — It's `<=` (less-than first), not `=<`.

## Mini Practice Exercise

**Task:** What does each line print?

```java
System.out.println(10 == 10);
System.out.println(10 != 10);
System.out.println(5 > 10);
System.out.println(5 <= 5);
System.out.println("Java".equals("Java"));
```

**Answers:**
1. `true`
2. `false`
3. `false`
4. `true`
5. `true`

## Quiz

1. What does `==` do?
   - a) Assigns a value
   - b) Checks if two values are equal ✅
   - c) Adds two values

2. What does `!=` mean?
   - a) Equal to
   - b) Not equal to ✅
   - c) Less than

3. How should you compare Strings?
   - a) Using `==`
   - b) Using `.equals()` ✅
   - c) Using `>`

4. What is the result of `5 >= 5`?
   - a) `true` ✅
   - b) `false`
   - c) `5`

---
**Next Lesson:** [Lesson 23 — Logical Operators](23_Logical_Operators.md)
