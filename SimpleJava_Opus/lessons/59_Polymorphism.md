# Lesson 59: Polymorphism

## Simple Explanation

**Polymorphism** means "many forms." In Java, it means a parent type variable can hold a child type object, and the correct method is called based on the **actual object**, not the variable type.

**Analogy:** A remote control (parent type) can control any TV (child type). You press "power" and the right TV turns on.

## Example

```java
public class Animal {
    void speak() { System.out.println("..."); }
}
public class Dog extends Animal {
    @Override
    void speak() { System.out.println("Woof!"); }
}
public class Cat extends Animal {
    @Override
    void speak() { System.out.println("Meow!"); }
}
```

```java
Animal a1 = new Dog();     // Variable type: Animal. Actual object: Dog.
Animal a2 = new Cat();     // Variable type: Animal. Actual object: Cat.

a1.speak();    // Woof!  — calls Dog's speak()
a2.speak();    // Meow!  — calls Cat's speak()
```

### Symbol breakdown of `Animal a1 = new Dog();`:
- `Animal` — The **declared type** (what the variable says it is).
- `a1` — Variable name.
- `=` — Assignment.
- `new Dog()` — The **actual object** being created. A Dog IS AN Animal, so this is valid.
- `;` — End of statement.

Java calls the method based on the **actual object** (`Dog`), not the declared type (`Animal`). This is called **dynamic dispatch**.

## The Power: Working with Collections

```java
ArrayList<Animal> animals = new ArrayList<>();
animals.add(new Dog());
animals.add(new Cat());
animals.add(new Dog());

for (Animal a : animals) {
    a.speak();    // Each animal speaks in its own way!
}
// Output: Woof! Meow! Woof!
```

One loop handles all animal types because of polymorphism.

## Polymorphism with Interfaces

```java
public interface Drawable {
    void draw();
}

public class Circle implements Drawable {
    public void draw() { System.out.println("Drawing circle"); }
}
public class Square implements Drawable {
    public void draw() { System.out.println("Drawing square"); }
}

// Polymorphism:
Drawable d = new Circle();
d.draw();    // Drawing circle
```

## `instanceof` — Checking the Actual Type

```java
Animal a = new Dog();

if (a instanceof Dog) {
    System.out.println("It's a dog!");
    Dog d = (Dog) a;    // Cast to Dog to access Dog-specific methods
    d.bark();            // If Dog has a bark() method
}
```

### Symbol breakdown of `a instanceof Dog`:
- `a` — The variable.
- `instanceof` — A Java **keyword** that checks if an object is an instance of a specific class.
- `Dog` — The class to check against.
- Returns `true` or `false`.

## Common Beginner Mistakes

1. **Calling child-only methods on parent type** — `Animal a = new Dog(); a.bark();` won't compile because `Animal` doesn't have `bark()`. You must cast first.
2. **Forgetting to override** — If the child doesn't override, the parent's version runs.
3. **Confusing compile-time and runtime types** — The compiler sees `Animal`, but at runtime it's a `Dog`.

## Quiz

1. What is polymorphism?
   - a) Having multiple classes
   - b) A parent type variable holding a child object, calling the child's method ✅
   - c) Creating multiple objects

2. What does `instanceof` check?
   - a) If a variable is null
   - b) If an object is an instance of a specific class ✅
   - c) If two objects are equal

---
**Next Lesson:** [Lesson 60 — Exceptions](60_Exceptions.md)
