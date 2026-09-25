[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](33_Objects.md) · [Next](35_Methods_In_Classes.md)

**Runnable companion:** [Phase3_Classes_Objects](../../examples/03-object-oriented-programming/01-classes-and-objects/Phase3_Classes_Objects.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 34: Fields

## Simple Explanation

**Fields** (also called **instance variables**) are variables that belong to a class. They represent the **data** or **properties** of an object.

**Analogy:** If a class `Person` is a blueprint, then fields are the blank lines on a form: Name: ___, Age: ___, Email: ___. Each person (object) fills in their own values.

## Declaring Fields

```java
public class Student {
    String name;          // Field: text
    int age;              // Field: whole number
    double gpa;           // Field: decimal number
    boolean isEnrolled;   // Field: true/false
}
```

Fields are declared **inside the class** but **outside any method**.

### Symbol breakdown of `String name;`:
- `String` — The data type of this field.
- `name` — The name of the field.
- `;` — End of statement.

No `static` keyword — these are **instance fields**, meaning each object gets its own copy.

## Default Values

If you don't assign a value, fields get default values:

| Type | Default Value |
|------|--------------|
| `int`, `short`, `byte`, `long` | `0` |
| `double`, `float` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` (null character) |
| `String` and other objects | `null` |

```java
Student s = new Student();
System.out.println(s.name);        // null
System.out.println(s.age);         // 0
System.out.println(s.gpa);         // 0.0
System.out.println(s.isEnrolled);  // false
```

## Setting Field Values

### At declaration:
```java
public class Student {
    String name = "Unknown";
    int age = 0;
    boolean isEnrolled = true;
}
```

### After creating an object:
```java
Student s = new Student();
s.name = "Alex";
s.age = 20;
s.isEnrolled = true;
```

### Using a constructor (covered in Lesson 36):
```java
Student s = new Student("Alex", 20, true);
```

## Fields vs Local Variables

| Feature | Fields | Local Variables |
|---------|--------|----------------|
| Declared | Inside the class, outside methods | Inside a method |
| Default value | Yes (`0`, `false`, `null`, etc.) | No — must initialize before use |
| Scope | Entire class (all methods can use them) | Only within the method/block |
| Lifetime | As long as the object exists | Only while the method runs |

```java
public class Example {
    int field = 10;    // Field — accessible everywhere in the class

    void myMethod() {
        int local = 20;    // Local variable — only in this method
        System.out.println(field);    // ✅ OK
        System.out.println(local);    // ✅ OK
    }

    void anotherMethod() {
        System.out.println(field);    // ✅ OK — field is class-wide
        // System.out.println(local); // ❌ ERROR — local doesn't exist here
    }
}
```

## Common Beginner Mistakes

1. **Declaring fields inside a method** — That makes them local variables, not fields.
2. **Forgetting default values exist** — Uninitialized `int` fields are `0`, not an error.
3. **Expecting local variables to have defaults** — Local variables MUST be initialized; fields don't need to be.
4. **Making everything `static`** — Instance fields should NOT be `static` (unless shared by all objects).

## Mini Practice Exercise

**Task:** Create a `Phone` class with fields: `brand` (String), `price` (double), `isSmartphone` (boolean). Create an object and print all fields.

**Answer:**
```java
public class Phone {
    String brand;
    double price;
    boolean isSmartphone;
}

// In Main.java:
Phone p = new Phone();
p.brand = "Samsung";
p.price = 799.99;
p.isSmartphone = true;
System.out.println(p.brand + " - $" + p.price + " - Smart: " + p.isSmartphone);
// Output: Samsung - $799.99 - Smart: true
```

## Quiz

1. Where are fields declared?
   - a) Inside a method
   - b) Inside the class, outside any method ✅
   - c) Outside the class

2. What is the default value of an `int` field?
   - a) `null`
   - b) `0` ✅
   - c) No default — it's an error

3. What is the default value of a `String` field?
   - a) `""`
   - b) `"null"`
   - c) `null` ✅

---
**Next Lesson:** [Lesson 35 — Methods Inside Classes](35_Methods_In_Classes.md)
