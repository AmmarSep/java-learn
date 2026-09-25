[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](../05-methods/31_Scope.md) · [Next](33_Objects.md)

**Runnable companion:** [Phase3_Classes_Objects](../../examples/03-object-oriented-programming/01-classes-and-objects/Phase3_Classes_Objects.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 32: Classes

## Simple Explanation

A **class** is a **blueprint** for creating things. It defines what something **has** (data) and what it can **do** (actions).

**Analogy:** A class is like an architectural blueprint for a house. The blueprint itself isn't a house — it describes what a house looks like. You can build many houses from one blueprint.

## Defining a Class

```java
public class Dog {
    String name;
    int age;

    void bark() {
        System.out.println(name + " says: Woof!");
    }
}
```

### Symbol-by-symbol breakdown:

- `public` — Everyone can access this class.
- `class` — Keyword that says "I'm defining a class."
- `Dog` — The name of the class. Starts with uppercase (PascalCase convention).
- `{` — Start of the class body.
- `String name;` — A **field** (variable that belongs to the class). Every Dog will have a name.
- `int age;` — Another field. Every Dog will have an age.
- `void bark()` — A **method** (action the class can do). This one doesn't return anything (`void`).
- `{` — Start of the method body.
- `System.out.println(name + " says: Woof!");` — What the method does.
- `}` — End of method body.
- `}` — End of class body.

## What a Class Contains

A class can contain:

1. **Fields** (also called instance variables) — the data:
   ```java
   String name;
   int age;
   double weight;
   ```

2. **Methods** — the actions:
   ```java
   void bark() { ... }
   void eat() { ... }
   String getName() { ... }
   ```

3. **Constructors** — special methods for creating objects (covered soon).

## Class vs Object (Preview)

- **Class** = the blueprint (the plan).
- **Object** = a real thing built from the blueprint (the actual house).

```java
// Dog is the CLASS (blueprint)
public class Dog {
    String name;
    int age;
}

// In another file or in main:
Dog myDog = new Dog();       // myDog is an OBJECT (a real dog)
Dog yourDog = new Dog();     // yourDog is another OBJECT (another real dog)
```

We'll cover creating objects in detail in the next lesson.

## File Organization

Each public class should go in its own file:

```
Dog.java      → contains public class Dog
Cat.java      → contains public class Cat
Main.java     → contains public class Main (with main method)
```

## A Complete Example

**File: Dog.java**
```java
public class Dog {
    String name;
    int age;

    void bark() {
        System.out.println(name + " says: Woof!");
    }

    void info() {
        System.out.println(name + " is " + age + " years old.");
    }
}
```

**File: Main.java**
```java
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "Buddy";
        myDog.age = 3;
        myDog.bark();
        myDog.info();
    }
}
```

**Output:**
```
Buddy says: Woof!
Buddy is 3 years old.
```

## Common Beginner Mistakes

1. **Forgetting that a class is just a blueprint** — You can't use a class directly. You create objects from it.
2. **Putting `static` on everything** — Fields and methods in a regular class usually should NOT be static. (We'll explain when to use static later.)
3. **Naming classes with lowercase** — Convention is PascalCase: `Dog`, not `dog`.
4. **Putting two public classes in one file** — Only one public class per file.

## Mini Practice Exercise

**Task:** Create a class `Car` with fields `brand` (String), `year` (int), and a method `displayInfo` that prints both.

**Answer:**
```java
public class Car {
    String brand;
    int year;

    void displayInfo() {
        System.out.println(brand + " (" + year + ")");
    }
}
```

## Quiz

1. What is a class?
   - a) A real object
   - b) A blueprint for creating objects ✅
   - c) A type of variable

2. What do fields represent?
   - a) Actions the class can do
   - b) Data the class holds ✅
   - c) Other classes

3. What naming convention do classes use?
   - a) camelCase (`myClass`)
   - b) PascalCase (`MyClass`) ✅
   - c) UPPER_CASE (`MY_CLASS`)

---
**Next Lesson:** [Lesson 33 — Objects](33_Objects.md)
