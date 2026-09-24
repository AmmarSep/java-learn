// PHASE 1: CORE FUNDAMENTALS
// Concept 1.2: Operators and Expressions

public class Phase1_Operators {
    public static void main(String[] args) {
        // ===== ARITHMETIC OPERATORS =====
        int a = 10;
        int b = 3;

        System.out.println("=== Arithmetic Operators ===");
        System.out.println("Addition: " + a + " + " + b + " = " + (a + b));        // 13
        System.out.println("Subtraction: " + a + " - " + b + " = " + (a - b));     // 7
        System.out.println("Multiplication: " + a + " * " + b + " = " + (a * b));  // 30
        System.out.println("Division: " + a + " / " + b + " = " + (a / b));        // 3 (integer division)
        System.out.println("Remainder (Modulo): " + a + " % " + b + " = " + (a % b));  // 1

        // Modulo examples
        System.out.println("\n=== Modulo Examples ===");
        System.out.println("10 % 3 = " + (10 % 3));  // 1
        System.out.println("15 % 5 = " + (15 % 5));  // 0 (divides evenly)
        System.out.println("7 % 2 = " + (7 % 2));    // 1 (odd number check)

        // Integer vs Double division
        System.out.println("\n=== Integer vs Double Division ===");
        int intDivision = 10 / 3;          // 3 (decimal part lost)
        double doubleDivision = 10.0 / 3;  // 3.333... (at least one operand is double)
        System.out.println("10 / 3 (int) = " + intDivision);
        System.out.println("10.0 / 3 (double) = " + doubleDivision);

        // ===== INCREMENT AND DECREMENT =====
        System.out.println("\n=== Increment and Decrement ===");
        int x = 5;
        System.out.println("x before: " + x);
        x++;  // Increment
        System.out.println("x after x++: " + x);  // 6
        x--;  // Decrement
        System.out.println("x after x--: " + x);  // 5

        // Post vs Pre increment (rarely matters)
        int y = 5;
        int z = y++;  // z = 5, then y becomes 6
        System.out.println("Post-increment - y: " + y + ", z: " + z);

        int m = 5;
        int n = ++m;  // m becomes 6, then n = 6
        System.out.println("Pre-increment - m: " + m + ", n: " + n);

        // ===== COMPARISON OPERATORS =====
        System.out.println("\n=== Comparison Operators ===");
        int num1 = 10;
        int num2 = 5;

        System.out.println(num1 + " == " + num2 + " ? " + (num1 == num2));  // false
        System.out.println(num1 + " != " + num2 + " ? " + (num1 != num2));  // true
        System.out.println(num1 + " > " + num2 + " ? " + (num1 > num2));    // true
        System.out.println(num1 + " < " + num2 + " ? " + (num1 < num2));    // false
        System.out.println(num1 + " >= " + num2 + " ? " + (num1 >= num2));  // true
        System.out.println(num1 + " <= " + num2 + " ? " + (num1 <= num2));  // false

        // ===== LOGICAL OPERATORS =====
        System.out.println("\n=== Logical Operators ===");
        boolean isStudent = true;
        boolean hasLicense = false;

        // AND (&&): both must be true
        System.out.println("isStudent && hasLicense = " + (isStudent && hasLicense));  // false

        // OR (||): at least one must be true
        System.out.println("isStudent || hasLicense = " + (isStudent || hasLicense));  // true

        // NOT (!): reverses truth value
        System.out.println("!isStudent = " + (!isStudent));              // false
        System.out.println("!hasLicense = " + (!hasLicense));            // true

        // Complex condition
        int age = 25;
        boolean canDrive = (age >= 18) && (hasLicense);
        System.out.println("Can drive (age 25, no license): " + canDrive);  // false

        // ===== STRING CONCATENATION =====
        System.out.println("\n=== String Concatenation ===");
        String firstName = "John";
        String lastName = "Doe";
        int salary = 50000;

        String fullName = firstName + " " + lastName;
        String message = "Hello, " + fullName + "! Your salary is $" + salary;
        System.out.println(message);

        // ===== OPERATOR PRECEDENCE =====
        System.out.println("\n=== Operator Precedence ===");
        int result1 = 2 + 3 * 4;      // 2 + 12 = 14 (multiply first)
        int result2 = (2 + 3) * 4;    // 5 * 4 = 20 (parentheses first)
        System.out.println("2 + 3 * 4 = " + result1);    // 14
        System.out.println("(2 + 3) * 4 = " + result2);  // 20

        // Complex expression
        int value = 10 + 5 * 2 - 3 / 2;  // 10 + 10 - 1 = 19
        System.out.println("10 + 5 * 2 - 3 / 2 = " + value);  // 19
    }
}

/*
Key Points:
- Arithmetic: +, -, *, /, %
- Increment: x++, ++x (usually same in practice)
- Comparisons: ==, !=, <, >, <=, >=
- Logical: && (AND), || (OR), ! (NOT)
- String concatenation: + joins strings
- Precedence: Parentheses > Multiply/Divide > Add/Subtract > Comparison > Logical
*/
