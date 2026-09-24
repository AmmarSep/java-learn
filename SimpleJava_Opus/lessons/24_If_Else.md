# Lesson 24: `if`, `else if`, `else`

## Simple Explanation

An **`if` statement** lets your program make decisions. It checks a condition and runs code only if the condition is `true`.

**Analogy:** "**If** it's raining, take an umbrella. **Otherwise**, wear sunglasses."

## The `if` Statement

```java
public class Main {
    public static void main(String[] args) {
        int age = 20;

        if (age >= 18) {
            System.out.println("You are an adult");
        }
    }
}
```

**Output:** `You are an adult`

### Symbol-by-symbol breakdown:

- `if` — A Java **keyword** that starts a conditional check. It means "if the following condition is true, run the code inside the braces."
- ` ` — A space.
- `(` — An **opening parenthesis**. The condition must be inside parentheses.
- `age >= 18` — The **condition**. This is a comparison that produces a boolean (`true` or `false`). Here, `20 >= 18` is `true`.
- `)` — A **closing parenthesis**. End of the condition.
- ` ` — A space.
- `{` — An **opening curly brace**. Start of the code block to run if the condition is true.
- `System.out.println("You are an adult");` — The code to run if the condition is true.
- `}` — A **closing curly brace**. End of the code block.

**Important:** The condition inside `()` must be a **boolean** expression (something that results in `true` or `false`).

## The `if-else` Statement

```java
int age = 15;

if (age >= 18) {
    System.out.println("You are an adult");
} else {
    System.out.println("You are a minor");
}
```

**Output:** `You are a minor`

### Symbol-by-symbol breakdown of the `else` part:

- `}` — Closing brace of the `if` block.
- ` ` — A space.
- `else` — A Java **keyword** meaning "otherwise" or "if the condition above was false, do this instead."
- ` ` — A space.
- `{` — Opening brace of the `else` block.
- `System.out.println("You are a minor");` — Code to run when the `if` condition is false.
- `}` — Closing brace of the `else` block.

## The `if-else if-else` Chain

You can check multiple conditions:

```java
int score = 85;

if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else if (score >= 60) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F");
}
```

**Output:** `Grade: B`

### How it works:
1. Check `score >= 90` → `85 >= 90` → `false` → skip.
2. Check `score >= 80` → `85 >= 80` → `true` → run this block! Print "Grade: B".
3. **Stop checking** — once a condition is `true`, the rest are skipped.

### Symbol breakdown of `else if`:
- `else` — "Otherwise..."
- `if` — "...check this new condition."
- `(score >= 80)` — The new condition to check.
- `{` — Start of the code block for this condition.

## Nested `if` Statements

You can put `if` inside another `if`:

```java
int age = 20;
boolean hasTicket = true;

if (age >= 18) {
    if (hasTicket) {
        System.out.println("Welcome to the show!");
    } else {
        System.out.println("You need a ticket.");
    }
} else {
    System.out.println("You must be 18 or older.");
}
```

**Output:** `Welcome to the show!`

## The Ternary Operator (Shorthand `if-else`)

For simple cases, Java has a shortcut:

```java
int age = 20;
String status = (age >= 18) ? "adult" : "minor";
System.out.println(status);    // adult
```

### Symbol breakdown:
- `(age >= 18)` — The condition.
- `?` — A **question mark**. It means "if the condition is true, use the value after me."
- `"adult"` — The value if the condition is `true`.
- `:` — A **colon**. It means "otherwise, use the value after me."
- `"minor"` — The value if the condition is `false`.

This is the same as:
```java
String status;
if (age >= 18) {
    status = "adult";
} else {
    status = "minor";
}
```

## Common Beginner Mistakes

1. **Forgetting parentheses** — `if age >= 18` is wrong. Must be `if (age >= 18)`.
2. **Using `=` instead of `==`** — `if (x = 5)` is wrong. Use `if (x == 5)`.
3. **Adding a semicolon after `if`** — `if (x > 5);` means the `if` does nothing! The semicolon ends it prematurely.
4. **Forgetting curly braces** — Without `{}`, only the next single line is part of the `if`. Always use braces.
5. **Not covering all cases** — Always think about what happens when none of the conditions are true.

## Mini Practice Exercise

**Task:** Write a program that checks a temperature and prints:
- "Cold" if below 15
- "Warm" if between 15 and 25
- "Hot" if above 25

**Answer:**
```java
public class Main {
    public static void main(String[] args) {
        int temp = 22;

        if (temp < 15) {
            System.out.println("Cold");
        } else if (temp <= 25) {
            System.out.println("Warm");
        } else {
            System.out.println("Hot");
        }
    }
}
```

## Quiz

1. What must the condition inside `if ()` evaluate to?
   - a) A number
   - b) A String
   - c) A boolean (`true` or `false`) ✅

2. What happens if you write `if (x > 5);`?
   - a) It works normally
   - b) The `if` does nothing because of the semicolon ✅
   - c) Compilation error

3. How many `else` blocks can an `if` statement have?
   - a) None or one ✅
   - b) As many as you want
   - c) Exactly one

4. What does the ternary operator `?:` do?
   - a) It's a shorthand for `if-else` ✅
   - b) It creates a loop
   - c) It compares strings

---
**Next Lesson:** [Lesson 25 — `switch`](25_Switch.md)
