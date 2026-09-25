// PHASE 3: OBJECT-ORIENTED PROGRAMMING
// Concept 3.5 & 3.6: Inheritance and Polymorphism

// ===== PARENT CLASS =====
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
}

// ===== CHILD CLASS 1 =====
class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);  // Call parent constructor
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof!");
    }

    public void fetch() {
        System.out.println(name + " is fetching a ball");
    }
}

// ===== CHILD CLASS 2 =====
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow!");
    }

    public void scratch() {
        System.out.println(name + " is scratching the furniture");
    }
}

// ===== CHILD CLASS 3 =====
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet tweet!");
    }

    public void fly() {
        System.out.println(name + " is flying");
    }
}

public class Phase3_Inheritance_Polymorphism {
    public static void main(String[] args) {
        System.out.println("=== Inheritance: Child Classes Inherit from Parent ===\n");

        Dog dog = new Dog("Buddy", "Labrador");
        dog.eat();      // Inherited from Animal
        dog.sleep();    // Inherited from Animal
        dog.fetch();    // Specific to Dog

        System.out.println("\n=== Method Overriding ===\n");

        System.out.println("Parent class method:");
        Animal genericAnimal = new Animal("Generic");
        genericAnimal.makeSound();

        System.out.println("\nChild class overrides method:");
        dog.makeSound();  // Dog's version

        Cat cat = new Cat("Whiskers");
        cat.makeSound();  // Cat's version

        System.out.println("\n=== Polymorphism: One Method Call, Different Behaviors ===\n");

        // Create array of Animal references
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Rex", "Bulldog");
        animals[1] = new Cat("Mittens");
        animals[2] = new Bird("Tweety");

        System.out.println("Calling makeSound() on each animal:");
        for (Animal animal : animals) {
            animal.makeSound();  // Different behavior depending on actual object type
        }

        System.out.println("\nCalling eat() on each animal:");
        for (Animal animal : animals) {
            animal.eat();  // Same inherited method
        }

        System.out.println("\n=== Polymorphic References ===\n");

        // Upcasting: assign child to parent reference (automatic)
        Animal myDog = new Dog("Fido", "Golden Retriever");
        myDog.makeSound();  // Calls Dog's version
        myDog.eat();        // Calls Animal's version

        // Can't call Dog-specific methods through Animal reference
        // myDog.fetch();  // ERROR: fetch() not in Animal class

        System.out.println("\n=== Downcasting (Be Careful!) ===\n");

        if (myDog instanceof Dog) {
            Dog actualDog = (Dog) myDog;  // Cast to Dog
            actualDog.fetch();  // Now can call fetch()
        }

        System.out.println("\n=== Inheritance Hierarchy ===\n");

        Animal dog2 = new Dog("Buddy", "Labrador");  // Parent reference allows sibling-type checks
        System.out.println("Is dog2 an Animal? " + (dog2 instanceof Animal));  // true
        System.out.println("Is dog2 a Dog? " + (dog2 instanceof Dog));          // true
        System.out.println("Is dog2 a Cat? " + (dog2 instanceof Cat));          // false

        System.out.println("\n=== Calling Parent Method with super ===\n");

        // In Dog class, makeSound() uses super to access parent
        // (This is already implemented in Dog class)
        Dog dog3 = new Dog("Max", "Poodle");
        dog3.eat();    // Parent's eat()
        dog3.makeSound();  // Dog's makeSound()

        System.out.println("\n=== Polymorphic Method ===\n");

        makeSomethingSound(new Dog("Sound Dog", "Terrier"));
        makeSomethingSound(new Cat("Sound Cat"));
        makeSomethingSound(new Bird("Sound Bird"));
        makeSomethingSound(new Animal("Generic Sound"));
    }

    // Polymorphic method: accepts any Animal, calls appropriate makeSound()
    public static void makeSomethingSound(Animal animal) {
        animal.makeSound();  // Which method runs depends on actual object type
    }
}

/*
Key Concepts:
- Inheritance: Child extends Parent, inherits all parent methods/variables
- super: Call parent constructor or parent method
- @Override: Annotation marking intentional method override
- Polymorphism: One method call, many behaviors
- Upcasting: Assign child to parent reference (automatic)
- Downcasting: Cast parent to child (use instanceof first)
- instanceof: Check if object is instance of a class

Execution:
javac Phase3_Inheritance_Polymorphism.java
java Phase3_Inheritance_Polymorphism
*/
