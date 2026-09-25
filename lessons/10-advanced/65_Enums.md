[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](64_Generics.md) · [Next](66_Lambdas.md)

---

# Lesson 65: Enums

## Simple Explanation

An **enum** (short for "enumeration") is a special type that represents a **fixed set of constants**. Use it when a variable can only be one of a few specific values.

**Analogy:** Days of the week — there are exactly 7, and they never change.

## Defining an Enum

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

### Symbol breakdown:
- `public` — Access modifier.
- `enum` — Keyword meaning "this is an enumeration" (not `class`!).
- `Day` — The name (PascalCase, like a class).
- `{` — Start of enum body.
- `MONDAY, TUESDAY, ...` — The **constants** (values). Convention: UPPER_SNAKE_CASE. Separated by commas `,`.
- `}` — End of enum body.

## Using an Enum

```java
Day today = Day.WEDNESDAY;
System.out.println(today);    // WEDNESDAY

if (today == Day.WEDNESDAY) {
    System.out.println("It's hump day!");
}
```

### Symbol breakdown of `Day today = Day.WEDNESDAY`:
- `Day` — The enum type.
- `today` — Variable name.
- `=` — Assignment.
- `Day.WEDNESDAY` — Access the `WEDNESDAY` constant from the `Day` enum.

## Enums in Switch

Enums work great with `switch`:

```java
switch (today) {
    case MONDAY -> System.out.println("Start of week");
    case FRIDAY -> System.out.println("Almost weekend!");
    case SATURDAY, SUNDAY -> System.out.println("Weekend!");
    default -> System.out.println("Regular day");
}
```

## Enums with Fields and Methods

Enums can have fields, constructors, and methods:

```java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private final double mass;
    private final double radius;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() { return mass; }
    public double getRadius() { return radius; }
}
```

## Useful Enum Methods

```java
Day d = Day.MONDAY;
System.out.println(d.name());       // "MONDAY" (String name)
System.out.println(d.ordinal());    // 0 (position, starting from 0)

Day[] allDays = Day.values();       // Array of all enum values
Day fri = Day.valueOf("FRIDAY");    // Convert String to enum
```

## Why Use Enums Instead of Strings or Ints?

```java
// BAD: Using Strings — typos cause bugs
String day = "Mnday";    // Oops! No compile error.

// GOOD: Using Enums — typos cause compile errors
Day day = Day.MNDAY;     // ❌ Compile error — MNDAY doesn't exist!
```

## Quiz

1. What is an enum?
   - a) A type of loop
   - b) A fixed set of constants ✅
   - c) A type of exception

2. Can you use `==` to compare enum values?
   - a) Yes ✅ (enums are safe with `==`)
   - b) No

---
**Next Lesson:** [Lesson 66 — Lambdas](66_Lambdas.md)
