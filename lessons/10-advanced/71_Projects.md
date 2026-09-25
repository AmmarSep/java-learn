[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](70_Unit_Testing.md)

---

# Lesson 71: Small Beginner Projects

## Congratulations! 🎉

You've completed all 70 lessons! Now it's time to practice by building small projects. Here are 10 beginner-friendly project ideas with guidance.

---

## Project 1: Calculator

**Concepts used:** Variables, operators, Scanner, if/else, methods

```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        String op = input.next();

        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();

        double result = switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num2 != 0 ? num1 / num2 : Double.NaN;
            default -> Double.NaN;
        };

        System.out.println("Result: " + result);
    }
}
```

---

## Project 2: Number Guessing Game

**Concepts used:** Loops, random numbers, Scanner, if/else

```java
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secret = random.nextInt(100) + 1;    // 1 to 100
        Scanner input = new Scanner(System.in);
        int attempts = 0;

        System.out.println("I'm thinking of a number between 1 and 100.");

        while (true) {
            System.out.print("Your guess: ");
            int guess = input.nextInt();
            attempts++;

            if (guess < secret) {
                System.out.println("Too low!");
            } else if (guess > secret) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You got it in " + attempts + " attempts!");
                break;
            }
        }
    }
}
```

---

## Project 3: To-Do List

**Concepts used:** ArrayList, loops, Scanner, switch

```java
import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. View tasks");
            System.out.println("2. Add task");
            System.out.println("3. Remove task");
            System.out.println("4. Quit");
            System.out.print("Choice: ");

            int choice = input.nextInt();
            input.nextLine();    // Consume newline

            switch (choice) {
                case 1 -> {
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter task: ");
                    tasks.add(input.nextLine());
                    System.out.println("Task added!");
                }
                case 3 -> {
                    System.out.print("Task number to remove: ");
                    int num = input.nextInt();
                    if (num >= 1 && num <= tasks.size()) {
                        tasks.remove(num - 1);
                        System.out.println("Task removed!");
                    } else {
                        System.out.println("Invalid number.");
                    }
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
```

---

## Project 4: Student Grade Manager

**Concepts used:** Classes, objects, ArrayList, methods, encapsulation

Create a `Student` class with name and grades, and a main program that manages students.

---

## Project 5: Simple Bank Account

**Concepts used:** OOP, encapsulation, methods, constructors

Create a `BankAccount` class with deposit, withdraw, and balance checking.

---

## Project 6: Word Counter

**Concepts used:** String methods, HashMap, file I/O

Read a text file and count how many times each word appears.

---

## Project 7: Quiz App

**Concepts used:** Arrays/ArrayList, loops, if/else, Scanner

Create a multiple-choice quiz that tracks the score.

---

## Project 8: Contact Book

**Concepts used:** HashMap, Scanner, loops, OOP

Store contacts with name, phone, and email. Allow adding, searching, and deleting.

---

## Project 9: Tic-Tac-Toe

**Concepts used:** 2D arrays, loops, methods, if/else

Build a two-player tic-tac-toe game in the console.

---

## Project 10: Simple File Organizer

**Concepts used:** File I/O, String methods

Read a CSV file, parse the data, and display it formatted.

---

## Tips for Building Projects

1. **Start small** — Get the basic version working first, then add features.
2. **Plan before coding** — Write down what the program should do.
3. **Break it into methods** — Each method does one small thing.
4. **Test as you go** — Don't write 100 lines and then test. Test every few lines.
5. **Use what you learned** — Apply OOP, collections, exceptions, etc.
6. **Google is your friend** — Real programmers search for help constantly.
7. **Read error messages** — They tell you exactly what's wrong.
8. **Have fun!** — The best way to learn is by building things you find interesting.

---

## What's Next?

After these projects, you can explore:

- **JavaFX** — Build graphical user interfaces (GUI)
- **Spring Boot** — Build web applications
- **JDBC** — Connect to databases
- **Maven/Gradle** — Build tools for managing projects
- **Design Patterns** — Advanced OOP techniques
- **Data Structures & Algorithms** — Essential for interviews
- **Android Development** — Build mobile apps with Java/Kotlin

---

## 🎓 You Did It!

You've learned Java from absolute zero to a solid foundation. You understand:

- ✅ How Java works (JDK, JVM, compilation)
- ✅ Variables, types, and operators
- ✅ Control flow (if/else, switch, loops)
- ✅ Arrays and collections
- ✅ Methods and scope
- ✅ Object-Oriented Programming (classes, objects, inheritance, polymorphism)
- ✅ Exceptions and error handling
- ✅ File I/O
- ✅ Generics, lambdas, and streams
- ✅ Debugging and testing

**Keep coding, keep building, keep learning!** 🚀
