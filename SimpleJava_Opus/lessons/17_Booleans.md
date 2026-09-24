# Lesson 17: Booleans

## Simple Explanation

A **boolean** is a value that can only be one of two things: `true` or `false`.

Think of it like a light switch — it's either **on** (`true`) or **off** (`false`). There's nothing in between.

Booleans are used to make **decisions** in programs: "Is the user logged in? Yes or no? Is the number greater than 10? True or false?"

## The `boolean` Type

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(true);      // Prints: true
        System.out.println(false);     // Prints: false
    }
}
```

- `true` — A keyword in Java meaning "yes" or "correct."
- `false` — A keyword in Java meaning "no" or "incorrect."
- No quotes around them! `true` is a boolean. `"true"` is a String (text).

## Comparisons Produce Booleans

When you compare two values, the result is always a boolean:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(5 > 3);      // true (5 is greater than 3)
        System.out.println(5 < 3);      // false (5 is NOT less than 3)
        System.out.println(5 == 5);     // true (5 equals 5)
        System.out.println(5 != 3);     // true (5 is NOT equal to 3)
        System.out.println(10 >= 10);   // true (10 is greater than or equal to 10)
        System.out.println(10 <= 5);    // false (10 is NOT less than or equal to 5)
    }
}
```

### Comparison Operators:

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `>` | Greater than | `5 > 3` | `true` |
| `<` | Less than | `5 < 3` | `false` |
| `>=` | Greater than or equal to | `5 >= 5` | `true` |
| `<=` | Less than or equal to | `5 <= 3` | `false` |
| `==` | Equal to | `5 == 5` | `true` |
| `!=` | Not equal to | `5 != 3` | `true` |

### Important: `==` vs `=`
- `==` (two equals signs) means "is equal to?" — it's a **comparison**.
- `=` (one equals sign) means "assign this value" — it **stores** a value. We'll see this with variables.

## Why Are Booleans Useful?

Booleans are the foundation of **decision-making** in programs. Later, you'll write code like:

```java
if (age >= 18) {
    System.out.println("You can vote");
}
```

The part `age >= 18` produces a boolean: `true` or `false`. If it's `true`, the code inside the braces runs. If it's `false`, it's skipped. (We'll learn `if` statements later.)

## Common Beginner Mistakes

1. **Capitalizing `true` or `false`** — `True`, `False`, `TRUE`, `FALSE` are all wrong. It must be lowercase: `true`, `false`.
2. **Adding quotes** — `"true"` is a String (text), not a boolean. `true` (no quotes) is a boolean.
3. **Using `=` instead of `==`** — `5 = 5` is assignment (wrong here). `5 == 5` is comparison (correct).
4. **Thinking booleans can be numbers** — In Java, `true` is not `1` and `false` is not `0`. They are their own type.

## Mini Practice Exercise

**Task:** What does each line print?

```java
System.out.println(10 > 5);
System.out.println(10 < 5);
System.out.println(10 == 10);
System.out.println(10 != 10);
System.out.println(3 >= 3);
```

**Answers:**
1. `true`
2. `false`
3. `true`
4. `false`
5. `true`

## Quiz

1. What are the only two boolean values?
   - a) `yes` and `no`
   - b) `1` and `0`
   - c) `true` and `false` ✅

2. What does `5 == 5` give?
   - a) `5`
   - b) `true` ✅
   - c) `false`

3. What is the difference between `=` and `==`?
   - a) They are the same
   - b) `=` assigns a value, `==` compares values ✅
   - c) `==` assigns a value, `=` compares values

4. Is `"false"` a boolean?
   - a) Yes
   - b) No ✅ — It's a String because it has quotes.

---
**Next Lesson:** [Lesson 18 — Variables](18_Variables.md)
