# Lesson 43: Strings in Detail

## Simple Explanation

We introduced Strings earlier. Now let's dive deeper. A **String** in Java is an **object** of the `String` class that holds a sequence of characters. Strings are **immutable** — once created, they cannot be changed.

## String Immutability

**Immutable** means the original String never changes. When you "modify" a String, Java actually creates a **new** String:

```java
String name = "Hello";
name = name + " World";    // Creates a NEW String "Hello World"
// The original "Hello" still exists in memory (until garbage collected)
```

## Creating Strings

### Method 1: String literal (preferred)
```java
String s1 = "Hello";
```

### Method 2: Using `new` (rarely needed)
```java
String s2 = new String("Hello");
```

Both create a String, but literals are more efficient because Java reuses identical literals from a special memory area called the **String Pool**.

```java
String a = "Hello";
String b = "Hello";
System.out.println(a == b);    // true — same object in the String Pool

String c = new String("Hello");
System.out.println(a == c);    // false — different objects!
System.out.println(a.equals(c));  // true — same content
```

**Rule:** Always use `.equals()` to compare String content, never `==`.

## String Concatenation

```java
String first = "Hello";
String second = " World";
String result = first + second;    // "Hello World"
String greeting = first + " " + "Java";  // "Hello Java"
```

Concatenation with other types:
```java
String msg = "Age: " + 25;              // "Age: 25"
String msg2 = "Pi: " + 3.14;            // "Pi: 3.14"
String msg3 = "Active: " + true;        // "Active: true"
```

## Multi-Line Strings (Text Blocks — Java 15+)

```java
String json = """
        {
            "name": "Alex",
            "age": 25
        }
        """;
```

### Symbol breakdown:
- `"""` — Three double quotes start a **text block**.
- Everything between the opening `"""` and closing `"""` is the String content, preserving line breaks.
- `"""` — Three double quotes end the text block.

## Common Beginner Mistakes

1. **Using `==` to compare Strings** — Use `.equals()` instead.
2. **Forgetting Strings are immutable** — `s.toUpperCase()` returns a NEW String; it doesn't change `s`.
3. **Null Strings** — `String s = null; s.length();` causes NullPointerException.

## Quiz

1. Are Strings mutable or immutable?
   - a) Mutable
   - b) Immutable ✅

2. How should you compare String content?
   - a) `==`
   - b) `.equals()` ✅

3. What does `"Hello" + " " + "World"` produce?
   - a) `"Hello World"` ✅
   - b) An error

---
**Next Lesson:** [Lesson 44 — String Methods](44_String_Methods.md)
