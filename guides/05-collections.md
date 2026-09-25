[All guides](README.md) · [Phase examples](../examples/05-collections/README.md) · [Previous phase](04-language-features.md) · [Next phase](06-exceptions-and-concurrency.md)

# PHASE 5: COLLECTIONS & GENERICS

## Concept 5.1: Arrays vs Collections

### Why This Matters
Arrays are fixed-size. Collections are dynamic. Understanding differences helps you choose the right tool.

### Arrays (Review)

```java
int[] numbers = new int[5];  // Fixed size: 5
numbers[0] = 10;

System.out.println(numbers.length);  // 5
```

**Limitations:**
- Fixed size (can't grow or shrink)
- Only one type (int[] is all integers)
- Low-level (no built-in methods like add(), remove())

### Collections Framework

Dynamic, flexible alternatives to arrays:

```java
List<Integer> numbers = new ArrayList<>();  // Dynamic size

numbers.add(10);      // Add element
numbers.add(20);
numbers.add(30);

System.out.println(numbers.size());  // 3
numbers.remove(0);    // Remove by index
System.out.println(numbers.size());  // 2
```

### Main Collection Types

**List** - Ordered, allows duplicates
```java
List<String> names = new ArrayList<>();
```

**Set** - Unique values only
```java
Set<String> names = new HashSet<>();
```

**Map** - Key-value pairs
```java
Map<String, Integer> ages = new HashMap<>();
```

---

## Concept 5.2: Generics and Type Safety

### Why This Matters
Generics specify what type a collection holds, preventing errors at compile time instead of runtime.

### Without Generics (Old Java)

```java
List list = new ArrayList();  // No type specified
list.add("Hello");
list.add(123);
list.add(45.6);

for (Object obj : list) {
    String str = (String) obj;  // Unsafe cast!
    System.out.println(str);
}
// Runtime error: can't cast Integer to String
```

No compile-time check. Error appears only when running.

### With Generics (Modern Java)

```java
List<String> list = new ArrayList<>();  // Type specified
list.add("Hello");
list.add(123);  // ERROR: can't add Integer to List<String>
```

Compile-time error caught immediately.

### Generic Type Parameter

Angle brackets `< >` specify the type:

```java
List<String> names = new ArrayList<>();  // List of Strings
List<Integer> ages = new ArrayList<>();   // List of Integers
List<Double> prices = new ArrayList<>();  // List of Doubles
```

### Generic Collections

```java
// List
List<String> list = new ArrayList<>();
list.add("Alice");
list.add("Bob");
String first = list.get(0);  // "Alice" (no cast needed)

// Set
Set<Integer> uniqueNumbers = new HashSet<>();
uniqueNumbers.add(5);
uniqueNumbers.add(5);  // Ignored (duplicate)
System.out.println(uniqueNumbers.size());  // 1

// Map
Map<String, Integer> ages = new HashMap<>();
ages.put("Alice", 25);
ages.put("Bob", 30);
int aliceAge = ages.get("Alice");  // 25
```

### Benefits of Generics

1. **Type safety:** Catch errors at compile time
2. **No casting:** Compiler knows the type
3. **Readability:** Code is clearer

### Common Mistakes
- Forgetting type parameter: `List list = new ArrayList();` → No type safety
- Wrong type in initialization: `List<String> list = new ArrayList<Integer>();` → ERROR
- Mixing types: `List<String> list; list.add(123);` → ERROR

---

## Concept 5.3: List Interface

### Why This Matters
List is ordered, allows duplicates. It's the most common collection type.

### ArrayList (Dynamic Array)

```java
List<String> names = new ArrayList<>();

names.add("Alice");
names.add("Bob");
names.add("Charlie");

System.out.println(names.size());  // 3
System.out.println(names.get(0));  // "Alice"
System.out.println(names.get(1));  // "Bob"

names.remove(1);  // Remove "Bob"
System.out.println(names.size());  // 2

names.set(0, "Alicia");  // Change "Alice" to "Alicia"
System.out.println(names.get(0));  // "Alicia"
```

### LinkedList (Better for insert/delete)

```java
List<Integer> numbers = new LinkedList<>();

numbers.add(1);
numbers.add(2);
numbers.add(3);

numbers.add(1, 99);  // Insert 99 at index 1
// List is now [1, 99, 2, 3]

System.out.println(numbers);  // [1, 99, 2, 3]
```

### Iteration Methods

**for loop:**
```java
for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}
```

**for-each loop:**
```java
for (String name : names) {
    System.out.println(name);
}
```

**Iterator:**
```java
Iterator<String> it = names.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

### Common Methods

| Method | Purpose |
|--------|---------|
| `add(item)` | Add to end |
| `add(index, item)` | Insert at position |
| `remove(index)` | Remove by index |
| `remove(object)` | Remove by value |
| `get(index)` | Get by index |
| `set(index, item)` | Replace at index |
| `size()` | Number of elements |
| `contains(item)` | Check if contains |
| `clear()` | Remove all |

---

## Concept 5.4: Set Interface

### Why This Matters
Set stores unique values only. Automatically rejects duplicates.

### HashSet (No Order)

```java
Set<String> fruits = new HashSet<>();

fruits.add("apple");
fruits.add("banana");
fruits.add("apple");  // Duplicate, ignored

System.out.println(fruits.size());  // 2
System.out.println(fruits.contains("apple"));  // true

fruits.remove("banana");
System.out.println(fruits.size());  // 1
```

Order is not preserved:
```java
Set<Integer> numbers = new HashSet<>();
numbers.add(3);
numbers.add(1);
numbers.add(2);

System.out.println(numbers);  // [1, 2, 3] or [2, 1, 3]? No guaranteed order
```

### TreeSet (Sorted Order)

```java
Set<Integer> numbers = new TreeSet<>();

numbers.add(3);
numbers.add(1);
numbers.add(2);

System.out.println(numbers);  // [1, 2, 3] (sorted)

for (Integer num : numbers) {
    System.out.println(num);  // 1, then 2, then 3
}
```

### Common Set Methods

| Method | Purpose |
|--------|---------|
| `add(item)` | Add item |
| `remove(item)` | Remove item |
| `contains(item)` | Check if contains |
| `size()` | Number of unique items |
| `clear()` | Remove all |

### Set vs List

| Feature | List | Set |
|---------|------|-----|
| Duplicates | Allowed | Not allowed |
| Order | Preserved (ArrayList) or not (LinkedList) | No (HashSet) or sorted (TreeSet) |
| Access by index | Yes | No |
| Use case | Sequence of items | Unique values |

---

## Concept 5.5: Map Interface

### Why This Matters
Map stores key-value pairs. Look up values by key, not by index.

### HashMap (No Order)

```java
Map<String, Integer> ages = new HashMap<>();

ages.put("Alice", 25);
ages.put("Bob", 30);
ages.put("Charlie", 28);

System.out.println(ages.get("Alice"));  // 25
System.out.println(ages.size());        // 3

if (ages.containsKey("Bob")) {
    System.out.println("Bob is here");
}

ages.remove("Bob");
System.out.println(ages.size());  // 2
```

**Key points:**
- Keys must be unique
- Values can be duplicated
- No guaranteed order

### TreeMap (Sorted by Key)

```java
Map<String, Integer> ages = new TreeMap<>();

ages.put("Charlie", 28);
ages.put("Alice", 25);
ages.put("Bob", 30);

// Iterating gives sorted order by key
for (String name : ages.keySet()) {
    System.out.println(name + ": " + ages.get(name));
}

// Output:
// Alice: 25
// Bob: 30
// Charlie: 28
```

### Iterating Over Maps

**By key:**
```java
for (String key : map.keySet()) {
    System.out.println(key + ": " + map.get(key));
}
```

**By value:**
```java
for (Integer value : map.values()) {
    System.out.println(value);
}
```

**By entry:**
```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### Common Map Methods

| Method | Purpose |
|--------|---------|
| `put(key, value)` | Add/update |
| `get(key)` | Get value by key |
| `remove(key)` | Remove by key |
| `containsKey(key)` | Check if key exists |
| `size()` | Number of pairs |
| `keySet()` | All keys |
| `values()` | All values |
| `entrySet()` | All key-value pairs |

---

