# Lesson 13: Values

## Simple Explanation

A **value** is a piece of data — a number, some text, true/false, or any other data your program works with.

Think of values as the **ingredients** in a recipe. Just as recipes use flour, sugar, and eggs, programs use numbers, text, and other data.

## Types of Values in Java

Java has different **types** of values. Here are the main ones you'll use:

### 1. Integer Values (Whole Numbers)

Numbers without decimal points.

```java
System.out.println(42);       // 42 is an integer value
System.out.println(0);        // 0 is an integer value
System.out.println(-15);      // -15 is an integer value
System.out.println(1000000);  // 1000000 is an integer value
```

- No quotes around them.
- No decimal points.
- Can be positive, negative, or zero.

### 2. Decimal Values (Floating-Point Numbers)

Numbers with decimal points.

```java
System.out.println(3.14);     // 3.14 is a decimal value
System.out.println(0.5);      // 0.5 is a decimal value
System.out.println(-2.7);     // -2.7 is a decimal value
System.out.println(100.0);    // 100.0 is a decimal value (even though it's a "whole" number)
```

- No quotes around them.
- They have a decimal point `.`.
- `100` and `100.0` are different types in Java!

### 3. Text Values (Strings)

Text enclosed in **double quotes** `" "`.

```java
System.out.println("Hello");          // "Hello" is a String value
System.out.println("Java is fun");    // "Java is fun" is a String value
System.out.println("123");            // "123" is a String value (text, NOT a number!)
System.out.println("");               // "" is an empty String value
```

- Always surrounded by double quotes `" "`.
- Can contain letters, numbers, spaces, symbols — anything.
- `"123"` is text. `123` is a number. They look similar but Java treats them differently.

### 4. Character Values (Single Characters)

A single character enclosed in **single quotes** `' '`.

```java
System.out.println('A');      // 'A' is a character value
System.out.println('z');      // 'z' is a character value
System.out.println('7');      // '7' is a character value (the character, not the number)
System.out.println('!');      // '!' is a character value
```

- Always surrounded by single quotes `' '`.
- Must be exactly **one** character. `'AB'` is NOT valid.
- `'A'` (single quotes) is a character. `"A"` (double quotes) is a String. They are different types!

### 5. Boolean Values (True or False)

Only two possible values: `true` or `false`.

```java
System.out.println(true);     // true is a boolean value
System.out.println(false);    // false is a boolean value
```

- No quotes around them.
- Only `true` or `false` — nothing else.
- Used for yes/no, on/off, pass/fail decisions.

## Summary Table

| Value Type | Example | Quotes? |
|-----------|---------|---------|
| Integer (whole number) | `42`, `-7`, `0` | No quotes |
| Decimal (floating-point) | `3.14`, `-0.5` | No quotes |
| String (text) | `"Hello"`, `"123"` | Double quotes `" "` |
| Character (single character) | `'A'`, `'7'` | Single quotes `' '` |
| Boolean (true/false) | `true`, `false` | No quotes |

## Why Are Quotes Important?

Quotes tell Java **what type** a value is:

```java
System.out.println(42);       // NUMBER — Java can do math with this
System.out.println("42");     // TEXT — Java treats this as text, not a number
System.out.println('4');      // CHARACTER — a single character
```

This matters because:
```java
System.out.println(10 + 20);      // 30 (Java does math)
System.out.println("10" + "20");  // 1020 (Java joins text)
```

## Common Beginner Mistakes

1. **Confusing `"42"` and `42`** — One is text, the other is a number.
2. **Using single quotes for Strings** — `'Hello'` is wrong. Strings use double quotes: `"Hello"`.
3. **Using double quotes for characters** — `"A"` is a String, not a character. Characters use single quotes: `'A'`.
4. **Putting more than one character in single quotes** — `'AB'` is invalid. Single quotes are for one character only.
5. **Capitalizing `true` or `false`** — `True` and `False` are wrong. It must be lowercase: `true`, `false`.

## Mini Practice Exercise

**Task:** What type is each value?

1. `"Hello, World!"` → ?
2. `42` → ?
3. `3.14` → ?
4. `'X'` → ?
5. `true` → ?
6. `"true"` → ?

**Answers:**
1. String (text in double quotes)
2. Integer (whole number, no quotes)
3. Decimal / floating-point (number with decimal point)
4. Character (single character in single quotes)
5. Boolean (true/false value)
6. String (it's in double quotes, so it's text — not a boolean!)

## Quiz

1. Which of these is a String?
   - a) `42`
   - b) `"42"` ✅
   - c) `'4'`

2. What type of quotes does a character use?
   - a) Double quotes `" "`
   - b) Single quotes `' '` ✅
   - c) No quotes

3. What is the result of `"5" + "3"`?
   - a) `8`
   - b) `"53"` ✅
   - c) Error

4. What are the only two boolean values?
   - a) `yes` and `no`
   - b) `1` and `0`
   - c) `true` and `false` ✅

---
**Next Lesson:** [Lesson 14 — Strings](14_Strings.md)
