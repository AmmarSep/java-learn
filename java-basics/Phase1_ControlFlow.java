// PHASE 1: CORE FUNDAMENTALS
// Concept 1.3 & 1.4: if-else, switch, and loops

public class Phase1_ControlFlow {
    public static void main(String[] args) {
        // ===== IF STATEMENTS =====
        System.out.println("=== IF Statements ===");

        int age = 25;
        if (age >= 18) {
            System.out.println("You are an adult");
        }

        // ===== IF-ELSE =====
        System.out.println("\n=== IF-ELSE ===");

        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else {
            System.out.println("Grade: B or lower");
        }

        // ===== IF-ELSE IF-ELSE =====
        System.out.println("\n=== IF-ELSE IF-ELSE ===");

        int testScore = 75;
        if (testScore >= 90) {
            System.out.println("Grade: A");
        } else if (testScore >= 80) {
            System.out.println("Grade: B");
        } else if (testScore >= 70) {
            System.out.println("Grade: C");
        } else if (testScore >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        // ===== SWITCH STATEMENT =====
        System.out.println("\n=== SWITCH Statement ===");

        int dayOfWeek = 3;
        String dayName;

        switch (dayOfWeek) {
            case 1:
                dayName = "Monday";
                break;  // IMPORTANT: exit switch
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Unknown";
        }

        System.out.println("Day " + dayOfWeek + " is " + dayName);

        // Switch with fallthrough (usually not intended)
        System.out.println("\n=== Switch Fallthrough (Warning!) ===");
        int num = 2;
        switch (num) {
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Other");
        }
        // Output: "Two" and "Three" (falls through without break!)

        // ===== FOR LOOP =====
        System.out.println("\n=== FOR Loop ===");

        for (int i = 0; i < 5; i++) {
            System.out.println("Count: " + i);
        }

        // For loop with custom step
        System.out.println("\nFor loop with step 2:");
        for (int i = 0; i < 10; i += 2) {
            System.out.println("i = " + i);
        }

        // ===== WHILE LOOP =====
        System.out.println("\n=== WHILE Loop ===");

        int counter = 0;
        while (counter < 3) {
            System.out.println("Counter: " + counter);
            counter++;
        }

        // ===== DO-WHILE LOOP =====
        System.out.println("\n=== DO-WHILE Loop ===");

        int value = 0;
        do {
            System.out.println("Value: " + value);
            value++;
        } while (value < 3);

        // Do-while runs at least once even if condition is false
        System.out.println("\nDo-while with false condition:");
        int falseCounter = 5;
        do {
            System.out.println("This runs once");
        } while (falseCounter < 3);  // False, but body ran once

        // ===== BREAK AND CONTINUE =====
        System.out.println("\n=== BREAK (exit loop) ===");

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;  // Exit loop when i equals 5
            }
            System.out.println("i = " + i);
        }

        System.out.println("\n=== CONTINUE (skip iteration) ===");

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue;  // Skip when i equals 2
            }
            System.out.println("i = " + i);
        }
        // Output: 0, 1, 3, 4 (skips 2)

        // ===== NESTED IF =====
        System.out.println("\n=== Nested IF ===");

        int myAge = 25;
        boolean hasLicense = true;

        if (myAge >= 18) {
            System.out.println("You are old enough to drive");
            if (hasLicense) {
                System.out.println("You can drive!");
            } else {
                System.out.println("You need a license");
            }
        } else {
            System.out.println("Too young to drive");
        }

        // ===== TERNARY OPERATOR (shorthand if-else) =====
        System.out.println("\n=== Ternary Operator ===");

        int number = 15;
        String result = (number > 10) ? "Greater than 10" : "10 or less";
        System.out.println(result);

        // Nested ternary (avoid if too complex)
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
        System.out.println("Score " + score + " = Grade " + grade);
    }
}

/*
Key Points:
- if: execute if condition true
- if-else: two branches
- if-else if-else: multiple conditions
- switch: clean for many cases
- for: loop exact number of times
- while: loop while condition true
- do-while: runs at least once
- break: exit loop
- continue: skip to next iteration
*/
