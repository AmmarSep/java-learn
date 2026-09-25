[All guides](README.md) · [Phase examples](../examples/03-object-oriented-programming/README.md) · [Previous phase](02-methods-and-memory.md) · [Next phase](04-language-features.md)

# PHASE 3: OBJECT-ORIENTED PROGRAMMING

## Concept 3.1: Classes and Objects

### Why This Matters
Classes let you create custom data types that bundle data (variables) with behavior (methods). Objects are instances of classes.

### Classes vs Objects

**Class:** A blueprint or template
```java
public class Car {
    // Template: what every car should have
}
```

**Object:** An actual instance based on the blueprint
```java
Car myCar = new Car();  // Create an object from the blueprint
```

Analogy: Class is a recipe, object is a cake made from that recipe.

### Simple Class Example

```java
public class Dog {
    // Variables (data)
    String name;
    int age;

    // Method (behavior)
    public void bark() {
        System.out.println(name + " says woof!");
    }
}
```

### Creating Objects

```java
public class Main {
    public static void main(String[] args) {
        // Create object 1
        Dog dog1 = new Dog();
        dog1.name = "Buddy";
        dog1.age = 3;
        dog1.bark();  // Buddy says woof!

        // Create object 2
        Dog dog2 = new Dog();
        dog2.name = "Max";
        dog2.age = 5;
        dog2.bark();  // Max says woof!
    }
}
```

Breaking down `new Dog()`:
- `new` = Create a new object
- `Dog()` = Call constructor (we'll explain next)
- `=` Store the reference in dog1

### Object Memory

Each object is independent:
```
dog1 (Stack) ─────→ Object in Heap
                   name = "Buddy"
                   age = 3

dog2 (Stack) ─────→ Object in Heap
                   name = "Max"
                   age = 5
```

Changing dog1's data doesn't affect dog2.

---

## Concept 3.2: Constructors

### Why This Matters
Constructors initialize objects. Instead of creating an object then manually setting values, a constructor does it all at once.

### Default Constructor

If you don't write a constructor, Java provides a default (empty) one:

```java
public class Dog {
    String name;
    int age;

    // Java automatically provides:
    // public Dog() { }
}

Dog dog = new Dog();  // Works, but name and age are uninitialized
```

### Custom Constructor

Write your own to initialize values:

```java
public class Dog {
    String name;
    int age;

    // Constructor: same name as class, no return type
    public Dog(String n, int a) {
        name = n;
        age = a;
    }
}

Dog dog = new Dog("Buddy", 3);  // Initialize while creating
System.out.println(dog.name);   // Buddy
```

### Constructor Overloading

Multiple constructors with different parameters:

```java
public class Dog {
    String name;
    int age;

    // Constructor 1: takes name and age
    public Dog(String n, int a) {
        name = n;
        age = a;
    }

    // Constructor 2: takes only name
    public Dog(String n) {
        name = n;
        age = 0;
    }

    // Constructor 3: no parameters
    public Dog() {
        name = "Unknown";
        age = 0;
    }
}

Dog dog1 = new Dog("Buddy", 3);
Dog dog2 = new Dog("Max");
Dog dog3 = new Dog();
```

### Constructor Chaining (Advanced)

```java
public class Dog {
    String name;
    int age;
    String breed;

    // Constructor 1: all parameters
    public Dog(String n, int a, String b) {
        name = n;
        age = a;
        breed = b;
    }

    // Constructor 2: use this() to call another constructor
    public Dog(String n, int a) {
        this(n, a, "Unknown");  // Call constructor 1
    }

    // Constructor 3: minimal
    public Dog(String n) {
        this(n, 0);  // Call constructor 2
    }
}
```

`this(...)` calls another constructor in the same class.

### Common Mistakes
- Constructor with return type: `public void Dog() { }` → NO return type
- Wrong constructor name: `public dog() { }` → Must match class name exactly
- Constructor not returning value: Constructors don't return (not even void)

---

## Concept 3.3: The this Keyword

### Why This Matters
`this` refers to the current object. It's useful when parameter names match variable names and for accessing object members.

### Using this to Avoid Confusion

```java
public class Dog {
    String name;
    int age;

    // Without this: confusing which 'name' is which
    public Dog(String name, int age) {
        this.name = name;  // this.name = the object's name variable
                          // name = the parameter
        this.age = age;
    }
}
```

Inside the constructor:
- `name` (parameter) = the value passed in
- `this.name` (instance variable) = the object's data
- `this.age` (instance variable) = the object's age

### Calling Methods with this

```java
public class Dog {
    String name;

    public void greet() {
        this.bark();  // Call another method on this object
    }

    public void bark() {
        System.out.println(name + " says woof!");
    }
}
```

### Returning this

Methods can return `this` to enable chaining:

```java
public class Dog {
    String name;
    int age;

    public Dog setName(String name) {
        this.name = name;
        return this;  // Return the object itself
    }

    public Dog setAge(int age) {
        this.age = age;
        return this;
    }
}

// Chaining: set multiple values in one statement
Dog dog = new Dog()
    .setName("Buddy")
    .setAge(3);
```

### this() for Constructor Chaining

Already covered in 3.2, but important:

```java
public class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        this(name, 0);  // Call another constructor
    }
}
```

---

## Concept 3.4: Encapsulation

### Why This Matters
Encapsulation protects an object's data by restricting direct access. Users interact through controlled methods, not raw variables.

### The Problem Without Encapsulation

```java
public class BankAccount {
    public int balance;  // Anyone can access directly
}

BankAccount account = new BankAccount();
account.balance = 1000000;  // Oops! Set balance directly
account.balance = -999999;  // Oops! Can't prevent invalid values
```

Without protection, anyone can corrupt the object's state.

### Solution: Private Variables, Public Methods

```java
public class BankAccount {
    private int balance;  // Hidden from outside

    // Constructor
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Controlled access: get the balance
    public int getBalance() {
        return balance;
    }

    // Controlled access: deposit safely
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Controlled access: withdraw safely
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.balance = -999;  // ERROR: balance is private
        account.deposit(500);     // OK: proper method
        account.withdraw(200);    // OK: proper method

        System.out.println(account.getBalance());  // 1300
    }
}
```

**Access Modifiers:**
- `public` = Anyone can access
- `private` = Only inside this class

### Getters and Setters

Standard pattern for controlled access:

```java
public class Person {
    private int age;

    // Getter: read the value
    public int getAge() {
        return age;
    }

    // Setter: write the value (with validation)
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }
}

Person p = new Person();
p.setAge(25);           // OK
p.setAge(-5);          // Rejected by validation
System.out.println(p.getAge());  // 25
```

### Benefits of Encapsulation

1. **Validation:** Control what values are acceptable
2. **Consistency:** Ensure object is always in valid state
3. **Flexibility:** Change implementation without breaking client code
4. **Abstraction:** Users don't need to know implementation details

### Common Mistakes
- Making variables public by default: `String name;` should be `private String name;`
- Setters with no validation: Allows invalid states
- Confusing getter names: Use `getName()` not `name()`

---

## Concept 3.5: Inheritance

### Why This Matters
Inheritance lets you create a hierarchy of classes. Child classes inherit data and methods from parent classes, reducing code duplication.

### Parent and Child Classes

```java
// Parent class (superclass)
public class Animal {
    String name;

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class (subclass)
public class Dog extends Animal {
    public void bark() {
        System.out.println(name + " is barking");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";

        dog.eat();    // Inherited from Animal
        dog.sleep();  // Inherited from Animal
        dog.bark();   // Defined in Dog
    }
}
```

Dog "extends" Animal, inheriting `eat()` and `sleep()` methods.

### Is-a Relationship

Inheritance models "is-a" relationships:
- Dog IS-A Animal
- Car IS-A Vehicle
- Student IS-A Person

Not:
- Car HAS-A Engine (use composition instead)

### Calling Parent Constructor

```java
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}

public class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);  // Call parent constructor
        this.breed = breed;
    }
}

Dog dog = new Dog("Buddy", "Labrador");
System.out.println(dog.name);   // Buddy (from parent)
System.out.println(dog.breed);  // Labrador (from child)
```

`super(name)` calls the parent class constructor.

### Inheritance Hierarchy

```
        Animal
         /  |  \
       Dog  Cat  Bird
      / |
    Pug Bulldog
```

All inherit from Animal. Dogs further specialize into Pug and Bulldog.

### Common Mistakes
- Circular inheritance: Class A extends B, B extends A → Compilation error
- Forgetting super(): Parent constructor not called
- Deep inheritance: Too many levels makes code hard to follow

---

## Concept 3.6: Polymorphism and Method Overriding

### Why This Matters
Polymorphism (many forms) means one method call can behave differently depending on the object type. This is powerful abstraction.

### Method Overriding

Child class provides its own version of a parent method:

```java
public class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

public class Dog extends Animal {
    @Override  // Annotation: tells Java this intentionally overrides parent
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound();  // Woof!
        cat.makeSound();  // Meow!
    }
}
```

Same method name, different behavior depending on actual object type.

### Polymorphic References

```java
Animal[] animals = new Animal[3];
animals[0] = new Dog();
animals[1] = new Cat();
animals[2] = new Animal();

for (Animal animal : animals) {
    animal.makeSound();
}

// Output:
// Woof!
// Meow!
// Some generic sound
```

The loop doesn't know what type each animal is, but the correct method runs anyway. This is polymorphism's power.

### Overriding vs Overloading

**Overriding** (same signature, child class):
```java
// Parent
public void makeSound() { ... }

// Child
public void makeSound() { ... }  // Override
```

**Overloading** (different signature, same class):
```java
public void eat() { ... }
public void eat(String food) { ... }  // Overload
```

### @Override Annotation

Good practice to mark overridden methods:

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```

If you misspell the method name, Java catches the error:
```java
@Override
public void makeSount() { }  // ERROR: method doesn't override anything
```

### Common Mistakes
- Forgetting to override but thinking you did: Method signature is different
- Changing return type: Can only change to subtype (covariant)
- Making overridden method more restrictive: Can't change public to private

---

## Concept 3.7: Abstract Classes

### Why This Matters
Abstract classes are templates that force child classes to implement certain methods. They can't be instantiated directly.

### Abstract Class Definition

```java
public abstract class Animal {
    String name;

    // Abstract method: no body, must be implemented by child
    public abstract void makeSound();

    // Regular method: already implemented
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Can't do this:
Animal animal = new Animal();  // ERROR: can't instantiate abstract class
```

### Implementing Abstract Methods

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Now OK:
Animal dog = new Dog();
Animal cat = new Cat();

dog.makeSound();  // Woof!
cat.makeSound();  // Meow!
```

### Abstract Class Benefits

1. **Contract:** Forces all child classes to implement certain methods
2. **Code reuse:** Common code in parent, special in child
3. **Polymorphism:** Treat different types uniformly

### Abstract Class vs Concrete Class

**Abstract:** Can't instantiate, must extend
```java
public abstract class Shape { }
```

**Concrete:** Can instantiate
```java
public class Circle extends Shape { }
Circle c = new Circle();  // OK
```

### Common Mistakes
- Forgetting to implement abstract methods in child class
- Making abstract method have implementation (defeats purpose)
- Trying to instantiate abstract class

---

