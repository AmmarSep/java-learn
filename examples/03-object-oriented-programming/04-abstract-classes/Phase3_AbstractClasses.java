// PHASE 3: OBJECT-ORIENTED PROGRAMMING
// Concept 3.7: Abstract Classes

// ===== ABSTRACT CLASS =====
abstract class Shape {
    // Concrete variable
    protected String color;

    // Constructor
    public Shape(String color) {
        this.color = color;
    }

    // Abstract method: must be implemented by subclasses
    abstract double calculateArea();

    abstract double calculatePerimeter();

    // Concrete method: already implemented
    public void printColor() {
        System.out.println("Color: " + color);
    }

    public void describe() {
        System.out.println("This is a " + this.getClass().getSimpleName());
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

// ===== CONCRETE SUBCLASS 1 =====
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}

// ===== CONCRETE SUBCLASS 2 =====
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}

// ===== CONCRETE SUBCLASS 3 =====
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double calculateArea() {
        // Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

// ===== ANOTHER ABSTRACT CLASS (More Abstract) =====
abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();

    abstract void move();

    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// ===== PARTIALLY ABSTRACT SUBCLASS =====
abstract class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    // Still abstract
    @Override
    abstract void makeSound();

    // Concrete implementation
    @Override
    public void move() {
        System.out.println(name + " is walking");
    }

    abstract void nurse();
}

// ===== FULLY CONCRETE SUBCLASS =====
class Dog extends Mammal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof!");
    }

    @Override
    public void nurse() {
        System.out.println(name + " can nurse puppies");
    }

    public void fetch() {
        System.out.println(name + " is fetching");
    }
}

public class Phase3_AbstractClasses {
    public static void main(String[] args) {
        System.out.println("=== Abstract Classes Overview ===\n");

        // Can't instantiate abstract class
        // Shape shape = new Shape("red");  // ERROR

        // But can instantiate concrete subclasses
        Shape circle = new Circle("red", 5);
        Shape rectangle = new Rectangle("blue", 10, 5);
        Shape triangle = new Triangle("green", 3, 4, 5);

        System.out.println("=== Circle ===");
        circle.describe();

        System.out.println("\n=== Rectangle ===");
        rectangle.describe();

        System.out.println("\n=== Triangle ===");
        triangle.describe();

        System.out.println("\n=== Polymorphism with Abstract Classes ===\n");

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("red", 5);
        shapes[1] = new Rectangle("blue", 10, 5);
        shapes[2] = new Triangle("green", 3, 4, 5);

        double totalArea = 0;
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
            totalArea += shape.calculateArea();
        }
        System.out.println("Total area: " + totalArea);

        System.out.println("\n=== Inheritance Hierarchy ===\n");

        // Abstract class hierarchy
        Animal dog = new Dog("Buddy");
        dog.makeSound();
        dog.move();
        dog.sleep();

        // Can't call Dog-specific method through Animal reference
        // dog.fetch();  // ERROR

        // Must cast to access Dog methods
        if (dog instanceof Dog) {
            Dog actualDog = (Dog) dog;
            actualDog.fetch();
        }

        System.out.println("\n=== Abstract Class vs Interface ===\n");

        System.out.println("Abstract Class Shape:");
        System.out.println("- Can have concrete methods (printColor)");
        System.out.println("- Can have instance variables (color)");
        System.out.println("- Can have constructors");
        System.out.println("- Single inheritance only");

        System.out.println("\nBoth have:");
        System.out.println("- Abstract methods (must implement)");
        System.out.println("- Enable polymorphism");
        System.out.println("- Can't instantiate");
        System.out.println("- Force subclasses to follow contract");

        System.out.println("\n=== Abstract Class Benefits ===");
        System.out.println("1. Define common interface for subclasses");
        System.out.println("2. Force subclasses to implement abstract methods");
        System.out.println("3. Share common code in parent");
        System.out.println("4. Model IS-A relationships");
        System.out.println("5. Provide partial implementation");
    }
}

/*
Key Concepts:
- Abstract class: Can't instantiate, can have concrete and abstract methods
- abstract methods: No body, subclasses must implement
- abstract keyword: Marks class or method as abstract
- Subclasses must implement all abstract methods
- Can have constructors, instance variables, concrete methods
- Single inheritance: extends only one abstract class

Execution:
javac Phase3_AbstractClasses.java
java Phase3_AbstractClasses
*/
