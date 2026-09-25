[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](22_Comparisons.md) · [Next](24_If_Else.md)

**Runnable companion:** [Phase1_Operators](../../examples/01-fundamentals/02-operators/Phase1_Operators.java). See the [runner guide](../../scripts/README.md).

---

# Lesson 23: Logical Operators

## Simple Explanation

**Logical operators** combine multiple boolean conditions. They let you ask complex questions like "Is the user older than 18 **AND** has a valid ID?"

## The Three Logical Operators

| Operator | Name | Meaning | Example |
|----------|------|---------|---------|
| `&&` | AND | Both must be true | `true && true` → `true` |
| `\|\|` | OR | At least one must be true | `true \|\| false` → `true` |
| `!` | NOT | Flips true to false, false to true | `!true` → `false` |

## AND Operator `&&`

Both conditions must be `true` for the result to be `true`.

| Left | Right | Result |
|------|-------|--------|
| `true` | `true` | `true` |
| `true` | `false` | `false` |
| `false` | `true` | `false` |
| `false` | `false` | `false` |

```java
int age = 25;
boolean hasID = true;

System.out.println(age >= 18 && hasID);     // true (both are true)
System.out.println(age >= 18 && !hasID);    // false (hasID is flipped to false)
```

### Symbol breakdown of `age >= 18 && hasID`:
- `age >= 18` — First condition: is age greater than or equal to 18? (`true`)
- `&&` — Two ampersand symbols. The AND operator: "both must be true."
- `hasID` — Second condition: is hasID true? (`true`)
- Result: `true && true` → `true`

**Analogy:** To enter a movie theater, you need a ticket **AND** to be old enough. Both conditions must be met.

## OR Operator `||`

At least one condition must be `true` for the result to be `true`.

| Left | Right | Result |
|------|-------|--------|
| `true` | `true` | `true` |
| `true` | `false` | `true` |
| `false` | `true` | `true` |
| `false` | `false` | `false` |

```java
boolean hasCard = false;
boolean hasCash = true;

System.out.println(hasCard || hasCash);    // true (at least one is true)
System.out.println(hasCard || false);      // false (both are false)
```

### Symbol breakdown of `hasCard || hasCash`:
- `hasCard` — First condition (`false`).
- `||` — Two pipe symbols (vertical bars). The OR operator: "at least one must be true."
- `hasCash` — Second condition (`true`).
- Result: `false || true` → `true`

**Analogy:** To pay for lunch, you need a card **OR** cash. At least one is enough.

## NOT Operator `!`

Flips a boolean value: `true` becomes `false`, `false` becomes `true`.

```java
boolean isRaining = true;

System.out.println(!isRaining);    // false (flipped from true)
System.out.println(!false);        // true (flipped from false)
```

### Symbol breakdown of `!isRaining`:
- `!` — An exclamation mark. The NOT operator: "flip this value."
- `isRaining` — The boolean value (`true`).
- Result: `!true` → `false`

**Analogy:** NOT raining means the opposite of raining.

## Combining Operators

You can combine multiple logical operators:

```java
int age = 25;
boolean isStudent = true;
boolean hasCoupon = false;

// Gets a discount if: (student OR has coupon) AND is an adult
boolean getsDiscount = (isStudent || hasCoupon) && age >= 18;
System.out.println(getsDiscount);  // true
```

### Symbol breakdown:
- `(` — Opening parenthesis. Groups the OR condition.
- `isStudent || hasCoupon` — `true || false` → `true`
- `)` — Closing parenthesis.
- `&&` — AND operator.
- `age >= 18` — `25 >= 18` → `true`
- Final: `true && true` → `true`

**Use parentheses `()` to make the order clear!**

## Common Beginner Mistakes

1. **Using `&` instead of `&&`** — Single `&` is a different operator (bitwise AND). Always use `&&`.
2. **Using `|` instead of `||`** — Single `|` is bitwise OR. Always use `||`.
3. **Forgetting that `!` flips the value** — `!true` is `false`, `!false` is `true`.
4. **Not using parentheses** — Without `()`, the order might not be what you expect. `&&` has higher priority than `||`.

## Mini Practice Exercise

**Task:** What does each line print?

```java
System.out.println(true && true);
System.out.println(true && false);
System.out.println(false || true);
System.out.println(false || false);
System.out.println(!true);
System.out.println(!(5 > 3));
```

**Answers:**
1. `true`
2. `false`
3. `true`
4. `false`
5. `false`
6. `false` — `5 > 3` is `true`, then `!true` is `false`.

## Quiz

1. What does `&&` mean?
   - a) OR
   - b) AND ✅
   - c) NOT

2. What is `true || false`?
   - a) `true` ✅
   - b) `false`
   - c) Error

3. What does `!` do?
   - a) Checks equality
   - b) Flips a boolean value ✅
   - c) Adds two values

4. What is `true && false || true`?
   - a) `true` ✅ — `&&` evaluates first: `false || true` → `true`
   - b) `false`
   - c) Error

---
**Next Lesson:** [Lesson 24 — `if`, `else if`, `else`](24_If_Else.md)
