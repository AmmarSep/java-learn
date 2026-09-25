// PHASE 0: ENVIRONMENT & EXECUTION
// Concept 0.4: Command-Line Arguments

public class Phase0_CommandLineArgs {
    public static void main(String[] args) {
        // args is an array of String
        // It contains whatever user typed after "java Phase0_CommandLineArgs"

        // Print how many arguments were passed
        System.out.println("Number of arguments: " + args.length);

        // Print each argument
        if (args.length == 0) {
            System.out.println("No arguments provided");
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + i + ": " + args[i]);
            }
        }
    }
}

/*
How to run this:

With no arguments:
javac Phase0_CommandLineArgs.java
java Phase0_CommandLineArgs
Output:
Number of arguments: 0
No arguments provided

With arguments:
java Phase0_CommandLineArgs hello world java
Output:
Number of arguments: 3
Argument 0: hello
Argument 1: world
Argument 2: java

With different arguments:
java Phase0_CommandLineArgs Alice Bob 25
Output:
Number of arguments: 3
Argument 0: Alice
Argument 1: Bob
Argument 2: 25
*/
