# Lesson 50: Enhanced `for` Loop (for-each)

## Simple Explanation

The **enhanced for loop** (also called **for-each loop**) is a simpler way to loop through arrays and collections. Instead of managing an index variable, you directly get each element.

## Syntax

```java
for (Type element : collection) {
    // use element
}
```

### Symbol breakdown:
- `for` — Loop keyword.
- `(` — Opening parenthesis.
- `Type` — The type of each element (e.g., `String`, `int`).
- `element` — A variable name you choose. It holds the current element in each iteration.
- `:` — A **colon**. Read it as "in". So `String name : names` reads "for each String name **in** names."
- `collection` — The array or collection to loop through.
- `)` — Closing parenthesis.
- `{ }` — Loop body.

## With Arrays

```java
String[] fruits = {"Apple", "Banana", "Cherry"};

for (String fruit : fruits) {
    System.out.println(fruit);
}
```

**Output:**
```
Apple
Banana
Cherry
```

### Compare with regular for loop:

```java
// Regular for loop (more complex)
for (int i = 0; i < fruits.length; i++) {
    System.out.println(fruits[i]);
}

// Enhanced for loop (simpler)
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

## With Collections

```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<>();
names.add("Alex");
names.add("Sam");
names.add("Jordan");

for (String name : names) {
    System.out.println("Hello, " + name);
}
```

Works with `ArrayList`, `HashSet`, `LinkedList`, and any `Iterable`.

## With Primitive Arrays

```java
int[] numbers = {10, 20, 30, 40, 50};

int sum = 0;
for (int num : numbers) {
    sum += num;
}
System.out.println("Sum: " + sum);    // Sum: 150
```

## When to Use Which Loop?

| Use regular `for` when... | Use enhanced `for` when... |
|--------------------------|---------------------------|
| You need the index | You just need each element |
| You need to modify the array | You're only reading values |
| You need to skip elements | You want every element |
| You need to loop backward | You want simple, clean code |

## Limitations

1. **No index access** — You can't know what position you're at.
2. **Can't modify the collection** — Removing elements during a for-each loop causes `ConcurrentModificationException`.
3. **Can't loop backward** — Always goes forward.

## Common Beginner Mistakes

1. **Trying to modify elements** — `for (int n : arr) { n = 0; }` does NOT change the array.
2. **Removing during iteration** — Use `Iterator` or regular for loop instead.
3. **Forgetting the colon** — It's `:`, not `,` or `;`.

## Quiz

1. What does the `:` mean in `for (String s : list)`?
   - a) "equals"
   - b) "in" ✅
   - c) "from"

2. Can you access the index in an enhanced for loop?
   - a) Yes
   - b) No ✅

3. Which is simpler for reading all elements?
   - a) Regular for loop
   - b) Enhanced for loop ✅

---
**Next Lesson:** [Lesson 51 — OOP Basics](51_OOP_Basics.md)
