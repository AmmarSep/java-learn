# Lesson 41: Packages

## Simple Explanation

A **package** is a folder that organizes your Java classes. Just like you organize files into folders on your computer, you organize classes into packages.

**Analogy:** A library has sections: Science, History, Fiction. Packages are like those sections — they group related classes together.

## Declaring a Package

The first line of a Java file declares which package it belongs to:

```java
package com.myapp.models;

public class User {
    String name;
}
```

### Symbol breakdown of `package com.myapp.models;`:
- `package` — A Java keyword meaning "this file belongs to the following package."
- `com.myapp.models` — The package name. Each dot `.` represents a subfolder.
- `;` — End of statement.

This file must be located at: `com/myapp/models/User.java`

## Package Naming Convention

- All **lowercase** letters.
- Usually starts with your domain name reversed: `com.google`, `org.apache`, `com.myapp`.
- Dots separate folder levels.

```
com/
  myapp/
    models/
      User.java        → package com.myapp.models
      Product.java     → package com.myapp.models
    utils/
      MathHelper.java  → package com.myapp.utils
    Main.java          → package com.myapp
```

## Why Use Packages?

1. **Organization** — Group related classes together.
2. **Avoid name conflicts** — Two classes can have the same name if they're in different packages.
3. **Access control** — Package-private access (no modifier) limits visibility to the same package.

## The Default Package

If you don't declare a package, the class is in the **default package** (no package). This is fine for practice but not recommended for real projects.

```java
// No package declaration — this is in the default package
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
```

## Common Java Packages

Java comes with many built-in packages:

| Package | Contains |
|---------|----------|
| `java.lang` | Basic classes (`String`, `System`, `Math`) — auto-imported |
| `java.util` | Utility classes (`ArrayList`, `HashMap`, `Scanner`) |
| `java.io` | Input/Output (file reading/writing) |
| `java.time` | Date and time classes |
| `java.math` | `BigDecimal`, `BigInteger` |

## Common Beginner Mistakes

1. **Package name doesn't match folder structure** — The package `com.myapp` means the file must be in `com/myapp/`.
2. **Not putting the package statement first** — It must be the very first line (before imports).
3. **Using uppercase in package names** — Convention: all lowercase.

## Quiz

1. What is a package?
   - a) A type of variable
   - b) A folder that organizes classes ✅
   - c) A Java keyword for printing

2. What must come first in a Java file?
   - a) Import statements
   - b) The package declaration ✅
   - c) The class declaration

3. What package is `String` in?
   - a) `java.util`
   - b) `java.lang` ✅
   - c) `java.io`

---
**Next Lesson:** [Lesson 42 — Imports](42_Imports.md)
