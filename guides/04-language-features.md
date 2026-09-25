[All guides](README.md) · [Phase examples](../examples/04-language-features/README.md) · [Previous phase](03-object-oriented-programming.md) · [Next phase](05-collections.md)

# PHASE 4: CORE LANGUAGE FEATURES

## Concept 4.1: Interfaces

### Why This Matters
Interfaces define contracts: what methods must exist, without specifying how. They enable powerful design patterns and loose coupling.

### Interface Definition

```java
public interface Animal {
    // Abstract methods (no body)
    void makeSound();
    void eat();

    // Default method (optional, with body)
    default void sleep() {
        System.out.println("Zzz...");
    }
}
```

### Implementing an Interface

```java
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void eat() {
        System.out.println("Eating dog food");
    }
}

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void eat() {
        System.out.println("Eating cat food");
    }
}

Animal dog = new Dog();
Animal cat = new Cat();

dog.makeSound();  // Woof!
cat.makeSound();  // Meow!
```

### Multiple Interfaces

A class can implement multiple interfaces (unlike extending one class):

```java
public interface Drawable {
    void draw();
}

public interface Moveable {
    void move();
}

public class Car implements Drawable, Moveable {
    @Override
    public void draw() {
        System.out.println("Drawing a car");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

Car car = new Car();
car.draw();  // Drawing a car
car.move();  // Car is moving
```

### Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|---------|-----------|-----------------|
| Instantiate | No | No |
| Methods | Abstract only (before Java 8) | Abstract and concrete |
| Variables | static final only | Any access level |
| Inheritance | Multiple interfaces allowed | Single abstract class |
| Use Case | Contract/capability | Parent-child relationship |

**Use interface when:** Defining what a class SHOULD DO
**Use abstract class when:** Defining what a class IS

### Common Mistakes
- Interface methods public by default: Don't need to write `public`
- Forgetting `implements` keyword: Use `implements` not `extends` for interfaces
- Not implementing all methods: All abstract methods must be implemented

---

## Concept 4.2: The final Keyword

### Why This Matters
`final` prevents modification. It can be applied to variables, methods, and classes.

### final Variables

Constant: value can't be changed after initialization:

```java
public class Constants {
    final int MAX_SIZE = 100;  // Can't be changed

    public void example() {
        MAX_SIZE = 200;  // ERROR: can't reassign
    }
}
```

Naming convention: Use UPPERCASE for constants:

```java
public class Constants {
    public static final double PI = 3.14159;
    public static final int DAYS_PER_WEEK = 7;
}
```

### final Methods

Method can't be overridden:

```java
public class Parent {
    public final void importantMethod() {
        System.out.println("This behavior is fixed");
    }
}

public class Child extends Parent {
    @Override
    public void importantMethod() {  // ERROR: can't override final method
        System.out.println("Different behavior");
    }
}
```

### final Classes

Class can't be extended:

```java
public final class Immutable {
    // No class can extend this
}

public class Child extends Immutable {  // ERROR: can't extend final class
    // ...
}
```

Example: String class is final (can't create custom String subclass).

### Real-World Scenarios

```java
// Protect critical class from modification
public final class SecurityKey {
    private final String secret;  // Can't change after creation

    public SecurityKey(String secret) {
        this.secret = secret;
    }
}

// Define unchangeable constant
public static final int MAX_ATTEMPTS = 3;
```

---

## Concept 4.3: The static Keyword

### Why This Matters
`static` means "belongs to the class, not to objects." It's used for shared data and utility methods.

### static Variables

Variable shared by all objects of the class:

```java
public class Car {
    static int totalCars = 0;  // Shared by all Car objects
    String color;              // Each object has its own color

    public Car(String color) {
        this.color = color;
        totalCars++;  // Increment shared counter
    }
}

Car car1 = new Car("Red");
Car car2 = new Car("Blue");

System.out.println(Car.totalCars);  // 2
```

All Car objects share one `totalCars` variable.

### static Methods

Method called on the class, not on objects:

```java
public class Math {
    public static int add(int a, int b) {
        return a + b;
    }
}

// Called on class, not object
int result = Math.add(5, 3);  // 8

// Can't do this:
Math math = new Math();
math.add(5, 3);  // Possible but bad practice
```

### When to Use static

**static variables:**
- Counters: total number of objects created
- Constants: values shared by all objects
- Configuration: global settings

**static methods:**
- Utility functions: don't need object state (Math.sqrt, Math.max)
- Factory methods: create objects

### Common Mistakes
- Using this in static method: `static void method() { this.x = 5; }` → ERROR
- Accessing instance variable in static method: static has no `this`
- Making everything static: Defeats purpose of objects

---

## Concept 4.4: Access Modifiers and Packages

### Why This Matters
Access modifiers control visibility. They're essential for encapsulation and API design.

### Four Access Levels

| Modifier | Same Class | Same Package | Child Class | Everywhere |
|----------|-----------|-------------|-----------|-----------|
| `public` | ✓ | ✓ | ✓ | ✓ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| (default/package) | ✓ | ✓ | ✗ | ✗ |
| `private` | ✓ | ✗ | ✗ | ✗ |

### Examples

```java
public class Person {
    public String name;          // Accessible everywhere
    protected int age;           // Accessible in package and subclasses
    String phoneNumber;          // Accessible in package only (default)
    private String password;     // Accessible only in this class
}
```

### public

Most visible, use for API:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

### private

Least visible, use for implementation:

```java
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;  // Only this class can access balance
    }
}
```

### Packages

Organize classes into namespaces:

```java
// File: com/example/game/Player.java
package com.example.game;

public class Player {
    // ...
}

// File: com/example/game/Main.java
package com.example.game;

public class Main {
    Player p = new Player();  // Same package, no import needed
}
```

### Import Statements

```java
// Import one class
import java.util.ArrayList;

// Import all classes from package
import java.util.*;

public class Example {
    ArrayList<String> list = new ArrayList<>();
}
```

### Common Mistakes
- Default (no modifier) not truly private: `private` is different from default
- Making everything public: Reduces encapsulation
- Not using packages: All classes in default package is bad practice

---

## Concept 4.5: equals() and hashCode()

### Why This Matters
Default equality checks reference, not content. Overriding equals() and hashCode() enables proper object comparison.

### The Problem: Default equals()

```java
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Person p1 = new Person("Alice", 25);
Person p2 = new Person("Alice", 25);

System.out.println(p1 == p2);           // false (different objects)
System.out.println(p1.equals(p2));      // false (default equals checks reference)
```

Two people with same name and age are not equal (by default).

### Overriding equals()

```java
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if same object
        if (this == obj) return true;

        // Check if null or different class
        if (obj == null || getClass() != obj.getClass()) return false;

        // Cast and compare fields
        Person person = (Person) obj;
        return name.equals(person.name) && age == person.age;
    }
}

Person p1 = new Person("Alice", 25);
Person p2 = new Person("Alice", 25);

System.out.println(p1.equals(p2));  // true (content matches)
```

### hashCode()

When equals() is overridden, hashCode() should be too:

```java
@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

hashCode() is used in HashMaps and HashSets for efficient lookup.

### Contract

If two objects are equal:
- `equals()` returns true
- `hashCode()` returns same value

If `equals()` is true, `hashCode()` MUST be same.

### Common Mistakes
- Overriding equals() without hashCode(): Breaks HashMaps/HashSets
- Using `==` instead of `.equals()`: Checks reference, not content
- Forgetting to cast in equals(): `Person person = (Person) obj;`

---

