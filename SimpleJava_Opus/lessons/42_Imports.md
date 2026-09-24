# Lesson 42: Imports

## Simple Explanation

An **import** statement tells Java which classes from other packages you want to use. Without importing, you'd need to write the full package name every time.

**Analogy:** Importing is like adding a contact to your phone. Instead of typing the full phone number every time, you save it under a name.

## The `import` Statement

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Hello, " + name);
    }
}
```

### Symbol breakdown of `import java.util.Scanner;`:
- `import` — A Java keyword meaning "I want to use this class."
- `java.util` — The package where `Scanner` lives.
- `.` — Dot separating package from class name.
- `Scanner` — The specific class to import.
- `;` — End of statement.

## Without Import (Fully Qualified Name)

You can use a class without importing by writing its full name every time:

```java
// Without import:
java.util.Scanner input = new java.util.Scanner(System.in);
java.util.ArrayList<String> list = new java.util.ArrayList<>();
```

That's long and painful. Importing is much easier:

```java
import java.util.Scanner;
import java.util.ArrayList;

Scanner input = new Scanner(System.in);
ArrayList<String> list = new ArrayList<>();
```

## Wildcard Import `*`

Import **all classes** from a package:

```java
import java.util.*;    // Import everything from java.util
```

### Symbol breakdown:
- `java.util` — The package.
- `.` — Dot.
- `*` — An **asterisk** (wildcard) meaning "all classes in this package."
- `;` — End of statement.

This imports `Scanner`, `ArrayList`, `HashMap`, and everything else in `java.util`.

**Note:** Wildcard imports don't import sub-packages. `java.util.*` does NOT import `java.util.stream.*`.

## `java.lang` Is Auto-Imported

Classes in `java.lang` are automatically available — no import needed:
- `String`
- `System`
- `Math`
- `Integer`, `Double`, `Boolean`
- `Object`

That's why you can use `System.out.println()` and `String` without importing anything.

## Import Order (Convention)

```java
package com.myapp;

import java.util.ArrayList;      // 1. Java standard library
import java.util.List;

import javax.swing.JFrame;       // 2. Java extensions

import com.google.gson.Gson;     // 3. Third-party libraries

import com.myapp.utils.Helper;   // 4. Your own packages
```

## Static Imports

You can import static methods and fields to use them without the class name:

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        System.out.println(PI);          // Instead of Math.PI
        System.out.println(sqrt(25));    // Instead of Math.sqrt(25)
    }
}
```

### Symbol breakdown of `import static java.lang.Math.PI;`:
- `import` — Import keyword.
- `static` — Import a static member (not a class).
- `java.lang.Math` — The class.
- `.` — Dot.
- `PI` — The specific static field to import.
- `;` — End of statement.

## Common Beginner Mistakes

1. **Importing `java.lang` classes** — Not needed. `String`, `System`, etc. are auto-imported.
2. **Wrong package** — `import java.util.Scanner;` is correct. `import java.Scanner;` is wrong.
3. **Import after class declaration** — Imports must come before the class, after the package.
4. **Forgetting to import** — If you use `ArrayList` without importing, you get a compile error.

## File Structure Order

```java
package com.myapp;             // 1. Package (optional, first line)

import java.util.Scanner;     // 2. Imports (after package, before class)

public class Main {            // 3. Class declaration
    // code
}
```

## Quiz

1. What does `import` do?
   - a) Downloads a library
   - b) Lets you use a class from another package without the full name ✅
   - c) Creates a new class

2. What does `import java.util.*;` import?
   - a) Only Scanner
   - b) All classes in java.util ✅
   - c) All classes in Java

3. Do you need to import `String`?
   - a) Yes
   - b) No ✅ — it's in `java.lang`, which is auto-imported.

---
**Next Lesson:** [Lesson 43 — Strings in Detail](43_Strings_Detail.md)
