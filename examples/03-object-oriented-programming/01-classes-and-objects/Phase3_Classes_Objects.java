// PHASE 3: OBJECT-ORIENTED PROGRAMMING
// Concept 3.1 & 3.2: Classes, Objects, and Constructors

// ===== SIMPLE CLASS =====
class Dog {
    // Variables (instance variables)
    String name;
    int age;
    String breed;

    // Constructor: initializes object
    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    // Method
    public void bark() {
        System.out.println(name + " says: Woof!");
    }

    public void getInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Breed: " + breed);
    }
}

// ===== CLASS WITH OVERLOADED CONSTRUCTORS =====
class Person {
    String name;
    int age;
    String email;

    // Constructor 1: all parameters
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Constructor 2: name and age only
    public Person(String name, int age) {
        this(name, age, "unknown@email.com");  // Call constructor 1
    }

    // Constructor 3: name only
    public Person(String name) {
        this(name, 0, "unknown@email.com");  // Call constructor 2
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email);
    }
}

// ===== CLASS WITH THIS KEYWORD =====
class Car {
    String brand;
    String model;
    int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;      // this.brand refers to instance variable
        this.model = model;      // model refers to parameter
        this.year = year;
    }

    public void describe() {
        System.out.println(this.year + " " + this.brand + " " + this.model);
    }

    public Car setYear(int year) {
        this.year = year;
        return this;  // Return the object itself for chaining
    }
}

public class Phase3_Classes_Objects {
    public static void main(String[] args) {
        System.out.println("=== Creating and Using Objects ===\n");

        // Create objects using the constructor
        Dog dog1 = new Dog("Buddy", 3, "Labrador");
        Dog dog2 = new Dog("Max", 5, "Golden Retriever");

        dog1.getInfo();
        dog1.bark();

        dog2.getInfo();
        dog2.bark();

        System.out.println("\n=== Constructor Overloading ===\n");

        Person p1 = new Person("Alice", 25, "alice@email.com");
        Person p2 = new Person("Bob", 30);
        Person p3 = new Person("Charlie");

        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();

        System.out.println("\n=== Using 'this' Keyword ===\n");

        Car car1 = new Car("Toyota", "Camry", 2020);
        car1.describe();

        System.out.println("\n=== Method Chaining with 'return this' ===\n");

        Car car2 = new Car("Honda", "Accord", 2019);
        car2.setYear(2023).describe();  // Chain method calls

        System.out.println("\n=== Object Independence ===\n");

        Dog dog3 = new Dog("Buddy", 3, "Labrador");
        Dog dog4 = new Dog("Buddy", 3, "Labrador");

        // Both dogs have same data but are different objects
        System.out.println("dog3 and dog4 have same name: " + dog3.name.equals(dog4.name));
        System.out.println("dog3 and dog4 are same object: " + (dog3 == dog4));  // false
        System.out.println("dog3 == dog1: " + (dog3 == dog1));  // false (different objects)

        System.out.println("\n=== Accessing Object Members ===\n");

        Dog myDog = new Dog("Rover", 4, "Beagle");
        System.out.println("Accessing direct members:");
        System.out.println("  myDog.name = " + myDog.name);
        System.out.println("  myDog.age = " + myDog.age);
        System.out.println("Calling methods:");
        myDog.getInfo();
        myDog.bark();

        System.out.println("\n=== Modifying Object State ===\n");

        Dog dog5 = new Dog("Old Dog", 10, "Poodle");
        System.out.println("Before modification:");
        dog5.getInfo();

        dog5.age = 11;  // Change the age
        dog5.name = "Old Dog (Senior)";

        System.out.println("After modification:");
        dog5.getInfo();
    }
}

/*
Key Concepts:
- Class: Blueprint for objects
- Object: Instance of a class, created with 'new'
- Constructor: Special method that initializes objects
- this: Reference to current object
- Instance variables: Data stored in each object
- Methods: Functions that belong to objects

Compilation and Execution:
javac Phase3_Classes_Objects.java
java Phase3_Classes_Objects
*/
