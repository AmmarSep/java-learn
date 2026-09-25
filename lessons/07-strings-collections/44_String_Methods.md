[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](43_Strings_Detail.md) · [Next](45_Wrapper_Classes.md)

---

# Lesson 44: String Methods

## Simple Explanation

The `String` class has many useful methods. Remember: since Strings are **immutable**, these methods **return new Strings** — they don't change the original.

## Essential String Methods

```java
String s = "Hello, World!";
```

| Method | What It Does | Example | Result |
|--------|-------------|---------|--------|
| `length()` | Returns the number of characters | `s.length()` | `13` |
| `charAt(i)` | Returns character at index `i` | `s.charAt(0)` | `'H'` |
| `toUpperCase()` | Returns all uppercase | `s.toUpperCase()` | `"HELLO, WORLD!"` |
| `toLowerCase()` | Returns all lowercase | `s.toLowerCase()` | `"hello, world!"` |
| `trim()` | Removes leading/trailing spaces | `"  Hi  ".trim()` | `"Hi"` |
| `contains(str)` | Checks if it contains a substring | `s.contains("World")` | `true` |
| `startsWith(str)` | Checks if it starts with | `s.startsWith("Hello")` | `true` |
| `endsWith(str)` | Checks if it ends with | `s.endsWith("!")` | `true` |
| `indexOf(str)` | Finds first position of substring | `s.indexOf("World")` | `7` |
| `substring(start)` | Returns from start to end | `s.substring(7)` | `"World!"` |
| `substring(start, end)` | Returns from start to end-1 | `s.substring(0, 5)` | `"Hello"` |
| `replace(old, new)` | Replaces all occurrences | `s.replace("World", "Java")` | `"Hello, Java!"` |
| `equals(str)` | Compares content | `s.equals("Hello, World!")` | `true` |
| `equalsIgnoreCase(str)` | Compares ignoring case | `"abc".equalsIgnoreCase("ABC")` | `true` |
| `isEmpty()` | Checks if length is 0 | `"".isEmpty()` | `true` |
| `isBlank()` | Checks if empty or only spaces | `"  ".isBlank()` | `true` |
| `split(regex)` | Splits into array | `"a,b,c".split(",")` | `["a","b","c"]` |

## Code Examples

```java
public class Main {
    public static void main(String[] args) {
        String message = "  Hello, Java World!  ";

        // Length
        System.out.println(message.length());           // 22

        // Trim spaces
        String trimmed = message.trim();
        System.out.println(trimmed);                    // "Hello, Java World!"

        // Case
        System.out.println(trimmed.toUpperCase());      // "HELLO, JAVA WORLD!"
        System.out.println(trimmed.toLowerCase());      // "hello, java world!"

        // Search
        System.out.println(trimmed.contains("Java"));   // true
        System.out.println(trimmed.indexOf("Java"));    // 7

        // Substring
        System.out.println(trimmed.substring(7, 11));   // "Java"

        // Replace
        System.out.println(trimmed.replace("Java", "Python")); // "Hello, Python World!"

        // Split
        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit);    // apple, banana, cherry (one per line)
        }

        // Compare
        System.out.println("hello".equals("hello"));           // true
        System.out.println("hello".equals("Hello"));           // false
        System.out.println("hello".equalsIgnoreCase("Hello")); // true
    }
}
```

### Symbol breakdown of `trimmed.substring(7, 11)`:
- `trimmed` — The String object.
- `.` — Access a method inside this String.
- `substring` — Method that extracts a portion of the String.
- `(` — Start of arguments.
- `7` — Start index (inclusive — includes this position).
- `,` — Comma separating arguments.
- `11` — End index (exclusive — does NOT include this position).
- `)` — End of arguments.

So indices 7, 8, 9, 10 give us `"Java"`.

## `StringBuilder` — For Efficient String Building

Since Strings are immutable, building a String with `+` in a loop creates many temporary objects. `StringBuilder` is more efficient:

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ");
sb.append("World");
String result = sb.toString();    // "Hello World"
```

### Symbol breakdown of `sb.append("Hello")`:
- `sb` — The StringBuilder object.
- `.` — Access method.
- `append` — Method that adds text to the end.
- `("Hello")` — The text to add.

## Common Beginner Mistakes

1. **Forgetting methods return new Strings** — `s.toUpperCase();` alone does nothing. Save it: `s = s.toUpperCase();`
2. **Off-by-one in substring** — End index is exclusive: `substring(0, 5)` gets indices 0-4.
3. **Using `==` instead of `.equals()`** — Always use `.equals()` for String comparison.

## Quiz

1. Does `s.toUpperCase()` change the original String `s`?
   - a) Yes
   - b) No — it returns a new String ✅

2. What does `"Hello".charAt(1)` return?
   - a) `'H'`
   - b) `'e'` ✅
   - c) `'l'`

3. What does `"Hello".substring(1, 3)` return?
   - a) `"Hel"`
   - b) `"el"` ✅
   - c) `"ell"`

---
**Next Lesson:** [Lesson 45 — Wrapper Classes](45_Wrapper_Classes.md)
