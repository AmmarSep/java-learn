# Lesson 62: Checked vs Unchecked Exceptions

## Simple Explanation

Java has two categories of exceptions:

- **Checked exceptions** — The compiler **forces** you to handle them. They represent expected problems (file not found, network error).
- **Unchecked exceptions** — The compiler does **not** force handling. They represent programming bugs (null pointer, bad index).

## Checked Exceptions

You **must** handle these with `try-catch` or declare them with `throws`:

```java
import java.io.FileReader;
import java.io.FileNotFoundException;

// Option 1: try-catch
public void readFile() {
    try {
        FileReader reader = new FileReader("data.txt");
    } catch (FileNotFoundException e) {
        System.out.println("File not found!");
    }
}

// Option 2: declare with throws
public void readFile() throws FileNotFoundException {
    FileReader reader = new FileReader("data.txt");
}
```

### Symbol breakdown of `throws FileNotFoundException`:
- `throws` — Keyword meaning "this method might throw this exception; the caller must handle it."
- `FileNotFoundException` — The exception type.

Common checked exceptions: `IOException`, `FileNotFoundException`, `SQLException`.

## Unchecked Exceptions

You **don't have to** handle these (but you can):

```java
int x = 10 / 0;                    // ArithmeticException
String s = null; s.length();        // NullPointerException
int[] a = {1}; System.out.println(a[5]);  // ArrayIndexOutOfBoundsException
```

All unchecked exceptions extend `RuntimeException`.

## Summary

| Feature | Checked | Unchecked |
|---------|---------|-----------|
| Must handle? | Yes | No |
| Extends | `Exception` | `RuntimeException` |
| When | Expected problems | Programming bugs |
| Examples | `IOException`, `FileNotFoundException` | `NullPointerException`, `ArithmeticException` |

## `throw` vs `throws`

- `throw` — Used inside a method to **create and throw** an exception: `throw new Exception("error");`
- `throws` — Used in method signature to **declare** that the method might throw an exception: `void read() throws IOException`

## Quiz

1. Must you handle checked exceptions?
   - a) Yes ✅
   - b) No

2. Which is a checked exception?
   - a) `NullPointerException`
   - b) `IOException` ✅
   - c) `ArithmeticException`

3. What's the difference between `throw` and `throws`?
   - a) They're the same
   - b) `throw` creates an exception; `throws` declares a method might throw one ✅

---
**Next Lesson:** [Lesson 63 — File Reading and Writing](63_File_IO.md)
