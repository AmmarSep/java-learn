[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](37_This.md) · [Next](39_Static.md)

**Runnable companion:** [Phase3_Encapsulation](../../examples/03-object-oriented-programming/02-encapsulation/Phase3_Encapsulation.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 38: Access Modifiers — `public`, `private`, `protected`

## Simple Explanation

**Access modifiers** control **who can see and use** your code. They're like security levels — some things are open to everyone, some are private.

## The Four Access Levels

| Modifier | Who Can Access? |
|----------|----------------|
| `public` | **Everyone** — any class, anywhere |
| `private` | **Only the same class** — no one else |
| `protected` | **Same class + same package + subclasses** |
| *(no modifier)* | **Same package only** (called "package-private" or "default") |

## `public` — Open to Everyone

```java
public class Dog {
    public String name;

    public void bark() {
        System.out.println(name + " says: Woof!");
    }
}

// Any class can do this:
Dog d = new Dog();
d.name = "Buddy";    // ✅ OK — name is public
d.bark();             // ✅ OK — bark is public
```

## `private` — Only Inside the Same Class

```java
public class BankAccount {
    private double balance;    // Only this class can access balance

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;    // ✅ OK — same class
        }
    }

    public double getBalance() {
        return balance;           // ✅ OK — same class
    }
}

// In Main.java:
BankAccount acc = new BankAccount();
acc.deposit(100);
// acc.balance = 1000000;    // ❌ ERROR — balance is private!
System.out.println(acc.getBalance());    // ✅ OK — using public method
```

### Why use `private`?

**Protection!** You control how the data is accessed and changed. The `deposit` method checks that the amount is positive. If `balance` were public, anyone could set it to anything.

## The Common Pattern: Private Fields + Public Methods

```java
public class Person {
    private String name;    // Private field
    private int age;        // Private field

    // Public constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public getter
    public String getName() {
        return name;
    }

    // Public setter with validation
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }
}
```

This pattern is called **encapsulation** — hide the data, control access through methods.

## `protected` — Same Package + Subclasses

```java
public class Animal {
    protected String species;    // Accessible by subclasses and same package
}
```

We'll see `protected` more when we learn about inheritance. For now, just know it exists.

## Default (No Modifier) — Package-Private

If you don't write any modifier, it's accessible within the same **package** (folder):

```java
class Helper {           // No "public" — package-private class
    String message;      // No modifier — package-private field

    void doStuff() {     // No modifier — package-private method
        System.out.println(message);
    }
}
```

## Summary Table

```
                  Same Class | Same Package | Subclass | Everywhere
public               ✅           ✅           ✅          ✅
protected            ✅           ✅           ✅          ❌
(default)            ✅           ✅           ❌          ❌
private              ✅           ❌           ❌          ❌
```

## Common Beginner Mistakes

1. **Making everything public** — Only make things public if they need to be. Use `private` for fields.
2. **Making everything private** — Constructors and key methods should usually be `public`.
3. **Forgetting that `private` means only THIS class** — Not even subclasses can access private members.
4. **Confusing no modifier with `public`** — No modifier = package-private, NOT public.

## Mini Practice Exercise

**Task:** Fix this class to follow good practices (private fields, public methods):

```java
public class Student {
    String name;
    int grade;
}
```

**Answer:**
```java
public class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public int getGrade() { return grade; }
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        }
    }
}
```

## Quiz

1. Which modifier makes something accessible to everyone?
   - a) `private`
   - b) `public` ✅
   - c) `protected`

2. Which modifier is best for fields?
   - a) `public`
   - b) `private` ✅
   - c) No modifier

3. What is the common pattern for class design?
   - a) Public fields, private methods
   - b) Private fields, public methods (getters/setters) ✅
   - c) Everything public

---
**Next Lesson:** [Lesson 39 — `static`](39_Static.md)
