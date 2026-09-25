// PHASE 6: EXCEPTIONS & BASIC CONCURRENCY
// Concept 6.1-6.3: Exception Handling and Custom Exceptions

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Available: $" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount + ", New balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class Phase6_Exceptions {
    public static void main(String[] args) {
        System.out.println("=== Basic try-catch ===\n");

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[0]);  // OK: 1
            System.out.println(numbers[5]);  // ERROR: out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        System.out.println("Program continues\n");

        // ===== MULTIPLE CATCH BLOCKS =====
        System.out.println("=== Multiple catch Blocks ===\n");

        try {
            String text = null;
            System.out.println(text.length());  // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught null pointer: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught generic exception");
        }
        System.out.println();

        // ===== FINALLY BLOCK =====
        System.out.println("=== Finally Block ===\n");

        try {
            int result = 10 / 0;  // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block (always runs)");
        }
        System.out.println();

        // ===== TRY-FINALLY (no catch) =====
        System.out.println("=== Try-Finally (no catch) ===\n");

        try {
            System.out.println("Attempting operation");
            // Exception would propagate, but finally still runs
        } finally {
            System.out.println("Cleanup in finally");
        }
        System.out.println();

        // ===== CUSTOM EXCEPTIONS =====
        System.out.println("=== Custom Exceptions ===\n");

        BankAccount account = new BankAccount("123456", 1000);

        try {
            System.out.println("Current balance: $" + account.getBalance());
            account.withdraw(500);
            account.withdraw(600);  // Not enough money
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
        System.out.println();

        // ===== EXCEPTION HIERARCHY =====
        System.out.println("=== Exception Hierarchy ===\n");

        try {
            int x = Integer.parseInt("not a number");
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        } catch (Exception e) {
            System.out.println("Caught generic Exception");
        }
        System.out.println();

        // ===== THROWING EXCEPTIONS =====
        System.out.println("=== Throwing Exceptions ===\n");

        try {
            validateAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
        System.out.println();

        // ===== EXCEPTION MESSAGE AND STACK TRACE =====
        System.out.println("=== Exception Details ===\n");

        try {
            Object obj = "string";
            Integer num = (Integer) obj;  // ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Exception type: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Stack trace (first 3 lines):");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < Math.min(3, stackTrace.length); i++) {
                System.out.println("  " + stackTrace[i]);
            }
        }
    }

    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        System.out.println("Age " + age + " is valid");
    }
}

/*
Key Concepts:
- try-catch: Catch exceptions and handle gracefully
- finally: Code that ALWAYS runs (cleanup)
- throw: Throw exceptions
- throws: Declare that method might throw exception
- Custom exceptions: Extend Exception or RuntimeException
- Exception hierarchy: Catch specific exceptions first
- getMessage(): Get error message
- printStackTrace(): Print full stack trace

Execution:
javac Phase6_Exceptions.java
java Phase6_Exceptions
*/
