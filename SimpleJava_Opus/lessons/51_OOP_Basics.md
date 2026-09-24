# Lesson 51: Object-Oriented Programming Basics

## Simple Explanation

**Object-Oriented Programming (OOP)** is a way of organizing code around **objects** — things that have data and behavior. Java is an OOP language.

## The Four Pillars of OOP

| Pillar | Meaning | Analogy |
|--------|---------|---------|
| **Encapsulation** | Hide internal details, expose only what's needed | A car hides its engine; you just use the steering wheel |
| **Inheritance** | A class can inherit from another class | A "SportsCar" inherits properties from "Car" |
| **Polymorphism** | Same method name, different behavior | "speak()" — a Dog barks, a Cat meows |
| **Abstraction** | Show only essential features, hide complexity | A TV remote — you press buttons without knowing the circuits |

We've already used classes and objects. Now we'll explore each pillar in depth over the next lessons.

## Why OOP?

1. **Reuse code** — Write once, use in many places through inheritance.
2. **Organize code** — Group related data and behavior together.
3. **Manage complexity** — Break large programs into smaller, manageable pieces.
4. **Model real things** — Objects in code can represent real-world things.

## Quick Preview

```java
// Encapsulation: private data, public methods
public class BankAccount {
    private double balance;
    public void deposit(double amount) { balance += amount; }
    public double getBalance() { return balance; }
}

// Inheritance: Dog IS AN Animal
public class Animal { void eat() { System.out.println("Eating"); } }
public class Dog extends Animal { void bark() { System.out.println("Woof"); } }

// Polymorphism: same method, different behavior
Animal a = new Dog();
a.eat();    // Works — Dog inherited eat() from Animal
```

## Quiz

1. What are the four pillars of OOP?
   - Encapsulation, Inheritance, Polymorphism, Abstraction ✅

2. What does OOP organize code around?
   - a) Functions
   - b) Objects ✅
   - c) Files

---
**Next Lesson:** [Lesson 52 — Encapsulation](52_Encapsulation.md)
