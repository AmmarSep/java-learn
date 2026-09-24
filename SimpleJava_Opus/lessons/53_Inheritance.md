# Lesson 53: Inheritance

## Simple Explanation

**Inheritance** lets a class **inherit** (receive) fields and methods from another class. The new class gets everything the parent has, plus can add its own.

**Analogy:** A child inherits traits from a parent. A "SportsCar" inherits features from "Car" (wheels, engine) and adds its own (turbo, spoiler).

## The `extends` Keyword

```java
public class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating");
    }
}

public class Dog extends Animal {
    void bark() {
        System.out.println(name + " says: Woof!");
    }
}
```

### Symbol breakdown of `public class Dog extends Animal`:
- `public class Dog` — Define a class called Dog.
- `extends` — A Java **keyword** meaning "inherits from."
- `Animal` — The **parent class** (also called superclass or base class).

`Dog` is the **child class** (also called subclass or derived class).

## What Does Dog Get?

```java
Dog d = new Dog();
d.name = "Buddy";    // ✅ Inherited from Animal
d.eat();              // ✅ Inherited from Animal → "Buddy is eating"
d.bark();             // ✅ Dog's own method → "Buddy says: Woof!"
```

`Dog` has:
- `name` field — inherited from `Animal`
- `eat()` method — inherited from `Animal`
- `bark()` method — its own

## Terminology

| Term | Meaning | Example |
|------|---------|---------|
| **Parent/Superclass** | The class being inherited from | `Animal` |
| **Child/Subclass** | The class that inherits | `Dog` |
| `extends` | Keyword for inheritance | `class Dog extends Animal` |
| **IS-A relationship** | The child IS A type of parent | A Dog IS AN Animal |

## Java Inheritance Rules

1. **Single inheritance** — A class can only extend **one** class.
2. **Every class extends `Object`** — If you don't write `extends`, Java automatically extends `Object`.
3. **`private` members are NOT inherited** — The child can't directly access private fields/methods of the parent. Use `protected` or getters.

```java
public class Animal {
    private String secret = "hidden";    // Dog can't access this directly
    protected String species;             // Dog CAN access this
}
```

## Multi-Level Inheritance

```java
class Animal { }                        // Grandparent
class Dog extends Animal { }            // Parent
class Puppy extends Dog { }             // Child
```

`Puppy` inherits from `Dog`, which inherits from `Animal`. So `Puppy` has everything from both.

## Common Beginner Mistakes

1. **Trying to extend multiple classes** — `class Dog extends Animal, Pet` is WRONG. Java only allows single inheritance.
2. **Forgetting that private is not inherited** — Use `protected` for fields subclasses need.
3. **Inheriting when it doesn't make sense** — Only use inheritance for IS-A relationships. A Dog IS AN Animal. A Car IS NOT a Driver.

## Quiz

1. What keyword is used for inheritance?
   - a) `inherits`
   - b) `extends` ✅
   - c) `implements`

2. Can a class extend more than one class?
   - a) Yes
   - b) No ✅

3. Can a child class access private fields of the parent?
   - a) Yes
   - b) No — use protected or getters ✅

---
**Next Lesson:** [Lesson 54 — `super`](54_Super.md)
