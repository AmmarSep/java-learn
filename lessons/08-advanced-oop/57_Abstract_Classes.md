[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](56_Method_Overloading.md) · [Next](58_Interfaces.md)

**Runnable companion:** [Phase3_AbstractClasses](../../examples/03-object-oriented-programming/04-abstract-classes/Phase3_AbstractClasses.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 57: Abstract Classes

## Simple Explanation

An **abstract class** is a class that **cannot be instantiated** (you can't create objects from it directly). It's meant to be a **base class** that other classes extend. It can have abstract methods — methods with no body that child classes **must** implement.

**Analogy:** "Shape" is abstract — you can't draw "a shape." But you CAN draw a Circle or a Rectangle, which ARE shapes.

## The `abstract` Keyword

```java
public abstract class Shape {
    String color;

    // Regular method (has a body)
    void describe() {
        System.out.println("A " + color + " shape");
    }

    // Abstract method (NO body — child must implement)
    abstract double area();
}
```

### Symbol breakdown of `abstract double area();`:
- `abstract` — Keyword meaning "no implementation here — child classes must provide one."
- `double` — Return type.
- `area` — Method name.
- `()` — No parameters.
- `;` — End of statement. **No curly braces** — no body!

## Implementing an Abstract Class

```java
public class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle extends Shape {
    double width, height;

    Rectangle(String color, double width, double height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}
```

```java
// Shape s = new Shape();        // ❌ Can't instantiate abstract class!
Circle c = new Circle("Red", 5);
System.out.println(c.area());    // 78.539...
c.describe();                     // A Red shape
```

## Rules

1. **Cannot create objects** from abstract classes: `new Shape()` is an error.
2. **Can have both** abstract and regular methods.
3. **Child classes MUST implement** all abstract methods, or be abstract themselves.
4. **Can have constructors** — called via `super()` from child classes.
5. **Can have fields** — just like regular classes.

## Abstract vs Regular Class

| Feature | Abstract Class | Regular Class |
|---------|---------------|---------------|
| Can create objects? | No | Yes |
| Can have abstract methods? | Yes | No |
| Can have regular methods? | Yes | Yes |
| Can have fields? | Yes | Yes |

## Quiz

1. Can you create an object from an abstract class?
   - a) Yes
   - b) No ✅

2. Must child classes implement abstract methods?
   - a) Yes ✅
   - b) No

3. Can an abstract class have regular (non-abstract) methods?
   - a) Yes ✅
   - b) No

---
**Next Lesson:** [Lesson 58 — Interfaces](58_Interfaces.md)
