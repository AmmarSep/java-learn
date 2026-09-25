[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](55_Method_Overriding.md) · [Next](57_Abstract_Classes.md)

---

# Lesson 56: Method Overloading

## Simple Explanation

**Method overloading** is having **multiple methods with the same name** but **different parameters** in the same class. Java picks the right one based on the arguments you pass.

## Example

```java
public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

```java
Calculator calc = new Calculator();
System.out.println(calc.add(5, 3));          // 8 — calls int version
System.out.println(calc.add(2.5, 3.5));      // 6.0 — calls double version
System.out.println(calc.add(1, 2, 3));       // 6 — calls three-parameter version
```

## Overloading vs Overriding

| Feature | Overloading | Overriding |
|---------|------------|------------|
| Where | Same class | Child class |
| Method name | Same | Same |
| Parameters | **Different** | **Same** |
| Return type | Can differ | Must be same |
| Keyword | None | `@Override` |

## Rules

1. Methods must have **different parameter lists** (different types, different number, or different order).
2. **Return type alone** is NOT enough to overload — `int add()` and `double add()` with same parameters won't compile.

## Common Beginner Mistakes

1. **Confusing overloading with overriding** — Overloading = same class, different params. Overriding = child class, same params.
2. **Thinking return type makes it overloaded** — Only parameters matter.

## Quiz

1. What is method overloading?
   - a) Same name, same parameters, different class
   - b) Same name, different parameters, same class ✅
   - c) Different names, same parameters

2. What distinguishes overloaded methods?
   - a) Return type
   - b) Parameter list ✅
   - c) Access modifier

---
**Next Lesson:** [Lesson 57 — Abstract Classes](57_Abstract_Classes.md)
