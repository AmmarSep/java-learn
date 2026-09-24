# Lesson 18: Variables

## Simple Explanation

A **variable** is a named container that stores a value. Think of it as a **labeled box** — the label is the variable's name, and the thing inside is its value.

**Analogy:** Imagine a box with the label "age" on it, and inside the box is the number `25`. That's a variable!

## Creating a Variable

To create a variable in Java, you write:

```java
int age = 25;
```

### Symbol-by-symbol breakdown:

- `int` — The **data type**. It tells Java what kind of value this variable will hold. `int` means "integer" (a whole number).
- A space ` `.
- `age` — The **name** of the variable. You choose this name.
- A space ` `.
- `=` — The **assignment operator**. It means "store the value on the right into the variable on the left." It does NOT mean "equals" in the math sense.
- A space ` `.
- `25` — The **value** being stored in the variable.
- `;` — End of the statement.

## Using Variables

Once a variable is created, you can use its name to access the value inside:

```java
public class Main {
    public static void main(String[] args) {
        int age = 25;
        System.out.println(age);        // Prints: 25
        System.out.println("Age: " + age);  // Prints: Age: 25
    }
}
```

### Key points:
- `age` (without quotes) — Java looks up the variable and uses its value (`25`).
- `"age"` (with quotes) — Java treats this as text, not a variable. It would print the word "age".

```java
System.out.println(age);       // Prints: 25 (the value stored in the variable)
System.out.println("age");     // Prints: age (just the text)
```

## Changing a Variable's Value

You can change what's stored in a variable:

```java
public class Main {
    public static void main(String[] args) {
        int score = 0;                  // Start with 0
        System.out.println(score);      // Prints: 0

        score = 10;                     // Change to 10
        System.out.println(score);      // Prints: 10

        score = score + 5;             // Add 5 to the current value
        System.out.println(score);      // Prints: 15
    }
}
```

### Key points:
- `int score = 0;` — **Declare and initialize**: create the variable and give it a starting value.
- `score = 10;` — **Reassign**: change the value. Notice: no `int` this time! You only write the type when you **first create** the variable.
- `score = score + 5;` — Take the current value of `score` (10), add 5, and store the result (15) back into `score`.

## Declaring vs. Initializing

```java
int age;           // DECLARE: create the variable (no value yet)
age = 25;          // INITIALIZE: give it a value for the first time

int height = 170;  // DECLARE AND INITIALIZE: create and give a value in one line
```

- **Declare** = tell Java "I want a variable with this name and type."
- **Initialize** = give the variable its first value.
- You can do both in one line (this is most common).

## Variable Naming Rules

### Must follow these rules:
1. Must start with a **letter**, underscore `_`, or dollar sign `$`.
2. Cannot start with a number.
3. Cannot contain spaces.
4. Cannot be a Java keyword (like `int`, `class`, `public`).
5. Case-sensitive: `age`, `Age`, and `AGE` are three different variables.

### Convention (not required, but everyone does it):
- Use **camelCase**: start with lowercase, capitalize each new word.
  - `age`, `firstName`, `numberOfStudents`, `isLoggedIn`
- Use descriptive names that explain what the variable holds.

### Examples:

```java
// ✅ Good variable names
int age = 25;
String firstName = "Alex";
double totalPrice = 19.99;
boolean isActive = true;

// ❌ Bad variable names (but technically valid)
int x = 25;           // What does x mean?
String s = "Alex";    // What does s mean?

// ❌ Invalid variable names (will cause errors)
// int 1stPlace = 1;     // Cannot start with a number
// int my age = 25;      // Cannot have spaces
// int class = 5;        // Cannot use a keyword
```

## Multiple Variables

You can create multiple variables:

```java
public class Main {
    public static void main(String[] args) {
        String name = "Alex";
        int age = 25;
        double height = 5.9;
        boolean isStudent = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Student: " + isStudent);
    }
}
```

**Output:**
```
Name: Alex
Age: 25
Height: 5.9
Student: true
```

## Common Beginner Mistakes

1. **Forgetting the type** — `age = 25;` without `int` (on first creation) causes an error.
2. **Using the type twice** — `int age = 25; int age = 30;` causes an error. Only declare once.
3. **Using before declaring** — You must create a variable before you use it.
4. **Confusing `=` with `==`** — `=` stores a value. `==` compares values.
5. **Not initializing** — Using a variable that has no value causes an error (in local variables).
6. **Wrong type** — `int name = "Alex";` won't work. `int` is for numbers, not text.

## Mini Practice Exercise

**Task:** Create variables for: your name, your age, your favorite number (decimal), and whether you like Java (true/false). Print them all.

**Answer:**
```java
public class Main {
    public static void main(String[] args) {
        String name = "Sam";
        int age = 20;
        double favoriteNumber = 7.5;
        boolean likesJava = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Favorite number: " + favoriteNumber);
        System.out.println("Likes Java: " + likesJava);
    }
}
```

## Quiz

1. What is a variable?
   - a) A fixed value that never changes
   - b) A named container that stores a value ✅
   - c) A type of method

2. What does `=` do in `int x = 5;`?
   - a) Checks if x equals 5
   - b) Assigns the value 5 to x ✅
   - c) Creates a new class

3. Which variable name is valid?
   - a) `1stName` ❌
   - b) `first name` ❌
   - c) `firstName` ✅

4. What happens if you write `int x = 5; int x = 10;`?
   - a) x becomes 10
   - b) Compilation error — x is declared twice ✅
   - c) x becomes 15

---
**Next Lesson:** [Lesson 19 — Data Types](19_Data_Types.md)
