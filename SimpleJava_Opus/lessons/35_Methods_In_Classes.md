# Lesson 35: Methods Inside Classes

## Simple Explanation

Methods inside a class define the **actions** or **behaviors** that objects of that class can perform. They can access and use the object's fields.

## Instance Methods (Non-Static)

When methods are defined without `static`, they are **instance methods** — they belong to each object and can access that object's fields directly.

```java
public class Dog {
    String name;
    int age;

    void bark() {
        System.out.println(name + " says: Woof!");
    }

    void celebrateBirthday() {
        age++;
        System.out.println(name + " is now " + age + " years old!");
    }

    String getDescription() {
        return name + ", age " + age;
    }
}
```

### Key differences from static methods we wrote before:

| Static methods (in Main) | Instance methods (in a class) |
|--------------------------|-------------------------------|
| `public static void doStuff()` | `void doStuff()` |
| Called with class name or directly | Called on an object: `myDog.bark()` |
| Cannot access instance fields | CAN access instance fields directly |

### Using these methods:

```java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.name = "Rex";
        d.age = 2;

        d.bark();                // Rex says: Woof!
        d.celebrateBirthday();   // Rex is now 3 years old!

        String desc = d.getDescription();
        System.out.println(desc);    // Rex, age 3
    }
}
```

### Symbol breakdown of `d.bark();`:
- `d` — The Dog object.
- `.` — Access something inside this object.
- `bark` — The method name.
- `()` — Call the method with no arguments.
- `;` — End of statement.

## Methods That Use Fields

Instance methods can read and modify the object's fields without any special syntax:

```java
public class BankAccount {
    String owner;
    double balance;

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". Balance: $" + balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough money!");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Balance: $" + balance);
        }
    }

    void showBalance() {
        System.out.println(owner + "'s balance: $" + balance);
    }
}
```

```java
BankAccount acc = new BankAccount();
acc.owner = "Alex";
acc.balance = 100.0;
acc.deposit(50.0);     // Deposited $50.0. Balance: $150.0
acc.withdraw(30.0);    // Withdrew $30.0. Balance: $120.0
acc.showBalance();     // Alex's balance: $120.0
```

## Getter and Setter Methods

A common pattern is to use methods to **get** and **set** field values:

```java
public class Person {
    private String name;
    private int age;

    // Getter — returns the field value
    String getName() {
        return name;
    }

    // Setter — sets the field value
    void setName(String newName) {
        name = newName;
    }

    int getAge() {
        return age;
    }

    void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        }
    }
}
```

Why use getters/setters? **Control**. The `setAge` method can reject negative ages. Direct access (`person.age = -5`) can't be validated. We'll explore this more with access modifiers.

## Common Beginner Mistakes

1. **Adding `static` to instance methods** — Don't use `static` on methods that need to access instance fields.
2. **Forgetting to call methods on an object** — `bark();` won't work in `main`. Use `myDog.bark();`.
3. **Trying to access fields from a static context** — `main` is static. You can't directly use instance fields from `main` — you need an object.

## Mini Practice Exercise

**Task:** Add a method `applyDiscount(double percent)` to a `Product` class that reduces the price.

**Answer:**
```java
public class Product {
    String name;
    double price;

    void applyDiscount(double percent) {
        price -= price * percent / 100;
        System.out.println(name + " new price: $" + price);
    }
}
```

## Quiz

1. Can instance methods access the object's fields?
   - a) No
   - b) Yes, directly ✅

2. How do you call an instance method?
   - a) `methodName();`
   - b) `objectName.methodName();` ✅
   - c) `ClassName.methodName();`

3. Should instance methods use `static`?
   - a) Yes, always
   - b) No, not usually ✅

---
**Next Lesson:** [Lesson 36 — Constructors](36_Constructors.md)
