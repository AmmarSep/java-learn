[All guides](README.md) · [Phase examples](../examples/01-fundamentals/README.md) · [Previous phase](00-getting-started.md) · [Next phase](02-methods-and-memory.md)

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

