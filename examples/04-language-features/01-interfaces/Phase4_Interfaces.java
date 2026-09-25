// PHASE 4: CORE LANGUAGE FEATURES
// Concept 4.1: Interfaces

// ===== INTERFACE DEFINITION =====
interface Animal {
    // Abstract methods (no body)
    void makeSound();

    void eat();

    // Default method (Java 8+, optional)
    default void sleep() {
        System.out.println("Zzz... sleeping");
    }
}

// ===== INTERFACE FOR DRAWABLE OBJECTS =====
interface Drawable {
    void draw();

    void erase();
}

// ===== CONCRETE CLASS IMPLEMENTING INTERFACE =====
class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof!");
    }

    @Override
    public void eat() {
        System.out.println(name + " eats dog food");
    }

    // Can also override default methods
    @Override
    public void sleep() {
        System.out.println(name + " is taking a nap");
    }
}

// ===== ANOTHER IMPLEMENTATION =====
class Bird implements Animal {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet!");
    }

    @Override
    public void eat() {
        System.out.println(name + " eats seeds");
    }
}

// ===== CLASS IMPLEMENTING MULTIPLE INTERFACES =====
class Car implements Drawable {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + brand + " car");
    }

    @Override
    public void erase() {
        System.out.println("Erasing " + brand + " car drawing");
    }
}

// ===== INTERFACE EXTENDING INTERFACE =====
interface Mammal extends Animal {
    void nurse();
}

class Cat implements Mammal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow!");
    }

    @Override
    public void eat() {
        System.out.println(name + " eats cat food");
    }

    @Override
    public void nurse() {
        System.out.println(name + " can nurse kittens");
    }
}

public class Phase4_Interfaces {
    public static void main(String[] args) {
        System.out.println("=== Implementing Interfaces ===\n");

        // Create objects implementing the interface
        Animal dog = new Dog("Buddy");
        Animal bird = new Bird("Tweety");

        dog.makeSound();
        dog.eat();
        dog.sleep();

        System.out.println();

        bird.makeSound();
        bird.eat();
        bird.sleep();  // Uses default implementation

        System.out.println("\n=== Polymorphism with Interfaces ===\n");

        // Array of interface references
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Rex");
        animals[1] = new Bird("Chirpy");
        animals[2] = new Cat("Whiskers");

        System.out.println("Making sounds:");
        for (Animal animal : animals) {
            animal.makeSound();  // Different behavior for each
        }

        System.out.println("\nEating:");
        for (Animal animal : animals) {
            animal.eat();
        }

        System.out.println("\n=== Multiple Interfaces ===\n");

        Car car = new Car("Tesla");
        car.draw();
        car.erase();

        System.out.println("\n=== Interface Extending Interface ===\n");

        Mammal cat = new Cat("Mittens");
        cat.makeSound();
        cat.eat();
        cat.nurse();

        System.out.println("\n=== Interface vs Abstract Class ===\n");

        System.out.println("Interface Animal defines contract:");
        System.out.println("- makeSound(): implement this");
        System.out.println("- eat(): implement this");
        System.out.println("- sleep(): default implementation provided");

        System.out.println("\nBenefits of interfaces:");
        System.out.println("- Define behavior contract");
        System.out.println("- Enable polymorphism");
        System.out.println("- Allow multiple implementation");
        System.out.println("- Loose coupling between classes");
    }
}

/*
Key Concepts:
- Interface: Contract that classes must follow
- implements: A class implements an interface
- abstract methods: No body, must be implemented
- default methods: Have body, optional to override
- Multiple interfaces: Class can implement multiple
- instanceof: Check if object implements interface

Execution:
javac Phase4_Interfaces.java
java Phase4_Interfaces
*/
