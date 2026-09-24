// PHASE 2: METHODS & MEMORY
// Concept 2.1: Methods - Declaration and Calling

public class Phase2_Methods {
    // ===== SIMPLE METHOD =====
    public static void greet() {
        System.out.println("Hello, World!");
    }

    // ===== METHOD WITH PARAMETERS =====
    public static void greetPerson(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // ===== METHOD WITH RETURN VALUE =====
    // Overload 1: adds two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Overload 2: adds three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overload 3: adds two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // ===== METHOD WITH MULTIPLE PARAMETERS =====
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    // ===== METHOD THAT VALIDATES INPUT =====
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // ===== METHOD WITH VOID (NO RETURN) =====
    public static void printNumbers(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // ===== MAIN METHOD (Entry point) =====
    public static void main(String[] args) {
        System.out.println("=== Basic Method Call ===");
        greet();  // Call method with no parameters

        System.out.println("\n=== Method with Parameters ===");
        greetPerson("Alice");
        greetPerson("Bob");
        greetPerson("Charlie");

        System.out.println("\n=== Method with Return Value ===");
        int result = add(5, 3);
        System.out.println("5 + 3 = " + result);

        System.out.println("\n=== More Examples ===");
        double area = calculateArea(10, 5);
        System.out.println("Area of 10x5: " + area);

        System.out.println("\n=== Method Overloading ===");
        System.out.println("add(2, 3) = " + add(2, 3));           // Calls add(int, int)
        System.out.println("add(2, 3, 4) = " + add(2, 3, 4));     // Calls add(int, int, int)
        System.out.println("add(2.5, 3.5) = " + add(2.5, 3.5));   // Calls add(double, double)

        System.out.println("\n=== Boolean Return ===");
        System.out.println("Is 4 even? " + isEven(4));    // true
        System.out.println("Is 7 even? " + isEven(7));    // false

        System.out.println("\n=== Void Method ===");
        System.out.print("Numbers 1-5: ");
        printNumbers(5);

        System.out.print("Numbers 1-10: ");
        printNumbers(10);

        // ===== FACTORIAL METHOD (Using recursion preview) =====
        System.out.println("\n=== Method Calling Itself ===");
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 6: " + factorial(6));
    }

    // ===== RECURSIVE METHOD (Method calling itself) =====
    public static int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n <= 1) {
            return 1;
        }
        // Recursive case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }
}

/*
How to run:
javac Phase2_Methods.java
java Phase2_Methods

Key Points:
- Method signature: returnType methodName(parameters) { }
- void means no return value
- return stops execution and sends value back
- Overloading: same name, different parameters
- Recursion: method calling itself
*/
