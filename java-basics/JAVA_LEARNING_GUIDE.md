# Complete Java Learning Guide - All Phases

## TABLE OF CONTENTS
1. Phase 0: Environment & Execution
2. Phase 1: Core Fundamentals
3. Phase 2: Methods & Memory
4. Phase 3: Object-Oriented Programming
5. Phase 4: Core Language Features
6. Phase 5: Collections & Generics
7. Phase 6: Exceptions & Basic Concurrency
8. Phase 7: Code Quality & Debugging

---

# PHASE 0: ENVIRONMENT & EXECUTION

## Concept 0.1: JDK vs JRE vs JVM

### Why This Matters
Before writing Java code, you need to understand what you're installing and how Java actually runs on your machine. This is the foundation explaining Java's "write once, run anywhere" philosophy.

### The Three Components

**JVM (Java Virtual Machine)**
- A program that runs ON your operating system (Windows, macOS, Linux)
- Reads and executes Java bytecode (compiled Java code)
- Acts as an intermediary between your code and actual hardware
- Analogy: A translator who understands Java instructions and converts them to your CPU's language

**JRE (Java Runtime Environment)**
- Contains: JVM + standard libraries (String, ArrayList, File, etc.)
- Purpose: Run compiled Java programs
- Does NOT include: Compiler or development tools
- When you: Download JRE, you can run Java programs but cannot write/compile them

**JDK (Java Development Kit)**
- Contains: JRE + development tools (javac compiler, debugger, etc.)
- Purpose: Write, compile, and run Java programs
- What you need: As a developer, install the JDK

### The Execution Flow

```
Your Computer
    ↓
┌─────────────────────────────────────────┐
│  Operating System                       │
│  (Windows/macOS/Linux)                  │
└─────────────────────────────────────────┘
    ↓
┌─────────────────────────────────────────┐
│  JVM (Java Virtual Machine)             │
│  - Reads bytecode                       │
│  - Converts to OS-specific machine code │
└─────────────────────────────────────────┘
    ↓
┌─────────────────────────────────────────┐
│  Hardware (CPU, Memory, etc.)           │
│  Executes actual instructions           │
└─────────────────────────────────────────┘
```

### Real-World Analogy
You write a recipe in a standard format. You want it to work in France, Japan, and Brazil:
- Standard format recipe = Java bytecode
- French chef who reads standard format = JVM on Windows
- Japanese chef who reads standard format = JVM on macOS
- Brazilian chef who reads standard format = JVM on Linux

Each chef speaks a different language (x86, ARM, etc.) but all understand the same recipe format.

### Key Takeaways
- Install JDK to develop Java
- JDK includes a JRE
- Code is compiled to bytecode once
- Same bytecode runs on any JVM, any OS

---

## Concept 0.2: From .java to .class to Execution

### Why This Matters
Understanding this journey helps you debug errors, understand when compilation errors occur, and appreciate Java's architecture.

### The Three-Step Process

**Step 1: Write Source Code**
- File: `HelloWorld.java`
- Format: Human-readable Java code
- Created by: You (the developer)

**Step 2: Compile**
- Command: `javac HelloWorld.java`
- Tool: Java compiler (part of JDK)
- Creates: `HelloWorld.class` (bytecode)
- Checks: Syntax errors, type errors, etc.

**Step 3: Execute**
- Command: `java HelloWorld`
- Tool: JVM (part of JRE)
- Reads: `.class` file (bytecode)
- Does: Executes the bytecode

### Visual Flow

```
HelloWorld.java              javac              HelloWorld.class           java              Output
(readable)         →         compiler    →      (bytecode)        →       JVM       →      "Hello"
(human writes)               (checks)           (platform-neutral)        (interprets)
```

### Key Points
- Compilation happens ONCE per code change
- Execution reads the compiled `.class` file
- `.class` files are platform-neutral (work on all OSes)
- You run `java HelloWorld` NOT `java HelloWorld.java`

### Common Mistakes
- Running `java HelloWorld.java` → Use `java HelloWorld` (no extension)
- Filename mismatch: Class is `HelloWorld`, file is `helloworld.java` → Must match exactly
- Forgetting semicolons → Syntax error
- Wrong method name instead of `main` → Program doesn't run

---

## Concept 0.3: Bytecode and Platform Independence

### Why This Matters
This is Java's superpower: compile once, run anywhere. Understanding bytecode explains why this works.

### What is Bytecode?

Bytecode is an intermediate format between human-readable code and machine-specific instructions:
- NOT machine code (like x86 assembly for Intel processors)
- NOT source code (you can't read .class files easily)
- Platform-independent (same `.class` file on Windows/Mac/Linux)

### How Platform Independence Works

```
Step 1: You write Java code (once)
        ↓
Step 2: Compile to bytecode (once)
        ↓
Step 3: Distribute .class file (everywhere)
        ↓
        ┌──────────────────┬──────────────────┬──────────────────┐
        ↓                  ↓                  ↓
    Windows JVM         macOS JVM         Linux JVM
    Converts to         Converts to         Converts to
    x86 machine code    ARM machine code    x86 machine code
        ↓                  ↓                  ↓
    Runs on Intel     Runs on Apple      Runs on Intel
```

### Example Bytecode
If you write:
```java
int x = 5;
int y = 3;
int sum = x + y;
```

The bytecode might look like:
```
bipush 5       // Push 5 onto stack
istore_1       // Store in variable x
bipush 3       // Push 3 onto stack
istore_2       // Store in variable y
iload_1        // Load x from memory
iload_2        // Load y from memory
iadd           // Add them
istore_3       // Store result in sum
```

You don't need to understand bytecode details. Key insight: Same bytecode, different JVMs, different machine code, runs everywhere.

### Key Takeaway
Write once → Compile once → Run everywhere

---

## Concept 0.4: The main() Method Structure

### Why This Matters
The `main()` method is where your program starts. The JVM searches for this exact structure. Getting it wrong means your program won't run.

### The Exact Formula

```java
public static void main(String[] args) {
    // Your code here
}
```

Every part is REQUIRED. Deviating breaks it.

### Breaking Down Each Keyword

| Keyword | Why Required | What It Means |
|---------|-------------|---------------|
| `public` | JVM needs to see it from outside the class | Visible to the entire JVM |
| `static` | JVM calls it on the class itself, not on an object instance | Exists once for the whole class |
| `void` | main() performs actions but returns nothing | No return value |
| `main` | JVM searches for this exact name | Entry point name |
| `String[] args` | Receives command-line arguments | Array of text strings |

### Understanding `String[] args`

`args` stands for "arguments" - how users pass information to your program:

```bash
java MyProgram hello world java
```

Inside MyProgram:
- `args[0]` = "hello"
- `args[1]` = "world"
- `args[2]` = "java"
- `args.length` = 3

If run with no arguments:
- `args.length` = 0
- Array is empty but exists

### Dissecting the Structure

```java
public class HelloWorld {          // Class declaration
    public static void main(...) { // Entry point
        // Code executes here when you run: java HelloWorld
        System.out.println("Hello!");
    }
}
```

When you run `java HelloWorld`:
1. JVM loads the class
2. Searches for `main` method
3. Executes code inside main() from top to bottom
4. Program ends when main() finishes

### Common Mistakes
- Forgetting `static` → No entry point found
- Using `int main()` instead of `void main()` → Compilation error
- Wrong parameter: `main(String str)` instead of `main(String[] args)` → JVM won't find it
- Method name `start()` instead of `main()` → No entry point found
- Forgetting `[]` after String → Not an array, can't hold multiple arguments

---

## Concept 0.5: Compilation and Runtime Errors

### Why This Matters
Not all errors are the same. Some happen during compilation, some during execution. Understanding this helps you debug faster.

### Two Categories of Errors

**Compilation Errors** (Happen when you compile)
- Syntax errors: Missing semicolons, wrong brackets, typos
- Type errors: Using wrong type (String where int expected)
- Method not found: Calling a method that doesn't exist
- When: `javac` is running
- Result: No `.class` file created, can't run program

**Runtime Errors** (Happen when program runs)
- Logic errors: Code compiles but does wrong thing
- Null pointer exceptions: Trying to use null object
- Array index out of bounds: Accessing wrong index
- When: `java` is running
- Result: Program crashes mid-execution with error message

### Example Compilation Error

```java
public class BadCode {
    public static void main(String[] args) {
        System.out.println("Missing semicolon")  // ← Error: no semicolon
    }
}
```

When you run `javac BadCode.java`:
```
BadCode.java:3: error: ';' expected
        System.out.println("Missing semicolon")
                                             ^
1 error
```

Result: No `.class` file created

### Example Runtime Error

```java
public class RuntimeError {
    public static void main(String[] args) {
        String[] names = new String[2]; // Array with 2 spaces
        System.out.println(names[5]);   // ← Accessing index 5 (doesn't exist!)
    }
}
```

When you compile: Works fine (syntax is correct)
When you run: `java RuntimeError`
```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 2
```

### Key Difference
- **Compilation error** = I can't create .class file, fix your code
- **Runtime error** = .class created, but program crashes when running

---

## Concept 0.6: JVM Memory Basics (Preview)

### Why This Matters
The JVM manages memory for your program. Understanding where data goes helps you avoid mistakes later.

### Two Main Memory Areas

**Stack**
- Stores: Local variables, method calls
- Size: Limited, smaller
- Speed: Very fast
- Lifetime: Variables exist only while method runs
- Automatic cleanup: When method ends, variables disappear

**Heap**
- Stores: Objects, arrays
- Size: Larger, limited by system RAM
- Speed: Slower than stack
- Lifetime: Objects exist until no variables point to them
- Cleanup: Garbage collector removes unused objects

### Simple Analogy

Stack = A stack of plates. Take from top, add to top. Simple, fast, limited.
Heap = A scattered pile of boxes. Can access any box anytime. Bigger, messier.

### Preview Example

```java
int x = 5;           // Stack: x = 5
String name = "Bob"; // Stack: name points to → Heap: "Bob" object
```

We'll dive deep into this in Phase 2.

---

# PHASE 1: CORE FUNDAMENTALS

## Concept 1.1: Variables and Data Types (Primitives)

### Why This Matters
Variables store data. Java requires you to specify what type of data each variable holds. This prevents mistakes and makes code clear.

### What is a Variable?

A variable is a named container that holds data:
- Name: How you refer to it (`age`, `salary`, `isActive`)
- Type: What kind of data it holds (number, text, true/false)
- Value: The actual data stored

```
Variable name:    age
Type:            int (integer)
Value:           25
In code:         int age = 25;
```

### Eight Primitive Data Types in Java

| Type | Size | Range | Used For | Example |
|------|------|-------|----------|---------|
| `byte` | 1 byte | -128 to 127 | Small numbers, memory-critical | `byte b = 100;` |
| `short` | 2 bytes | -32,768 to 32,767 | Medium numbers | `short s = 1000;` |
| `int` | 4 bytes | -2.1B to 2.1B | Regular numbers, default | `int age = 25;` |
| `long` | 8 bytes | -9.2Q to 9.2Q | Very large numbers | `long population = 8000000000L;` |
| `float` | 4 bytes | ~7 decimal digits | Decimals, memory-critical | `float price = 19.99f;` |
| `double` | 8 bytes | ~15 decimal digits | Decimals, default | `double pi = 3.14159;` |
| `boolean` | 1 bit | true or false | Yes/no, on/off | `boolean isActive = true;` |
| `char` | 2 bytes | Any single character | Single character | `char grade = 'A';` |

### Most Important Types

**int** - Used 90% of the time for whole numbers
```java
int age = 25;
int population = 8000000;
```

**double** - Used 90% of the time for decimals
```java
double salary = 50000.50;
double temperature = 98.6;
```

**boolean** - Yes/no questions
```java
boolean isStudent = true;
boolean hasLicense = false;
```

**String** - Text (technically a reference type, not primitive, but so important)
```java
String name = "Alice";
String city = "New York";
```

### Declaring vs Initializing

**Declaration:** Telling Java the variable exists and its type
```java
int age;           // Declared, no value yet
```

**Initialization:** Giving it an initial value
```java
int age = 25;      // Declared AND initialized
```

**Key Rule:** You must initialize before using

```java
int score;
System.out.println(score);  // ← ERROR: score has no value yet

int score = 0;
System.out.println(score);  // ← OK: score = 0
```

### Variable Naming Rules

**Must Follow:**
- Start with letter, underscore, or dollar sign
- Continue with letters, digits, underscore
- Case-sensitive: `age` ≠ `Age` ≠ `AGE`
- No spaces or special characters
- Cannot use Java keywords

**Good Names:**
```java
int age;           // Clear
int studentAge;    // Clear, CamelCase
int DAYS_PER_WEEK; // Clear, constants use CAPS
```

**Bad Names:**
```java
int a;             // Too vague
int 1age;          // Starts with number
int age-value;     // Hyphen not allowed
int class;         // 'class' is a keyword
```

### Type Casting (Introduction)

Sometimes you need to convert one type to another.

**Implicit Cast** (automatic, no data loss):
```java
int age = 25;
double ageDouble = age;  // int → double automatically
// ageDouble is now 25.0
```

**Explicit Cast** (you must write it):
```java
double price = 19.99;
int priceInt = (int) price;  // double → int (data loss!)
// priceInt is 19 (decimal part lost)
```

The `(int)` is the cast operator telling Java "I know what I'm doing."

### Common Mistakes
- Initializing `int x = 5.5;` → Error: can't assign double to int without casting
- Using keyword as variable name: `int int = 5;` → Error: 'int' is a keyword
- Space in variable name: `int my age = 25;` → Error: spaces not allowed
- Forgetting semicolon: `int x = 5` → Syntax error
- Using uninitialized variable: `int x; System.out.println(x);` → Error: x has no value

---

## Concept 1.2: Operators and Expressions

### Why This Matters
Operators let you perform actions on variables: math, comparisons, logical operations. Understanding operator precedence prevents logic errors.

### Arithmetic Operators

Used for mathematical operations.

```java
int a = 10;
int b = 3;

int add = a + b;        // 13 (addition)
int subtract = a - b;   // 7 (subtraction)
int multiply = a * b;   // 30 (multiplication)
int divide = a / b;     // 3 (integer division, not 3.33)
int remainder = a % b;  // 1 (modulo: remainder of 10 ÷ 3)
```

**Important: Integer Division**
```java
int result = 10 / 3;    // Result is 3, not 3.33
// The decimal part is discarded

double result2 = 10.0 / 3;  // Result is 3.333... (at least one operand is double)
```

**Modulo (%)** - Very useful
```java
10 % 3 = 1   (remainder when 10 ÷ 3)
15 % 5 = 0   (15 ÷ 5 divides evenly)
7 % 2 = 1    (check if number is odd)
```

### Increment and Decrement

**Increment (++)**
```java
int x = 5;
x++;        // x becomes 6
++x;        // x becomes 7 (same result, different timing)
```

**Decrement (--)**
```java
int x = 5;
x--;        // x becomes 4
--x;        // x becomes 3
```

**Important: Post vs Pre increment**
```java
int x = 5;
int y = x++;   // y = 5, then x becomes 6
int z = ++x;   // x becomes 7, then z = 7
```

Most of the time, use `x++` or `x--`.

### Comparison Operators

Used to compare values. Return true or false.

```java
int a = 10;
int b = 5;

a == b    // false (not equal)
a != b    // true (not equal)
a > b     // true (greater than)
a < b     // false (less than)
a >= b    // true (greater than or equal)
a <= b    // false (less than or equal)
```

**Key Difference:**
- `=` is assignment (stores value)
- `==` is comparison (checks equality)

```java
int x = 5;       // Assignment: x now equals 5
x == 5;          // Comparison: is x equal to 5? (true)
```

### Logical Operators

Used to combine conditions.

**AND (&&)** - Both must be true
```java
boolean result = (age > 18) && (hasLicense);
// true only if BOTH age > 18 AND hasLicense is true
```

**OR (||)** - At least one must be true
```java
boolean result = (isWeekend) || (isHoliday);
// true if EITHER isWeekend OR isHoliday is true
```

**NOT (!)** - Reverses the truth value
```java
boolean isMorning = true;
boolean isAfternoon = !isMorning;  // false
```

### Operator Precedence (Order of Operations)

Operations are performed in this order:
1. Parentheses `()`
2. Multiplication, Division, Modulo `*`, `/`, `%`
3. Addition, Subtraction `+`, `-`
4. Comparison `<`, `>`, `<=`, `>=`
5. Equality `==`, `!=`
6. AND `&&`
7. OR `||`

```java
int result = 2 + 3 * 4;  // Multiply first: 2 + 12 = 14, not 5 * 4
int result2 = (2 + 3) * 4;  // Parentheses first: 5 * 4 = 20
```

### String Concatenation with +

The `+` operator has special meaning with Strings:

```java
String name = "Alice";
int age = 25;
String message = name + " is " + age + " years old";
// message = "Alice is 25 years old"

// With numbers
int x = 5;
int y = 3;
System.out.println(x + y);          // 8 (arithmetic addition)
System.out.println(x + " + " + y);  // "5 + 3" (string concatenation)
```

### Common Mistakes
- Using `=` instead of `==`: `if (x = 5)` → Assigns instead of compares
- Using `&&` when `&` meant: `&&` checks left first, `&` checks both (different)
- Integer division: `int result = 10 / 3;` → Result is 3, not 3.33
- Uninitialized operator: `int x; int y = x + 5;` → Error: x has no value
- Comparing Strings with `==`: `if (str == "hello")` → Use `.equals()` instead

---

## Concept 1.3: Control Flow - if, else if, else

### Why This Matters
Programs make decisions based on conditions. if/else lets your code execute different code depending on what's true or false.

### Basic if Statement

Execute code only IF a condition is true:

```java
int age = 25;

if (age >= 18) {
    System.out.println("You are an adult");
}
```

If `age >= 18` is true, the code inside `{}` runs.
If false, the code inside `{}` is skipped.

### if...else Statement

Execute one block if condition is true, another if false:

```java
int age = 15;

if (age >= 18) {
    System.out.println("You are an adult");
} else {
    System.out.println("You are a minor");
}
```

Exactly one block runs (not both).

### if...else if...else Statement

Check multiple conditions:

```java
int score = 75;

if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else {
    System.out.println("Grade: F");
}
```

Conditions are checked top to bottom. First true condition runs. Rest are skipped.

### Switch Statement

More readable when checking one variable against many values:

```java
int dayOfWeek = 3;
String dayName;

switch (dayOfWeek) {
    case 1:
        dayName = "Monday";
        break;
    case 2:
        dayName = "Tuesday";
        break;
    case 3:
        dayName = "Wednesday";
        break;
    default:
        dayName = "Unknown";
}

System.out.println(dayName);  // "Wednesday"
```

**Important: `break` statement**
- Exits the switch immediately
- Without `break`, execution falls through to next case (usually wrong)

```java
int x = 1;
switch (x) {
    case 1:
        System.out.println("One");
        // Missing break!
    case 2:
        System.out.println("Two");
        break;
    case 3:
        System.out.println("Three");
}
// Output: "One" and "Two" (falls through!)
```

### Nested if Statements

if statements inside if statements:

```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("Can drive");
    } else {
        System.out.println("Adult but no license");
    }
} else {
    System.out.println("Too young to drive");
}
```

### Common Mistakes
- Forgetting curly braces: `if (x > 5) x = 0;` works but `if (x > 5) x = 0; y = 1;` → Only first statement is inside if
- Using `=` instead of `==`: `if (x = 5)` assigns instead of compares
- Forgetting `break` in switch: Code falls through to next case
- Wrong condition logic: `if (x >= 1 && x <= 10)` for range, not `if (x >= 1 || x <= 10)`

---

## Concept 1.4: Loops - for, while, do-while

### Why This Matters
Loops execute the same code multiple times. Without loops, you'd copy-paste the same code over and over.

### for Loop

Execute code a specific number of times:

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Count: " + i);
}

// Output:
// Count: 0
// Count: 1
// Count: 2
// Count: 3
// Count: 4
```

**Breaking down the for loop:**
```java
for (initialization; condition; update) {
    // Code runs here repeatedly
}
```

- **Initialization:** `int i = 0` → Create loop variable, set to 0
- **Condition:** `i < 5` → Check before each iteration
- **Update:** `i++` → Execute after each iteration
- **Body:** Code between `{}`

### How for Loop Executes (Step by Step)

```
Iteration 1: i = 0, check 0 < 5 (true), run body, then i++
Iteration 2: i = 1, check 1 < 5 (true), run body, then i++
Iteration 3: i = 2, check 2 < 5 (true), run body, then i++
Iteration 4: i = 3, check 3 < 5 (true), run body, then i++
Iteration 5: i = 4, check 4 < 5 (true), run body, then i++
Check: i = 5, check 5 < 5 (false), exit loop
```

### while Loop

Execute code while condition is true:

```java
int i = 0;
while (i < 5) {
    System.out.println("Count: " + i);
    i++;
}
```

Checks condition BEFORE each iteration. If false, exits immediately.

**Infinite Loop (accidental):**
```java
int i = 0;
while (true) {
    System.out.println(i);
    // Missing i++ → loop never ends!
}
```

### do-while Loop

Execute code, then check condition. Code runs at least once:

```java
int i = 0;
do {
    System.out.println("Count: " + i);
    i++;
} while (i < 5);
```

**Difference:** while checks first, do-while checks last

```java
int i = 5;

// while: checks first, so doesn't run
while (i < 5) {
    System.out.println(i);  // Never runs
}

// do-while: runs first, then checks
do {
    System.out.println(i);  // Runs once
} while (i < 5);
```

### break and continue

**break** - Exit the loop immediately

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;  // Exit loop when i reaches 5
    }
    System.out.println(i);
}
// Output: 0 1 2 3 4
```

**continue** - Skip to next iteration

```java
for (int i = 0; i < 5; i++) {
    if (i == 2) {
        continue;  // Skip when i equals 2
    }
    System.out.println(i);
}
// Output: 0 1 3 4
```

### Common Mistakes
- Off-by-one error: `for (int i = 1; i <= 5; i++)` vs `for (int i = 0; i < 5; i++)`
- Infinite loop: Missing increment `while (x < 10) { /* no x++ */ }`
- Using `i` after loop: `for (int i = 0; ...) { } System.out.println(i);` → i doesn't exist outside loop (Java 5+)
- Confusing while and do-while: do-while always runs at least once

---

## Concept 1.5: Arrays

### Why This Matters
Arrays store multiple values of the same type in one variable. Without arrays, you'd need separate variables for each item.

### Creating an Array

```java
int[] numbers = new int[5];  // Array of 5 integers
```

Breaking this down:
- `int[]` = Type: array of integers
- `numbers` = Variable name
- `new int[5]` = Create array with 5 spaces
- Spaces are indexed 0, 1, 2, 3, 4

### Accessing Elements

```java
int[] numbers = new int[5];

numbers[0] = 10;   // First element
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;   // Last element

System.out.println(numbers[0]);  // 10
System.out.println(numbers[4]);  // 50
System.out.println(numbers[10]); // ERROR: index out of bounds
```

### Array Literal (Shorthand)

```java
int[] numbers = {10, 20, 30, 40, 50};
// Length is automatically 5
// No need for 'new int[5]'
```

### Array Properties

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers.length);  // 5 (number of elements)
```

### Looping Through Arrays

**Using for loop:**
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

**Using for-each loop (easier):**
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}
// num automatically gets each value
```

### Multidimensional Arrays

```java
int[][] matrix = new int[3][3];  // 3x3 grid

matrix[0][0] = 1;
matrix[0][1] = 2;
matrix[1][0] = 3;

int[][] grid = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(grid[1][2]);  // 6
```

### Strings are Like Arrays

```java
String name = "Alice";

name.length();      // 5 (number of characters)
name.charAt(0);     // 'A' (character at index 0)
name.charAt(4);     // 'e' (character at index 4)
name.substring(0, 3);  // "Ali" (characters 0-2)
```

### Common Mistakes
- Array index out of bounds: `int[] arr = new int[5]; arr[5]` → Index 5 doesn't exist
- Using `size()` instead of `length`: Arrays use `.length`, collections use `.size()`
- Forgetting `new`: `int[] arr;` declares but doesn't create; need `new int[5]`
- 0-based indexing: First element is index 0, not 1

---

# PHASE 2: METHODS & MEMORY

## Concept 2.1: Methods - Declaration and Calling

### Why This Matters
Methods let you break code into reusable pieces. Instead of writing the same code twice, write it once in a method and call it multiple times.

### Method Basics

```java
public class Calculator {
    // Method declaration
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Method call
        int result = add(5, 3);
        System.out.println(result);  // 8
    }
}
```

### Breaking Down Method Syntax

```java
public static int add(int a, int b) {
    return a + b;
}
```

- `public` = Accessible everywhere (covered in Phase 4)
- `static` = Called on class, not objects (covered in Phase 4)
- `int` = Return type: this method returns an integer
- `add` = Method name
- `(int a, int b)` = Parameters: what information the method needs
- `return a + b;` = What the method gives back

### Method Parameters and Arguments

**Parameters** = Variables in the method definition
**Arguments** = Values passed when calling

```java
public static void greet(String name) {  // 'name' is parameter
    System.out.println("Hello, " + name);
}

greet("Alice");  // "Alice" is argument
greet("Bob");    // "Bob" is argument
```

### Return Values

```java
public static int multiply(int a, int b) {
    int result = a * b;
    return result;  // Sends value back to caller
}

int product = multiply(4, 5);
System.out.println(product);  // 20
```

**void** = Method returns nothing

```java
public static void printMessage(String msg) {
    System.out.println(msg);
    // No return statement needed
}

printMessage("Hello");  // Just call it
String x = printMessage("Hi");  // ERROR: void returns nothing
```

### Method Overloading

Multiple methods with same name but different parameters:

```java
public class Math {
    public static int add(int a, int b) {
        return a + b;  // Adds two integers
    }

    public static double add(double a, double b) {
        return a + b;  // Adds two doubles
    }

    public static int add(int a, int b, int c) {
        return a + b + c;  // Adds three integers
    }
}

// Java knows which to call based on argument types
int result1 = add(5, 3);           // Calls add(int, int)
double result2 = add(5.5, 3.2);    // Calls add(double, double)
int result3 = add(5, 3, 2);        // Calls add(int, int, int)
```

Java chooses the correct method based on argument types.

### Common Mistakes
- Forgetting return type: `public add(int a, int b)` → Must specify return type
- Forgetting return statement: Method returns void by mistake
- Parameter vs argument confusion: Parameters in definition, arguments in call
- Overloading with only return type different: `int add(int a, int b)` and `double add(int a, int b)` → Not allowed

---

## Concept 2.2: Stack vs Heap Memory

### Why This Matters
Understanding where data lives in memory helps you understand Java behavior and debug memory-related issues.

### Stack Memory

Where **primitive variables** and **local variables** are stored.

**Characteristics:**
- Very fast access
- Limited size
- Variables exist only during method execution
- Automatically cleaned up when method ends
- LIFO: Last In, First Out (like a stack of plates)

**Example:**
```java
public static void main(String[] args) {
    int x = 5;      // Stack: x = 5
    int y = 10;     // Stack: y = 10
    int sum = x + y; // Stack: sum = 15

    printNumber(sum);  // Method call
    // After method ends: x, y, sum disappear
}

public static void printNumber(int num) {
    System.out.println(num);  // Stack: num = 15
    // When this method ends, num disappears
}
```

When `main()` starts, the stack grows:
```
[int x = 5]
[int y = 10]
[int sum = 15]
[int num = 15]  ← From printNumber call
```

When each method ends, its variables are popped off the stack.

### Heap Memory

Where **objects** and **arrays** are stored.

**Characteristics:**
- Slower access than stack
- Larger size
- Objects exist until no variables reference them
- Garbage collector removes unused objects
- Random access: any object anytime

**Example:**
```java
public static void main(String[] args) {
    String name = "Alice";  // Stack: name points to → Heap: "Alice" object
    int[] numbers = {1, 2, 3};  // Stack: numbers points to → Heap: array
}
```

Visual representation:
```
STACK              HEAP
name ─────────→ "Alice" (String object)
numbers ──────→ [1, 2, 3] (array object)
```

### Reference Variables

Primitive variables hold values. Reference variables hold addresses:

```java
int x = 5;        // x contains 5
String s = "Bob"; // s contains address of "Bob" object in heap
```

When you assign one reference variable to another:
```java
String name1 = "Alice";
String name2 = name1;  // name2 points to same "Alice" object

// name1 and name2 reference the same object
```

NOT:
```java
String name1 = "Alice";
String name2 = name1;  // name2 is a copy of the reference, NOT a copy of the string
// Modifying name1 doesn't change name2 (strings are immutable anyway)
```

### Memory Cleanup

**Stack:** Automatic. When method ends, variables disappear.
```java
public static void example() {
    int x = 5;  // Stack
}  // x is automatically removed from stack
```

**Heap:** Garbage Collector. When no variables reference an object, it's eventually removed.
```java
String name = "Alice";  // Heap: "Alice" object created
name = "Bob";           // Heap: "Bob" object created, "Alice" unreferenced
                        // Garbage collector will eventually remove "Alice"
```

### Common Mistakes
- Assuming objects are copied: `String s1 = "Alice"; String s2 = s1;` → Both reference same object
- Stack overflow: Infinite recursion fills stack
- Memory leak: Keeping references to unused objects (rare in Java)
- Null pointer exception: Using object that doesn't exist

---

## Concept 2.3: Pass-by-Value

### Why This Matters
Java passes copies of values to methods. Understanding this prevents confusion about whether method can modify original variable.

### What is Pass-by-Value?

Java makes a **copy** of the value and passes the copy. Changes to the copy don't affect the original.

### Primitives are Passed by Value

```java
public static void changeValue(int x) {
    x = 100;  // Change the copy
}

public static void main(String[] args) {
    int original = 5;
    changeValue(original);
    System.out.println(original);  // Still 5, not changed!
}
```

Visual flow:
```
main() has: original = 5
            ↓
changeValue(original) called
            ↓
changeValue gets a COPY: x = 5
            ↓
Inside changeValue: x = 100 (only the copy changed)
            ↓
Return to main()
            ↓
original is still 5
```

The method received a copy. Modifying the copy doesn't touch the original.

### Objects are Passed by Value (But It's Tricky)

Reference variables are also passed by value, but the value is an address:

```java
public static void changeName(String str) {
    str = "Bob";  // Change the copy's address
}

public static void main(String[] args) {
    String name = "Alice";
    changeName(name);
    System.out.println(name);  // Still "Alice"!
}
```

The method gets a copy of the address, not the object itself:
```
main() has: name (address of "Alice" object)
            ↓
changeName(name) called
            ↓
changeName gets a COPY of the address
            ↓
Inside changeName: str = (address of "Bob" object)
                   (only the copy changed)
            ↓
Return to main()
            ↓
name still points to "Alice"
```

### Arrays are Objects Too

```java
public static void modifyArray(int[] arr) {
    arr[0] = 999;  // Modify the actual array
}

public static void main(String[] args) {
    int[] numbers = {1, 2, 3};
    modifyArray(numbers);
    System.out.println(numbers[0]);  // 999 (changed!)
}
```

Why? The method gets a copy of the address, but both copies point to the same array:
```
main() has: numbers (address of array [1, 2, 3])
            ↓
modifyArray(numbers) called
            ↓
modifyArray gets a COPY of the address
            ↓
Inside modifyArray: arr points to same array
                    arr[0] = 999 modifies the actual array
            ↓
Return to main()
            ↓
numbers[0] is now 999 (same array was modified)
```

### Key Insight

```
Pass-by-value means:
- Primitives: copy of value. Changes don't affect original.
- Objects: copy of address. Can modify object contents, but can't change what the original reference points to.
```

### Common Mistakes
- Thinking objects can be changed: `changeString(s)` won't change s's value because strings are immutable
- Expecting array changes to revert: Method modifies array, changes stick
- Confusion with return values: Method doesn't need to return to modify arrays/objects

---

# PHASE 3: OBJECT-ORIENTED PROGRAMMING

## Concept 3.1: Classes and Objects

### Why This Matters
Classes let you create custom data types that bundle data (variables) with behavior (methods). Objects are instances of classes.

### Classes vs Objects

**Class:** A blueprint or template
```java
public class Car {
    // Template: what every car should have
}
```

**Object:** An actual instance based on the blueprint
```java
Car myCar = new Car();  // Create an object from the blueprint
```

Analogy: Class is a recipe, object is a cake made from that recipe.

### Simple Class Example

```java
public class Dog {
    // Variables (data)
    String name;
    int age;

    // Method (behavior)
    public void bark() {
        System.out.println(name + " says woof!");
    }
}
```

### Creating Objects

```java
public class Main {
    public static void main(String[] args) {
        // Create object 1
        Dog dog1 = new Dog();
        dog1.name = "Buddy";
        dog1.age = 3;
        dog1.bark();  // Buddy says woof!

        // Create object 2
        Dog dog2 = new Dog();
        dog2.name = "Max";
        dog2.age = 5;
        dog2.bark();  // Max says woof!
    }
}
```

Breaking down `new Dog()`:
- `new` = Create a new object
- `Dog()` = Call constructor (we'll explain next)
- `=` Store the reference in dog1

### Object Memory

Each object is independent:
```
dog1 (Stack) ─────→ Object in Heap
                   name = "Buddy"
                   age = 3

dog2 (Stack) ─────→ Object in Heap
                   name = "Max"
                   age = 5
```

Changing dog1's data doesn't affect dog2.

---

## Concept 3.2: Constructors

### Why This Matters
Constructors initialize objects. Instead of creating an object then manually setting values, a constructor does it all at once.

### Default Constructor

If you don't write a constructor, Java provides a default (empty) one:

```java
public class Dog {
    String name;
    int age;

    // Java automatically provides:
    // public Dog() { }
}

Dog dog = new Dog();  // Works, but name and age are uninitialized
```

### Custom Constructor

Write your own to initialize values:

```java
public class Dog {
    String name;
    int age;

    // Constructor: same name as class, no return type
    public Dog(String n, int a) {
        name = n;
        age = a;
    }
}

Dog dog = new Dog("Buddy", 3);  // Initialize while creating
System.out.println(dog.name);   // Buddy
```

### Constructor Overloading

Multiple constructors with different parameters:

```java
public class Dog {
    String name;
    int age;

    // Constructor 1: takes name and age
    public Dog(String n, int a) {
        name = n;
        age = a;
    }

    // Constructor 2: takes only name
    public Dog(String n) {
        name = n;
        age = 0;
    }

    // Constructor 3: no parameters
    public Dog() {
        name = "Unknown";
        age = 0;
    }
}

Dog dog1 = new Dog("Buddy", 3);
Dog dog2 = new Dog("Max");
Dog dog3 = new Dog();
```

### Constructor Chaining (Advanced)

```java
public class Dog {
    String name;
    int age;
    String breed;

    // Constructor 1: all parameters
    public Dog(String n, int a, String b) {
        name = n;
        age = a;
        breed = b;
    }

    // Constructor 2: use this() to call another constructor
    public Dog(String n, int a) {
        this(n, a, "Unknown");  // Call constructor 1
    }

    // Constructor 3: minimal
    public Dog(String n) {
        this(n, 0);  // Call constructor 2
    }
}
```

`this(...)` calls another constructor in the same class.

### Common Mistakes
- Constructor with return type: `public void Dog() { }` → NO return type
- Wrong constructor name: `public dog() { }` → Must match class name exactly
- Constructor not returning value: Constructors don't return (not even void)

---

## Concept 3.3: The this Keyword

### Why This Matters
`this` refers to the current object. It's useful when parameter names match variable names and for accessing object members.

### Using this to Avoid Confusion

```java
public class Dog {
    String name;
    int age;

    // Without this: confusing which 'name' is which
    public Dog(String name, int age) {
        this.name = name;  // this.name = the object's name variable
                          // name = the parameter
        this.age = age;
    }
}
```

Inside the constructor:
- `name` (parameter) = the value passed in
- `this.name` (instance variable) = the object's data
- `this.age` (instance variable) = the object's age

### Calling Methods with this

```java
public class Dog {
    String name;

    public void greet() {
        this.bark();  // Call another method on this object
    }

    public void bark() {
        System.out.println(name + " says woof!");
    }
}
```

### Returning this

Methods can return `this` to enable chaining:

```java
public class Dog {
    String name;
    int age;

    public Dog setName(String name) {
        this.name = name;
        return this;  // Return the object itself
    }

    public Dog setAge(int age) {
        this.age = age;
        return this;
    }
}

// Chaining: set multiple values in one statement
Dog dog = new Dog()
    .setName("Buddy")
    .setAge(3);
```

### this() for Constructor Chaining

Already covered in 3.2, but important:

```java
public class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        this(name, 0);  // Call another constructor
    }
}
```

---

## Concept 3.4: Encapsulation

### Why This Matters
Encapsulation protects an object's data by restricting direct access. Users interact through controlled methods, not raw variables.

### The Problem Without Encapsulation

```java
public class BankAccount {
    public int balance;  // Anyone can access directly
}

BankAccount account = new BankAccount();
account.balance = 1000000;  // Oops! Set balance directly
account.balance = -999999;  // Oops! Can't prevent invalid values
```

Without protection, anyone can corrupt the object's state.

### Solution: Private Variables, Public Methods

```java
public class BankAccount {
    private int balance;  // Hidden from outside

    // Constructor
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Controlled access: get the balance
    public int getBalance() {
        return balance;
    }

    // Controlled access: deposit safely
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Controlled access: withdraw safely
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.balance = -999;  // ERROR: balance is private
        account.deposit(500);     // OK: proper method
        account.withdraw(200);    // OK: proper method

        System.out.println(account.getBalance());  // 1300
    }
}
```

**Access Modifiers:**
- `public` = Anyone can access
- `private` = Only inside this class

### Getters and Setters

Standard pattern for controlled access:

```java
public class Person {
    private int age;

    // Getter: read the value
    public int getAge() {
        return age;
    }

    // Setter: write the value (with validation)
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }
}

Person p = new Person();
p.setAge(25);           // OK
p.setAge(-5);          // Rejected by validation
System.out.println(p.getAge());  // 25
```

### Benefits of Encapsulation

1. **Validation:** Control what values are acceptable
2. **Consistency:** Ensure object is always in valid state
3. **Flexibility:** Change implementation without breaking client code
4. **Abstraction:** Users don't need to know implementation details

### Common Mistakes
- Making variables public by default: `String name;` should be `private String name;`
- Setters with no validation: Allows invalid states
- Confusing getter names: Use `getName()` not `name()`

---

## Concept 3.5: Inheritance

### Why This Matters
Inheritance lets you create a hierarchy of classes. Child classes inherit data and methods from parent classes, reducing code duplication.

### Parent and Child Classes

```java
// Parent class (superclass)
public class Animal {
    String name;

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class (subclass)
public class Dog extends Animal {
    public void bark() {
        System.out.println(name + " is barking");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Buddy";

        dog.eat();    // Inherited from Animal
        dog.sleep();  // Inherited from Animal
        dog.bark();   // Defined in Dog
    }
}
```

Dog "extends" Animal, inheriting `eat()` and `sleep()` methods.

### Is-a Relationship

Inheritance models "is-a" relationships:
- Dog IS-A Animal
- Car IS-A Vehicle
- Student IS-A Person

Not:
- Car HAS-A Engine (use composition instead)

### Calling Parent Constructor

```java
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}

public class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);  // Call parent constructor
        this.breed = breed;
    }
}

Dog dog = new Dog("Buddy", "Labrador");
System.out.println(dog.name);   // Buddy (from parent)
System.out.println(dog.breed);  // Labrador (from child)
```

`super(name)` calls the parent class constructor.

### Inheritance Hierarchy

```
        Animal
         /  |  \
       Dog  Cat  Bird
      / |
    Pug Bulldog
```

All inherit from Animal. Dogs further specialize into Pug and Bulldog.

### Common Mistakes
- Circular inheritance: Class A extends B, B extends A → Compilation error
- Forgetting super(): Parent constructor not called
- Deep inheritance: Too many levels makes code hard to follow

---

## Concept 3.6: Polymorphism and Method Overriding

### Why This Matters
Polymorphism (many forms) means one method call can behave differently depending on the object type. This is powerful abstraction.

### Method Overriding

Child class provides its own version of a parent method:

```java
public class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

public class Dog extends Animal {
    @Override  // Annotation: tells Java this intentionally overrides parent
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound();  // Woof!
        cat.makeSound();  // Meow!
    }
}
```

Same method name, different behavior depending on actual object type.

### Polymorphic References

```java
Animal[] animals = new Animal[3];
animals[0] = new Dog();
animals[1] = new Cat();
animals[2] = new Animal();

for (Animal animal : animals) {
    animal.makeSound();
}

// Output:
// Woof!
// Meow!
// Some generic sound
```

The loop doesn't know what type each animal is, but the correct method runs anyway. This is polymorphism's power.

### Overriding vs Overloading

**Overriding** (same signature, child class):
```java
// Parent
public void makeSound() { ... }

// Child
public void makeSound() { ... }  // Override
```

**Overloading** (different signature, same class):
```java
public void eat() { ... }
public void eat(String food) { ... }  // Overload
```

### @Override Annotation

Good practice to mark overridden methods:

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```

If you misspell the method name, Java catches the error:
```java
@Override
public void makeSount() { }  // ERROR: method doesn't override anything
```

### Common Mistakes
- Forgetting to override but thinking you did: Method signature is different
- Changing return type: Can only change to subtype (covariant)
- Making overridden method more restrictive: Can't change public to private

---

## Concept 3.7: Abstract Classes

### Why This Matters
Abstract classes are templates that force child classes to implement certain methods. They can't be instantiated directly.

### Abstract Class Definition

```java
public abstract class Animal {
    String name;

    // Abstract method: no body, must be implemented by child
    public abstract void makeSound();

    // Regular method: already implemented
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Can't do this:
Animal animal = new Animal();  // ERROR: can't instantiate abstract class
```

### Implementing Abstract Methods

```java
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Now OK:
Animal dog = new Dog();
Animal cat = new Cat();

dog.makeSound();  // Woof!
cat.makeSound();  // Meow!
```

### Abstract Class Benefits

1. **Contract:** Forces all child classes to implement certain methods
2. **Code reuse:** Common code in parent, special in child
3. **Polymorphism:** Treat different types uniformly

### Abstract Class vs Concrete Class

**Abstract:** Can't instantiate, must extend
```java
public abstract class Shape { }
```

**Concrete:** Can instantiate
```java
public class Circle extends Shape { }
Circle c = new Circle();  // OK
```

### Common Mistakes
- Forgetting to implement abstract methods in child class
- Making abstract method have implementation (defeats purpose)
- Trying to instantiate abstract class

---

# PHASE 4: CORE LANGUAGE FEATURES

## Concept 4.1: Interfaces

### Why This Matters
Interfaces define contracts: what methods must exist, without specifying how. They enable powerful design patterns and loose coupling.

### Interface Definition

```java
public interface Animal {
    // Abstract methods (no body)
    void makeSound();
    void eat();

    // Default method (optional, with body)
    default void sleep() {
        System.out.println("Zzz...");
    }
}
```

### Implementing an Interface

```java
public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void eat() {
        System.out.println("Eating dog food");
    }
}

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void eat() {
        System.out.println("Eating cat food");
    }
}

Animal dog = new Dog();
Animal cat = new Cat();

dog.makeSound();  // Woof!
cat.makeSound();  // Meow!
```

### Multiple Interfaces

A class can implement multiple interfaces (unlike extending one class):

```java
public interface Drawable {
    void draw();
}

public interface Moveable {
    void move();
}

public class Car implements Drawable, Moveable {
    @Override
    public void draw() {
        System.out.println("Drawing a car");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

Car car = new Car();
car.draw();  // Drawing a car
car.move();  // Car is moving
```

### Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|---------|-----------|-----------------|
| Instantiate | No | No |
| Methods | Abstract only (before Java 8) | Abstract and concrete |
| Variables | static final only | Any access level |
| Inheritance | Multiple interfaces allowed | Single abstract class |
| Use Case | Contract/capability | Parent-child relationship |

**Use interface when:** Defining what a class SHOULD DO
**Use abstract class when:** Defining what a class IS

### Common Mistakes
- Interface methods public by default: Don't need to write `public`
- Forgetting `implements` keyword: Use `implements` not `extends` for interfaces
- Not implementing all methods: All abstract methods must be implemented

---

## Concept 4.2: The final Keyword

### Why This Matters
`final` prevents modification. It can be applied to variables, methods, and classes.

### final Variables

Constant: value can't be changed after initialization:

```java
public class Constants {
    final int MAX_SIZE = 100;  // Can't be changed

    public void example() {
        MAX_SIZE = 200;  // ERROR: can't reassign
    }
}
```

Naming convention: Use UPPERCASE for constants:

```java
public class Constants {
    public static final double PI = 3.14159;
    public static final int DAYS_PER_WEEK = 7;
}
```

### final Methods

Method can't be overridden:

```java
public class Parent {
    public final void importantMethod() {
        System.out.println("This behavior is fixed");
    }
}

public class Child extends Parent {
    @Override
    public void importantMethod() {  // ERROR: can't override final method
        System.out.println("Different behavior");
    }
}
```

### final Classes

Class can't be extended:

```java
public final class Immutable {
    // No class can extend this
}

public class Child extends Immutable {  // ERROR: can't extend final class
    // ...
}
```

Example: String class is final (can't create custom String subclass).

### Real-World Scenarios

```java
// Protect critical class from modification
public final class SecurityKey {
    private final String secret;  // Can't change after creation

    public SecurityKey(String secret) {
        this.secret = secret;
    }
}

// Define unchangeable constant
public static final int MAX_ATTEMPTS = 3;
```

---

## Concept 4.3: The static Keyword

### Why This Matters
`static` means "belongs to the class, not to objects." It's used for shared data and utility methods.

### static Variables

Variable shared by all objects of the class:

```java
public class Car {
    static int totalCars = 0;  // Shared by all Car objects
    String color;              // Each object has its own color

    public Car(String color) {
        this.color = color;
        totalCars++;  // Increment shared counter
    }
}

Car car1 = new Car("Red");
Car car2 = new Car("Blue");

System.out.println(Car.totalCars);  // 2
```

All Car objects share one `totalCars` variable.

### static Methods

Method called on the class, not on objects:

```java
public class Math {
    public static int add(int a, int b) {
        return a + b;
    }
}

// Called on class, not object
int result = Math.add(5, 3);  // 8

// Can't do this:
Math math = new Math();
math.add(5, 3);  // Possible but bad practice
```

### When to Use static

**static variables:**
- Counters: total number of objects created
- Constants: values shared by all objects
- Configuration: global settings

**static methods:**
- Utility functions: don't need object state (Math.sqrt, Math.max)
- Factory methods: create objects

### Common Mistakes
- Using this in static method: `static void method() { this.x = 5; }` → ERROR
- Accessing instance variable in static method: static has no `this`
- Making everything static: Defeats purpose of objects

---

## Concept 4.4: Access Modifiers and Packages

### Why This Matters
Access modifiers control visibility. They're essential for encapsulation and API design.

### Four Access Levels

| Modifier | Same Class | Same Package | Child Class | Everywhere |
|----------|-----------|-------------|-----------|-----------|
| `public` | ✓ | ✓ | ✓ | ✓ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| (default/package) | ✓ | ✓ | ✗ | ✗ |
| `private` | ✓ | ✗ | ✗ | ✗ |

### Examples

```java
public class Person {
    public String name;          // Accessible everywhere
    protected int age;           // Accessible in package and subclasses
    String phoneNumber;          // Accessible in package only (default)
    private String password;     // Accessible only in this class
}
```

### public

Most visible, use for API:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

### private

Least visible, use for implementation:

```java
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;  // Only this class can access balance
    }
}
```

### Packages

Organize classes into namespaces:

```java
// File: com/example/game/Player.java
package com.example.game;

public class Player {
    // ...
}

// File: com/example/game/Main.java
package com.example.game;

public class Main {
    Player p = new Player();  // Same package, no import needed
}
```

### Import Statements

```java
// Import one class
import java.util.ArrayList;

// Import all classes from package
import java.util.*;

public class Example {
    ArrayList<String> list = new ArrayList<>();
}
```

### Common Mistakes
- Default (no modifier) not truly private: `private` is different from default
- Making everything public: Reduces encapsulation
- Not using packages: All classes in default package is bad practice

---

## Concept 4.5: equals() and hashCode()

### Why This Matters
Default equality checks reference, not content. Overriding equals() and hashCode() enables proper object comparison.

### The Problem: Default equals()

```java
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Person p1 = new Person("Alice", 25);
Person p2 = new Person("Alice", 25);

System.out.println(p1 == p2);           // false (different objects)
System.out.println(p1.equals(p2));      // false (default equals checks reference)
```

Two people with same name and age are not equal (by default).

### Overriding equals()

```java
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if same object
        if (this == obj) return true;

        // Check if null or different class
        if (obj == null || getClass() != obj.getClass()) return false;

        // Cast and compare fields
        Person person = (Person) obj;
        return name.equals(person.name) && age == person.age;
    }
}

Person p1 = new Person("Alice", 25);
Person p2 = new Person("Alice", 25);

System.out.println(p1.equals(p2));  // true (content matches)
```

### hashCode()

When equals() is overridden, hashCode() should be too:

```java
@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

hashCode() is used in HashMaps and HashSets for efficient lookup.

### Contract

If two objects are equal:
- `equals()` returns true
- `hashCode()` returns same value

If `equals()` is true, `hashCode()` MUST be same.

### Common Mistakes
- Overriding equals() without hashCode(): Breaks HashMaps/HashSets
- Using `==` instead of `.equals()`: Checks reference, not content
- Forgetting to cast in equals(): `Person person = (Person) obj;`

---

# PHASE 5: COLLECTIONS & GENERICS

## Concept 5.1: Arrays vs Collections

### Why This Matters
Arrays are fixed-size. Collections are dynamic. Understanding differences helps you choose the right tool.

### Arrays (Review)

```java
int[] numbers = new int[5];  // Fixed size: 5
numbers[0] = 10;

System.out.println(numbers.length);  // 5
```

**Limitations:**
- Fixed size (can't grow or shrink)
- Only one type (int[] is all integers)
- Low-level (no built-in methods like add(), remove())

### Collections Framework

Dynamic, flexible alternatives to arrays:

```java
List<Integer> numbers = new ArrayList<>();  // Dynamic size

numbers.add(10);      // Add element
numbers.add(20);
numbers.add(30);

System.out.println(numbers.size());  // 3
numbers.remove(0);    // Remove by index
System.out.println(numbers.size());  // 2
```

### Main Collection Types

**List** - Ordered, allows duplicates
```java
List<String> names = new ArrayList<>();
```

**Set** - Unique values only
```java
Set<String> names = new HashSet<>();
```

**Map** - Key-value pairs
```java
Map<String, Integer> ages = new HashMap<>();
```

---

## Concept 5.2: Generics and Type Safety

### Why This Matters
Generics specify what type a collection holds, preventing errors at compile time instead of runtime.

### Without Generics (Old Java)

```java
List list = new ArrayList();  // No type specified
list.add("Hello");
list.add(123);
list.add(45.6);

for (Object obj : list) {
    String str = (String) obj;  // Unsafe cast!
    System.out.println(str);
}
// Runtime error: can't cast Integer to String
```

No compile-time check. Error appears only when running.

### With Generics (Modern Java)

```java
List<String> list = new ArrayList<>();  // Type specified
list.add("Hello");
list.add(123);  // ERROR: can't add Integer to List<String>
```

Compile-time error caught immediately.

### Generic Type Parameter

Angle brackets `< >` specify the type:

```java
List<String> names = new ArrayList<>();  // List of Strings
List<Integer> ages = new ArrayList<>();   // List of Integers
List<Double> prices = new ArrayList<>();  // List of Doubles
```

### Generic Collections

```java
// List
List<String> list = new ArrayList<>();
list.add("Alice");
list.add("Bob");
String first = list.get(0);  // "Alice" (no cast needed)

// Set
Set<Integer> uniqueNumbers = new HashSet<>();
uniqueNumbers.add(5);
uniqueNumbers.add(5);  // Ignored (duplicate)
System.out.println(uniqueNumbers.size());  // 1

// Map
Map<String, Integer> ages = new HashMap<>();
ages.put("Alice", 25);
ages.put("Bob", 30);
int aliceAge = ages.get("Alice");  // 25
```

### Benefits of Generics

1. **Type safety:** Catch errors at compile time
2. **No casting:** Compiler knows the type
3. **Readability:** Code is clearer

### Common Mistakes
- Forgetting type parameter: `List list = new ArrayList();` → No type safety
- Wrong type in initialization: `List<String> list = new ArrayList<Integer>();` → ERROR
- Mixing types: `List<String> list; list.add(123);` → ERROR

---

## Concept 5.3: List Interface

### Why This Matters
List is ordered, allows duplicates. It's the most common collection type.

### ArrayList (Dynamic Array)

```java
List<String> names = new ArrayList<>();

names.add("Alice");
names.add("Bob");
names.add("Charlie");

System.out.println(names.size());  // 3
System.out.println(names.get(0));  // "Alice"
System.out.println(names.get(1));  // "Bob"

names.remove(1);  // Remove "Bob"
System.out.println(names.size());  // 2

names.set(0, "Alicia");  // Change "Alice" to "Alicia"
System.out.println(names.get(0));  // "Alicia"
```

### LinkedList (Better for insert/delete)

```java
List<Integer> numbers = new LinkedList<>();

numbers.add(1);
numbers.add(2);
numbers.add(3);

numbers.add(1, 99);  // Insert 99 at index 1
// List is now [1, 99, 2, 3]

System.out.println(numbers);  // [1, 99, 2, 3]
```

### Iteration Methods

**for loop:**
```java
for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}
```

**for-each loop:**
```java
for (String name : names) {
    System.out.println(name);
}
```

**Iterator:**
```java
Iterator<String> it = names.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

### Common Methods

| Method | Purpose |
|--------|---------|
| `add(item)` | Add to end |
| `add(index, item)` | Insert at position |
| `remove(index)` | Remove by index |
| `remove(object)` | Remove by value |
| `get(index)` | Get by index |
| `set(index, item)` | Replace at index |
| `size()` | Number of elements |
| `contains(item)` | Check if contains |
| `clear()` | Remove all |

---

## Concept 5.4: Set Interface

### Why This Matters
Set stores unique values only. Automatically rejects duplicates.

### HashSet (No Order)

```java
Set<String> fruits = new HashSet<>();

fruits.add("apple");
fruits.add("banana");
fruits.add("apple");  // Duplicate, ignored

System.out.println(fruits.size());  // 2
System.out.println(fruits.contains("apple"));  // true

fruits.remove("banana");
System.out.println(fruits.size());  // 1
```

Order is not preserved:
```java
Set<Integer> numbers = new HashSet<>();
numbers.add(3);
numbers.add(1);
numbers.add(2);

System.out.println(numbers);  // [1, 2, 3] or [2, 1, 3]? No guaranteed order
```

### TreeSet (Sorted Order)

```java
Set<Integer> numbers = new TreeSet<>();

numbers.add(3);
numbers.add(1);
numbers.add(2);

System.out.println(numbers);  // [1, 2, 3] (sorted)

for (Integer num : numbers) {
    System.out.println(num);  // 1, then 2, then 3
}
```

### Common Set Methods

| Method | Purpose |
|--------|---------|
| `add(item)` | Add item |
| `remove(item)` | Remove item |
| `contains(item)` | Check if contains |
| `size()` | Number of unique items |
| `clear()` | Remove all |

### Set vs List

| Feature | List | Set |
|---------|------|-----|
| Duplicates | Allowed | Not allowed |
| Order | Preserved (ArrayList) or not (LinkedList) | No (HashSet) or sorted (TreeSet) |
| Access by index | Yes | No |
| Use case | Sequence of items | Unique values |

---

## Concept 5.5: Map Interface

### Why This Matters
Map stores key-value pairs. Look up values by key, not by index.

### HashMap (No Order)

```java
Map<String, Integer> ages = new HashMap<>();

ages.put("Alice", 25);
ages.put("Bob", 30);
ages.put("Charlie", 28);

System.out.println(ages.get("Alice"));  // 25
System.out.println(ages.size());        // 3

if (ages.containsKey("Bob")) {
    System.out.println("Bob is here");
}

ages.remove("Bob");
System.out.println(ages.size());  // 2
```

**Key points:**
- Keys must be unique
- Values can be duplicated
- No guaranteed order

### TreeMap (Sorted by Key)

```java
Map<String, Integer> ages = new TreeMap<>();

ages.put("Charlie", 28);
ages.put("Alice", 25);
ages.put("Bob", 30);

// Iterating gives sorted order by key
for (String name : ages.keySet()) {
    System.out.println(name + ": " + ages.get(name));
}

// Output:
// Alice: 25
// Bob: 30
// Charlie: 28
```

### Iterating Over Maps

**By key:**
```java
for (String key : map.keySet()) {
    System.out.println(key + ": " + map.get(key));
}
```

**By value:**
```java
for (Integer value : map.values()) {
    System.out.println(value);
}
```

**By entry:**
```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### Common Map Methods

| Method | Purpose |
|--------|---------|
| `put(key, value)` | Add/update |
| `get(key)` | Get value by key |
| `remove(key)` | Remove by key |
| `containsKey(key)` | Check if key exists |
| `size()` | Number of pairs |
| `keySet()` | All keys |
| `values()` | All values |
| `entrySet()` | All key-value pairs |

---

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
