[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](13_Values.md) · [Next](15_Characters.md)

---

# Lesson 14: Strings

## Simple Explanation

A **String** is a sequence of characters — in other words, **text**. It can contain letters, numbers, spaces, symbols, or even nothing at all.

In Java, Strings are always wrapped in **double quotes** `" "`.

## Examples

```java
"Hello, World!"      // A String with letters, a comma, a space, and an exclamation mark
"Java"               // A String with 4 letters
"123"                // A String with digits (this is TEXT, not a number!)
""                   // An empty String (no characters at all)
"I am 25 years old"  // A String with letters, numbers, and spaces
" "                  // A String with just a space (this is NOT empty — it has one character)
```

## Printing Strings

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("My name is Alex");
        System.out.println("I love Java");
    }
}
```

### Symbol breakdown of the first line:
- `System` — Built-in class.
- `.` — Access inside System.
- `out` — Standard output (screen).
- `.` — Access inside out.
- `println` — Print and go to next line.
- `(` — Start of what to print.
- `"` — Opening double quote — start of the String.
- `Hello, World!` — The text content of the String.
- `"` — Closing double quote — end of the String.
- `)` — End of what to print.
- `;` — End of statement.

## String Concatenation (Joining Strings)

You can **join** Strings together using the `+` operator. This is called **concatenation**.

```java
System.out.println("Hello" + " " + "World");
```

**Output:** `Hello World`

- `"Hello"` — First String.
- `+` — Concatenation operator (joins Strings).
- `" "` — Second String (just a space).
- `+` — Join again.
- `"World"` — Third String.

### Joining Strings with Numbers:

```java
System.out.println("Age: " + 25);
```

**Output:** `Age: 25`

- `"Age: "` — A String.
- `+` — Concatenation.
- `25` — A number. Java automatically converts it to the text `"25"` and joins it.

## Important Facts About Strings

1. **Strings use double quotes** — `"Hello"` (not single quotes `'Hello'`).
2. **Strings are objects** — `String` starts with a capital `S` because it's a class (a special type). We'll learn about classes and objects later.
3. **Strings are immutable** — Once a String is created, it cannot be changed. When you "change" a String, Java actually creates a new one. (More on this later.)
4. **Empty String vs. null** — `""` is an empty String (it exists, but has no characters). `null` means "no String at all" (it doesn't exist). We'll cover `null` later.

## String Length

You can find out how many characters are in a String:

```java
System.out.println("Hello".length());
```

**Output:** `5`

### Symbol breakdown:
- `"Hello"` — A String with 5 characters.
- `.` — Access something inside this String.
- `length` — A method (action) that counts the number of characters.
- `()` — Parentheses to call (use) the method. No value between them because `length` doesn't need any input.

## Common Beginner Mistakes

1. **Using single quotes** — `'Hello'` is wrong for Strings. Use double quotes: `"Hello"`.
2. **Forgetting to close quotes** — `"Hello` without the second `"` causes an error.
3. **Confusing `"123"` with `123`** — The first is text, the second is a number.
4. **String concatenation surprises** — `"5" + 3` gives `"53"` (text), not `8` (number).

## Mini Practice Exercise

**Task:** What is the output of each line?

```java
System.out.println("Java" + " is " + "cool");
System.out.println("The year is " + 2024);
System.out.println("Hello".length());
System.out.println("".length());
```

**Answers:**
1. `Java is cool`
2. `The year is 2024`
3. `5`
4. `0` (empty String has zero characters)

## Quiz

1. What quotes do Strings use?
   - a) Single quotes `' '`
   - b) Double quotes `" "` ✅
   - c) No quotes

2. What does `"Hello" + " " + "World"` produce?
   - a) `HelloWorld`
   - b) `Hello World` ✅
   - c) `Hello + World`

3. What does `"Java".length()` return?
   - a) `3`
   - b) `4` ✅
   - c) `5`

4. What type is `"100"`?
   - a) A number
   - b) A String ✅
   - c) A boolean

---
**Next Lesson:** [Lesson 15 — Characters](15_Characters.md)
