public class CommandLineArguments {
    public static void main(String[] args) {
        // Print the number of arguments passed
        System.out.println("Number of arguments: " + args.length);

        // Print each argument
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
    }
}
