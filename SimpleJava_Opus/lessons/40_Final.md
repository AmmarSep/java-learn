# Lesson 40: `final`

## Simple Explanation

`final` means **"cannot be changed."** Once set, it's permanent.

**Analogy:** Writing in permanent marker — once you write it, you can't erase it.

## `final` Variables (Constants)

A `final` variable can only be assigned **once**:

```java
final int MAX_SCORE = 100;
// MAX_SCORE = 200;    // ❌ ERROR — cannot change a final variable

final String GREETING = "Hello";
// GREETING = "Hi";    // ❌ ERROR
```

### Symbol breakdown of `final int MAX_SCORE = 100;`:
- `final` — Keyword meaning this value cannot be changed after assignment.
- `int` — Data type.
- `MAX_SCORE` — Variable name. Convention: `final` constants use **UPPER_SNAKE_CASE**.
- `=` — Assignment.
- `100` — The value (permanent).
- `;` — End of statement.

### Common constants:

```java
public class GameSettings {
    static final int MAX_LIVES = 3;
    static final double PI = 3.14159265;
    static final String GAME_NAME = "Java Quest";
}
```

- `static final` — The most common combination for constants. `static` = belongs to class. `final` = can't change.

## `final` Methods

A `final` method **cannot be overridden** by subclasses:

```java
public class Animal {
    final void breathe() {
        System.out.println("Breathing...");
    }
}

public class Dog extends Animal {
    // void breathe() { }    // ❌ ERROR — can't override a final method
}
```

## `final` Classes

A `final` class **cannot be extended** (no subclasses):

```java
final class MathUtils {
    static int add(int a, int b) { return a + b; }
}

// class BetterMath extends MathUtils { }    // ❌ ERROR — can't extend final class
```

`String` is a `final` class in Java — you cannot create a subclass of `String`.

## Summary

| Where | Meaning |
|-------|---------|
| `final` variable | Value can't change |
| `final` method | Method can't be overridden |
| `final` class | Class can't be extended |

## Common Beginner Mistakes

1. **Trying to change a `final` variable** — Once set, it's permanent.
2. **Not using UPPER_SNAKE_CASE for constants** — Convention: `MAX_SIZE`, not `maxSize`.
3. **Confusing `final` with `static`** — `final` = can't change. `static` = belongs to class. They're different but often used together.

## Quiz

1. What does `final` mean for a variable?
   - a) It's static
   - b) Its value cannot be changed ✅
   - c) It's private

2. What naming convention do constants use?
   - a) camelCase
   - b) UPPER_SNAKE_CASE ✅
   - c) PascalCase

3. Can a `final` class be extended?
   - a) Yes
   - b) No ✅

---
**Next Lesson:** [Lesson 41 — Packages](41_Packages.md)
