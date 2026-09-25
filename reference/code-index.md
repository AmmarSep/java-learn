[Home](../README.md) · [All examples](../examples/README.md)

# Java Learning Code Index

This is a complete index of all runnable Java code examples organized by learning phase. Run all commands from the repository root. The three tiny starter programs are also listed in the [complete example catalog](../examples/README.md).

## How to Use This Index

1. **Read the concept** in [the detailed guides](../guides/README.md)
2. **Study the code** file listed below
3. **List examples**: `python3 scripts/java.py list`
4. **Compile and run**: `python3 scripts/java.py run ClassName`
5. **Experiment**: Modify the code and run again

---

## PHASE 0: ENVIRONMENT & EXECUTION

### 0.1 Program Structure
- **File**: [Phase0_HelloWorld.java](../examples/00-getting-started/04-program-structure/Phase0_HelloWorld.java)
- **Concept**: Basic program structure, main method, printing
- **Key Topics**:
  - Class structure
  - main() method entry point
  - System.out.println()
  - Comments

**How to run**:
```bash
python3 scripts/java.py run Phase0_HelloWorld
```

### 0.2 Command-Line Arguments
- **File**: [Phase0_CommandLineArgs.java](../examples/00-getting-started/05-arguments-explained/Phase0_CommandLineArgs.java)
- **Concept**: Receiving input from command line via String[] args
- **Key Topics**:
  - args array
  - args.length
  - Accessing command-line arguments

**How to run**:
```bash
python3 scripts/java.py run Phase0_CommandLineArgs hello world java
```

---

## PHASE 1: CORE FUNDAMENTALS

### 1.1 Variables and Data Types
- **File**: [Phase1_Variables.java](../examples/01-fundamentals/01-variables/Phase1_Variables.java)
- **Concept**: Primitive data types, declaration, initialization, casting
- **Key Topics**:
  - int, double, boolean, String, char, long, float
  - Variable naming rules
  - Type casting (implicit and explicit)
  - Constants with 'final'

**How to run**:
```bash
python3 scripts/java.py run Phase1_Variables
```

### 1.2 Operators and Expressions
- **File**: [Phase1_Operators.java](../examples/01-fundamentals/02-operators/Phase1_Operators.java)
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
python3 scripts/java.py run Phase1_Operators
```

### 1.3-1.4 Control Flow
- **File**: [Phase1_ControlFlow.java](../examples/01-fundamentals/03-control-flow/Phase1_ControlFlow.java)
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
python3 scripts/java.py run Phase1_ControlFlow
```

### 1.5 Arrays
- **File**: [Phase1_Arrays.java](../examples/01-fundamentals/04-arrays/Phase1_Arrays.java)
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
python3 scripts/java.py run Phase1_Arrays
```

---

## PHASE 2: METHODS & MEMORY

### 2.1 Methods
- **File**: [Phase2_Methods.java](../examples/02-methods-and-memory/01-methods/Phase2_Methods.java)
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
python3 scripts/java.py run Phase2_Methods
```

### 2.3 Pass-by-Value
- **File**: [Phase2_PassByValue.java](../examples/02-methods-and-memory/02-pass-by-value/Phase2_PassByValue.java)
- **Concept**: How Java passes primitives and objects; memory behavior
- **Key Topics**:
  - Primitives passed by value (copies)
  - Objects passed by reference (copy of reference)
  - Modifying array contents in methods
  - Reassigning references in methods

**How to run**:
```bash
python3 scripts/java.py run Phase2_PassByValue
```

---

## PHASE 3: OBJECT-ORIENTED PROGRAMMING

### 3.1-3.2 Classes and Objects
- **File**: [Phase3_Classes_Objects.java](../examples/03-object-oriented-programming/01-classes-and-objects/Phase3_Classes_Objects.java)
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
python3 scripts/java.py run Phase3_Classes_Objects
```

### 3.4 Encapsulation
- **File**: [Phase3_Encapsulation.java](../examples/03-object-oriented-programming/02-encapsulation/Phase3_Encapsulation.java)
- **Concept**: private variables, getters/setters, data protection
- **Key Topics**:
  - private variables
  - public methods
  - Getter and setter methods
  - Input validation
  - Protecting object state

**How to run**:
```bash
python3 scripts/java.py run Phase3_Encapsulation
```

### 3.5-3.6 Inheritance and Polymorphism
- **File**: [Phase3_Inheritance_Polymorphism.java](../examples/03-object-oriented-programming/03-inheritance-and-polymorphism/Phase3_Inheritance_Polymorphism.java)
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
python3 scripts/java.py run Phase3_Inheritance_Polymorphism
```

### 3.7 Abstract Classes
- **File**: [Phase3_AbstractClasses.java](../examples/03-object-oriented-programming/04-abstract-classes/Phase3_AbstractClasses.java)
- **Concept**: Abstract classes, abstract methods, partial implementations
- **Key Topics**:
  - abstract keyword
  - Abstract methods (no body)
  - Concrete methods in abstract classes
  - Inheritance hierarchies
  - Polymorphism with abstract classes

**How to run**:
```bash
python3 scripts/java.py run Phase3_AbstractClasses
```

---

## PHASE 4: CORE LANGUAGE FEATURES

### 4.1 Interfaces
- **File**: [Phase4_Interfaces.java](../examples/04-language-features/01-interfaces/Phase4_Interfaces.java)
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
python3 scripts/java.py run Phase4_Interfaces
```

### 4.2-4.3 Static and Final Keywords
- **File**: [Phase4_Static_Final.java](../examples/04-language-features/02-static-and-final/Phase4_Static_Final.java)
- **Concept**: Static variables/methods, final constants, immutability
- **Key Topics**:
  - static variables (shared by all objects)
  - static methods (called on class)
  - final variables (constants)
  - final methods (can't override)
  - Immutable objects

**How to run**:
```bash
python3 scripts/java.py run Phase4_Static_Final
```

---

## PHASE 5: COLLECTIONS & GENERICS

### 5.1-5.5 Collections Framework
- **File**: [Phase5_Collections.java](../examples/05-collections/01-collections/Phase5_Collections.java)
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
python3 scripts/java.py run Phase5_Collections
```

---

## PHASE 6: EXCEPTIONS & BASIC CONCURRENCY

### 6.1-6.3 Exception Handling
- **File**: [Phase6_Exceptions.java](../examples/06-exceptions-and-concurrency/01-exceptions/Phase6_Exceptions.java)
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
python3 scripts/java.py run Phase6_Exceptions
```

### 6.4-6.5 Threads and Synchronization
- **File**: [Phase6_Threads.java](../examples/06-exceptions-and-concurrency/02-threads/Phase6_Threads.java)
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
python3 scripts/java.py run Phase6_Threads
```

---

## PHASE 7: CODE QUALITY & DEBUGGING

### 7.1-7.3 Code Quality and Common Pitfalls
- **File**: [Phase7_CodeQuality.java](../examples/07-code-quality/01-code-quality/Phase7_CodeQuality.java)
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
python3 scripts/java.py run Phase7_CodeQuality
```

---

## Quick Reference

### Compile and run

Run from the repository root:

```bash
python3 scripts/java.py list
python3 scripts/java.py check
python3 scripts/java.py run Phase0_CommandLineArgs hello world
```

See [all 21 programs](../examples/README.md) for the current file layout. Compiling all sources together is not supported: lessons intentionally reuse helper-class names.

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

1. **Read first**: Always read the concept explanation in [the detailed guides](../guides/README.md) first
2. **Study code**: Read the entire code file line by line
3. **Compile and run**: Execute the code to see output
4. **Modify**: Change values and see what happens
5. **Experiment**: Write your own variations
6. **Debug**: Add print statements to understand flow
7. **Connect**: See how concepts build on each other

## Common commands

```bash
python3 scripts/java.py list
python3 scripts/java.py check
python3 scripts/java.py smoke
```

Build output stays in ignored `.build/`, not beside the learning material.

## Next Steps After Learning

1. **Small Projects**: Build a todo list app, calculator, simple game
2. **Real Libraries**: Try Maven or Gradle
3. **Frameworks**: Spring Boot, Hibernate (after mastering fundamentals)
4. **Testing**: Learn JUnit testing
5. **Data Structures**: Implement linked lists, trees, graphs
6. **Design Patterns**: Study common patterns (Singleton, Observer, etc.)

---

Good luck on your Java journey! Remember: **Depth over speed**. Master each concept thoroughly before moving on.
