# Lesson 64: Generics

## Simple Explanation

**Generics** let you write code that works with **any type**, while still being type-safe. You've already used them: `ArrayList<String>` — the `<String>` part is a generic.

**Analogy:** A generic box — it can hold shoes, books, or toys, but once you label it "shoes," it only accepts shoes.

## Using Generics (You Already Know This)

```java
ArrayList<String> names = new ArrayList<>();    // Only Strings
ArrayList<Integer> numbers = new ArrayList<>();  // Only Integers
```

The type in `<>` is called a **type parameter**.

## Creating a Generic Class

```java
public class Box<T> {
    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
```

### Symbol breakdown of `class Box<T>`:
- `Box` — Class name.
- `<` — Opening angle bracket.
- `T` — A **type parameter** (placeholder). It stands for "some type" — you decide what when you use it. `T` is a convention for "Type."
- `>` — Closing angle bracket.

### Using the generic class:

```java
Box<String> stringBox = new Box<>();
stringBox.put("Hello");
String s = stringBox.get();    // "Hello" — no casting needed!

Box<Integer> intBox = new Box<>();
intBox.put(42);
int n = intBox.get();          // 42
```

## Generic Methods

```java
public static <T> void printArray(T[] array) {
    for (T item : array) {
        System.out.println(item);
    }
}
```

### Symbol breakdown of `<T> void printArray(T[] array)`:
- `<T>` — Declares a type parameter for this method.
- `void` — Returns nothing.
- `printArray` — Method name.
- `T[]` — An array of type T.
- `array` — Parameter name.

```java
String[] names = {"Alex", "Sam"};
Integer[] nums = {1, 2, 3};
printArray(names);    // Works with Strings
printArray(nums);     // Works with Integers
```

## Common Type Parameter Names

| Letter | Convention |
|--------|-----------|
| `T` | Type |
| `E` | Element (used in collections) |
| `K` | Key (used in maps) |
| `V` | Value (used in maps) |
| `N` | Number |

## Bounded Generics

Restrict what types are allowed:

```java
// Only accepts Number types (Integer, Double, etc.)
public static <T extends Number> double sum(T a, T b) {
    return a.doubleValue() + b.doubleValue();
}

sum(5, 3);        // ✅ Works — Integer extends Number
sum(2.5, 3.5);    // ✅ Works — Double extends Number
// sum("a", "b");  // ❌ Error — String doesn't extend Number
```

### Symbol breakdown of `<T extends Number>`:
- `T` — Type parameter.
- `extends` — Means "T must be Number or a subclass of Number."
- `Number` — The upper bound.

## Common Beginner Mistakes

1. **Using primitives** — `Box<int>` is wrong. Use `Box<Integer>`.
2. **Forgetting `<>` when creating** — `Box box = new Box();` loses type safety (raw type warning).
3. **Confusing `extends` in generics** — In generics, `extends` means both "extends" and "implements."

## Quiz

1. What does `<T>` mean?
   - a) The letter T
   - b) A type parameter — a placeholder for any type ✅
   - c) A String

2. Can you use `int` as a generic type?
   - a) Yes
   - b) No — use `Integer` ✅

---
**Next Lesson:** [Lesson 65 — Enums](65_Enums.md)
