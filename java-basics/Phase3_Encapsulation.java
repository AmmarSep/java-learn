// PHASE 3: OBJECT-ORIENTED PROGRAMMING
// Concept 3.4: Encapsulation

// ===== BAD: No Encapsulation =====
class BadBankAccount {
    public double balance;      // Public access = dangerous!
    public String accountType;

    // Anyone can change balance directly
}

// ===== GOOD: Proper Encapsulation =====
class GoodBankAccount {
    // Private variables: hidden from outside
    private double balance;
    private String accountNumber;
    private String accountType;
    private boolean isActive;

    // Constructor: initialize properly
    public GoodBankAccount(String accountNumber, String type, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountType = type;
        this.balance = initialBalance;
        this.isActive = true;
    }

    // Getter: read balance (controlled access)
    public double getBalance() {
        return balance;
    }

    // Setter with validation (controlled modification)
    public void setBalance(double newBalance) {
        if (newBalance >= 0) {
            this.balance = newBalance;
        } else {
            System.out.println("Balance can't be negative!");
        }
    }

    // Methods with business logic
    public void deposit(double amount) {
        if (!isActive) {
            System.out.println("Account is inactive");
            return;
        }
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        balance += amount;
        System.out.println("Deposited: $" + amount + ", New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (!isActive) {
            System.out.println("Account is inactive");
            return;
        }
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew: $" + amount + ", New balance: $" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void closeAccount() {
        isActive = false;
        System.out.println("Account closed");
    }

    public void reactivateAccount() {
        isActive = true;
        System.out.println("Account reactivated");
    }
}

// ===== STUDENT WITH ENCAPSULATION =====
class Student {
    private String studentId;
    private String name;
    private double gpa;
    private int enrollmentYear;

    public Student(String studentId, String name, double gpa, int enrollmentYear) {
        this.studentId = studentId;
        this.name = name;
        setGPA(gpa);  // Use setter for validation
        this.enrollmentYear = enrollmentYear;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    // Setter with validation
    public void setGPA(double newGPA) {
        if (newGPA >= 0.0 && newGPA <= 4.0) {
            this.gpa = newGPA;
        } else {
            System.out.println("GPA must be between 0.0 and 4.0");
        }
    }

    public void updateName(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.name = newName;
        } else {
            System.out.println("Name cannot be empty");
        }
    }

    public boolean isGoodStanding() {
        return gpa >= 2.0;
    }

    public String getClassYear() {
        int currentYear = 2024;
        int yearsEnrolled = currentYear - enrollmentYear;

        if (yearsEnrolled <= 1) return "Freshman";
        if (yearsEnrolled <= 2) return "Sophomore";
        if (yearsEnrolled <= 3) return "Junior";
        return "Senior";
    }
}

public class Phase3_Encapsulation {
    public static void main(String[] args) {
        System.out.println("=== Bad Encapsulation (Don't Do This) ===\n");

        BadBankAccount badAccount = new BadBankAccount();
        badAccount.balance = 1000;
        System.out.println("Balance: $" + badAccount.balance);

        // Anyone can corrupt the data!
        badAccount.balance = -999999;
        System.out.println("After corruption: $" + badAccount.balance);
        System.out.println("Problem: No validation!\n");

        // ===== GOOD ENCAPSULATION =====
        System.out.println("=== Good Encapsulation (Do This) ===\n");

        GoodBankAccount account = new GoodBankAccount("123456", "Checking", 1000);

        System.out.println("Account #" + account.getAccountNumber());
        System.out.println("Type: " + account.getAccountType());
        System.out.println("Initial balance: $" + account.getBalance());

        // Use methods, not direct access
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000);  // Rejected: insufficient funds

        // Try to set invalid balance
        account.setBalance(-100);  // Rejected: validation

        // Valid update
        account.setBalance(account.getBalance() + 100);
        System.out.println("Final balance: $" + account.getBalance());

        System.out.println();

        // ===== STUDENT ENCAPSULATION =====
        System.out.println("=== Student Encapsulation ===\n");

        Student student = new Student("S001", "Alice", 3.8, 2022);

        System.out.println("Student: " + student.getName());
        System.out.println("ID: " + student.getStudentId());
        System.out.println("GPA: " + student.getGPA());
        System.out.println("Class Year: " + student.getClassYear());
        System.out.println("Good standing? " + student.isGoodStanding());

        // Update GPA with validation
        System.out.println("\nTrying to set GPA to 4.5 (invalid):");
        student.setGPA(4.5);  // Rejected

        System.out.println("Setting GPA to 3.5 (valid):");
        student.setGPA(3.5);  // Accepted
        System.out.println("New GPA: " + student.getGPA());

        // Try to set invalid name
        System.out.println("\nTrying to set name to empty string:");
        student.updateName("");  // Rejected

        System.out.println("Setting name to 'Alice Smith':");
        student.updateName("Alice Smith");
        System.out.println("New name: " + student.getName());

        // ===== BENEFITS OF ENCAPSULATION =====
        System.out.println("\n=== Benefits of Encapsulation ===");
        System.out.println("1. Validation: Only valid data accepted");
        System.out.println("2. Consistency: Object always in valid state");
        System.out.println("3. Flexibility: Change implementation without breaking client code");
        System.out.println("4. Abstraction: Users don't need to know implementation");
        System.out.println("5. Security: Protect sensitive data");

        // ===== ACCESS MODIFIER LEVELS =====
        System.out.println("\n=== Access Modifier Levels ===");
        System.out.println("private: Only in this class");
        System.out.println("(default): Only in same package");
        System.out.println("protected: Same package + subclasses");
        System.out.println("public: Everywhere");
    }
}

/*
Key Concepts:
- private variables: Hide implementation details
- public methods: Control interface
- Getters: Read access with protection
- Setters: Write access with validation
- Encapsulation: Hide "how", show "what"
- Benefits: Validation, consistency, flexibility

Execution:
javac Phase3_Encapsulation.java
java Phase3_Encapsulation
*/
