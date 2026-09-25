// PHASE 7: CODE QUALITY & DEBUGGING
// Concept 7.1-7.3: Naming Conventions, Common Pitfalls, Debugging

public class Phase7_CodeQuality {

    // ===== GOOD NAMING CONVENTIONS =====

    // Class names: PascalCase, noun
    class BankAccount {
        // Instance variables: camelCase, noun
        private String accountNumber;
        private double balance;
        private boolean isActive;

        // Constructor
        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
            this.isActive = true;
        }

        // Getter methods: "get" prefix
        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        // Setter methods: "set" prefix
        public void setBalance(double newBalance) {
            if (newBalance >= 0) {
                this.balance = newBalance;
            }
        }

        // Boolean getter: "is" prefix
        public boolean isActive() {
            return isActive;
        }

        // Regular method: camelCase, verb
        public void transfer(BankAccount toAccount, double amount) {
            if (this.balance >= amount) {
                this.balance -= amount;
                toAccount.balance += amount;
            }
        }
    }

    // ===== CONSTANTS: UPPER_CASE =====
    public static final double INTEREST_RATE = 0.05;
    public static final int MAX_WITHDRAWAL_AMOUNT = 1000;
    public static final String BANK_NAME = "MyBank";

    // ===== COMMON PITFALLS & FIXES =====

    public static void main(String[] args) {
        System.out.println("=== Common Java Pitfalls ===\n");

        // PITFALL 1: == vs equals()
        System.out.println("--- Pitfall 1: == vs equals() ---");
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println("s1 == s2: " + (s1 == s2));      // false (different objects)
        System.out.println("s1.equals(s2): " + (s1.equals(s2)));  // true (same content)
        System.out.println("Fix: Use .equals() for content comparison\n");

        // PITFALL 2: Null Pointer Exception
        System.out.println("--- Pitfall 2: Null Pointer ---");
        String name = null;
        if (name != null) {  // Always check before using
            System.out.println("Name: " + name);
        } else {
            System.out.println("Name is null");
        }
        System.out.println("Fix: Check for null before using objects\n");

        // PITFALL 3: Integer Division
        System.out.println("--- Pitfall 3: Integer Division ---");
        int result1 = 10 / 3;        // 3 (decimal lost)
        double result2 = 10.0 / 3;   // 3.333... (at least one is double)
        System.out.println("10 / 3 (int): " + result1);
        System.out.println("10.0 / 3 (double): " + result2);
        System.out.println("Fix: Use double for decimal division\n");

        // PITFALL 4: Array Index Out of Bounds
        System.out.println("--- Pitfall 4: Array Index Out of Bounds ---");
        int[] arr = {1, 2, 3};
        System.out.println("Valid indices: 0, 1, 2");
        System.out.println("arr[0] = " + arr[0]);
        System.out.println("arr[2] = " + arr[2]);
        // arr[3] would throw ArrayIndexOutOfBoundsException
        System.out.println("Fix: Array indices go from 0 to length-1\n");

        // PITFALL 5: Infinite Loop
        System.out.println("--- Pitfall 5: Infinite Loop ---");
        int counter = 0;
        while (counter < 3) {  // Must have exit condition
            System.out.println("Counter: " + counter);
            counter++;  // MUST change counter
        }
        System.out.println("Fix: Ensure loop condition becomes false\n");

        // PITFALL 6: Forgetting break in switch
        System.out.println("--- Pitfall 6: Switch Fallthrough ---");
        int day = 2;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;  // MUST break!
            case 2:
                System.out.println("Tuesday");
                break;
            default:
                System.out.println("Other");
        }
        System.out.println("Fix: Add break in each case\n");

        // PITFALL 7: Uninitialized Variables
        System.out.println("--- Pitfall 7: Uninitialized Variables ---");
        int x = 0;  // Must initialize
        System.out.println("x = " + x);
        System.out.println("Fix: Initialize before using\n");

        // PITFALL 8: String Comparison
        System.out.println("--- Pitfall 8: String Comparison ---");
        String input = "hello";
        if (input.equals("hello")) {  // Correct
            System.out.println("Strings match");
        }
        System.out.println("Fix: Use .equals() not ==\n");

        // PITFALL 9: Modifying Collections While Iterating
        System.out.println("--- Pitfall 9: Modifying During Iteration ---");
        java.util.List<String> items = new java.util.ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");

        for (String item : items) {
            System.out.println(item);
            // Don't modify list here: items.remove(item);
        }
        System.out.println("Fix: Don't modify collection during iteration\n");

        // PITFALL 10: Variable Shadowing
        System.out.println("--- Pitfall 10: Variable Shadowing ---");
        int z = 5;
        {
            int z2 = 10;  // Different variable (confusing!)
            System.out.println("Inner z: " + z2);
        }
        System.out.println("Outer z: " + z);
        System.out.println("Fix: Use different variable names\n");

        // ===== DEBUGGING TIPS =====
        System.out.println("=== Debugging Techniques ===\n");

        System.out.println("1. Print statements:");
        int debugValue = 42;
        System.out.println("DEBUG: debugValue = " + debugValue);

        System.out.println("\n2. Stack trace from exceptions:");
        try {
            int[] test = {1, 2, 3};
            System.out.println(test[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error at: " + e.getStackTrace()[0]);
        }

        System.out.println("\n3. Check preconditions:");
        int age = 15;
        if (age >= 0 && age <= 150) {
            System.out.println("Age is valid");
        } else {
            System.out.println("Age is invalid");
        }

        System.out.println("\n=== Code Quality Checklist ===");
        System.out.println("✓ Classes: PascalCase");
        System.out.println("✓ Variables: camelCase");
        System.out.println("✓ Constants: UPPER_CASE");
        System.out.println("✓ Methods: camelCase, descriptive verbs");
        System.out.println("✓ Comments: Explain WHY, not WHAT");
        System.out.println("✓ Handle exceptions properly");
        System.out.println("✓ Avoid magic numbers");
        System.out.println("✓ Keep methods small and focused");
        System.out.println("✓ Use meaningful variable names");
        System.out.println("✓ Check for null before using objects");
    }

    // ===== DEBUGGING WITH LOGGING =====
    private static void debugExample() {
        // In real code, use proper logging:
        // java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Phase7_CodeQuality.class.getName());
        // logger.info("Debug message");
        // logger.warning("Warning message");
        // logger.severe("Severe message");
    }

    // ===== GOOD CODE EXAMPLE =====
    class User {
        private String email;
        private int age;
        private String firstName;
        private String lastName;

        // Good: Clear constructor
        public User(String email, String firstName, String lastName, int age) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        // Good: Clear getters
        public String getEmail() {
            return email;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        public int getAge() {
            return age;
        }

        // Good: Clear method with validation
        public void setAge(int newAge) {
            if (newAge < 0 || newAge > 150) {
                throw new IllegalArgumentException("Age must be 0-150");
            }
            this.age = newAge;
        }

        @Override
        public String toString() {
            return "User{" +
                    "email='" + email + '\'' +
                    ", age=" + age +
                    ", name='" + getFullName() + '\'' +
                    '}';
        }
    }
}

/*
Key Takeaways:
- Naming: Classes (PascalCase), variables/methods (camelCase), constants (UPPER_CASE)
- Common pitfalls: Use .equals() for Strings, check null, watch integer division, array bounds
- Debugging: Print statements, exception stack traces, IDE debugger
- Code quality: Meaningful names, small methods, proper encapsulation, good comments

Execution:
javac Phase7_CodeQuality.java
java Phase7_CodeQuality
*/
