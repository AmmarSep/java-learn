[All guides](README.md) · [Phase examples](../examples/06-exceptions-and-concurrency/README.md) · [Previous phase](05-collections.md) · [Next phase](07-code-quality.md)

# PHASE 6: EXCEPTIONS & BASIC CONCURRENCY

## Concept 6.1: Exceptions Overview

### Why This Matters
Exceptions handle errors gracefully. Without exception handling, errors crash your program immediately.

### The Problem: No Exception Handling

```java
public class NoExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[10]);  // Out of bounds!
        // Program crashes: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
        System.out.println("This never runs");
    }
}
```

Program crashes mid-execution without graceful cleanup.

### Exception Hierarchy

```
Throwable
├── Error (serious, don't catch)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│
└── Exception (handle these)
    ├── Checked Exceptions (checked at compile time)
    │   ├── IOException
    │   ├── SQLException
    │   └── ...
    │
    └── Unchecked Exceptions (checked at runtime)
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        ├── ArithmeticException
        └── ...
```

### Checked vs Unchecked

**Checked** - Must handle or declare (compiler enforces):
```java
void readFile() throws IOException {
    // Must either handle IOException or declare it
}
```

**Unchecked** - Can ignore (optional to handle):
```java
int[] arr = new int[5];
System.out.println(arr[10]);  // Unchecked: optional to handle
```

---

## Concept 6.2: try-catch-finally

### Why This Matters
try-catch allows you to handle errors and keep program running.

### Basic try-catch

```java
try {
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[10]);  // Error happens here
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index out of bounds: " + e.getMessage());
}
System.out.println("Program continues");  // This runs
```

**Flow:**
1. Try block executes
2. Exception is thrown
3. Control jumps to catch block
4. catch block handles exception
5. Program continues normally

### Multiple catch Blocks

```java
try {
    String str = null;
    System.out.println(str.length());  // NullPointerException
} catch (NullPointerException e) {
    System.out.println("Null pointer: " + e.getMessage());
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index error: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Generic error: " + e.getMessage());
}
```

Order matters: specific exceptions first, generic last.

### finally Block

Code that ALWAYS runs, whether exception or not:

```java
try {
    int result = 10 / 0;  // ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Caught: " + e.getMessage());
} finally {
    System.out.println("This ALWAYS runs");
}
```

Use finally for cleanup (close files, release resources):

```java
try {
    // Open file
    System.out.println("Reading file");
} catch (IOException e) {
    System.out.println("Error reading: " + e.getMessage());
} finally {
    System.out.println("Closing file");  // Runs no matter what
}
```

---

## Concept 6.3: Custom Exceptions

### Why This Matters
Create domain-specific exceptions for your application.

### Extending Exception

```java
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough money!");
        }
        balance -= amount;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        try {
            account.withdraw(50);   // OK
            account.withdraw(60);   // Throws exception
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
```

### Extending RuntimeException (Unchecked)

```java
public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// No need to declare throws or handle
public void setAge(int age) {
    if (age < 0) {
        throw new InvalidAgeException("Age can't be negative");
    }
}
```

### Common Mistakes
- Extending Exception vs RuntimeException: Checked vs unchecked behavior
- Not calling super constructor: `super(message);`
- Throwing checked exception without declaring: Compiler error

---

## Concept 6.4: Threads (Conceptual Basics)

### Why This Matters
Threads allow multiple tasks to run "simultaneously" within one program.

### Single Thread vs Multiple Threads

**Single-threaded:** Tasks run one after another
```
Task 1: 0-2 seconds
Task 2: 0-2 seconds
Task 3: 0-2 seconds
Total: 6 seconds
```

**Multi-threaded:** Tasks run "at the same time"
```
Task 1: ▓▓▓
Task 2: ▓▓▓
Task 3: ▓▓▓
Total: 2 seconds (overlapping)
```

### Creating a Thread

**Method 1: Extend Thread**
```java
public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
}

MyThread thread = new MyThread();
thread.start();  // Starts the thread
```

**Method 2: Implement Runnable (Preferred)**
```java
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + i);
        }
    }
}

Thread thread = new Thread(new MyRunnable());
thread.start();  // Starts the thread
```

Runnable is preferred because you can extend another class if needed.

### Thread Behavior

```java
public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        thread1.start();  // Starts executing
        thread2.start();  // Starts executing

        System.out.println("Main ends");
    }
}

// Output might be (interleaved):
// Main ends
// Thread 1: 0
// Thread 2: 0
// Thread 1: 1
// Thread 2: 1
// ...
```

Threads are unpredictable - output order is not guaranteed.

### Thread States

```
NEW → RUNNABLE ↔ RUNNING ↔ BLOCKED/WAITING → TERMINATED
```

- **NEW:** Created but not started
- **RUNNABLE:** Ready to run
- **RUNNING:** Currently executing
- **BLOCKED/WAITING:** Waiting for something
- **TERMINATED:** Finished

---

## Concept 6.5: Synchronization (High-Level Overview)

### Why This Matters
When multiple threads access shared data, they must coordinate to avoid corruption.

### The Problem: Race Condition

```java
public class Counter {
    private int count = 0;

    public void increment() {
        count++;  // Three operations: read, add, write
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // 100 threads each incrementing 100 times
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Wait for all threads
        for (Thread t : threads) {
            t.join();
        }

        System.out.println(counter.getCount());  // Should be 10000 but might be 9847 or less!
    }
}
```

Why? Multiple threads read `count`, increment, write back - but steps overlap:

```
Thread 1: read count (0)
Thread 2: read count (0)
Thread 1: add 1 → write 1
Thread 2: add 1 → write 1  ← Lost one increment!
```

### Solution: synchronized Keyword

Make method atomic (indivisible):

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;  // Only one thread can execute at a time
    }

    public int getCount() {
        return count;
    }
}
```

Only one thread executes synchronized method at a time:

```
Thread 1: acquires lock → reads count (0) → adds 1 → writes 1 → releases lock
Thread 2: waits for lock → acquires lock → reads count (1) → adds 1 → writes 2 → releases lock
```

### synchronized Block

Synchronize only critical section:

```java
public void transfer(Account from, Account to, int amount) {
    synchronized (from) {  // Lock specific object
        from.withdraw(amount);
        to.deposit(amount);
    }
}
```

### Volatile (Simple Flag)

For simple boolean flags:

```java
public class Runner {
    private volatile boolean running = true;

    public void stop() {
        running = false;  // All threads see update immediately
    }

    public void run() {
        while (running) {
            // Do work
        }
    }
}
```

### Common Mistakes
- Forgetting synchronized: Race conditions occur
- Over-synchronizing: Performance penalty
- Synchronizing read-only methods unnecessarily

---

