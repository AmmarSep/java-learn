# Lesson 48: `HashMap`

## Simple Explanation

A **`HashMap`** stores data as **key-value pairs**. Each key maps to a value, like a dictionary where each word (key) has a definition (value).

**Analogy:** A phone book — the name (key) maps to a phone number (value).

## Creating a HashMap

```java
import java.util.HashMap;

HashMap<String, Integer> ages = new HashMap<>();
```

### Symbol breakdown:
- `HashMap` — The class.
- `<` — Opening angle bracket.
- `String` — The type of the **key**.
- `,` — Comma separating key type from value type.
- `Integer` — The type of the **value**.
- `>` — Closing angle bracket.
- `ages` — Variable name.
- `= new HashMap<>()` — Create a new empty HashMap.

## Common Operations

```java
import java.util.HashMap;

HashMap<String, Integer> ages = new HashMap<>();

// Put (add) entries
ages.put("Alex", 25);
ages.put("Sam", 30);
ages.put("Jordan", 22);

// Get a value by key
System.out.println(ages.get("Alex"));       // 25
System.out.println(ages.get("Unknown"));    // null (key doesn't exist)

// Check if key exists
System.out.println(ages.containsKey("Sam"));      // true

// Check if value exists
System.out.println(ages.containsValue(30));        // true

// Size
System.out.println(ages.size());    // 3

// Remove
ages.remove("Jordan");              // Removes Jordan
System.out.println(ages.size());    // 2

// Get with default value
System.out.println(ages.getOrDefault("Unknown", 0));  // 0

// Overwrite a value
ages.put("Alex", 26);              // Replaces 25 with 26
```

## Looping Through a HashMap

```java
// Loop through keys
for (String name : ages.keySet()) {
    System.out.println(name);
}

// Loop through values
for (int age : ages.values()) {
    System.out.println(age);
}

// Loop through key-value pairs
for (var entry : ages.entrySet()) {
    System.out.println(entry.getKey() + " is " + entry.getValue());
}
```

### Symbol breakdown of `ages.entrySet()`:
- `ages` — The HashMap.
- `.` — Access method.
- `entrySet()` — Returns a set of all key-value pairs (entries).

### Symbol breakdown of `entry.getKey()` and `entry.getValue()`:
- `entry` — One key-value pair.
- `.getKey()` — Returns the key.
- `.getValue()` — Returns the value.

## Important Rules

1. **Keys must be unique** — If you `put` with an existing key, the value is replaced.
2. **Keys can be null** — One `null` key is allowed.
3. **Order is not guaranteed** — Elements may not be in the order you added them.
4. **Use `TreeMap` for sorted keys** — `TreeMap` keeps keys in sorted order.

## Common Beginner Mistakes

1. **Expecting order** — HashMap doesn't maintain insertion order. Use `LinkedHashMap` if order matters.
2. **Getting a non-existent key** — Returns `null`, not an error. Use `getOrDefault()` to be safe.
3. **Using primitives as types** — `HashMap<String, int>` is wrong. Use `Integer`.

## Quiz

1. What does `put("Alex", 25)` do?
   - a) Adds a key-value pair ✅
   - b) Gets a value
   - c) Removes an entry

2. What does `get("Unknown")` return if the key doesn't exist?
   - a) `0`
   - b) An error
   - c) `null` ✅

3. Can a HashMap have duplicate keys?
   - a) Yes
   - b) No — the new value replaces the old one ✅

---
**Next Lesson:** [Lesson 49 — `HashSet`](49_HashSet.md)
