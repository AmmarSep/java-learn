# Phase 6: Exceptions and basic concurrency

[All examples](../README.md) · [Detailed explanation](../../guides/06-exceptions-and-concurrency.md) · [Runner help](../../scripts/README.md)

Study one program at a time. Run commands below from the repository root. In IntelliJ, run the main method in that example's isolated module.

## Phase6_Exceptions

[Source code](01-exceptions/Phase6_Exceptions.java)

```bash
python3 scripts/java.py run Phase6_Exceptions
```

**Read first:** [Lesson 60](../../lessons/09-errors-files/60_Exceptions.md), [Lesson 61](../../lessons/09-errors-files/61_Try_Catch_Finally.md), [Lesson 62](../../lessons/09-errors-files/62_Checked_Unchecked.md)

**Try it:** Trigger a failure, catch it, and explain why execution continues.

## Phase6_Threads

[Source code](02-threads/Phase6_Threads.java)

```bash
python3 scripts/java.py run Phase6_Threads
```

**Read first:** [Lesson 66](../../lessons/10-advanced/66_Lambdas.md)

**Try it:** Repeat the race example; explain why a correct-looking result proves nothing.

Thread output order and the unsynchronized counter are intentionally nondeterministic. A run may happen to produce the expected count; that does not make the code thread-safe.
