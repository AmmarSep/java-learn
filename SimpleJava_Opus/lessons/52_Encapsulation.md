# Lesson 52: Encapsulation

## Simple Explanation

**Encapsulation** means hiding the internal data of an object and controlling access through methods. Make fields `private`, provide `public` getters and setters.

**Analogy:** An ATM. You can't reach inside and grab cash. You use buttons (methods) to interact with it safely.

## The Pattern

```java
public class Person {
    // 1. Private fields (hidden data)
    private String name;
    private int age;

    // 2. Constructor
    public Person(String name, int age) {
        this.name = name;
        setAge(age);    // Use setter for validation
    }

    // 3. Public getter (read access)
    public String getName() {
        return name;
    }

    // 4. Public setter (write access with validation)
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }
}
```

## Why Encapsulate?

### Without encapsulation (BAD):
```java
public class Person {
    public int age;    // Anyone can set this to anything!
}

Person p = new Person();
p.age = -5;      // ❌ Negative age! No one stopped us.
p.age = 99999;   // ❌ Ridiculous age! Still no protection.
```

### With encapsulation (GOOD):
```java
Person p = new Person("Alex", 25);
p.setAge(-5);      // Ignored — validation rejects it
p.setAge(30);      // ✅ Valid — accepted
System.out.println(p.getAge());    // 30
```

## Benefits

1. **Data protection** — Invalid data is rejected.
2. **Flexibility** — You can change internal implementation without affecting users.
3. **Read-only fields** — Provide a getter but no setter.
4. **Controlled access** — Add logging, validation, or transformations in getters/setters.

## Common Beginner Mistakes

1. **Making fields public** — Always use `private` fields.
2. **Setters without validation** — If you just write `this.age = age;`, you get no benefit from the setter.
3. **Forgetting to use `this`** — When parameter names match field names.

## Quiz

1. What is encapsulation?
   - a) Making everything public
   - b) Hiding data and controlling access through methods ✅
   - c) Using loops

2. What access modifier should fields have?
   - a) `public`
   - b) `private` ✅
   - c) `static`

---
**Next Lesson:** [Lesson 53 — Inheritance](53_Inheritance.md)
