# Lesson 68: Date and Time Basics

## Simple Explanation

Java's `java.time` package (introduced in Java 8) provides classes for working with dates, times, and durations.

## Key Classes

| Class | What It Represents | Example |
|-------|--------------------|---------|
| `LocalDate` | Date only (no time) | `2024-03-15` |
| `LocalTime` | Time only (no date) | `14:30:00` |
| `LocalDateTime` | Date and time | `2024-03-15T14:30:00` |
| `Instant` | A point in time (UTC) | Timestamps |
| `Duration` | Amount of time | 2 hours, 30 minutes |
| `Period` | Amount of date | 3 years, 2 months |

## Getting Current Date/Time

```java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

LocalDate today = LocalDate.now();
System.out.println(today);          // 2024-03-15

LocalTime now = LocalTime.now();
System.out.println(now);            // 14:30:15.123

LocalDateTime dateTime = LocalDateTime.now();
System.out.println(dateTime);       // 2024-03-15T14:30:15.123
```

### Symbol breakdown of `LocalDate.now()`:
- `LocalDate` — The class for dates.
- `.` — Access a static method.
- `now()` — A static method that returns the current date.

## Creating Specific Dates

```java
LocalDate birthday = LocalDate.of(2000, 6, 15);    // June 15, 2000
LocalTime lunchTime = LocalTime.of(12, 30);          // 12:30 PM
LocalDateTime meeting = LocalDateTime.of(2024, 3, 15, 14, 30);  // March 15, 2024 at 2:30 PM
```

### Symbol breakdown of `LocalDate.of(2000, 6, 15)`:
- `LocalDate.of` — Static factory method to create a specific date.
- `(2000, 6, 15)` — Year, month, day.

## Useful Operations

```java
LocalDate today = LocalDate.now();

// Get parts
int year = today.getYear();           // 2024
int month = today.getMonthValue();    // 3
int day = today.getDayOfMonth();      // 15

// Add/subtract
LocalDate nextWeek = today.plusDays(7);
LocalDate lastMonth = today.minusMonths(1);
LocalDate nextYear = today.plusYears(1);

// Compare
boolean isBefore = today.isBefore(nextWeek);    // true
boolean isAfter = today.isAfter(lastMonth);      // true
```

## Formatting

```java
import java.time.format.DateTimeFormatter;

LocalDate date = LocalDate.of(2024, 3, 15);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
String formatted = date.format(formatter);
System.out.println(formatted);    // 03/15/2024

// Parsing a String to a date
LocalDate parsed = LocalDate.parse("03/15/2024", formatter);
```

### Common format patterns:
- `yyyy` — 4-digit year (2024)
- `MM` — 2-digit month (03)
- `dd` — 2-digit day (15)
- `HH` — Hour (14)
- `mm` — Minute (30)
- `ss` — Second (00)

## Important: Immutability

Date/time classes are **immutable**. Methods like `plusDays()` return a **new** object:

```java
LocalDate today = LocalDate.now();
today.plusDays(1);                  // Returns a new date but doesn't change today!
LocalDate tomorrow = today.plusDays(1);  // Correct: save the result
```

## Quiz

1. Which class represents a date without time?
   - a) `LocalTime`
   - b) `LocalDate` ✅
   - c) `LocalDateTime`

2. Does `today.plusDays(1)` change `today`?
   - a) Yes
   - b) No — it returns a new object ✅

---
**Next Lesson:** [Lesson 69 — Debugging](69_Debugging.md)
