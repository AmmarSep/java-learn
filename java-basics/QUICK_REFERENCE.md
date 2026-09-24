# Java Quick Reference Guide

A quick lookup for syntax and concepts while learning.

## Data Types

| Type | Size | Range | Example |
|------|------|-------|---------|
| byte | 1 byte | -128 to 127 | byte b = 10; |
| short | 2 bytes | -32,768 to 32,767 | short s = 1000; |
| int | 4 bytes | -2.1B to 2.1B | int x = 5; |
| long | 8 bytes | huge | long L = 5L; |
| float | 4 bytes | ~7 digits | float f = 5.5f; |
| double | 8 bytes | ~15 digits | double d = 5.5; |
| boolean | 1 bit | true/false | boolean b = true; |
| char | 2 bytes | single char | char c = 'A'; |
| String | varies | text | String s = "hello"; |

## Operators

### Arithmetic
```java
+ (addition)
- (subtraction)
* (multiplication)
/ (division)
% (modulo/remainder)
++ (increment)
-- (decrement)
```

### Comparison
```java
== (equals)
!= (not equals)
< (less than)
> (greater than)
<= (less or equal)
>= (greater or equal)
```

### Logical
```java
&& (AND)
|| (OR)
! (NOT)
```

## Control Flow

### if-else
```java
if (condition) {
    // code
} else if (condition) {
    // code
} else {
    // code
}
```

### switch
```java
switch (variable) {
    case 1:
        // code
        break;
    default:
        // code
}
```

### for Loop
```java
for (int i = 0; i < 5; i++) {
    // code
}

// for-each
for (type item : collection) {
    // code
}
```

### while Loop
```java
while (condition) {
    // code
}
```

### do-while
```java
do {
    // code
} while (condition);
```

## Arrays

### Declaration
```java
int[] arr = new int[5];
int[] arr = {1, 2, 3};
int[][] matrix = new int[3][3];
```

### Access
```java
arr[0] = 10;
int value = arr[0];
arr.length;
```

## Methods

### Basic Method
```java
public static int add(int a, int b) {
    return a + b;
}
```

### Method Overloading
```java
public int add(int a, int b) { return a + b; }
public double add(double a, double b) { return a + b; }
```

## Classes and Objects

### Class Definition
```java
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet() {
        System.out.println("Hello");
    }
}
```

### Create Object
```java
Person p = new Person("Alice", 25);
```

### Inheritance
```java
public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }
}
```

## Collections

### List
```java
List<String> list = new ArrayList<>();
list.add("item");
list.remove(0);
list.get(0);
list.size();
```

### Set
```java
Set<String> set = new HashSet<>();
set.add("item");
set.remove("item");
set.contains("item");
```

### Map
```java
Map<String, Integer> map = new HashMap<>();
map.put("key", 100);
map.get("key");
map.remove("key");
map.size();
```

## Exception Handling

### try-catch-finally
```java
try {
    // code
} catch (Exception e) {
    // handle error
} finally {
    // cleanup
}
```

### throw
```java
if (age < 0) {
    throw new IllegalArgumentException("Age negative");
}
```

## Access Modifiers

| Modifier | Same Class | Same Package | Subclass | Everywhere |
|----------|-----------|-------------|----------|-----------|
| public | ✓ | ✓ | ✓ | ✓ |
| protected | ✓ | ✓ | ✓ | ✗ |
| (default) | ✓ | ✓ | ✗ | ✗ |
| private | ✓ | ✗ | ✗ | ✗ |

## Keywords

| Keyword | Purpose |
|---------|---------|
| class | Define a class |
| interface | Define an interface |
| extends | Inherit from class |
| implements | Implement interface |
| abstract | Mark as abstract |
| final | Make immutable |
| static | Shared by class |
| public | Visible everywhere |
| private | Visible only internally |
| protected | Visible in subclasses |
| new | Create object |
| this | Current object |
| super | Parent class |
| return | Return from method |
| void | No return value |
| if, else | Conditional |
| switch | Multi-way choice |
| for, while | Loops |
| try, catch, finally | Exception handling |
| throw | Throw exception |
| throws | Declare exception |
| true, false | Boolean values |
| null | No value |
| instanceof | Type check |

## Naming Conventions

```java
public class MyClass { }          // PascalCase
public void myMethod() { }         // camelCase
private String myVariable;         // camelCase
public static final int MAX = 10;  // UPPER_CASE
```

## Common Methods

### String
```java
s.length()           // length
s.charAt(0)          // character at index
s.substring(0, 3)    // substring
s.toUpperCase()      // uppercase
s.toLowerCase()      // lowercase
s.equals("text")     // equality
s.contains("ab")     // contains substring
s.split(",")         // split into array
s.trim()             // remove whitespace
```

### Array/List
```java
arr.length           // size
list.size()          // size
list.add(item)       // add
list.remove(index)   // remove
list.get(index)      // access
list.contains(item)  // check
list.clear()         // empty
```

### Math
```java
Math.abs(-5)         // absolute value
Math.sqrt(25)        // square root
Math.pow(2, 3)       // power
Math.max(5, 10)      // maximum
Math.min(5, 10)      // minimum
Math.random()        // random 0-1
Math.PI              // pi constant
```

## Input/Output

### Print
```java
System.out.println("text");    // print + newline
System.out.print("text");      // print only
System.out.printf("%d", 5);    // formatted print
```

### Read (Scanner)
```java
Scanner scanner = new Scanner(System.in);
String input = scanner.nextLine();    // read line
int number = scanner.nextInt();       // read integer
scanner.close();
```

## Type Casting

### Automatic (Widening)
```java
int x = 5;
double y = x;  // 5.0
```

### Manual (Narrowing)
```java
double x = 5.5;
int y = (int) x;  // 5
```

## Common Errors

| Error | Cause | Fix |
|-------|-------|-----|
| NullPointerException | Using null object | Check for null |
| ArrayIndexOutOfBoundsException | Wrong index | Check bounds |
| ClassCastException | Invalid cast | Check type first |
| NumberFormatException | Bad string to number | Validate input |
| ConcurrentModificationException | Modify during iteration | Don't modify loop collection |

## Compile and Run Commands

```bash
# Single file
javac MyClass.java
java MyClass

# Multiple files
javac *.java
java MyClass

# With arguments
java MyClass arg1 arg2

# With classpath
javac -cp lib.jar MyClass.java
java -cp lib.jar MyClass
```

## Useful Keyboard Shortcuts (IDE)

```
Ctrl+C     Copy
Ctrl+V     Paste
Ctrl+Z     Undo
Ctrl+S     Save
Ctrl+Shift+F  Format code
Ctrl+/     Comment/uncomment
F11        Debug
Ctrl+F11   Run
```

## Learning Checklist

- [ ] Understand variables and primitive types
- [ ] Master operators and expressions
- [ ] Control flow (if, loops, switch)
- [ ] Arrays and indexing
- [ ] Methods and parameters
- [ ] Classes and objects
- [ ] Inheritance and polymorphism
- [ ] Encapsulation and access modifiers
- [ ] Interfaces and abstract classes
- [ ] Collections (List, Set, Map)
- [ ] Exception handling
- [ ] Generics and type safety
- [ ] Threads basics
- [ ] Naming conventions
- [ ] Debugging techniques

---

**Keep this handy while coding!**
