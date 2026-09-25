> Historical overview: retained for context, not current setup instructions. Start at the [learning home](../../README.md) and use the [current setup guide](../../docs/setup.md).

# Java Learning Guide - Complete Reference

A comprehensive, self-paced Java learning resource from first principles through solid OOP and basic concurrency. **Learn Java the right way: with deep understanding, not memorization.**

## 📚 What's Included

### Main Learning Materials
- **JAVA_LEARNING_GUIDE.md** - Complete written explanations for every single concept
- **CODE_INDEX.md** - Index of all runnable code examples with guidance
- **QUICK_REFERENCE.md** - Handy lookup guide for syntax and common commands

### Runnable Code Examples (17 Files)
All files are production-quality, well-commented, and ready to compile and run.

## 📖 Curriculum Overview

### Phase 0: Environment & Execution
- How Java actually works (JDK, JRE, JVM)
- From source code to bytecode to execution
- Program structure and main method
- **Code Files**: `Phase0_HelloWorld.java`, `Phase0_CommandLineArgs.java`

### Phase 1: Core Fundamentals
- All 8 primitive data types
- Operators (arithmetic, logical, comparison)
- Control flow (if, switch, for, while, do-while)
- Arrays and iteration
- **Code Files**: `Phase1_Variables.java`, `Phase1_Operators.java`, `Phase1_ControlFlow.java`, `Phase1_Arrays.java`

### Phase 2: Methods & Memory
- Method declaration and overloading
- Stack vs Heap memory
- Pass-by-value (the crucial concept that trips up beginners)
- Recursion
- **Code Files**: `Phase2_Methods.java`, `Phase2_PassByValue.java`

### Phase 3: Object-Oriented Programming
- Classes and objects from first principles
- Constructors and initialization
- Encapsulation and data protection
- Inheritance and "is-a" relationships
- Polymorphism and dynamic dispatch
- Abstract classes
- **Code Files**: `Phase3_Classes_Objects.java`, `Phase3_Encapsulation.java`, `Phase3_Inheritance_Polymorphism.java`, `Phase3_AbstractClasses.java`

### Phase 4: Core Language Features
- Interfaces and contracts
- Static keyword and class members
- Final keyword and immutability
- Access modifiers and visibility
- equals() and hashCode()
- **Code Files**: `Phase4_Interfaces.java`, `Phase4_Static_Final.java`

### Phase 5: Collections & Generics
- Arrays vs Collections (when to use each)
- ArrayList, LinkedList
- HashSet, TreeSet
- HashMap, TreeMap
- Generics and type safety
- Iteration patterns
- **Code Files**: `Phase5_Collections.java`

### Phase 6: Exceptions & Basic Concurrency
- Exception hierarchy and types
- try-catch-finally blocks
- Custom exceptions
- Threads and Runnable
- Race conditions
- synchronized keyword
- **Code Files**: `Phase6_Exceptions.java`, `Phase6_Threads.java`

### Phase 7: Code Quality & Debugging
- Java naming conventions
- 10 common pitfalls and how to avoid them
- Debugging techniques
- Code quality checklist
- **Code Files**: `Phase7_CodeQuality.java`

## 🚀 How to Use This Resource

### For Each Topic:
1. **Read explanation**: Open `JAVA_LEARNING_GUIDE.md` and find your topic
2. **Study code**: Find the corresponding code file and read it carefully
3. **Compile**: `javac FileName.java`
4. **Run**: `java ClassName`
5. **Experiment**: Modify values, add print statements, break it on purpose
6. **Reflect**: Understand WHY things work this way

### Example Workflow:
```bash
# Study Phase 1: Variables
# 1. Read JAVA_LEARNING_GUIDE.md - "Concept 1.1: Variables and Data Types"
# 2. Open Phase1_Variables.java
# 3. Compile and run:
javac Phase1_Variables.java
java Phase1_Variables
# 4. Modify the code: change types, values, operations
# 5. Re-compile and run your changes
```

## 📋 File Organization

```
Java_Basics/
├── README.md                              ← You are here
├── JAVA_LEARNING_GUIDE.md                 ← Main explanations
├── CODE_INDEX.md                          ← Code file guide
├── QUICK_REFERENCE.md                     ← Syntax lookup
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

## ⚡ Quick Start

```bash
# Enter the Java_Basics folder
cd Java_Basics

# Compile all files
javac *.java

# Run a specific example
java Phase0_HelloWorld
java Phase1_Variables
java Phase3_Classes_Objects

# With command-line arguments
java Phase0_CommandLineArgs hello world java
```

## 🎓 Learning Path

### Option 1: Sequential (Recommended for Beginners)
Follow phases 0→1→2→3→4→5→6→7 in order. Takes 4-8 weeks.

### Option 2: Focused (For Specific Goals)
- Want to code quickly? → Phases 0, 1, 3 (basics and OOP)
- Need collections? → Phases 1-5
- Want multi-threading? → Phases 0-6
- Professional code? → All phases

### Option 3: Just-In-Time
Look up what you need in CODE_INDEX.md when you encounter a concept.

## 💡 Key Learning Principles

✅ **Understand WHY** - Every concept explains its purpose and how Java executes it
✅ **Line-by-line** - Read and understand every line of code
✅ **JVM perspective** - Know what happens under the hood
✅ **Production quality** - Code examples follow real-world standards
✅ **Common mistakes** - Learn what breaks and why
✅ **No frameworks** - Pure Java, no Spring/Hibernate/etc.
✅ **Depth over speed** - Master concepts, don't rush

## 🔍 How Code Files Are Structured

Each code file contains:
- **Class definition** showing the concept
- **Multiple examples** demonstrating variations
- **Clear comments** explaining each section
- **Output** so you know what to expect
- **Key concepts** at the bottom in comments

Example structure:
```java
// PHASE X: TOPIC
// Concept X.Y: Detailed topic name

public class PhaseX_Topic {
    // Example 1: Basic usage

    // Example 2: Advanced usage

    // Example 3: Common mistakes

    public static void main(String[] args) {
        // Run all examples
    }
}

/*
Key Points:
- Point 1
- Point 2

Execution:
javac Phase#_Topic.java
java Phase#_Topic
*/
```

## 📌 Important Notes

- **All files compile and run correctly** - Test them!
- **No dependencies needed** - Just vanilla Java
- **Complete explanations** - Nothing is assumed knowledge
- **Progressive complexity** - Each phase builds on previous
- **Real-world patterns** - Learn how professionals code

## 🎯 Success Metrics

You'll know you understand a concept when you can:
- [ ] Explain it in your own words
- [ ] Predict the output before running
- [ ] Modify the code without errors
- [ ] Solve new problems using the concept
- [ ] Explain why it works (the mechanism)

## 🛠️ Development Setup

You need:
- **JDK installed** (Java 8 or later)
- **Text editor** or **IDE** (VS Code, IntelliJ IDEA, Eclipse)
- **Terminal/Command prompt**
- **Nothing else** - no frameworks or libraries required

Verify installation:
```bash
javac -version
java -version
```

## 📚 Beyond This Course

After completing all 7 phases:
- **Build projects**: Todo app, game, data analysis tool
- **Learn frameworks**: Spring Boot, Hibernate
- **Study patterns**: Singleton, Observer, Factory, etc.
- **Practice algorithms**: LeetCode, HackerRank
- **Contribute to open source**: GitHub projects

## ❓ Getting Stuck?

1. **Re-read the explanation** in JAVA_LEARNING_GUIDE.md
2. **Study the code** line by line
3. **Add print statements** to understand flow
4. **Check QUICK_REFERENCE.md** for syntax
5. **Read the comments** in code files
6. **Modify the code** to experiment

## ✅ Checklist Before Moving Forward

Before starting Phase N+1, ensure you can:
- [ ] Understand all concepts from Phase N
- [ ] Run all code files without errors
- [ ] Modify code examples successfully
- [ ] Explain why each part works
- [ ] Spot and fix common mistakes

---

## 🎓 Remember

> "The best way to learn to code is to code."

Read, understand, run, modify, break, fix, repeat.

**Good luck on your Java journey! You've got this!** 🚀
