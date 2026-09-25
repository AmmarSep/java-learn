[All guides](README.md) · [Phase examples](../examples/02-methods-and-memory/README.md) · [Previous phase](01-fundamentals.md) · [Next phase](03-object-oriented-programming.md)

# PHASE 2: METHODS & MEMORY

## Concept 2.1: Methods - Declaration and Calling

### Why This Matters
Methods let you break code into reusable pieces. Instead of writing the same code twice, write it once in a method and call it multiple times.

### Method Basics

```java
public class Calculator {
    // Method declaration
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Method call
        int result = add(5, 3);
        System.out.println(result);  // 8
    }
}
```

### Breaking Down Method Syntax

```java
public static int add(int a, int b) {
    return a + b;
}
```

- `public` = Accessible everywhere (covered in Phase 4)
- `static` = Called on class, not objects (covered in Phase 4)
- `int` = Return type: this method returns an integer
- `add` = Method name
- `(int a, int b)` = Parameters: what information the method needs
- `return a + b;` = What the method gives back

### Method Parameters and Arguments

**Parameters** = Variables in the method definition
**Arguments** = Values passed when calling

```java
public static void greet(String name) {  // 'name' is parameter
    System.out.println("Hello, " + name);
}

greet("Alice");  // "Alice" is argument
greet("Bob");    // "Bob" is argument
```

### Return Values

```java
public static int multiply(int a, int b) {
    int result = a * b;
    return result;  // Sends value back to caller
}

int product = multiply(4, 5);
System.out.println(product);  // 20
```

**void** = Method returns nothing

```java
public static void printMessage(String msg) {
    System.out.println(msg);
    // No return statement needed
}

printMessage("Hello");  // Just call it
String x = printMessage("Hi");  // ERROR: void returns nothing
```

### Method Overloading

Multiple methods with same name but different parameters:

```java
public class Math {
    public static int add(int a, int b) {
        return a + b;  // Adds two integers
    }

    public static double add(double a, double b) {
        return a + b;  // Adds two doubles
    }

    public static int add(int a, int b, int c) {
        return a + b + c;  // Adds three integers
    }
}

// Java knows which to call based on argument types
int result1 = add(5, 3);           // Calls add(int, int)
double result2 = add(5.5, 3.2);    // Calls add(double, double)
int result3 = add(5, 3, 2);        // Calls add(int, int, int)
```

Java chooses the correct method based on argument types.

### Common Mistakes
- Forgetting return type: `public add(int a, int b)` → Must specify return type
- Forgetting return statement: Method returns void by mistake
- Parameter vs argument confusion: Parameters in definition, arguments in call
- Overloading with only return type different: `int add(int a, int b)` and `double add(int a, int b)` → Not allowed

---

## Concept 2.2: Stack vs Heap Memory

### Why This Matters
Understanding where data lives in memory helps you understand Java behavior and debug memory-related issues.

### Stack Memory

Where **primitive variables** and **local variables** are stored.

**Characteristics:**
- Very fast access
- Limited size
- Variables exist only during method execution
- Automatically cleaned up when method ends
- LIFO: Last In, First Out (like a stack of plates)

**Example:**
```java
public static void main(String[] args) {
    int x = 5;      // Stack: x = 5
    int y = 10;     // Stack: y = 10
    int sum = x + y; // Stack: sum = 15

    printNumber(sum);  // Method call
    // After method ends: x, y, sum disappear
}

public static void printNumber(int num) {
    System.out.println(num);  // Stack: num = 15
    // When this method ends, num disappears
}
```

When `main()` starts, the stack grows:
```
[int x = 5]
[int y = 10]
[int sum = 15]
[int num = 15]  ← From printNumber call
```

When each method ends, its variables are popped off the stack.

### Heap Memory

Where **objects** and **arrays** are stored.

**Characteristics:**
- Slower access than stack
- Larger size
- Objects exist until no variables reference them
- Garbage collector removes unused objects
- Random access: any object anytime

**Example:**
```java
public static void main(String[] args) {
    String name = "Alice";  // Stack: name points to → Heap: "Alice" object
    int[] numbers = {1, 2, 3};  // Stack: numbers points to → Heap: array
}
```

Visual representation:
```
STACK              HEAP
name ─────────→ "Alice" (String object)
numbers ──────→ [1, 2, 3] (array object)
```

### Reference Variables

Primitive variables hold values. Reference variables hold addresses:

```java
int x = 5;        // x contains 5
String s = "Bob"; // s contains address of "Bob" object in heap
```

When you assign one reference variable to another:
```java
String name1 = "Alice";
String name2 = name1;  // name2 points to same "Alice" object

// name1 and name2 reference the same object
```

NOT:
```java
String name1 = "Alice";
String name2 = name1;  // name2 is a copy of the reference, NOT a copy of the string
// Modifying name1 doesn't change name2 (strings are immutable anyway)
```

### Memory Cleanup

**Stack:** Automatic. When method ends, variables disappear.
```java
public static void example() {
    int x = 5;  // Stack
}  // x is automatically removed from stack
```

**Heap:** Garbage Collector. When no variables reference an object, it's eventually removed.
```java
String name = "Alice";  // Heap: "Alice" object created
name = "Bob";           // Heap: "Bob" object created, "Alice" unreferenced
                        // Garbage collector will eventually remove "Alice"
```

### Common Mistakes
- Assuming objects are copied: `String s1 = "Alice"; String s2 = s1;` → Both reference same object
- Stack overflow: Infinite recursion fills stack
- Memory leak: Keeping references to unused objects (rare in Java)
- Null pointer exception: Using object that doesn't exist

---

## Concept 2.3: Pass-by-Value

### Why This Matters
Java passes copies of values to methods. Understanding this prevents confusion about whether method can modify original variable.

### What is Pass-by-Value?

Java makes a **copy** of the value and passes the copy. Changes to the copy don't affect the original.

### Primitives are Passed by Value

```java
public static void changeValue(int x) {
    x = 100;  // Change the copy
}

public static void main(String[] args) {
    int original = 5;
    changeValue(original);
    System.out.println(original);  // Still 5, not changed!
}
```

Visual flow:
```
main() has: original = 5
            ↓
changeValue(original) called
            ↓
changeValue gets a COPY: x = 5
            ↓
Inside changeValue: x = 100 (only the copy changed)
            ↓
Return to main()
            ↓
original is still 5
```

The method received a copy. Modifying the copy doesn't touch the original.

### Objects are Passed by Value (But It's Tricky)

Reference variables are also passed by value, but the value is an address:

```java
public static void changeName(String str) {
    str = "Bob";  // Change the copy's address
}

public static void main(String[] args) {
    String name = "Alice";
    changeName(name);
    System.out.println(name);  // Still "Alice"!
}
```

The method gets a copy of the address, not the object itself:
```
main() has: name (address of "Alice" object)
            ↓
changeName(name) called
            ↓
changeName gets a COPY of the address
            ↓
Inside changeName: str = (address of "Bob" object)
                   (only the copy changed)
            ↓
Return to main()
            ↓
name still points to "Alice"
```

### Arrays are Objects Too

```java
public static void modifyArray(int[] arr) {
    arr[0] = 999;  // Modify the actual array
}

public static void main(String[] args) {
    int[] numbers = {1, 2, 3};
    modifyArray(numbers);
    System.out.println(numbers[0]);  // 999 (changed!)
}
```

Why? The method gets a copy of the address, but both copies point to the same array:
```
main() has: numbers (address of array [1, 2, 3])
            ↓
modifyArray(numbers) called
            ↓
modifyArray gets a COPY of the address
            ↓
Inside modifyArray: arr points to same array
                    arr[0] = 999 modifies the actual array
            ↓
Return to main()
            ↓
numbers[0] is now 999 (same array was modified)
```

### Key Insight

```
Pass-by-value means:
- Primitives: copy of value. Changes don't affect original.
- Objects: copy of address. Can modify object contents, but can't change what the original reference points to.
```

### Common Mistakes
- Thinking objects can be changed: `changeString(s)` won't change s's value because strings are immutable
- Expecting array changes to revert: Method modifies array, changes stick
- Confusion with return values: Method doesn't need to return to modify arrays/objects

---

