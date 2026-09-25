[All guides](README.md) · [Phase examples](../examples/00-getting-started/README.md) · [Next phase](01-fundamentals.md)

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

