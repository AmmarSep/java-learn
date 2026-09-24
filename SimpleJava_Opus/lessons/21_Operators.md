# Lesson 21: Operators

## Simple Explanation

An **operator** is a symbol that tells Java to perform an operation on values. Just like `+` and `-` in math, Java has operators for math, assignment, and more.

## Arithmetic Operators (Math)

| Operator | Name | Example | Result |
|----------|------|---------|--------|
| `+` | Addition | `5 + 3` | `8` |
| `-` | Subtraction | `5 - 3` | `2` |
| `*` | Multiplication | `5 * 3` | `15` |
| `/` | Division | `5 / 3` | `1` (integer division!) |
| `%` | Modulus (remainder) | `5 % 3` | `2` |

```java
public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println(a + b);    // 13
        System.out.println(a - b);    // 7
        System.out.println(a * b);    // 30
        System.out.println(a / b);    // 3 (integer division drops decimal)
        System.out.println(a % b);    // 1 (remainder of 10 ÷ 3)
    }
}
```

## Assignment Operators

| Operator | Example | Same As |
|----------|---------|---------|
| `=` | `x = 5` | Assign 5 to x |
| `+=` | `x += 3` | `x = x + 3` |
| `-=` | `x -= 3` | `x = x - 3` |
| `*=` | `x *= 3` | `x = x * 3` |
| `/=` | `x /= 3` | `x = x / 3` |
| `%=` | `x %= 3` | `x = x % 3` |

```java
public class Main {
    public static void main(String[] args) {
        int x = 10;         // x is 10
        x += 5;             // x = x + 5 → x is now 15
        System.out.println(x);  // 15

        x -= 3;             // x = x - 3 → x is now 12
        System.out.println(x);  // 12

        x *= 2;             // x = x * 2 → x is now 24
        System.out.println(x);  // 24
    }
}
```

### Symbol breakdown of `x += 5;`:
- `x` — The variable.
- `+=` — The "add and assign" operator. It means "add 5 to x and store the result back in x."
- `5` — The value to add.
- `;` — End of statement.

## Increment and Decrement

| Operator | Name | Example | Effect |
|----------|------|---------|--------|
| `++` | Increment | `x++` | Add 1 to x |
| `--` | Decrement | `x--` | Subtract 1 from x |

```java
public class Main {
    public static void main(String[] args) {
        int count = 10;

        count++;                       // count = count + 1 → 11
        System.out.println(count);     // 11

        count--;                       // count = count - 1 → 10
        System.out.println(count);     // 10
    }
}
```

### Symbol breakdown of `count++`:
- `count` — The variable.
- `++` — Two plus signs together. This means "add 1 to this variable."

### `++x` vs `x++` (Pre vs Post):
- `++x` — Increment **first**, then use the value.
- `x++` — Use the value **first**, then increment.

```java
int a = 5;
System.out.println(a++);   // Prints 5, THEN a becomes 6
System.out.println(a);     // Prints 6

int b = 5;
System.out.println(++b);   // b becomes 6 FIRST, then prints 6
System.out.println(b);     // Prints 6
```

For beginners: just use `x++` or `x--` on their own line to avoid confusion.

## String Concatenation with `+`

When `+` is used with Strings, it **joins** them instead of doing math:

```java
System.out.println("Hello" + " " + "World");  // Hello World
System.out.println("Age: " + 25);              // Age: 25
System.out.println(5 + 3);                     // 8 (both are numbers → math)
System.out.println("5" + 3);                   // 53 (one is a String → join)
```

## Operator Precedence (Order of Operations)

Java follows math rules:
1. `()` — Parentheses first
2. `*`, `/`, `%` — Multiplication, division, modulus
3. `+`, `-` — Addition, subtraction

```java
System.out.println(2 + 3 * 4);       // 14 (3*4=12, then 2+12=14)
System.out.println((2 + 3) * 4);     // 20 (2+3=5, then 5*4=20)
```

## Common Beginner Mistakes

1. **Confusing `=` and `==`** — `=` assigns, `==` compares.
2. **Integer division** — `7 / 2` gives `3`, not `3.5`.
3. **Forgetting operator precedence** — `2 + 3 * 4` is `14`, not `20`.
4. **Using `x` for multiplication** — It's `*` (asterisk).

## Mini Practice Exercise

**Task:** What does each line print?

```java
int x = 10;
x += 5;
System.out.println(x);
x *= 2;
System.out.println(x);
x--;
System.out.println(x);
```

**Answers:**
1. `15` (10 + 5)
2. `30` (15 * 2)
3. `29` (30 - 1)

## Quiz

1. What does `x += 3` mean?
   - a) x equals 3
   - b) x = x + 3 ✅
   - c) x = 3 + 3

2. What does `%` do?
   - a) Calculates percentage
   - b) Gives the remainder after division ✅
   - c) Divides by 100

3. What does `x++` do?
   - a) Doubles x
   - b) Adds 1 to x ✅
   - c) Resets x to 0

4. What is `"5" + 3`?
   - a) `8`
   - b) `"53"` ✅
   - c) Error

---
**Next Lesson:** [Lesson 22 — Comparisons](22_Comparisons.md)
