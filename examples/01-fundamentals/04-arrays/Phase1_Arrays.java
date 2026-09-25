// PHASE 1: CORE FUNDAMENTALS
// Concept 1.5: Arrays

public class Phase1_Arrays {
    public static void main(String[] args) {
        // ===== CREATING ARRAYS =====
        System.out.println("=== Creating Arrays ===");

        // Method 1: Declare size, values auto-initialized
        int[] numbers = new int[5];  // Array of 5 integers (default: all 0)
        System.out.println("Array size: " + numbers.length);

        // ===== ACCESSING AND MODIFYING =====
        System.out.println("\n=== Accessing and Modifying ===");

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[4]);

        // ===== ARRAY LITERAL (Shorthand) =====
        System.out.println("\n=== Array Literal ===");

        String[] fruits = {"apple", "banana", "cherry", "date"};
        System.out.println("Fruits array size: " + fruits.length);
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  " + fruits[i]);
        }

        // ===== FOR LOOP ITERATION =====
        System.out.println("\n=== Iteration with FOR Loop ===");

        int[] scores = {85, 92, 78, 95, 88};
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Score " + i + ": " + scores[i]);
        }

        // ===== FOR-EACH LOOP (Simpler) =====
        System.out.println("\n=== Iteration with FOR-EACH Loop ===");

        double[] temperatures = {98.6, 72.3, 65.4, 88.9};
        for (double temp : temperatures) {
            System.out.println("Temperature: " + temp);
        }

        // ===== COMMON ARRAY OPERATIONS =====
        System.out.println("\n=== Array Operations ===");

        int[] data = {10, 20, 30, 40, 50};

        // Sum
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        System.out.println("Sum: " + sum);

        // Average
        double average = (double) sum / data.length;
        System.out.println("Average: " + average);

        // Find max
        int max = data[0];
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Maximum: " + max);

        // Find min
        int min = data[0];
        for (int value : data) {
            if (value < min) {
                min = value;
            }
        }
        System.out.println("Minimum: " + min);

        // ===== MULTIDIMENSIONAL ARRAYS =====
        System.out.println("\n=== 2D Arrays (Matrix) ===");

        int[][] matrix = new int[3][3];

        // Fill the matrix
        int value = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                matrix[row][col] = value;
                value++;
            }
        }

        // Print the matrix
        System.out.println("3x3 Matrix:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        // ===== 2D ARRAY LITERAL =====
        System.out.println("\n=== 2D Array Literal ===");

        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Element at [1][2]: " + grid[1][2]);  // 6
        System.out.println("Element at [2][0]: " + grid[2][0]);  // 7

        // ===== STRING ARRAY =====
        System.out.println("\n=== String Array ===");

        String[] names = {"Alice", "Bob", "Charlie", "Diana"};
        System.out.println("Names:");
        for (String name : names) {
            System.out.println("  - " + name);
        }

        // ===== ARRAY OF DIFFERENT TYPES =====
        System.out.println("\n=== Boolean Array ===");

        boolean[] flags = {true, false, true, false, true};
        System.out.println("Flags:");
        for (boolean flag : flags) {
            System.out.println("  " + flag);
        }

        // ===== ARRAY BOUNDS CHECKING =====
        System.out.println("\n=== Array Bounds ===");

        int[] test = {1, 2, 3};
        System.out.println("Valid access: " + test[0] + ", " + test[1] + ", " + test[2]);

        // This would throw ArrayIndexOutOfBoundsException:
        // System.out.println(test[3]);  // ERROR: index out of bounds

        // ===== STRINGS VS CHARACTER ARRAY =====
        System.out.println("\n=== String Character Access ===");

        String text = "Hello";
        System.out.println("String length: " + text.length());
        System.out.println("First character: " + text.charAt(0));  // 'H'
        System.out.println("Last character: " + text.charAt(4));   // 'o'
        System.out.println("Substring: " + text.substring(1, 4));  // "ell"
    }
}

/*
Key Points:
- Arrays are fixed size: new int[5] creates array of 5 slots
- Index from 0 to length-1
- .length property gives size
- for-each loop: for (type item : array) { }
- 2D arrays: new int[rows][cols]
- String has .length(), .charAt(), .substring()
- Array index out of bounds is runtime error
*/
