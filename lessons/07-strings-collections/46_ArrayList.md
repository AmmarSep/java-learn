[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](45_Wrapper_Classes.md) · [Next](47_Collections.md)

**Runnable companion:** [Phase5_Collections](../../examples/05-collections/01-collections/Phase5_Collections.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 46: `ArrayList`

## Simple Explanation

An **`ArrayList`** is like an array that can **grow and shrink**. Unlike arrays (fixed size), an ArrayList can add and remove elements dynamically.

## Creating an ArrayList

```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<>();
```

### Symbol-by-symbol breakdown:
- `import java.util.ArrayList;` — Import the ArrayList class.
- `ArrayList` — The class name.
- `<` — Opening **angle bracket**. Starts the type parameter.
- `String` — The type of elements this list holds. Must be a class (use `Integer` not `int`).
- `>` — Closing **angle bracket**.
- `names` — Variable name.
- `=` — Assignment.
- `new ArrayList<>()` — Create a new empty ArrayList. The `<>` (diamond operator) lets Java infer the type.
- `;` — End of statement.

## Common Operations

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();

        // Add elements
        fruits.add("Apple");       // [Apple]
        fruits.add("Banana");      // [Apple, Banana]
        fruits.add("Cherry");      // [Apple, Banana, Cherry]

        // Get element by index
        System.out.println(fruits.get(0));    // Apple

        // Change element
        fruits.set(1, "Blueberry");    // [Apple, Blueberry, Cherry]

        // Remove element
        fruits.remove("Cherry");        // [Apple, Blueberry]
        fruits.remove(0);               // [Blueberry]

        // Size
        System.out.println(fruits.size());    // 1

        // Check if contains
        System.out.println(fruits.contains("Blueberry"));  // true

        // Check if empty
        System.out.println(fruits.isEmpty());    // false

        // Clear all
        fruits.clear();
        System.out.println(fruits.isEmpty());    // true
    }
}
```

## ArrayList Methods Summary

| Method | What It Does | Example |
|--------|-------------|---------|
| `add(item)` | Adds to end | `list.add("A")` |
| `add(index, item)` | Inserts at index | `list.add(0, "A")` |
| `get(index)` | Returns element at index | `list.get(0)` |
| `set(index, item)` | Replaces element | `list.set(0, "B")` |
| `remove(index)` | Removes by index | `list.remove(0)` |
| `remove(object)` | Removes first occurrence | `list.remove("A")` |
| `size()` | Returns number of elements | `list.size()` |
| `contains(item)` | Checks if item exists | `list.contains("A")` |
| `isEmpty()` | Checks if empty | `list.isEmpty()` |
| `clear()` | Removes all elements | `list.clear()` |
| `indexOf(item)` | Returns index of first occurrence | `list.indexOf("A")` |

## ArrayList with Numbers

Use wrapper classes for primitives:

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);     // Autoboxing: int → Integer
numbers.add(20);
numbers.add(30);

int first = numbers.get(0);    // Unboxing: Integer → int
System.out.println(first);     // 10
```

## Looping Through an ArrayList

```java
ArrayList<String> colors = new ArrayList<>();
colors.add("Red");
colors.add("Green");
colors.add("Blue");

// Method 1: for loop
for (int i = 0; i < colors.size(); i++) {
    System.out.println(colors.get(i));
}

// Method 2: enhanced for loop (easier)
for (String color : colors) {
    System.out.println(color);
}
```

## Array vs ArrayList

| Feature | Array | ArrayList |
|---------|-------|-----------|
| Size | Fixed | Dynamic (grows/shrinks) |
| Syntax | `int[] arr = new int[5]` | `ArrayList<Integer> list = new ArrayList<>()` |
| Primitives | Yes (`int[]`) | No (use `Integer`) |
| Length | `arr.length` | `list.size()` |
| Access | `arr[0]` | `list.get(0)` |

## Common Beginner Mistakes

1. **Using primitives in `<>`** — `ArrayList<int>` is wrong. Use `ArrayList<Integer>`.
2. **Using `[]` to access** — `list[0]` is wrong. Use `list.get(0)`.
3. **Using `.length` instead of `.size()`** — ArrayList uses `size()`, arrays use `length`.
4. **Forgetting to import** — `import java.util.ArrayList;`

## Quiz

1. Can an ArrayList change size?
   - a) No
   - b) Yes ✅

2. How do you get element at index 2?
   - a) `list[2]`
   - b) `list.get(2)` ✅

3. What goes inside `<>` for an ArrayList of integers?
   - a) `int`
   - b) `Integer` ✅

---
**Next Lesson:** [Lesson 47 — Collections Basics](47_Collections.md)
