// PHASE 6: EXCEPTIONS & BASIC CONCURRENCY
// Concept 6.4 & 6.5: Threads and Synchronization

// ===== METHOD 1: Implement Runnable (Preferred) =====
class PrinterTask implements Runnable {
    private String name;
    private int count;

    public PrinterTask(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(name + " - " + i);
            try {
                Thread.sleep(500);  // Sleep 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// ===== SHARED RESOURCE (Without synchronization) =====
class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// ===== SYNCHRONIZED VERSION =====
class SafeCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class Phase6_Threads {
    public static void main(String[] args) {
        System.out.println("=== Creating and Starting Threads ===\n");

        Thread thread1 = new Thread(new PrinterTask("Thread 1", 3));
        Thread thread2 = new Thread(new PrinterTask("Thread 2", 3));

        // Start threads (not guaranteed order)
        thread1.start();
        thread2.start();

        System.out.println("Main thread continues\n");

        // ===== USING LAMBDA (Java 8+) =====
        System.out.println("=== Lambda Threads ===\n");

        Thread lambdaThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Lambda thread: " + i);
            }
        });

        lambdaThread.start();

        // ===== MULTIPLE THREADS =====
        System.out.println("\n=== Multiple Threads Running Concurrently ===\n");

        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            int threadNum = i + 1;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    System.out.println("Thread " + threadNum + " - iteration " + j);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }

        // ===== WAITING FOR THREADS TO COMPLETE =====
        System.out.println("\n=== Waiting for Threads (join) ===\n");

        try {
            for (Thread t : threads) {
                t.join();  // Wait for thread to complete
            }
            System.out.println("All threads completed\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ===== RACE CONDITION (Without synchronization) =====
        System.out.println("=== Race Condition Example ===\n");

        Counter unsafeCounter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                unsafeCounter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Unsafe counter (should be 2000): " + unsafeCounter.getCount());
        System.out.println("(May be less due to race condition)\n");

        // ===== SYNCHRONIZED (Thread-safe) =====
        System.out.println("=== Synchronized Counter (Thread-safe) ===\n");

        SafeCounter safeCounter = new SafeCounter();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.increment();
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Safe counter (should be 2000): " + safeCounter.getCount() + "\n");

        // ===== THREAD STATES =====
        System.out.println("=== Thread States ===\n");

        Thread stateThread = new Thread(() -> {
            System.out.println("Thread is running");
        });

        System.out.println("State before start: " + stateThread.getState());  // NEW
        stateThread.start();
        System.out.println("State after start: " + stateThread.getState());   // RUNNABLE or RUNNING

        try {
            stateThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after finish: " + stateThread.getState());  // TERMINATED
    }
}

/*
Key Concepts:
- Thread: Runnable task running concurrently
- Runnable: Interface for thread code
- start(): Begin thread execution
- run(): Method containing thread code (don't call directly)
- sleep(): Pause thread
- join(): Wait for thread to complete
- Race condition: Multiple threads access shared data unsafely
- synchronized: Lock prevents multiple threads at once
- Volatile: Flag updates visible to all threads

Execution:
javac Phase6_Threads.java
java Phase6_Threads
*/
