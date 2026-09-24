# Lesson 31: Scope

## Simple Explanation

**Scope** is where a variable **exists** and can be used. A variable only lives within the block `{ }` where it was created. Outside that block, the variable doesn't exist.

**Analogy:** A variable is like a guest badge at a building. The badge only works on the floor where it was issued. Go to a different floor, and the badge doesn't work.

## Block Scope

A **block** is any code between `{` and `}`. Variables created inside a block only exist in that block.

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;    // x exists from here...

        if (x > 5) {
            int y = 20;    // y exists only inside this if-block
            System.out.println(x);    // ✅ OK — x is visible here
            System.out.println(y);    // ✅ OK — y is visible here
        }    // y stops existing here

        System.out.println(x);    // ✅ OK — x is still alive
        // System.out.println(y);  // ❌ ERROR — y doesn't exist here!
    }    // x stops existing here
}
```

## Method Scope

Parameters and variables declared in a method only exist in that method:

```java
public class Main {
    public static void methodA() {
        int a = 5;
        System.out.println(a);    // ✅ OK
    }

    public static void methodB() {
        // System.out.println(a);  // ❌ ERROR — a doesn't exist here!
        int b = 10;
        System.out.println(b);    // ✅ OK
    }

    public static void main(String[] args) {
        methodA();
        methodB();
        // System.out.println(a);  // ❌ ERROR — a doesn't exist here!
        // System.out.println(b);  // ❌ ERROR — b doesn't exist here!
    }
}
```

## Loop Scope

The loop variable only exists inside the loop:

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);    // ✅ OK — i exists in the loop
}
// System.out.println(i);    // ❌ ERROR — i doesn't exist outside the loop!
```

If you need the variable after the loop, declare it before the loop:

```java
int i;
for (i = 0; i < 5; i++) {
    System.out.println(i);
}
System.out.println("Final i: " + i);    // ✅ OK — i was declared outside
```

## Variable Shadowing

If you create a variable with the same name in a nested block, it "shadows" (hides) the outer one:

```java
int x = 10;
if (true) {
    int x = 20;    // ❌ ERROR in Java! Can't redeclare x in a nested block.
}
```

Java does **not** allow shadowing of local variables in nested blocks (unlike some other languages). You'll get a compilation error.

## Common Beginner Mistakes

1. **Using a variable outside its scope** — If declared inside `if`, it doesn't exist outside.
2. **Using loop variables after the loop** — `i` from `for(int i...)` doesn't exist after `}`.
3. **Declaring the same variable twice in the same scope** — `int x = 5; int x = 10;` is an error.
4. **Thinking variables carry over between methods** — Each method has its own scope.

## Mini Practice Exercise

**Task:** What's wrong with this code?

```java
public static void main(String[] args) {
    if (true) {
        String message = "Hello";
    }
    System.out.println(message);
}
```

**Answer:** `message` is declared inside the `if` block. It doesn't exist outside the `}`. Fix: declare `message` before the `if` block.

## Quiz

1. What is scope?
   - a) The size of a variable
   - b) Where a variable exists and can be used ✅
   - c) The type of a variable

2. Can you use a loop variable after the loop ends?
   - a) Yes, always
   - b) No, unless declared before the loop ✅
   - c) Only in while loops

3. Can two different methods have variables with the same name?
   - a) No
   - b) Yes ✅ — each method has its own scope.

---
**Next Lesson:** [Lesson 32 — Classes](32_Classes.md)
