[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](44_String_Methods.md) · [Next](46_ArrayList.md)

---

# Lesson 45: Wrapper Classes

## Simple Explanation

**Wrapper classes** are object versions of primitive types. They "wrap" a primitive value in an object.

| Primitive | Wrapper Class |
|-----------|--------------|
| `int` | `Integer` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |
| `long` | `Long` |
| `float` | `Float` |
| `byte` | `Byte` |
| `short` | `Short` |

## Why Do We Need Them?

Some Java features (like `ArrayList`) only work with **objects**, not primitives. Wrapper classes solve this:

```java
// ArrayList<int> list;     // ❌ Can't use primitive
ArrayList<Integer> list;    // ✅ Use wrapper class instead
```

## Autoboxing and Unboxing

Java **automatically** converts between primitives and wrappers:

```java
// Autoboxing: primitive → wrapper (automatic)
Integer num = 42;    // int 42 is automatically wrapped into an Integer object

// Unboxing: wrapper → primitive (automatic)
int x = num;         // Integer is automatically unwrapped to int
```

### Symbol breakdown of `Integer num = 42;`:
- `Integer` — The wrapper class type (not `int`).
- `num` — Variable name.
- `=` — Assignment.
- `42` — A primitive `int` value. Java automatically converts it to an `Integer` object (**autoboxing**).
- `;` — End of statement.

## Useful Wrapper Methods

### Parsing Strings to Numbers:

```java
int a = Integer.parseInt("42");          // String → int
double b = Double.parseDouble("3.14");   // String → double
boolean c = Boolean.parseBoolean("true"); // String → boolean
```

### Symbol breakdown of `Integer.parseInt("42")`:
- `Integer` — The wrapper class.
- `.` — Access a static method.
- `parseInt` — A static method that converts a String to an `int`.
- `(` — Start of argument.
- `"42"` — The String to convert.
- `)` — End of argument.

### Converting Numbers to Strings:

```java
String s1 = Integer.toString(42);       // "42"
String s2 = String.valueOf(42);         // "42" (alternative)
String s3 = "" + 42;                    // "42" (quick trick)
```

### Getting Min/Max Values:

```java
System.out.println(Integer.MAX_VALUE);  // 2147483647
System.out.println(Integer.MIN_VALUE);  // -2147483648
```

## Common Beginner Mistakes

1. **NullPointerException with unboxing** — `Integer num = null; int x = num;` crashes!
2. **Using `==` with wrappers** — Use `.equals()`: `Integer a = 200; Integer b = 200; a == b` may be `false`.
3. **Forgetting to parse** — `"42"` is a String, not a number. Use `Integer.parseInt("42")`.

## Quiz

1. What is the wrapper class for `int`?
   - a) `Int`
   - b) `Integer` ✅
   - c) `Number`

2. What is autoboxing?
   - a) Manually converting types
   - b) Automatic conversion from primitive to wrapper ✅
   - c) Creating arrays

3. How do you convert `"123"` to an `int`?
   - a) `(int) "123"`
   - b) `Integer.parseInt("123")` ✅
   - c) `"123".toInt()`

---
**Next Lesson:** [Lesson 46 — `ArrayList`](46_ArrayList.md)
