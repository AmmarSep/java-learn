# Lesson 49: `HashSet`

## Simple Explanation

A **`HashSet`** is a collection that stores **unique elements only** — no duplicates allowed. It also has **no guaranteed order**.

**Analogy:** A bag of unique marbles. You can't have two identical marbles in the bag.

## Creating and Using a HashSet

```java
import java.util.HashSet;

HashSet<String> colors = new HashSet<>();

colors.add("Red");
colors.add("Green");
colors.add("Blue");
colors.add("Red");        // Ignored — already exists!

System.out.println(colors);          // [Red, Blue, Green] (order may vary)
System.out.println(colors.size());   // 3 (not 4!)
```

## Key Operations

```java
HashSet<Integer> numbers = new HashSet<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.contains(20);     // true — checks if element exists
numbers.remove(20);       // removes 20
numbers.size();            // 2
numbers.isEmpty();         // false
numbers.clear();           // removes all elements
```

## Looping Through a HashSet

```java
HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");

for (String fruit : fruits) {
    System.out.println(fruit);
}
```

## When to Use HashSet?

- When you need to ensure **no duplicates**.
- When you need to quickly check if something **exists** (`contains()` is very fast).
- When you **don't care about order**.

## Common Beginner Mistakes

1. **Expecting order** — HashSet doesn't maintain order. Use `LinkedHashSet` for insertion order, `TreeSet` for sorted order.
2. **Expecting `get(index)`** — HashSet has no indexes. You can't do `set.get(0)`.
3. **Forgetting duplicates are silently ignored** — `add()` returns `false` if the element already exists.

## Quiz

1. Does a HashSet allow duplicate elements?
   - a) Yes
   - b) No ✅

2. Does a HashSet maintain insertion order?
   - a) Yes
   - b) No ✅

3. Can you access HashSet elements by index?
   - a) Yes
   - b) No ✅ — HashSet has no indexes.

---
**Next Lesson:** [Lesson 50 — Enhanced `for` Loop](50_Enhanced_For.md)
