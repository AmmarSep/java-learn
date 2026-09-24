# Lesson 12: Printing with `System.out.println`

## Simple Explanation

**Printing** means displaying text or values on the screen. In Java, you use `System.out.println()` to print something and move to a new line.

## The Three Print Methods

### 1. `System.out.println()` — Print Line

Prints the value and then moves the cursor to the **next line**.

```java
System.out.println("Hello");
System.out.println("World");
```

**Output:**
```
Hello
World
```

Each value appears on its own line because `println` adds a **new line** at the end.

### Symbol-by-Symbol Breakdown:

- `System` — A built-in Java class that gives access to system resources.
- `.` — The dot means "access something inside." Go inside `System`.
- `out` — A static field inside `System`. It represents the **standard output** (your screen/terminal).
- `.` — Another dot. Go inside `out`.
- `println` — A method that **prints** text and then moves to a **new line**. The name is short for "print line."
- `(` — Opening parenthesis. Start of what we're giving to the method.
- `"Hello"` — A **String** (text). The double quotes `" "` tell Java this is text.
- `)` — Closing parenthesis. End of what we're giving to the method.
- `;` — Semicolon. End of the statement.

### 2. `System.out.print()` — Print (No New Line)

Prints the value but does **NOT** move to the next line. The next thing printed will appear on the **same line**.

```java
System.out.print("Hello");
System.out.print(" ");
System.out.print("World");
```

**Output:**
```
Hello World
```

Everything is on one line because `print` does **not** add a new line.

### Difference between `println` and `print`:

```java
// Using println (each on its own line)
System.out.println("A");
System.out.println("B");
// Output:
// A
// B

// Using print (all on the same line)
System.out.print("A");
System.out.print("B");
// Output:
// AB
```

### 3. `System.out.printf()` — Formatted Print

Prints with **formatting** — you can control exactly how values appear. We'll cover this in more detail later.

```java
System.out.printf("My name is %s and I am %d years old", "Alex", 25);
```

**Output:**
```
My name is Alex and I am 25 years old
```

- `%s` is a **placeholder** for a String (text).
- `%d` is a placeholder for an integer (whole number).
- The values after the comma replace the placeholders in order.

Don't worry about `printf` for now. We'll come back to it.

## What Can You Print?

### Text (Strings):
```java
System.out.println("Hello, World!");     // Prints: Hello, World!
System.out.println("Java is fun");       // Prints: Java is fun
System.out.println("");                  // Prints an empty line
```

### Numbers:
```java
System.out.println(42);                  // Prints: 42
System.out.println(3.14);               // Prints: 3.14
System.out.println(-7);                 // Prints: -7
```

Notice: numbers are written **without** quotes. If you add quotes, Java treats them as text, not numbers:

```java
System.out.println(42);     // This is the NUMBER 42
System.out.println("42");   // This is the TEXT "42" (looks the same, but Java treats it differently)
```

### Math Expressions:
```java
System.out.println(5 + 3);              // Prints: 8
System.out.println(10 - 4);             // Prints: 6
System.out.println(3 * 7);              // Prints: 21
System.out.println(20 / 4);             // Prints: 5
```

Java calculates the math **first**, then prints the **result**.

### Combining Text and Values:

You can use `+` to combine (concatenate) text with other values:

```java
System.out.println("The answer is " + 42);
```

**Output:**
```
The answer is 42
```

- `"The answer is "` — A String (text). Notice the space before the closing quote.
- `+` — The **concatenation operator** when used with Strings. It joins things together.
- `42` — A number.
- Java converts the number to text and joins them.

More examples:

```java
System.out.println("I am " + 25 + " years old");
// Output: I am 25 years old

System.out.println("5 + 3 = " + (5 + 3));
// Output: 5 + 3 = 8
```

In the second example:
- `(5 + 3)` — Parentheses force Java to do the math first (result: 8).
- Then `"5 + 3 = " + 8` joins the text and the number.

Without parentheses:
```java
System.out.println("5 + 3 = " + 5 + 3);
// Output: 5 + 3 = 53    ← NOT what we wanted!
```

Why? Because `+` with a String means "join as text." So `"5 + 3 = " + 5` gives `"5 + 3 = 5"`, then `+ 3` gives `"5 + 3 = 53"`.

### Empty `println`:
```java
System.out.println();   // Just prints a blank line
```

No value between the parentheses — just prints a new line.

## Special Characters (Escape Sequences)

What if you want to print a quote mark or a new line inside a String? You use **escape sequences** — special codes that start with a backslash `\`.

| Escape Sequence | What It Does | Example |
|----------------|-------------|---------|
| `\n` | New line | `"Line1\nLine2"` |
| `\t` | Tab (indent) | `"Name\tAge"` |
| `\"` | Double quote | `"She said \"Hi\""` |
| `\\` | Backslash | `"C:\\folder"` |

```java
System.out.println("Hello\nWorld");
// Output:
// Hello
// World

System.out.println("Name\tAge");
// Output:
// Name    Age

System.out.println("She said \"Hi\"");
// Output:
// She said "Hi"

System.out.println("C:\\Users\\Documents");
// Output:
// C:\Users\Documents
```

### Breakdown of `"She said \"Hi\""`:
- `"` — Opening double quote (start of String).
- `She said ` — Regular text.
- `\"` — An **escaped double quote**. The backslash `\` tells Java "the next character is special — treat this quote as text, not as the end of the String."
- `Hi` — Regular text.
- `\"` — Another escaped double quote.
- `"` — Closing double quote (end of String).

## Common Beginner Mistakes

1. **Forgetting the parentheses** — `System.out.println;` won't work. You need `()`.
2. **Forgetting the semicolon** — `System.out.println("Hi")` needs `;` at the end.
3. **Using `Println` instead of `println`** — Java is case-sensitive. It's lowercase `p`.
4. **Confusing `print` and `println`** — `println` adds a new line, `print` does not.
5. **Forgetting quotes around text** — `System.out.println(Hello);` will cause an error. Text needs quotes: `"Hello"`.
6. **Unexpected concatenation** — `"result: " + 5 + 3` gives `"result: 53"`, not `"result: 8"`. Use parentheses: `"result: " + (5 + 3)`.

## Mini Practice Exercise

**Task:** Write a program that prints:
```
Name: Alex
Age: 25
City: New York
```

**Answer:**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Name: Alex");
        System.out.println("Age: " + 25);
        System.out.println("City: New York");
    }
}
```

## Quiz

1. What is the difference between `print` and `println`?
   - a) `print` is faster
   - b) `println` adds a new line after printing, `print` does not ✅
   - c) They are the same

2. What does `System.out.println(5 + 3)` print?
   - a) `5 + 3`
   - b) `53`
   - c) `8` ✅

3. What does `System.out.println("5 + 3")` print?
   - a) `5 + 3` ✅
   - b) `53`
   - c) `8`

4. What does `\n` do inside a String?
   - a) Prints the letter n
   - b) Creates a new line ✅
   - c) Prints a backslash

5. What does `System.out.println("Hi " + "there")` print?
   - a) `Hi there` ✅
   - b) `Hi + there`
   - c) Error

---
**Next Lesson:** [Lesson 13 — Values](13_Values.md)
