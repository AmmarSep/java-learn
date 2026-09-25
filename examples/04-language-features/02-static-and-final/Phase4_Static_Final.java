// PHASE 4: CORE LANGUAGE FEATURES
// Concept 4.2 & 4.3: Static and Final Keywords

class Counter {
    static int totalCount = 0;  // Shared by all Counter objects
    int instanceCount = 0;      // Each object has its own

    public Counter() {
        totalCount++;           // Increment shared counter
        instanceCount++;
    }

    public static void printTotalCount() {
        System.out.println("Total counters created: " + totalCount);
    }

    public void printInstanceCount() {
        System.out.println("This instance count: " + instanceCount);
    }
}

class Constants {
    // Final constants: can't be changed
    public static final double PI = 3.14159;
    public static final int DAYS_PER_WEEK = 7;
    public static final String COMPANY_NAME = "TechCorp";

    // Final instance variable: can't change after initialization
    private final String id;

    public Constants(String id) {
        this.id = id;
        // id can be assigned once in constructor
    }

    public String getId() {
        return id;
    }
}

class MathHelper {
    // Static method: doesn't need object instance
    public static int add(int a, int b) {
        return a + b;
    }

    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}

class ImmutableExample {
    private final int value;
    private final String name;

    public ImmutableExample(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    // No setters! Object is immutable
}

public class Phase4_Static_Final {
    public static void main(String[] args) {
        System.out.println("=== Static Variables ===\n");

        System.out.println("Initial total count: " + Counter.totalCount);

        Counter c1 = new Counter();
        System.out.println("After creating Counter 1:");
        Counter.printTotalCount();  // Call static method on class

        Counter c2 = new Counter();
        System.out.println("After creating Counter 2:");
        Counter.printTotalCount();

        Counter c3 = new Counter();
        System.out.println("After creating Counter 3:");
        Counter.printTotalCount();

        // All objects share the same totalCount
        System.out.println("\nShared static variable:");
        System.out.println("Counter.totalCount = " + Counter.totalCount);

        System.out.println("\n=== Static vs Instance Variables ===\n");

        c1.printInstanceCount();  // Instance-specific count
        c2.printInstanceCount();
        c3.printInstanceCount();

        System.out.println("\n=== Static Methods ===\n");

        System.out.println("3 + 5 = " + MathHelper.add(3, 5));
        System.out.println("sqrt(16) = " + MathHelper.squareRoot(16));
        System.out.println("max(10, 20) = " + MathHelper.max(10, 20));

        // Static methods called on class, not objects
        // No 'this' available in static methods

        System.out.println("\n=== Final Constants ===\n");

        System.out.println("PI = " + Constants.PI);
        System.out.println("Days per week = " + Constants.DAYS_PER_WEEK);
        System.out.println("Company = " + Constants.COMPANY_NAME);

        // These are immutable: can't change
        // Constants.PI = 3.14;  // ERROR: can't modify final

        System.out.println("\n=== Final Instance Variables ===\n");

        Constants c = new Constants("ID123");
        System.out.println("ID: " + c.getId());

        // c.id = "ID456";  // ERROR: can't modify final instance variable

        System.out.println("\n=== Immutable Objects ===\n");

        ImmutableExample obj1 = new ImmutableExample(100, "Object 1");
        System.out.println("Value: " + obj1.getValue());
        System.out.println("Name: " + obj1.getName());

        // obj1.value = 200;  // ERROR: private and final
        // No way to change the object after creation
        // This is immutability

        System.out.println("\n=== Static Block (Initialization) ===\n");

        System.out.println("Static block executed when class loads");
    }

    // Static block: runs once when class loads
    static {
        System.out.println("[Static Block] Class loaded");
    }
}

/*
Key Concepts:
- Static variables: Shared by all objects of the class
- Static methods: Called on class, not on objects
- final variables: Can't be changed after initialization
- final methods: Can't be overridden (prevents changing behavior)
- final classes: Can't be extended
- Immutable objects: Use final fields, no setters

Execution:
javac Phase4_Static_Final.java
java Phase4_Static_Final
*/
