// PHASE 0: ENVIRONMENT & EXECUTION
// Concept 0.2: Basic Program Structure

public class Phase0_HelloWorld {
    public static void main(String[] args) {
        // Line-by-line breakdown:
        // System = built-in Java class
        // .out = output stream (console)
        // .println() = method to print + newline
        // "Hello, Java!" = String literal (text in quotes)
        // ; = statement terminator

        System.out.println("Hello, Java!");
    }
}

/*
How to run this:
1. Compile: javac Phase0_HelloWorld.java
2. Run: java Phase0_HelloWorld
3. Output: Hello, Java!

What happens:
- javac reads Phase0_HelloWorld.java
- Checks for syntax errors
- Creates Phase0_HelloWorld.class (bytecode)
- java command runs the JVM
- JVM finds main() method
- JVM executes System.out.println()
*/
