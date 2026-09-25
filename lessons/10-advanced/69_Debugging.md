[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](68_Date_Time.md) · [Next](70_Unit_Testing.md)

**Runnable companion:** [Phase7_CodeQuality](../../examples/07-code-quality/01-code-quality/Phase7_CodeQuality.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 69: Debugging

## Simple Explanation

**Debugging** is the process of finding and fixing errors (bugs) in your code. It's a critical skill — you'll spend a lot of time debugging!

## Types of Errors

| Type | When | Example |
|------|------|---------|
| **Compile error** | Code doesn't compile | Missing semicolon, wrong type |
| **Runtime error** | Code crashes while running | Division by zero, null pointer |
| **Logic error** | Code runs but gives wrong results | Using `+` instead of `-` |

## Debugging Techniques

### 1. Read the Error Message

```
Exception in thread "main" java.lang.NullPointerException
    at Main.main(Main.java:5)
```

- **What**: `NullPointerException` — you used a null reference.
- **Where**: `Main.java:5` — line 5 of Main.java.

**Always read the error message first!** It usually tells you exactly what's wrong and where.

### 2. Print Debugging

Add `System.out.println()` to see what's happening:

```java
int result = calculate(x, y);
System.out.println("DEBUG: x=" + x + ", y=" + y + ", result=" + result);
```

This shows you the actual values at runtime. Remove debug prints when done.

### 3. Use a Debugger (IntelliJ IDEA)

A **debugger** lets you:

1. **Set breakpoints** — Click the line number gutter to set a red dot. The program pauses there.
2. **Step through code** — Execute one line at a time:
   - **Step Over** (F8) — Run current line, move to next.
   - **Step Into** (F7) — Go inside a method call.
   - **Step Out** (Shift+F8) — Finish current method, return to caller.
3. **Inspect variables** — See the current value of every variable.
4. **Watch expressions** — Monitor specific expressions.

### 4. Rubber Duck Debugging

Explain your code line by line to someone (or a rubber duck). Often, explaining the problem helps you find the bug.

### 5. Simplify and Isolate

If your program has a bug:
1. **Comment out** parts of the code.
2. Test with **simple input** first.
3. **Narrow down** which section has the bug.

## Common Debugging Scenarios

### NullPointerException
```java
String name = null;
System.out.println(name.length());    // CRASH!
// Fix: Check for null first
if (name != null) {
    System.out.println(name.length());
}
```

### Off-by-One Error
```java
// Bug: uses <= instead of <
for (int i = 0; i <= arr.length; i++) {    // Crashes on last iteration!
    System.out.println(arr[i]);
}
// Fix: use <
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### Infinite Loop
```java
// Bug: forgot to increment
int i = 0;
while (i < 10) {
    System.out.println(i);
    // i++ is missing! Loop never ends.
}
```

## Debugging Checklist

1. ✅ Read the error message completely.
2. ✅ Look at the line number mentioned.
3. ✅ Check for common issues: null, wrong index, wrong type.
4. ✅ Add print statements to trace values.
5. ✅ Use the debugger for complex issues.
6. ✅ Test with simple inputs first.
7. ✅ Take a break if stuck — fresh eyes help!

## Quiz

1. What should you do FIRST when you see an error?
   - a) Rewrite all the code
   - b) Read the error message ✅
   - c) Delete the file

2. What does a breakpoint do?
   - a) Breaks the code
   - b) Pauses the program at that line so you can inspect it ✅
   - c) Deletes a line

---
**Next Lesson:** [Lesson 70 — Unit Testing Basics](70_Unit_Testing.md)
