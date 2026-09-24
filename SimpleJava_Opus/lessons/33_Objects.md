# Lesson 33: Objects

## Simple Explanation

An **object** is a real instance created from a class. If the class is the blueprint, the object is the actual thing built from it.

**Analogy:** `Dog` (class) is the idea of a dog. `myDog` (object) is your actual dog, Buddy, who is 3 years old.

## Creating an Object

```java
Dog myDog = new Dog();
```

### Symbol-by-symbol breakdown:
- `Dog` — The **type** (the class this object is made from).
- `myDog` — The **name** of the variable holding the object. Use camelCase.
- `=` — Assignment operator.
- `new` — A Java **keyword** that creates a new object in memory.
- `Dog()` — Calls the **constructor** of the Dog class (creates and initializes the object). The parentheses `()` are required.
- `;` — End of statement.

## Accessing Fields and Methods

Use the **dot** `.` operator to access an object's fields and methods:

```java
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();       // Create a new Dog object

        myDog.name = "Buddy";        // Set the name field
        myDog.age = 3;               // Set the age field

        myDog.bark();                // Call the bark method
        myDog.info();                // Call the info method
    }
}
```

### Symbol breakdown of `myDog.name = "Buddy";`:
- `myDog` — The object.
- `.` — The dot means "access something inside this object."
- `name` — The field we're accessing.
- `=` — Assign a value.
- `"Buddy"` — The value.
- `;` — End of statement.

### Symbol breakdown of `myDog.bark();`:
- `myDog` — The object.
- `.` — Access something inside this object.
- `bark` — The method to call.
- `()` — Parentheses to call the method (no arguments).
- `;` — End of statement.

## Multiple Objects from One Class

Each object is **independent** — changing one doesn't affect another:

```java
public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.name = "Buddy";
        dog1.age = 3;

        Dog dog2 = new Dog();
        dog2.name = "Max";
        dog2.age = 5;

        dog1.bark();    // Buddy says: Woof!
        dog2.bark();    // Max says: Woof!

        System.out.println(dog1.name);  // Buddy
        System.out.println(dog2.name);  // Max
    }
}
```

`dog1` and `dog2` are two separate objects. They each have their own `name` and `age`.

## Objects vs Primitives

| Primitives | Objects |
|-----------|---------|
| `int`, `double`, `char`, `boolean` | `Dog`, `String`, `Car` |
| Store actual values | Store references (addresses) to data |
| Lowercase names | Uppercase names (classes) |
| Created without `new` | Created with `new` |

```java
int x = 5;              // Primitive — stores the value 5 directly
Dog d = new Dog();       // Object — stores a reference to a Dog in memory
```

## `null` — No Object

A reference variable can point to **nothing** — this is called `null`:

```java
Dog myDog = null;        // myDog doesn't point to any object
// myDog.bark();         // ❌ NullPointerException! No object to bark!

myDog = new Dog();       // Now myDog points to a real object
myDog.name = "Rex";
myDog.bark();            // ✅ OK now
```

- `null` means "no object" or "nothing."
- Trying to use a `null` reference causes a **NullPointerException** — one of the most common errors in Java.

## Common Beginner Mistakes

1. **Forgetting `new`** — `Dog myDog = Dog();` is wrong. You need `new Dog()`.
2. **Using an object before creating it** — Causes NullPointerException.
3. **Thinking objects share data** — Each object has its own copy of the fields.
4. **Confusing class and object** — The class is the blueprint; the object is the instance.

## Mini Practice Exercise

**Task:** Create a `Book` class with `title` and `author` fields, create two Book objects, and print their info.

**Answer:**
```java
// Book.java
public class Book {
    String title;
    String author;

    void display() {
        System.out.println(title + " by " + author);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java Basics";
        book1.author = "Alex";

        Book book2 = new Book();
        book2.title = "Learn to Code";
        book2.author = "Sam";

        book1.display();    // Java Basics by Alex
        book2.display();    // Learn to Code by Sam
    }
}
```

## Quiz

1. What keyword creates a new object?
   - a) `create`
   - b) `new` ✅
   - c) `make`

2. What does `.` (dot) do?
   - a) Ends a statement
   - b) Accesses a field or method of an object ✅
   - c) Multiplies numbers

3. What is `null`?
   - a) The number zero
   - b) An empty String
   - c) A reference that points to no object ✅

4. Do two objects from the same class share the same data?
   - a) Yes
   - b) No — each has its own copy ✅

---
**Next Lesson:** [Lesson 34 — Fields](34_Fields.md)
