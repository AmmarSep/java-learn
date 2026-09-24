# Java Learning Code Index

This is a complete index of all runnable Java code examples organized by learning phase.

## How to Use This Index

1. **Read the concept** in `JAVA_LEARNING_GUIDE.md`
2. **Study the code** file listed below
3. **Compile**: `javac FileName.java`
4. **Run**: `java ClassName`
5. **Experiment**: Modify the code and run again

---

## PHASE 0: ENVIRONMENT & EXECUTION

### 0.1 Program Structure
- **File**: `Phase0_HelloWorld.java`
- **Concept**: Basic program structure, main method, printing
- **Key Topics**:
  - Class structure
  - main() method entry point
  - System.out.println()
  - Comments

**How to run**:
```bash
javac Phase0_HelloWorld.java
java Phase0_HelloWorld
```

### 0.2 Command-Line Arguments
- **File**: `Phase0_CommandLineArgs.java`
- **Concept**: Receiving input from command line via String[] args
- **Key Topics**:
  - args array
  - args.length
  - Accessing command-line arguments

**How to run**:
```bash
javac Phase0_CommandLineArgs.java
java Phase0_CommandLineArgs hello world java
```

---

## PHASE 1: CORE FUNDAMENTALS

### 1.1 Variables and Data Types
- **File**: `Phase1_Variables.java`
- **Concept**: Primitive data types, declaration, initialization, casting
- **Key Topics**:
  - int, double, boolean, String, char, long, float
  - Variable naming rules
  - Type casting (implicit and explicit)
  - Constants with 'final'

**How to run**:
```bash
javac Phase1_Variables.java
java Phase1_Variables
```

### 1.2 Operators and Expressions
- **File**: `Phase1_Operators.java`
- **Concept**: Arithmetic, comparison, logical operators, operator precedence
- **Key Topics**:
  - Arithmetic: +, -, *, /, %
  - Comparison: ==, !=, <, >, <=, >=
  - Logical: &&, ||, !
  - Increment/Decrement: ++, --
  - Operator precedence
  - String concatenation

**How to run**:
```bash
javac Phase1_Operators.java
java Phase1_Operators
```

### 1.3-1.4 Control Flow
- **File**: `Phase1_ControlFlow.java`
- **Concept**: if, else, switch, for, while, do-while, break, continue
- **Key Topics**:
  - if-else statements
  - if-else if chains
  - switch statements
  - for loops
  - while loops
  - do-while loops
  - break and continue
  - Ternary operator

**How to run**:
```bash
javac Phase1_ControlFlow.java
java Phase1_ControlFlow
```

### 1.5 Arrays
- **File**: `Phase1_Arrays.java`
- **Concept**: Creating, accessing, iterating arrays; multidimensional arrays
- **Key Topics**:
  - Array declaration and initialization
  - Array literal syntax
  - for and for-each loops
  - 2D arrays (matrices)
  - Array operations (sum, average, max, min)
  - String character access

**How to run**:
```bash
javac Phase1_Arrays.java
java Phase1_Arrays
```

---

## PHASE 2: METHODS & MEMORY

### 2.1 Methods
- **File**: `Phase2_Methods.java`
- **Concept**: Method declaration, parameters, return values, overloading
- **Key Topics**:
  - Method syntax
  - Parameters and arguments
  - Return types
  - void methods
  - Method overloading
  - Recursion

**How to run**:
```bash
javac Phase2_Methods.java
java Phase2_Methods
```

### 2.3 Pass-by-Value
- **File**: `Phase2_PassByValue.java`
- **Concept**: How Java passes primitives and objects; memory behavior
- **Key Topics**:
  - Primitives passed by value (copies)
  - Objects passed by reference (copy of reference)
  - Modifying array contents in methods
  - Reassigning references in methods

**How to run**:
```bash
javac Phase2_PassByValue.java
java Phase2_PassByValue
```

---

## PHASE 3: OBJECT-ORIENTED PROGRAMMING

### 3.1-3.2 Classes and Objects
- **File**: `Phase3_Classes_Objects.java`
- **Concept**: Class definition, object creation, constructors
- **Key Topics**:
  - Class structure
  - Instance variables
  - Constructors
  - this keyword
  - Constructor overloading
  - Method chaining

**How to run**:
```bash
javac Phase3_Classes_Objects.java
java Phase3_Classes_Objects
```

### 3.4 Encapsulation
- **File**: `Phase3_Encapsulation.java`
- **Concept**: private variables, getters/setters, data protection
- **Key Topics**:
  - private variables
  - public methods
  - Getter and setter methods
  - Input validation
  - Protecting object state

**How to run**:
```bash
javac Phase3_Encapsulation.java
java Phase3_Encapsulation
```

### 3.5-3.6 Inheritance and Polymorphism
- **File**: `Phase3_Inheritance_Polymorphism.java`
- **Concept**: Extending classes, method overriding, polymorphic behavior
- **Key Topics**:
  - Class inheritance with 'extends'
  - super keyword
  - Method overriding with @Override
  - Polymorphic references
  - instanceof operator
  - Downcasting

**How to run**:
```bash
javac Phase3_Inheritance_Polymorphism.java
java Phase3_Inheritance_Polymorphism
```

### 3.7 Abstract Classes
- **File**: `Phase3_AbstractClasses.java`
- **Concept**: Abstract classes, abstract methods, partial implementations
- **Key Topics**:
  - abstract keyword
  - Abstract methods (no body)
  - Concrete methods in abstract classes
  - Inheritance hierarchies
  - Polymorphism with abstract classes

**How to run**:
```bash
javac Phase3_AbstractClasses.java
java Phase3_AbstractClasses
```

---

## PHASE 4: CORE LANGUAGE FEATURES

### 4.1 Interfaces
- **File**: `Phase4_Interfaces.java`
- **Concept**: Interface contracts, implementation, multiple interfaces
- **Key Topics**:
  - Interface definition
  - implements keyword
  - Abstract methods
  - Default methods
  - Multiple interface implementation
  - Interface inheritance

**How to run**:
```bash
javac Phase4_Interfaces.java
java Phase4_Interfaces
```

### 4.2-4.3 Static and Final Keywords
- **File**: `Phase4_Static_Final.java`
- **Concept**: Static variables/methods, final constants, immutability
- **Key Topics**:
  - static variables (shared by all objects)
  - static methods (called on class)
  - final variables (constants)
  - final methods (can't override)
  - Immutable objects

**How to run**:
```bash
javac Phase4_Static_Final.java
java Phase4_Static_Final
```

---

## PHASE 5: COLLECTIONS & GENERICS

### 5.1-5.5 Collections Framework
- **File**: `Phase5_Collections.java`
- **Concept**: List, Set, Map; Generics; iteration
- **Key Topics**:
  - ArrayList (dynamic lists)
  - HashSet and TreeSet (unique values)
  - HashMap and TreeMap (key-value pairs)
  - Generics and type safety
  - Iteration methods (for, for-each, Iterator)
  - Collection methods

**How to run**:
```bash
javac Phase5_Collections.java
java Phase5_Collections
```

---

## PHASE 6: EXCEPTIONS & BASIC CONCURRENCY

### 6.1-6.3 Exception Handling
- **File**: `Phase6_Exceptions.java`
- **Concept**: try-catch-finally, custom exceptions, exception hierarchy
- **Key Topics**:
  - try-catch blocks
  - Multiple catch blocks
  - finally blocks
  - throw statement
  - throws declaration
  - Custom exceptions
  - Exception hierarchy

**How to run**:
```bash
javac Phase6_Exceptions.java
java Phase6_Exceptions
```

### 6.4-6.5 Threads and Synchronization
- **File**: `Phase6_Threads.java`
- **Concept**: Creating threads, concurrency, race conditions, synchronization
- **Key Topics**:
  - Runnable interface
  - Thread creation and starting
  - Lambda for threads
  - Thread.sleep() and join()
  - Race conditions
  - synchronized methods
  - Thread states

**How to run**:
```bash
javac Phase6_Threads.java
java Phase6_Threads
```

---

## PHASE 7: CODE QUALITY & DEBUGGING

### 7.1-7.3 Code Quality and Common Pitfalls
- **File**: `Phase7_CodeQuality.java`
- **Concept**: Naming conventions, common mistakes, debugging techniques
- **Key Topics**:
  - Naming conventions (Class, variable, method, constant)
  - 10 common pitfalls and how to avoid them
  - Debugging techniques
  - print statements for debugging
  - Exception stack traces
  - Code quality checklist

**How to run**:
```bash
javac Phase7_CodeQuality.java
java Phase7_CodeQuality
```

---

## Quick Reference

### Compile and Run Template

For any file `PhaseX_Topic.java`:

```bash
# Compile
javac PhaseX_Topic.java

# Run
java PhaseX_Topic

# Run with arguments (if applicable)
java PhaseX_Topic arg1 arg2 arg3
```

### File Organization

```
Java_Basics/
├── README.md                          # Overview
├── JAVA_LEARNING_GUIDE.md            # Complete explanations
├── CODE_INDEX.md                     # This file
│
├── Phase0_HelloWorld.java
├── Phase0_CommandLineArgs.java
│
├── Phase1_Variables.java
├── Phase1_Operators.java
├── Phase1_ControlFlow.java
├── Phase1_Arrays.java
│
├── Phase2_Methods.java
├── Phase2_PassByValue.java
│
├── Phase3_Classes_Objects.java
├── Phase3_Encapsulation.java
├── Phase3_Inheritance_Polymorphism.java
├── Phase3_AbstractClasses.java
│
├── Phase4_Static_Final.java
├── Phase4_Interfaces.java
│
├── Phase5_Collections.java
│
├── Phase6_Exceptions.java
├── Phase6_Threads.java
│
└── Phase7_CodeQuality.java
```

## Learning Path Suggestions

### Week 1: Fundamentals
1. Phase 0: Program structure
2. Phase 1: Variables, operators, control flow, arrays

### Week 2: Methods and Memory
1. Phase 2: Methods and pass-by-value
2. Review Phase 1 concepts

### Week 3: Object-Oriented Programming
1. Phase 3: Classes, inheritance, polymorphism
2. Phase 4: Interfaces, static, final

### Week 4: Advanced Concepts
1. Phase 5: Collections
2. Phase 6: Exceptions and threads
3. Phase 7: Code quality

## Tips for Learning

1. **Read first**: Always read the concept explanation in JAVA_LEARNING_GUIDE.md first
2. **Study code**: Read the entire code file line by line
3. **Compile and run**: Execute the code to see output
4. **Modify**: Change values and see what happens
5. **Experiment**: Write your own variations
6. **Debug**: Add print statements to understand flow
7. **Connect**: See how concepts build on each other

## Common Commands

```bash
# List all Java files
ls -la *.java

# List all compiled class files
ls -la *.class

# Remove all compiled files (clean up)
rm *.class

# Compile all files
javac *.java

# Show file structure
cat Phase1_Variables.java | head -50
```

## Next Steps After Learning

1. **Small Projects**: Build a todo list app, calculator, simple game
2. **Real Libraries**: Try Maven or Gradle
3. **Frameworks**: Spring Boot, Hibernate (after mastering fundamentals)
4. **Testing**: Learn JUnit testing
5. **Data Structures**: Implement linked lists, trees, graphs
6. **Design Patterns**: Study common patterns (Singleton, Observer, etc.)

---

Good luck on your Java journey! Remember: **Depth over speed**. Master each concept thoroughly before moving on.
