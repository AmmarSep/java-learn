# Lesson 58: Interfaces

## Simple Explanation

An **interface** is a **contract** — it defines what methods a class must have, without saying how they work. A class that **implements** an interface promises to provide all the methods listed.

**Analogy:** A job description lists required skills. The interface says "must be able to swim." How you swim is up to you.

## Defining an Interface

```java
public interface Printable {
    void print();
}
```

### Symbol breakdown:
- `public` — Access modifier.
- `interface` — Keyword meaning "this is an interface" (not `class`!).
- `Printable` — The name. Convention: often adjectives or "-able" words.
- `{` — Start of interface body.
- `void print();` — An **abstract method**. No body, just a signature. Classes that implement this must provide the body.
- `}` — End of interface body.

## Implementing an Interface

```java
public class Document implements Printable {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }
}

public class Photo implements Printable {
    @Override
    public void print() {
        System.out.println("Printing photo...");
    }
}
```

### Symbol breakdown of `class Document implements Printable`:
- `implements` — A Java **keyword** meaning "this class promises to fulfill this interface's contract."
- `Printable` — The interface being implemented.

## Multiple Interfaces

Unlike classes (single inheritance), a class can implement **multiple** interfaces:

```java
public interface Printable {
    void print();
}

public interface Saveable {
    void save();
}

public class Document implements Printable, Saveable {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void save() {
        System.out.println("Saving...");
    }
}
```

### Symbol breakdown of `implements Printable, Saveable`:
- `implements` — Keyword.
- `Printable` — First interface.
- `,` — Comma separating interfaces.
- `Saveable` — Second interface.

## Default Methods (Java 8+)

Interfaces can have methods **with a body** using `default`:

```java
public interface Greeting {
    default void greet() {
        System.out.println("Hello!");
    }
}
```

Classes get this method automatically but can override it.

## Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|---------|-----------|---------------|
| Keyword | `interface` | `abstract class` |
| Implementation keyword | `implements` | `extends` |
| Multiple? | Yes (multiple interfaces) | No (single class) |
| Fields | Only `static final` constants | Any fields |
| Constructors | No | Yes |
| Default methods | Yes (Java 8+) | Yes |

## Common Beginner Mistakes

1. **Forgetting to implement all methods** — You must implement every method in the interface.
2. **Using `extends` instead of `implements`** — Classes **implement** interfaces, **extend** classes.
3. **Forgetting `public` on implemented methods** — Interface methods are implicitly `public`, so implementations must also be `public`.

## Quiz

1. What keyword makes a class fulfill an interface?
   - a) `extends`
   - b) `implements` ✅
   - c) `interface`

2. Can a class implement multiple interfaces?
   - a) Yes ✅
   - b) No

3. Can an interface have fields?
   - a) Only `static final` constants ✅
   - b) Any fields

---
**Next Lesson:** [Lesson 59 — Polymorphism](59_Polymorphism.md)
