# Lesson 39: `static`

## Simple Explanation

`static` means something belongs to the **class itself**, not to any specific object. Static members are shared by all objects of the class.

**Analogy:** Every student (object) has their own name (instance field). But the school name (static field) is the same for all students.

## Static Fields

```java
public class Student {
    String name;                    // Instance field — each object has its own
    static int totalStudents = 0;   // Static field — shared by ALL objects

    Student(String name) {
        this.name = name;
        totalStudents++;            // Increment the shared counter
    }
}
```

```java
Student s1 = new Student("Alex");
Student s2 = new Student("Sam");
Student s3 = new Student("Jordan");

System.out.println(Student.totalStudents);    // 3
```

### Symbol breakdown of `static int totalStudents = 0;`:
- `static` — This field belongs to the class, not individual objects.
- `int` — Data type.
- `totalStudents` — Field name.
- `=` — Assignment.
- `0` — Initial value.
- `;` — End of statement.

### Accessing static fields:
- Use the **class name**: `Student.totalStudents` ✅ (preferred)
- Can also use an object: `s1.totalStudents` (works but not recommended)

## Static Methods

```java
public class MathHelper {
    static int add(int a, int b) {
        return a + b;
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
```

```java
int sum = MathHelper.add(5, 3);      // 8 — called using class name
int bigger = MathHelper.max(10, 7);  // 10
```

Static methods:
- Are called using the **class name**: `ClassName.methodName()`
- **Cannot** access instance fields or instance methods
- **Can** access other static fields and static methods
- This is why `main` is `static` — it runs before any objects exist

### What static methods CANNOT do:

```java
public class Dog {
    String name;    // Instance field

    static void test() {
        // System.out.println(name);    // ❌ ERROR — can't access instance field
        // System.out.println(this);     // ❌ ERROR — no "this" in static context
    }
}
```

## `static` vs Instance Summary

| Feature | Instance | Static |
|---------|----------|--------|
| Belongs to | Each object | The class |
| Access | `object.field` | `ClassName.field` |
| Keyword | (no keyword) | `static` |
| Can access instance members? | Yes | No |
| Common use | Object data | Shared data, utility methods |

## Common Beginner Mistakes

1. **Accessing instance fields from static methods** — Can't use `name` in a `static` method.
2. **Making everything static** — Only use static for shared data and utility methods.
3. **Using `this` in static methods** — `this` doesn't exist in static context.

## Quiz

1. What does `static` mean?
   - a) The value never changes
   - b) It belongs to the class, not an object ✅
   - c) It's private

2. Can a static method access instance fields?
   - a) Yes
   - b) No ✅

3. How do you call a static method?
   - a) `object.method()`
   - b) `ClassName.method()` ✅
   - c) `static method()`

---
**Next Lesson:** [Lesson 40 — `final`](40_Final.md)
