# Lesson 66: Lambdas

## Simple Explanation

A **lambda expression** is a short way to write a method without giving it a name. It's like an anonymous (nameless) method you can pass around.

**Analogy:** Instead of writing a full formal letter (method), you write a quick sticky note (lambda).

## Syntax

```java
(parameters) -> expression
(parameters) -> { statements; }
```

### Symbol breakdown:
- `(parameters)` — The input, in parentheses.
- `->` — The **arrow operator**. Read it as "goes to" or "becomes."
- `expression` or `{ statements; }` — What to do with the input.

## Examples

```java
// Before: Traditional way
Comparator<String> comp = new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
};

// After: Lambda way
Comparator<String> comp = (a, b) -> a.length() - b.length();
```

Much shorter!

## Lambda Variations

```java
// No parameters
Runnable r = () -> System.out.println("Hello!");

// One parameter (parentheses optional)
Consumer<String> greet = name -> System.out.println("Hi " + name);

// Two parameters
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

// Multiple statements (need braces and return)
BiFunction<Integer, Integer, Integer> max = (a, b) -> {
    if (a > b) {
        return a;
    } else {
        return b;
    }
};
```

### Symbol breakdown of `(a, b) -> a + b`:
- `(` — Start of parameters.
- `a` — First parameter (type inferred).
- `,` — Comma.
- `b` — Second parameter.
- `)` — End of parameters.
- `->` — Arrow: "goes to."
- `a + b` — The expression: add a and b, return the result.

## Using Lambdas with Collections

```java
import java.util.ArrayList;
import java.util.Collections;

ArrayList<String> names = new ArrayList<>();
names.add("Charlie");
names.add("Alice");
names.add("Bob");

// Sort alphabetically using a lambda
Collections.sort(names, (a, b) -> a.compareTo(b));
System.out.println(names);    // [Alice, Bob, Charlie]

// ForEach with a lambda
names.forEach(name -> System.out.println("Hello, " + name));
```

### Symbol breakdown of `names.forEach(name -> System.out.println("Hello, " + name))`:
- `names` — The ArrayList.
- `.forEach` — A method that runs code for each element.
- `(` — Start of argument (the lambda).
- `name` — Each element, one at a time.
- `->` — Arrow.
- `System.out.println(...)` — What to do with each element.
- `)` — End of argument.

## Functional Interfaces

Lambdas work with **functional interfaces** — interfaces with exactly one abstract method:

| Interface | Method | Use |
|-----------|--------|-----|
| `Runnable` | `run()` | No input, no output |
| `Consumer<T>` | `accept(T)` | Takes input, no output |
| `Supplier<T>` | `get()` | No input, returns output |
| `Function<T,R>` | `apply(T)` | Takes input, returns output |
| `Predicate<T>` | `test(T)` | Takes input, returns boolean |

## Common Beginner Mistakes

1. **Using lambdas with non-functional interfaces** — The interface must have exactly one abstract method.
2. **Forgetting `return` in multi-line lambdas** — `{ return a + b; }` needs `return` and braces.
3. **Overcomplicating** — If a lambda is too long, use a regular method instead.

## Quiz

1. What does `->` mean?
   - a) Greater than
   - b) The arrow operator in a lambda expression ✅
   - c) Assignment

2. What is `(a, b) -> a + b`?
   - a) A class
   - b) A lambda that adds two numbers ✅
   - c) A variable

---
**Next Lesson:** [Lesson 67 — Streams](67_Streams.md)
