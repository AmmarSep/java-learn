[Home](../../README.md) · [All lessons](../README.md) · [This topic](README.md) · [Previous](04_JDK_JRE_JVM.md) · [Next](../02-first-steps/06_First_Java_Program.md)

---

# Lesson 5: Installing Java

## Simple Explanation

Before you can write and run Java programs, you need to install the **JDK** (Java Development Kit) on your computer. Let's walk through how to do this.

## What You Need to Install

You need the **JDK** — specifically, we recommend **JDK 17** or **JDK 21** (these are Long-Term Support versions, meaning they'll be supported for many years).

## Option 1: Download from Oracle (Official)

1. Go to: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
2. Choose your operating system (Windows, Mac, or Linux).
3. Download the installer.
4. Run the installer and follow the on-screen instructions.

## Option 2: Download from Adoptium (Free & Open Source)

1. Go to: [https://adoptium.net/](https://adoptium.net/)
2. Click the big download button (it auto-detects your system).
3. Run the installer.

## Option 3: Using a Package Manager

### On Mac (using Homebrew):
```
brew install openjdk@21
```

### On Windows (using winget):
```
winget install EclipseAdoptium.Temurin.21.JDK
```

### On Linux (Ubuntu/Debian):
```
sudo apt update
sudo apt install openjdk-21-jdk
```

## How to Check If Java Is Installed

Open your **terminal** (Mac/Linux) or **Command Prompt** (Windows) and type:

```
java -version
```

You should see something like:

```
openjdk version "21.0.1" 2023-10-17
OpenJDK Runtime Environment (build 21.0.1+12)
OpenJDK 64-Bit Server VM (build 21.0.1+12, mixed mode)
```

Also check the compiler:

```
javac -version
```

You should see something like:

```
javac 21.0.1
```

If you see version numbers, Java is installed! If you see "command not found," something went wrong and you need to try again.

## What Is a Terminal?

A **terminal** (also called **command line** or **command prompt**) is a text-based window where you type commands to your computer instead of clicking buttons.

- On **Mac**: Open the "Terminal" app (search for it in Spotlight).
- On **Windows**: Open "Command Prompt" or "PowerShell" (search in the Start menu).
- On **Linux**: Open "Terminal" (usually in your applications menu).

## Setting Up an Editor

You also need a place to **write** your Java code. Here are some options:

### For Beginners:
- **Notepad** (Windows) or **TextEdit** (Mac) — simple but very basic.
- **VS Code** — free, popular, with Java support.

### For Serious Learning (Recommended):
- **IntelliJ IDEA Community Edition** — free, powerful, made specifically for Java.
  - Download from: [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
  - Choose the **Community** edition (it's free).

IntelliJ IDEA will:
- Highlight your code with colors (so it's easier to read).
- Show you errors as you type.
- Let you run your code with one click.
- Help you complete code automatically.

## Common Beginner Mistakes

1. **Not checking if Java is installed** — Always verify with `java -version` and `javac -version`.
2. **Installing the wrong version** — Make sure you install the JDK, not just the JRE.
3. **PATH not set** — Sometimes Java installs but the terminal can't find it. The installer usually handles this, but if `java -version` doesn't work, you may need to set the PATH environment variable (your installer documentation will explain how).

## Mini Practice Exercise

**Task:** Install the JDK on your computer and verify it works.

1. Install JDK 17 or 21 using one of the methods above.
2. Open your terminal.
3. Type `java -version` and press Enter.
4. Type `javac -version` and press Enter.

**Success looks like:** Both commands show version numbers without errors.

## Quiz

1. What do you need to install to write Java programs?
   - a) JVM
   - b) JRE
   - c) JDK ✅

2. What command checks if Java is installed?
   - a) `java -check`
   - b) `java -version` ✅
   - c) `java -install`

3. What command checks if the Java compiler is installed?
   - a) `javac -version` ✅
   - b) `compiler -version`
   - c) `java -compiler`

4. Which editor is recommended for serious Java learning?
   - a) Notepad
   - b) Microsoft Word
   - c) IntelliJ IDEA ✅

---
**Next Lesson:** [Lesson 6 — Writing Your First Java Program](../02-first-steps/06_First_Java_Program.md)
