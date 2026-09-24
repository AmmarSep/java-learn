# Lesson 70: Unit Testing Basics

## Simple Explanation

**Unit testing** means writing code that automatically tests your code. Instead of manually running your program and checking the output, you write small tests that verify each piece works correctly.

**Analogy:** Before shipping a car, engineers test each part (brakes, engine, lights) individually. Unit tests do the same for code.

## JUnit — Java's Testing Framework

**JUnit** is the most popular testing framework for Java. A test looks like this:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    void testAddNegatives() {
        Calculator calc = new Calculator();
        assertEquals(-1, calc.add(-3, 2));
    }
}
```

### Symbol-by-symbol breakdown:

- `import org.junit.jupiter.api.Test;` — Import the `@Test` annotation from JUnit.
- `import static org.junit.jupiter.api.Assertions.*;` — Import assertion methods. The `static` keyword lets us call them without the class name.
- `@Test` — An **annotation** that marks a method as a test. JUnit will find and run it.
- `void testAdd()` — A test method. Convention: name describes what's being tested.
- `assertEquals(5, result)` — An **assertion**: "I expect `result` to equal `5`." If it doesn't, the test **fails**.

## Common Assertions

| Assertion | What It Checks |
|-----------|---------------|
| `assertEquals(expected, actual)` | Values are equal |
| `assertNotEquals(a, b)` | Values are NOT equal |
| `assertTrue(condition)` | Condition is `true` |
| `assertFalse(condition)` | Condition is `false` |
| `assertNull(object)` | Object is `null` |
| `assertNotNull(object)` | Object is NOT `null` |
| `assertThrows(Exception.class, () -> code)` | Code throws an exception |

## Example: Testing a Calculator

```java
// Calculator.java
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}
```

```java
// CalculatorTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(7, calc.subtract(10, 3));
    }

    @Test
    void testDivide() {
        assertEquals(5, calc.divide(10, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}
```

### Symbol breakdown of `assertThrows(ArithmeticException.class, () -> calc.divide(10, 0))`:
- `assertThrows` — Assert that an exception is thrown.
- `ArithmeticException.class` — The expected exception type. `.class` gives the class object.
- `,` — Comma separating arguments.
- `() -> calc.divide(10, 0)` — A lambda containing the code that should throw the exception.

## Running Tests

- **IntelliJ IDEA**: Right-click the test class → "Run Tests" (or click the green play button).
- **Command line**: Use build tools like Maven (`mvn test`) or Gradle (`gradle test`).

**Green** = all tests pass ✅  
**Red** = one or more tests fail ❌

## Best Practices

1. **One assertion per test** (when practical) — makes failures clear.
2. **Test edge cases** — zero, negative, null, empty, max values.
3. **Name tests descriptively** — `testAddPositiveNumbers`, not `test1`.
4. **Tests should be independent** — One test shouldn't depend on another.

## Quiz

1. What does `@Test` do?
   - a) Creates a class
   - b) Marks a method as a test that JUnit should run ✅
   - c) Prints test results

2. What does `assertEquals(5, result)` do?
   - a) Sets result to 5
   - b) Checks that result equals 5, fails if not ✅
   - c) Prints 5

---
**Next Lesson:** [Lesson 71 — Small Beginner Projects](71_Projects.md)
