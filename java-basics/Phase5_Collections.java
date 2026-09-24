// PHASE 5: COLLECTIONS & GENERICS
// Concept 5.1-5.5: List, Set, Map with Generics

import java.util.*;

public class Phase5_Collections {
    public static void main(String[] args) {
        System.out.println("=== ArrayList (Dynamic List) ===\n");

        List<String> fruits = new ArrayList<>();

        // Add elements
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("date");

        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("First: " + fruits.get(0));
        System.out.println("Last: " + fruits.get(fruits.size() - 1));

        // Remove
        fruits.remove("banana");
        System.out.println("After removing banana: " + fruits);

        // Check if contains
        System.out.println("Contains 'apple'? " + fruits.contains("apple"));

        System.out.println("\n=== Iterating Lists ===\n");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("For loop:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("  " + numbers.get(i));
        }

        System.out.println("For-each loop:");
        for (int num : numbers) {
            System.out.println("  " + num);
        }

        System.out.println("\n=== HashSet (Unique Values) ===\n");

        Set<String> uniqueFruits = new HashSet<>();

        uniqueFruits.add("apple");
        uniqueFruits.add("banana");
        uniqueFruits.add("apple");      // Duplicate, ignored
        uniqueFruits.add("cherry");

        System.out.println("Set (duplicates removed): " + uniqueFruits);
        System.out.println("Size: " + uniqueFruits.size());

        System.out.println("\n=== TreeSet (Sorted Set) ===\n");

        Set<Integer> sortedNumbers = new TreeSet<>();

        sortedNumbers.add(5);
        sortedNumbers.add(2);
        sortedNumbers.add(8);
        sortedNumbers.add(1);
        sortedNumbers.add(9);

        System.out.println("TreeSet (sorted): " + sortedNumbers);

        System.out.println("\n=== HashMap (Key-Value Pairs) ===\n");

        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 28);
        ages.put("Diana", 26);

        System.out.println("Map: " + ages);
        System.out.println("Size: " + ages.size());
        System.out.println("Alice's age: " + ages.get("Alice"));
        System.out.println("Contains Bob? " + ages.containsKey("Bob"));

        ages.remove("Bob");
        System.out.println("After removing Bob: " + ages);

        System.out.println("\n=== TreeMap (Sorted by Key) ===\n");

        Map<String, Integer> scores = new TreeMap<>();

        scores.put("Charlie", 88);
        scores.put("Alice", 95);
        scores.put("Bob", 82);
        scores.put("Diana", 90);

        System.out.println("TreeMap (sorted by key):");
        for (String name : scores.keySet()) {
            System.out.println("  " + name + ": " + scores.get(name));
        }

        System.out.println("\n=== Iterating Maps ===\n");

        Map<String, String> capitals = new HashMap<>();
        capitals.put("France", "Paris");
        capitals.put("Japan", "Tokyo");
        capitals.put("USA", "Washington DC");

        System.out.println("By key:");
        for (String country : capitals.keySet()) {
            System.out.println("  " + country + " -> " + capitals.get(country));
        }

        System.out.println("By value:");
        for (String capital : capitals.values()) {
            System.out.println("  " + capital);
        }

        System.out.println("By entry:");
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n=== Generics (Type Safety) ===\n");

        // Without generics (old Java, unsafe):
        // List list = new ArrayList();  // No type specified
        // list.add("hello");
        // list.add(123);
        // String str = (String) list.get(1);  // Runtime error!

        // With generics (modern Java, type-safe):
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        // names.add(123);  // ERROR at compile time!

        for (String name : names) {
            System.out.println("  " + name);  // No casting needed
        }

        System.out.println("\n=== List vs Set vs Map ===\n");

        System.out.println("List: Ordered, allows duplicates");
        System.out.println("  [apple, banana, apple, cherry]");

        System.out.println("Set: Unique values only");
        System.out.println("  {apple, banana, cherry}");

        System.out.println("Map: Key-value pairs");
        System.out.println("  {apple: fruit, carrot: vegetable}");

        System.out.println("\n=== Common Collection Methods ===\n");

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("List: " + list);

        Collections.sort(list);
        System.out.println("Sorted: " + list);

        System.out.println("Max: " + Collections.max(list));
        System.out.println("Min: " + Collections.min(list));

        Collections.reverse(list);
        System.out.println("Reversed: " + list);
    }
}

/*
Key Points:
- List: ArrayList, LinkedList (ordered, allows duplicates)
- Set: HashSet, TreeSet (unique values)
- Map: HashMap, TreeMap (key-value pairs)
- Generics <Type>: Specify collection contents for type safety
- No casting needed with generics
- Iterator, for-each, and for loops all work

Execution:
javac Phase5_Collections.java
java Phase5_Collections
*/
