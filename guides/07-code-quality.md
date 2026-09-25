[All guides](README.md) · [Phase examples](../examples/07-code-quality/README.md) · [Previous phase](06-exceptions-and-concurrency.md)

# PHASE 7: CODE QUALITY & DEBUGGING

## Concept 7.1: Java Naming Conventions

### Why This Matters
Consistent naming makes code readable and professional.

### Class Names

PascalCase (capitalize first letter of each word):

```java
public class BankAccount { }
public class UserProfile { }
public class IllegalArgumentException { }
```

Nouns describing what the class IS:
- ✓ `Dog`, `Car`, `Person`
- ✗ `Dog2`, `MyDog`, `doSomething`

### Variable Names

camelCase (lowercase first letter):

```java
int age;
String firstName;
boolean isActive;
```

Noun describing the data:
- ✓ `count`, `userName`, `totalPrice`
- ✗ `c`, `un`, `tp`

### Constant Names

ALL_CAPS with underscores:

```java
public static final int MAX_SIZE = 100;
public static final double PI = 3.14159;
public static final String DATABASE_URL = "jdbc:...";
```

### Method Names

camelCase, verbs describing action:

```java
public void eat() { }
public String getName() { }
public boolean isEmpty() { }
public void setAge(int age) { }
```

- Getters: `get` prefix → `getName()`
- Setters: `set` prefix → `setName(String name)`
- Boolean: `is` or `has` prefix → `isEmpty()`, `hasValue()`

### Package Names

All lowercase, reverse domain:

```java
com.example.game
java.util
org.springframework.web
```

### Examples of Good Names

```java
public class BankAccount {
    private double balance;
    private String accountNumber;
    private boolean isActive;

    public double getBalance() { }
    public void setBalance(double amount) { }
    public boolean isActive() { }
    public void transfer(BankAccount toAccount, double amount) { }
}
```

### Bad Names (Avoid)

```java
public class BA { }              // Too short
public class bankAccount { }     // Wrong case
public class d { }               // Meaningless

int x, y, z;                     // Single letters (except loops)
String un;                       // Abbreviation
boolean flag;                    // Too vague

public void fn() { }             // Abbreviation
public void process() { }        // Too generic
public void m() { }              // Too short
```

---

## Concept 7.2: Common Java Pitfalls

### Why This Matters
Knowing common mistakes helps you avoid them.

### Pitfall 1: == vs equals()

```java
String s1 = new String("Hello");
String s2 = new String("Hello");

System.out.println(s1 == s2);          // false (different objects)
System.out.println(s1.equals(s2));     // true (same content)
```

**Rule:** Use `==` for primitives and objects when checking reference.
**Rule:** Use `.equals()` for content comparison.

### Pitfall 2: Null Pointer Exception

```java
String name = null;
System.out.println(name.length());  // NullPointerException!
```

Always check before using:
```java
if (name != null) {
    System.out.println(name.length());
}
```

### Pitfall 3: Integer Division

```java
int result = 10 / 3;    // Result is 3 (decimal lost)
double result = 10 / 3;  // Result is 3.0 (still integer division)
double result = 10.0 / 3;  // Result is 3.333... (one operand is double)
```

### Pitfall 4: Array Index Out of Bounds

```java
int[] arr = new int[5];
System.out.println(arr[5]);  // IndexOutOfBoundsException
                             // Valid indices: 0, 1, 2, 3, 4
```

### Pitfall 5: Infinite Loop

```java
while (true) {
    System.out.println("Infinite!");
    // Missing break or condition change
}
```

Always ensure loop condition becomes false eventually.

### Pitfall 6: Forgetting break in switch

```java
int day = 1;
switch (day) {
    case 1:
        System.out.println("Monday");
        // Missing break!
    case 2:
        System.out.println("Tuesday");
        break;
}
// Output: Monday Tuesday (falls through!)
```

### Pitfall 7: Not Initializing Variables

```java
int x;
System.out.println(x);  // ERROR: x has no initial value
```

Initialize before using:
```java
int x = 0;
System.out.println(x);  // OK: 0
```

### Pitfall 8: String Comparison

```java
String input = "5";
if (input == "5") { }   // May be false (compares references)
if (input.equals("5")) { }  // Correct
```

### Pitfall 9: Modifying Collection While Iterating

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");

for (String name : names) {
    if (name.equals("Bob")) {
        names.remove("Bob");  // ConcurrentModificationException!
    }
}
```

### Pitfall 10: Shadowing Variables

```java
int x = 5;

{
    int x = 10;  // Different variable, same name
    System.out.println(x);  // 10
}

System.out.println(x);  // 5
```

Confusing! Use different names.

---

## Concept 7.3: Debugging Strategies

### Why This Matters
Debugging is finding and fixing bugs. Good debugging skills save hours.

### Print Statements (Simple)

```java
public static void processData(int[] data) {
    System.out.println("Input data length: " + data.length);

    for (int i = 0; i < data.length; i++) {
        System.out.println("Processing index " + i + ": " + data[i]);
    }

    int result = calculate(data);
    System.out.println("Final result: " + result);
}
```

Add println at key points to track execution.

### Logging (Professional)

Use logging library (Java has built-in):

```java
import java.util.logging.Logger;

public class DataProcessor {
    private static final Logger logger = Logger.getLogger(DataProcessor.class.getName());

    public void process(int[] data) {
        logger.info("Starting process with " + data.length + " items");

        try {
            // Process
            logger.fine("Processing item: " + item);
        } catch (Exception e) {
            logger.severe("Error processing: " + e.getMessage());
        }
    }
}
```

### Debugger (IDE)

Modern IDEs have debuggers:

1. Set breakpoint (click line number in IDE)
2. Run in debug mode
3. Execution pauses at breakpoint
4. Inspect variables
5. Step through code line by line

### Common Debug Steps

1. **Identify the bug:** What's wrong?
2. **Reproduce:** Can you make it happen consistently?
3. **Isolate:** Where exactly does it fail?
4. **Investigate:** What's the root cause?
5. **Fix:** Correct the code
6. **Verify:** Bug is gone

### Exception Stack Traces

Read from top to bottom:

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5
    at DataProcessor.process(DataProcessor.java:45)
    at Main.main(Main.java:15)
```

- **Line 45 in DataProcessor.java:** Where the crash happened
- **Called from line 15 in Main.java:** Called from here
- **Exception type:** ArrayIndexOutOfBoundsException

---

## Summary

You now have a complete map of Java from first principles through OOP and concurrency.

### Key Takeaways

**Phase 0:** Understand the environment and how Java executes
**Phase 1:** Master fundamentals (variables, operators, control flow)
**Phase 2:** Understand methods and memory (stack/heap, pass-by-value)
**Phase 3:** Build with OOP (classes, inheritance, polymorphism)
**Phase 4:** Master language features (interfaces, static, access modifiers)
**Phase 5:** Use collections effectively (List, Set, Map, generics)
**Phase 6:** Handle errors and concurrency (exceptions, threads, synchronized)
**Phase 7:** Write quality code (naming, debugging, avoiding pitfalls)

### Next Steps

1. **Study:** Read each phase carefully
2. **Code:** Write all examples yourself
3. **Experiment:** Modify code and see what breaks
4. **Practice:** Build small projects using these concepts
5. **Refine:** Come back when confused and re-read the concept

Remember: Deep understanding beats speed. Read slowly, understand thoroughly, and practice relentlessly.
