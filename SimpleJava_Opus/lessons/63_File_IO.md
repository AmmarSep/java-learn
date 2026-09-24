# Lesson 63: File Reading and Writing

## Simple Explanation

Java can read from and write to files on your computer. The main classes are in `java.io` and `java.nio.file`.

## Writing to a File

```java
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write("Hello, File!\n");
            writer.write("This is line 2.\n");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Symbol breakdown of `new FileWriter("output.txt")`:
- `new` — Create a new object.
- `FileWriter` — A class that writes text to files.
- `("output.txt")` — The file name/path.

The `try-with-resources` ensures the file is **automatically closed** when done.

## Reading from a File

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner reader = new Scanner(new File("output.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```

### Key methods:
- `reader.hasNextLine()` — Returns `true` if there's another line to read.
- `reader.nextLine()` — Reads and returns the next line.

## Modern Approach: `Files` Class (Java 7+)

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

// Read all lines
List<String> lines = Files.readAllLines(Path.of("output.txt"));
for (String line : lines) {
    System.out.println(line);
}

// Read entire file as one String (Java 11+)
String content = Files.readString(Path.of("output.txt"));

// Write to a file
Files.writeString(Path.of("data.txt"), "Hello from Files!");
```

## Checking If a File Exists

```java
import java.io.File;

File f = new File("output.txt");
System.out.println(f.exists());      // true or false
System.out.println(f.isFile());      // true if it's a file
System.out.println(f.isDirectory()); // true if it's a folder
System.out.println(f.getName());     // "output.txt"
```

## Common Beginner Mistakes

1. **Not handling `IOException`** — File operations are checked exceptions; you must handle them.
2. **Forgetting to close files** — Use try-with-resources to auto-close.
3. **Wrong file path** — Relative paths are relative to where you run the program.

## Quiz

1. What exception must you handle for file operations?
   - a) `NullPointerException`
   - b) `IOException` ✅
   - c) `ArithmeticException`

2. What does try-with-resources do?
   - a) Tries multiple times
   - b) Automatically closes the resource when done ✅

---
**Next Lesson:** [Lesson 64 — Generics](64_Generics.md)
