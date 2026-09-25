[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](46_ArrayList.md) · [Next](48_HashMap.md)

**Runnable companion:** [Phase5_Collections](../../examples/05-collections/01-collections/Phase5_Collections.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 47: Collections Basics

## Simple Explanation

The **Java Collections Framework** is a set of classes and interfaces for storing and manipulating groups of objects. Think of it as Java's built-in toolbox for working with groups of data.

## The Main Collection Types

| Interface | What It Is | Common Implementation | Duplicates? | Ordered? |
|-----------|-----------|----------------------|-------------|----------|
| `List` | Ordered sequence | `ArrayList`, `LinkedList` | Yes | Yes |
| `Set` | Unique elements | `HashSet`, `TreeSet` | No | Depends |
| `Map` | Key-value pairs | `HashMap`, `TreeMap` | Keys: No | Depends |

## `List` — Ordered, Allows Duplicates

```java
import java.util.List;
import java.util.ArrayList;

List<String> names = new ArrayList<>();
names.add("Alex");
names.add("Sam");
names.add("Alex");    // Duplicates allowed!
System.out.println(names);    // [Alex, Sam, Alex]
```

### Symbol breakdown of `List<String> names = new ArrayList<>();`:
- `List` — An **interface** (a contract). It defines what a list can do.
- `<String>` — The type of elements.
- `names` — Variable name.
- `=` — Assignment.
- `new ArrayList<>()` — The actual implementation. `ArrayList` is one way to create a `List`.

**Why use `List` instead of `ArrayList` as the type?** It's a best practice — code to the interface, not the implementation. You can easily swap `ArrayList` for `LinkedList` later.

## `Set` — No Duplicates

```java
import java.util.Set;
import java.util.HashSet;

Set<String> uniqueNames = new HashSet<>();
uniqueNames.add("Alex");
uniqueNames.add("Sam");
uniqueNames.add("Alex");    // Ignored — already exists!
System.out.println(uniqueNames);    // [Alex, Sam] (order may vary)
```

## `Map` — Key-Value Pairs

```java
import java.util.Map;
import java.util.HashMap;

Map<String, Integer> ages = new HashMap<>();
ages.put("Alex", 25);
ages.put("Sam", 30);
System.out.println(ages.get("Alex"));    // 25
```

## The `Collections` Utility Class

Java provides a helper class `Collections` (with an 's') with useful static methods:

```java
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

List<Integer> numbers = new ArrayList<>();
numbers.add(3);
numbers.add(1);
numbers.add(2);

Collections.sort(numbers);          // [1, 2, 3]
Collections.reverse(numbers);       // [3, 2, 1]
int max = Collections.max(numbers);  // 3
int min = Collections.min(numbers);  // 1
```

## Common Beginner Mistakes

1. **Confusing `Collection` (interface) with `Collections` (utility class)** — They're different!
2. **Using arrays when collections are better** — Use `ArrayList` when size changes dynamically.
3. **Forgetting imports** — Collections classes are in `java.util`.

## Quiz

1. Which collection type does NOT allow duplicates?
   - a) `List`
   - b) `Set` ✅
   - c) Both allow duplicates

2. Which collection stores key-value pairs?
   - a) `List`
   - b) `Set`
   - c) `Map` ✅

3. What does `Collections.sort()` do?
   - a) Creates a new collection
   - b) Sorts a list in order ✅
   - c) Removes duplicates

---
**Next Lesson:** [Lesson 48 — `HashMap`](48_HashMap.md)
