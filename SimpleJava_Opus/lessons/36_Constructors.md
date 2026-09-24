# Lesson 36: Constructors

## Simple Explanation

A **constructor** is a special method that runs **automatically** when you create a new object with `new`. Its job is to **set up** (initialize) the object.

**Analogy:** When you buy a new phone, it comes pre-configured with a name, storage, and color already set. The constructor is like the factory process that sets up the phone before you receive it.

## What Makes a Constructor Special?

1. It has the **same name** as the class.
2. It has **no return type** — not even `void`.
3. It runs **automatically** when `new` is used.

## Default Constructor

If you don't write a constructor, Java provides a hidden **default constructor** that does nothing:

```java
public class Dog {
    String name;
    int age;
    // Java secretly provides: Dog() { }
}

Dog d = new Dog();   // Calls the default constructor
```

## Writing Your Own Constructor

```java
public class Dog {
    String name;
    int age;

    // Constructor
    Dog(String dogName, int dogAge) {
        name = dogName;
        age = dogAge;
    }
}
```

### Symbol-by-symbol breakdown of `Dog(String dogName, int dogAge)`:
- `Dog` — The name of the constructor. **Must match the class name exactly.**
- `(` — Opening parenthesis. Start of parameters.
- `String dogName` — First parameter.
- `,` — Comma separating parameters.
- `int dogAge` — Second parameter.
- `)` — Closing parenthesis.
- `{` — Start of constructor body.
- `name = dogName;` — Set the field `name` to the value of `dogName`.
- `age = dogAge;` — Set the field `age` to the value of `dogAge`.
- `}` — End of constructor body.

**Notice:** No `void`, no `static`, no return type at all!

### Using the constructor:

```java
Dog myDog = new Dog("Buddy", 3);
System.out.println(myDog.name);    // Buddy
System.out.println(myDog.age);     // 3
```

### Symbol breakdown of `new Dog("Buddy", 3)`:
- `new` — Create a new object.
- `Dog` — The class.
- `(` — Start of arguments.
- `"Buddy"` — First argument → goes to `dogName` parameter.
- `,` — Comma.
- `3` — Second argument → goes to `dogAge` parameter.
- `)` — End of arguments.

Now the object is created with `name = "Buddy"` and `age = 3` right away! No need to set them manually.

## Multiple Constructors (Overloading)

You can have more than one constructor with different parameters:

```java
public class Dog {
    String name;
    int age;

    // Constructor with both parameters
    Dog(String dogName, int dogAge) {
        name = dogName;
        age = dogAge;
    }

    // Constructor with only a name (age defaults to 0)
    Dog(String dogName) {
        name = dogName;
        age = 0;
    }

    // Constructor with no parameters
    Dog() {
        name = "Unknown";
        age = 0;
    }
}
```

```java
Dog d1 = new Dog("Buddy", 3);     // Uses first constructor
Dog d2 = new Dog("Rex");           // Uses second constructor
Dog d3 = new Dog();                // Uses third constructor
```

Java picks the right constructor based on the arguments you pass.

## Important: Once You Write a Constructor...

If you write **any** constructor, Java **no longer provides** the default one:

```java
public class Cat {
    String name;

    Cat(String catName) {
        name = catName;
    }
}

Cat c1 = new Cat("Whiskers");   // ✅ OK
Cat c2 = new Cat();              // ❌ ERROR! No-argument constructor doesn't exist anymore.
```

To fix this, add a no-argument constructor yourself.

## Common Beginner Mistakes

1. **Adding a return type** — `void Dog()` is NOT a constructor — it's a regular method. Constructors have no return type.
2. **Wrong name** — The constructor name must exactly match the class name.
3. **Forgetting that default constructor disappears** — Once you write any constructor, the default one is gone.
4. **Using `static`** — Constructors are never `static`.

## Mini Practice Exercise

**Task:** Create a `Rectangle` class with `width` and `height` fields and a constructor that sets both. Add a method `area()` that returns the area.

**Answer:**
```java
public class Rectangle {
    double width;
    double height;

    Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    double area() {
        return width * height;
    }
}

// Usage:
Rectangle r = new Rectangle(5.0, 3.0);
System.out.println(r.area());    // 15.0
```

## Quiz

1. What is special about a constructor's name?
   - a) It can be anything
   - b) It must match the class name ✅
   - c) It must start with "init"

2. What return type does a constructor have?
   - a) `void`
   - b) `int`
   - c) None — no return type at all ✅

3. When does a constructor run?
   - a) When you call it manually
   - b) Automatically when `new` creates an object ✅
   - c) At the end of the program

---
**Next Lesson:** [Lesson 37 — `this`](37_This.md)
