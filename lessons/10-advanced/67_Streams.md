[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](66_Lambdas.md) · [Next](68_Date_Time.md)

---

# Lesson 67: Streams

## Simple Explanation

A **Stream** is a way to process collections of data in a functional style — like an assembly line where data flows through operations (filter, transform, collect).

**Analogy:** A factory assembly line: items come in → get filtered → get transformed → packaged at the end.

## Creating a Stream

```java
import java.util.List;
import java.util.stream.Collectors;

List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");

// Create a stream from the list
names.stream()
```

### Symbol breakdown of `names.stream()`:
- `names` — The collection.
- `.` — Access method.
- `stream()` — Creates a Stream from the collection. Data now flows through operations.

## Common Stream Operations

```java
List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");

// Filter: keep only names longer than 3 characters
List<String> longNames = names.stream()
    .filter(name -> name.length() > 3)
    .collect(Collectors.toList());
// [Alice, Charlie, David]

// Map: transform each element
List<String> upperNames = names.stream()
    .map(name -> name.toUpperCase())
    .collect(Collectors.toList());
// [ALICE, BOB, CHARLIE, DAVID, EVE]

// ForEach: do something with each element
names.stream()
    .forEach(name -> System.out.println(name));

// Count
long count = names.stream()
    .filter(name -> name.length() > 3)
    .count();
// 3
```

### Symbol breakdown of `.filter(name -> name.length() > 3)`:
- `.filter` — A stream operation that keeps elements matching a condition.
- `(` — Start of argument (a lambda).
- `name` — Each element.
- `->` — Arrow operator.
- `name.length() > 3` — The condition: keep names longer than 3 characters.
- `)` — End of argument.

### Symbol breakdown of `.collect(Collectors.toList())`:
- `.collect` — A **terminal operation** that gathers the results.
- `Collectors.toList()` — Collect into a List.

## Stream Operations Summary

| Operation | Type | What It Does | Example |
|-----------|------|-------------|---------|
| `filter()` | Intermediate | Keeps matching elements | `.filter(x -> x > 5)` |
| `map()` | Intermediate | Transforms each element | `.map(x -> x * 2)` |
| `sorted()` | Intermediate | Sorts elements | `.sorted()` |
| `distinct()` | Intermediate | Removes duplicates | `.distinct()` |
| `limit(n)` | Intermediate | Takes first n elements | `.limit(3)` |
| `forEach()` | Terminal | Does action for each | `.forEach(System.out::println)` |
| `collect()` | Terminal | Gathers into collection | `.collect(Collectors.toList())` |
| `count()` | Terminal | Counts elements | `.count()` |
| `reduce()` | Terminal | Combines into one value | `.reduce(0, Integer::sum)` |

## Chaining Operations

The power of streams: chain multiple operations:

```java
List<Integer> numbers = List.of(5, 3, 8, 1, 9, 2, 7, 4, 6);

List<Integer> result = numbers.stream()
    .filter(n -> n > 3)          // Keep numbers > 3: [5, 8, 9, 7, 4, 6]
    .sorted()                     // Sort: [4, 5, 6, 7, 8, 9]
    .limit(3)                     // Take first 3: [4, 5, 6]
    .collect(Collectors.toList());

System.out.println(result);    // [4, 5, 6]
```

## With Numbers

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);    // Sum all: 15

double average = numbers.stream()
    .mapToInt(n -> n)
    .average()
    .orElse(0.0);    // 3.0
```

## Important Rules

1. **Streams are lazy** — Intermediate operations don't run until a terminal operation is called.
2. **Streams can only be used once** — After a terminal operation, the stream is consumed.
3. **Streams don't modify the source** — The original collection is unchanged.

## Common Beginner Mistakes

1. **Reusing a stream** — A stream can only be consumed once.
2. **Forgetting the terminal operation** — Without `collect()`, `forEach()`, etc., nothing happens.
3. **Modifying the source collection during streaming** — Causes errors.

## Quiz

1. What does `filter()` do?
   - a) Transforms elements
   - b) Keeps elements that match a condition ✅
   - c) Sorts elements

2. What does `map()` do?
   - a) Keeps matching elements
   - b) Transforms each element into something else ✅
   - c) Counts elements

---
**Next Lesson:** [Lesson 68 — Date and Time Basics](68_Date_Time.md)
