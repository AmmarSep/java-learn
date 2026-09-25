[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](54_Super.md) · [Next](56_Method_Overloading.md)

**Runnable companion:** [Phase3_Inheritance_Polymorphism](../../examples/03-object-oriented-programming/03-inheritance-and-polymorphism/Phase3_Inheritance_Polymorphism.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 55: Method Overriding

## Simple Explanation

**Method overriding** is when a child class provides its **own version** of a method that already exists in the parent class. Same name, same parameters, different behavior.

## Example

```java
public class Animal {
    void speak() {
        System.out.println("Some generic sound");
    }
}

public class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("Meow!");
    }
}
```

```java
Dog d = new Dog();
Cat c = new Cat();
d.speak();    // Woof!
c.speak();    // Meow!
```

### Symbol breakdown of `@Override`:
- `@` — The "at" symbol. It marks an **annotation** — metadata attached to code.
- `Override` — The name of the annotation. It tells Java: "I intend to override a parent method. Please check that I'm doing it correctly."

`@Override` is **optional** but **strongly recommended**. If you misspell the method name, the annotation will cause a compile error, catching your mistake.

## Rules for Overriding

1. **Same method name** as the parent.
2. **Same parameters** (same types, same order).
3. **Same or broader access** — If parent is `protected`, child can be `protected` or `public`, but NOT `private`.
4. **Same return type** (or a subtype — called covariant return).
5. **Cannot override `static` methods** — Static methods belong to the class, not the object.
6. **Cannot override `final` methods** — `final` methods are locked.

## Common Beginner Mistakes

1. **Forgetting `@Override`** — It's optional but catches errors. Always use it.
2. **Changing the parameter types** — That creates **overloading**, not overriding (different concept!).
3. **Reducing access** — Making a `public` parent method `private` in the child is not allowed.

## Quiz

1. What is method overriding?
   - a) Creating a new method
   - b) Replacing a parent method with a new version in the child ✅
   - c) Deleting a method

2. What does `@Override` do?
   - a) Forces the method to run
   - b) Tells Java to check you're correctly overriding a parent method ✅
   - c) Makes the method private

---
**Next Lesson:** [Lesson 56 — Method Overloading](56_Method_Overloading.md)
