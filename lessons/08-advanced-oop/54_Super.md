[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](53_Inheritance.md) · [Next](55_Method_Overriding.md)

**Runnable companion:** [Phase3_Inheritance_Polymorphism](../../examples/03-object-oriented-programming/03-inheritance-and-polymorphism/Phase3_Inheritance_Polymorphism.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 54: `super`

## Simple Explanation

`super` is a keyword that refers to the **parent class**. It's used to call the parent's constructor or methods.

If `this` means "me" (the current object), then `super` means "my parent."

## `super()` — Calling the Parent Constructor

```java
public class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal created: " + name);
    }
}

public class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name);          // Call Animal's constructor FIRST
        this.breed = breed;
        System.out.println("Dog created: " + breed);
    }
}
```

### Symbol breakdown of `super(name)`:
- `super` — Refers to the parent class constructor.
- `(` — Start of arguments.
- `name` — The argument passed to the parent's constructor.
- `)` — End of arguments.
- `;` — End of statement.

**Rule:** `super()` must be the **first statement** in the child's constructor.

```java
Dog d = new Dog("Buddy", "Golden Retriever");
// Output:
// Animal created: Buddy
// Dog created: Golden Retriever
```

## `super.method()` — Calling a Parent Method

```java
public class Animal {
    void speak() {
        System.out.println("Some sound");
    }
}

public class Dog extends Animal {
    void speak() {
        super.speak();    // Call the parent's version first
        System.out.println("Woof!");
    }
}
```

### Symbol breakdown of `super.speak()`:
- `super` — The parent class.
- `.` — Access something in the parent.
- `speak()` — Call the parent's `speak` method.

## Common Beginner Mistakes

1. **`super()` not on the first line** — It must be the first statement in a constructor.
2. **Forgetting to call `super()`** — If the parent has no no-argument constructor, you MUST call `super(args)`.
3. **Confusing `this` and `super`** — `this` = current object, `super` = parent class.

## Quiz

1. What does `super` refer to?
   - a) The current object
   - b) The parent class ✅
   - c) A static method

2. Where must `super()` appear in a constructor?
   - a) Anywhere
   - b) As the first statement ✅
   - c) As the last statement

---
**Next Lesson:** [Lesson 55 — Method Overriding](55_Method_Overriding.md)
