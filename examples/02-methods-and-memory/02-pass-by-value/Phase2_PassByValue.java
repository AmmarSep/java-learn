// PHASE 2: METHODS & MEMORY
// Concept 2.3: Pass-by-Value

public class Phase2_PassByValue {
    // Method that tries to change primitive parameter
    public static void changeValue(int x) {
        x = 100;  // Only changes the copy
        System.out.println("Inside method: x = " + x);
    }

    // Method that changes an object (String reference)
    public static void changeName(String str) {
        str = "Bob";  // Changes the local copy's reference
        System.out.println("Inside method: str = " + str);
    }

    // Method that modifies array contents
    public static void modifyArray(int[] arr) {
        arr[0] = 999;  // Modifies the actual array
        System.out.println("Inside method: arr[0] = " + arr[0]);
    }

    // Method that tries to reassign array reference
    public static void reassignArray(int[] arr) {
        arr = new int[]{5, 6, 7};  // Only changes local copy of reference
        System.out.println("Inside method: arr length = " + arr.length);
    }

    public static void main(String[] args) {
        System.out.println("=== Pass-by-Value: Primitives ===");

        int original = 5;
        System.out.println("Before method call: original = " + original);
        changeValue(original);  // Pass a copy
        System.out.println("After method call: original = " + original);  // Still 5
        System.out.println("Conclusion: Primitive unchanged by method\n");

        // ===== PASS-BY-VALUE WITH OBJECTS =====
        System.out.println("=== Pass-by-Value: Objects (Strings) ===");

        String name = "Alice";
        System.out.println("Before method call: name = " + name);
        changeName(name);  // Pass a copy of the reference
        System.out.println("After method call: name = " + name);  // Still "Alice"
        System.out.println("Conclusion: Object reference unchanged (string is immutable anyway)\n");

        // ===== PASS-BY-VALUE: ARRAY CONTENTS =====
        System.out.println("=== Pass-by-Value: Array Contents CAN Be Modified ===");

        int[] numbers = {1, 2, 3};
        System.out.println("Before method call: numbers[0] = " + numbers[0]);
        modifyArray(numbers);  // Pass a copy of the array reference
        System.out.println("After method call: numbers[0] = " + numbers[0]);  // Changed to 999
        System.out.println("Conclusion: Array contents modified (same object)\n");

        // ===== PASS-BY-VALUE: ARRAY REFERENCE =====
        System.out.println("=== Pass-by-Value: Array Reference CAN'T Be Reassigned ===");

        int[] array = {1, 2, 3};
        System.out.println("Before method call: array.length = " + array.length);  // 3
        reassignArray(array);  // Pass a copy of the reference
        System.out.println("After method call: array.length = " + array.length);  // Still 3
        System.out.println("Conclusion: Array reference unchanged (reassignment only changed copy)\n");

        // ===== MEMORY VISUALIZATION =====
        System.out.println("=== Memory Visualization ===");
        System.out.println("\nPrimitives:");
        System.out.println("  Stack: original (value = 5)");
        System.out.println("  Method gets copy of value");
        System.out.println("  Copy is modified, original untouched");

        System.out.println("\nObjects (Arrays):");
        System.out.println("  Stack: numbers (reference to array)");
        System.out.println("  Heap: {1, 2, 3} (actual array)");
        System.out.println("  Method gets copy of reference");
        System.out.println("  Copy points to SAME array");
        System.out.println("  Method can modify array contents");
        System.out.println("  But cannot change what original reference points to");
    }
}

/*
Key Insight:
- Java ALWAYS passes by value
- For primitives: copy of value → changes don't affect original
- For objects: copy of reference → can modify object contents, but reassignment doesn't affect original

Analogy:
- Primitive: friend's phone number (give copy) → they change the copy, yours unchanged
- Object: friend's address (give copy) → they can enter the house and rearrange furniture, but telling them a new address doesn't change your address
*/
