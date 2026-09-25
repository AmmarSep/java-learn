[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](26_Loops.md) · [Next](../05-methods/28_Methods.md)

**Runnable companion:** [CommandLineArguments](../../examples/00-getting-started/02-command-line-arguments/CommandLineArguments.java), [Phase0_CommandLineArgs](../../examples/00-getting-started/05-arguments-explained/Phase0_CommandLineArgs.java), [Phase1_Arrays](../../examples/01-fundamentals/04-arrays/Phase1_Arrays.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 27: Arrays

## Simple Explanation

An **array** is a container that holds **multiple values of the same type** in a fixed-size list. Each value has a numbered position called an **index**.

**Analogy:** An array is like a row of mailboxes. Each mailbox has a number (index), and each one holds something (a value).

## Creating an Array

### Method 1: Declare and specify size

```java
int[] numbers = new int[5];
```

### Symbol-by-symbol breakdown:
- `int` — The data type of the values the array will hold.
- `[]` — **Square brackets** after the type. This tells Java "this is an array of ints", not just a single int.
- `numbers` — The name of the array variable.
- `=` — Assignment operator.
- `new` — A Java **keyword** meaning "create a new object/array."
- `int[5]` — Create an array that can hold 5 `int` values.
- `;` — End of statement.

This creates an array of 5 integers, all initialized to `0` by default.

### Method 2: Declare and provide values immediately

```java
int[] numbers = {10, 20, 30, 40, 50};
```

### Symbol-by-symbol breakdown:
- `int[]` — An array of integers.
- `numbers` — The name.
- `=` — Assignment.
- `{` — Opening **curly brace**. Starts the list of values.
- `10` — First value (index 0).
- `,` — A **comma**. Separates values in the list.
- `20` — Second value (index 1).
- `,` — Comma.
- `30, 40, 50` — More values.
- `}` — Closing **curly brace**. Ends the list.
- `;` — End of statement.

## Accessing Array Elements

Arrays use **zero-based indexing** — the first element is at index `0`, not `1`.

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[0]);    // 10 (first element)
System.out.println(numbers[1]);    // 20 (second element)
System.out.println(numbers[4]);    // 50 (last element)
```

### Symbol breakdown of `numbers[0]`:
- `numbers` — The name of the array.
- `[` — Opening **square bracket**.
- `0` — The **index** (position) of the element we want. `0` means "the first one."
- `]` — Closing **square bracket**.

### Visual representation:
```
Index:    [0]  [1]  [2]  [3]  [4]
Values:    10   20   30   40   50
```

## Changing Array Elements

```java
int[] numbers = {10, 20, 30, 40, 50};

numbers[2] = 99;    // Change the value at index 2

System.out.println(numbers[2]);    // 99 (changed from 30)
```

### Symbol breakdown of `numbers[2] = 99;`:
- `numbers[2]` — The element at index 2 of the array.
- `=` — Assign a new value.
- `99` — The new value.
- `;` — End of statement.

## Array Length

Every array knows its size:

```java
int[] numbers = {10, 20, 30, 40, 50};
System.out.println(numbers.length);    // 5
```

### Symbol breakdown:
- `numbers` — The array.
- `.` — Access something inside the array.
- `length` — A property (not a method!) that gives the number of elements. **No parentheses** — it's `length`, not `length()`.

## Looping Through an Array

### Using a `for` loop:

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println("Index " + i + ": " + numbers[i]);
}
```

**Output:**
```
Index 0: 10
Index 1: 20
Index 2: 30
Index 3: 40
Index 4: 50
```

- `i < numbers.length` — The loop runs while `i` is less than the array's length (5).
- `numbers[i]` — Access the element at the current index `i`.

## Arrays with Other Types

```java
String[] names = {"Alice", "Bob", "Charlie"};
double[] prices = {9.99, 14.50, 3.75};
boolean[] flags = {true, false, true};
char[] letters = {'A', 'B', 'C'};
```

## ArrayIndexOutOfBoundsException

If you try to access an index that doesn't exist:

```java
int[] numbers = {10, 20, 30};
System.out.println(numbers[5]);    // ERROR! Index 5 doesn't exist.
```

This causes an **ArrayIndexOutOfBoundsException** — Java's way of saying "that index doesn't exist!"

Valid indices for an array of size 3 are: `0`, `1`, `2`. Not `3` and not `-1`.

## Common Beginner Mistakes

1. **Starting at index 1 instead of 0** — Arrays start at index `0`.
2. **Accessing beyond the array** — An array of size 5 has indices 0-4, NOT 0-5.
3. **Confusing `length` with `length()`** — Arrays use `length` (no parentheses). Strings use `length()` (with parentheses).
4. **Trying to resize an array** — Arrays have a **fixed size**. Once created, you can't add more elements. (Use `ArrayList` for that — covered later.)
5. **Forgetting `new`** — `int[] numbers = int[5];` is wrong. Use `new int[5]`.

## Mini Practice Exercise

**Task:** Create an array of 4 favorite foods and print them all using a loop.

**Answer:**
```java
public class Main {
    public static void main(String[] args) {
        String[] foods = {"Pizza", "Sushi", "Tacos", "Pasta"};

        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i]);
        }
    }
}
```

## Quiz

1. What is the index of the first element in an array?
   - a) 1
   - b) 0 ✅
   - c) -1

2. What does `int[] x = new int[3];` create?
   - a) An array with values 1, 2, 3
   - b) An array of 3 integers, all initialized to 0 ✅
   - c) An array of 3 strings

3. How do you get the size of an array?
   - a) `array.size()`
   - b) `array.length` ✅
   - c) `array.length()`

4. What happens if you access `numbers[10]` on an array of size 5?
   - a) Returns 0
   - b) ArrayIndexOutOfBoundsException ✅
   - c) Returns null

---
**Next Lesson:** [Lesson 28 — Methods](../05-methods/28_Methods.md)
