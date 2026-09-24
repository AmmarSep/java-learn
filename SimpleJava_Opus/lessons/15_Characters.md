# Lesson 15: Characters

## Simple Explanation

A **character** is a single letter, digit, or symbol. In Java, a character is represented by the `char` type and is wrapped in **single quotes** `' '`.

Think of a character as a **single building block** of text. A String is made up of many characters, but a `char` is just **one**.

## Examples

```java
'A'    // The letter A
'z'    // The letter z
'7'    // The digit 7 (as a character, not a number!)
'!'    // An exclamation mark
' '    // A space (yes, a space is a character)
'@'    // The at symbol
```

## Code Example

```java
public class Main {
    public static void main(String[] args) {
        System.out.println('A');
        System.out.println('B');
        System.out.println('1');
        System.out.println('!');
    }
}
```

**Output:**
```
A
B
1
!
```

### Symbol breakdown of the first line:
- `System.out.println` — Print and go to new line (we know this from before).
- `(` — Start of what to print.
- `'` — Opening **single quote** — start of a character value.
- `A` — The character itself.
- `'` — Closing **single quote** — end of the character value.
- `)` — End of what to print.
- `;` — End of statement.

## Character vs. String

This is a very important distinction:

| Feature | Character (`char`) | String (`String`) |
|---------|-------------------|-------------------|
| Quotes | Single quotes `' '` | Double quotes `" "` |
| Length | Always exactly **1** | Can be 0, 1, or many |
| Example | `'A'` | `"A"` or `"Hello"` |
| Type name | `char` (lowercase) | `String` (uppercase S) |

```java
System.out.println('A');     // This is a char
System.out.println("A");    // This is a String (that happens to have 1 character)
```

Both print `A`, but Java treats them as different types.

## Characters and Numbers

Every character has a number behind it. This comes from a system called **Unicode** (and its subset **ASCII**). For example:

- `'A'` = 65
- `'B'` = 66
- `'a'` = 97
- `'0'` = 48

You can see this by doing math with characters:

```java
System.out.println('A' + 0);    // Prints: 65
System.out.println('a' + 0);    // Prints: 97
System.out.println('0' + 0);    // Prints: 48
```

### Why does this work?
- `'A'` — The character A.
- `+` — Addition operator.
- `0` — The number zero.
- When you add a `char` and a number, Java converts the character to its numeric value first.
- So `'A' + 0` becomes `65 + 0` = `65`.

You don't need to memorize these numbers. Just know that characters have numeric values behind them.

## Special Characters

Just like with Strings, you can use escape sequences:

```java
System.out.println('\'');    // Prints: '  (a single quote character)
System.out.println('\\');    // Prints: \  (a backslash character)
System.out.println('\n');    // Prints a new line
System.out.println('\t');    // Prints a tab
```

- `'\''` — The backslash `\` tells Java: "the next character is special." So `\'` means "a literal single quote character."
- `'\\'` — Two backslashes `\\` mean "a literal backslash character."

## Common Beginner Mistakes

1. **Using double quotes for a character** — `"A"` is a String, not a char. Use `'A'`.
2. **Putting multiple characters in single quotes** — `'AB'` is invalid! Single quotes are for exactly **one** character.
3. **Empty single quotes** — `''` is invalid! A char must have exactly one character. (An empty String `""` is fine, but an empty char is not.)
4. **Confusing `'7'` with `7`** — `'7'` is the character seven (numeric value 55). `7` is the number seven.

## Mini Practice Exercise

**Task:** What is the output of each line?

```java
System.out.println('H');
System.out.println('i');
System.out.println('!');
System.out.println('A' + 1);
```

**Answers:**
1. `H`
2. `i`
3. `!`
4. `66` — Because `'A'` is 65, and `65 + 1` = `66`.

## Quiz

1. What quotes does a `char` use?
   - a) Double quotes `" "`
   - b) Single quotes `' '` ✅
   - c) No quotes

2. Is `'AB'` valid in Java?
   - a) Yes
   - b) No ✅ — Single quotes can only hold one character.

3. What is the difference between `'A'` and `"A"`?
   - a) They are the same
   - b) `'A'` is a char, `"A"` is a String ✅
   - c) `'A'` is a String, `"A"` is a char

4. Is `''` (empty single quotes) valid?
   - a) Yes
   - b) No ✅ — A char must have exactly one character.

---
**Next Lesson:** [Lesson 16 — Numbers](16_Numbers.md)
