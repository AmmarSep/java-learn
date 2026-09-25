// PHASE 1: CORE FUNDAMENTALS
// Concept 1.1: Variables and Data Types

public class Phase1_Variables {
    public static void main(String[] args) {
        // ===== PRIMITIVE DATA TYPES =====

        // int: integer numbers (most common)
        int age = 25;
        int population = 8000000;
        System.out.println("Age: " + age);

        // double: decimal numbers (most common for decimals)
        double salary = 50000.50;
        double temperature = 98.6;
        System.out.println("Salary: $" + salary);

        // long: very large numbers (must end with 'L')
        long astronomicalDistance = 9461000000000000L;  // 1 light-year in km
        System.out.println("Light-year in km: " + astronomicalDistance);

        // float: decimals (less precise than double, must end with 'f')
        float price = 19.99f;
        System.out.println("Price: $" + price);

        // boolean: true or false
        boolean isActive = true;
        boolean hasLicense = false;
        System.out.println("Is active: " + isActive);

        // char: single character (use single quotes)
        char grade = 'A';
        char firstLetter = 'J';
        System.out.println("Grade: " + grade);

        // byte: small numbers (-128 to 127)
        byte smallNumber = 100;
        System.out.println("Small number: " + smallNumber);

        // short: medium numbers (-32,768 to 32,767)
        short mediumNumber = 1000;
        System.out.println("Medium number: " + mediumNumber);

        // ===== STRING (Reference Type) =====
        // String: text (technically not a primitive)
        String name = "Alice";
        String city = "New York";
        System.out.println("Name: " + name);

        // ===== VARIABLE NAMING RULES =====
        int studentAge = 20;      // Good: camelCase
        double hourlyWage = 15.5; // Good: clear name

        // ===== TYPE CASTING =====
        // Implicit cast: int → double (no data loss)
        int wholeNumber = 5;
        double decimalNumber = wholeNumber;  // Automatically 5.0
        System.out.println("Whole as decimal: " + decimalNumber);

        // Explicit cast: double → int (data loss!)
        double myPrice = 19.99;
        int roundedPrice = (int) myPrice;  // Becomes 19 (decimal lost)
        System.out.println("Rounded price: $" + roundedPrice);

        // ===== INITIALIZATION vs DECLARATION =====
        int score;                 // Declared, no value
        // System.out.println(score);  // ERROR: score uninitialized

        int points = 0;            // Declared AND initialized
        System.out.println("Points: " + points);  // OK

        // ===== LITERALS =====
        int decimal = 100;         // Decimal literal
        int hexadecimal = 0x64;    // Hex literal (same as 100)
        int binary = 0b1100100;    // Binary literal (same as 100)
        System.out.println("All three: " + decimal + ", " + hexadecimal + ", " + binary);

        // ===== CONSTANTS =====
        final int MAX_SIZE = 100;  // Constant: can't change
        // MAX_SIZE = 200;  // ERROR: MAX_SIZE is final
        System.out.println("Max size: " + MAX_SIZE);
    }
}

/*
How to run:
javac Phase1_Variables.java
java Phase1_Variables

Key Points:
- Declare type before variable name: int age = 25;
- Initialize before using: int x; System.out.println(x); → ERROR
- Casting: (targetType) value
- 'final' makes variable constant
*/
