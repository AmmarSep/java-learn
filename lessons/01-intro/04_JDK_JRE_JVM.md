[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](03_How_Java_Code_Runs.md) · [Next](05_Installing_Java.md)

---

# Lesson 4: JDK, JRE, JVM Explained Simply

## Simple Explanation

To work with Java, you need to know about three important tools. Think of them as three layers, one inside the other — like Russian nesting dolls.

## The Three Layers

### JVM — Java Virtual Machine (The Innermost Layer)

The **JVM** is the engine that actually **runs** your Java program.

- It reads the bytecode (the `.class` file) and executes it.
- It exists for every operating system: there's a JVM for Windows, one for Mac, one for Linux.
- This is what makes Java "Write Once, Run Anywhere" — same bytecode, different JVMs.

**Analogy:** The JVM is like a DVD player. The bytecode is the DVD. Any DVD player (JVM) can play any DVD (bytecode), no matter where the DVD was made.

### JRE — Java Runtime Environment (The Middle Layer)

The **JRE** includes:
- The **JVM** (the engine)
- **Libraries** — pre-written code that Java programs can use (like a toolbox of ready-made parts)

If you only want to **run** Java programs (not write them), you only need the JRE.

**Analogy:** The JRE is like a DVD player plus the remote control and the cables. Everything you need to *watch* a movie, but not to *make* one.

### JDK — Java Development Kit (The Outermost Layer)

The **JDK** includes:
- The **JRE** (which includes the JVM)
- **Development tools** like:
  - `javac` — the compiler (translates `.java` to `.class`)
  - `java` — the launcher (starts the JVM)
  - A debugger (helps find mistakes)
  - Other tools for building programs

If you want to **write** Java programs, you need the JDK.

**Analogy:** The JDK is like a full movie studio. It has everything needed to make a movie (write code) AND watch it (run code).

## Visual Summary

```
┌─────────────────────────────────────┐
│           JDK                       │
│  (Development tools + JRE)          │
│                                     │
│  ┌───────────────────────────────┐  │
│  │         JRE                   │  │
│  │  (Libraries + JVM)            │  │
│  │                               │  │
│  │  ┌─────────────────────────┐  │  │
│  │  │        JVM              │  │  │
│  │  │  (Runs bytecode)        │  │  │
│  │  └─────────────────────────┘  │  │
│  └───────────────────────────────┘  │
└─────────────────────────────────────┘
```

## Which One Do You Need?

| You want to... | You need... |
|----------------|-------------|
| **Run** a Java program someone else wrote | JRE |
| **Write and run** your own Java programs | JDK |

**As a learner, you need the JDK.** It has everything.

## Common Beginner Mistakes

1. **Installing only the JRE** — You need the JDK to write and compile Java programs.
2. **Confusing JDK with JVM** — The JDK is the full toolkit. The JVM is just the engine inside it.
3. **Thinking you need to install all three separately** — No! The JDK contains the JRE, which contains the JVM. Install the JDK and you get everything.

## Mini Practice Exercise

**Question:** Fill in the blanks:
- The _______ runs Java bytecode.
- The _______ includes libraries and the JVM.
- The _______ includes development tools, the JRE, and the JVM.

**Answer:**
- The **JVM** runs Java bytecode.
- The **JRE** includes libraries and the JVM.
- The **JDK** includes development tools, the JRE, and the JVM.

## Quiz

1. What does JDK stand for?
   - a) Java Data Kit
   - b) Java Development Kit ✅
   - c) Java Design Kit

2. If you want to write Java programs, which do you need?
   - a) Only the JVM
   - b) Only the JRE
   - c) The JDK ✅

3. What is inside the JRE?
   - a) Only the compiler
   - b) The JVM and libraries ✅
   - c) Only development tools

4. True or False: The JDK contains the JRE, which contains the JVM.
   - **True** ✅

---
**Next Lesson:** [Lesson 5 — Installing Java](05_Installing_Java.md)
