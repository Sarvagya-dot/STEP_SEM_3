# Week 10 — Data Structures Practice: Quiz & Concept Answers

## Part B — Quiz

**Q1.** `String s1 = new String("hello"); String s2 = new String("hello");` — which is true?
**Answer: B — s1 == s2 is false, and s1.equals(s2) is true.**
(`new String(...)` always allocates a new object on the heap, so `==` compares references and is false; `.equals()` compares content and is true.)

**Q2.** `StringBuilder sb = new StringBuilder(); sb.append("Java"); sb.append(" Lab"); sb.reverse();` — content of sb?
**Answer: B — "baL avaJ"**
("Java Lab" reversed character-by-character is "baL avaJ".)

**Q3.** `Student s = new Student("Ravi");` — which constructor is directly called?
**Answer: B — public Student(String name)**
(It then delegates via `this(name, "Not assigned")` to the two-arg constructor, but the *directly* called one matching the call signature is the single-String constructor.)

**Q4.** `Wallet w1 = new Wallet(500); Wallet w2 = w1; w2.add(200);` — balances via w1 and w2?
**Answer: D — w1 balance: 700, w2 balance: 700**
(w2 is a reference to the same object as w1, not a copy — both see the shared update.)

**Q5.** Three `Visitor` objects created, `static int count` incremented in constructor — `getTotalVisitors()`?
**Answer: C — 3**

**Q6.** `int[] scores = {45, 78, 92, 60, 85};` standard for loop printing each element — output?
**Answer: A — 45 78 92 60 85**

**Q7.** `for (i=1; i<=5; i++) { if (i==3) continue; print(i); }` — output?
**Answer: B — 1 2 4 5**

**Q8.** `change(int n)` sets `n = 10` inside the method; `x = 5; change(x); println(x);` — output?
**Answer: A — 5**
(Primitives are passed by value; the method's reassignment of its local copy doesn't affect the caller's `x`.)

**Q9.** `int total = 250; double count = 3; double avg = total / count;` — output?
**Answer: C — 83.33333333333333**
(`total / count` is `int / double`, so `total` is promoted to `double` before division — true floating-point division, not integer division.)

**Q10.** Abstract `Payment` with abstract `pay()`; `Card extends Payment` overrides `pay()` adding a 2% fee. `Payment p = new Card(); p.pay(500);` — output?
**Answer: B — Paid 510.0 by card**
(500 + 500 * 0.02 = 510.0)

**Q11.** `String name = "java"; String upperName = name.toUpperCase();` — state of `name` after the call?
**Answer: B — The name object's value remains "java", and a new String object "JAVA" is created for upperName.**
(Strings are immutable — `toUpperCase()` never mutates the original.)

**Q12.** `String s1 = "hello"; String s2 = "hello"; String s3 = new String("hello");` — how many String objects, considering the pool?
**Answer: B — 2**
(`s1` and `s2` share one pooled literal "hello"; `s3` forces a second, separate heap object via `new`.)

**Q13.** `Word` class: `text = "Campus"`; `getTextLength()` and `letterAt(2)` — output?
**Answer: A — 6 / m**
("Campus".length() = 6; indices are C=0, a=1, m=2, p=3, u=4, s=5, so charAt(2) = 'm'.)

**Q14.** `String email = "user@domain.com"; int index = email.indexOf("@");` — output?
**Answer: A — 4**
(u-0, s-1, e-2, r-3, @-4)

**Q15.** `Book` class with default constructor setting `title="Unknown"`, `price=0.0`; `getDetails()` — output?
**Answer: B — Title: Unknown, Price: 0.0**

**Q16.** `Book` class with parameterized constructor; `new Book("Java Programming", 450.0)` — output?
**Answer: A — Title: Java Programming, Price: 450.0**

**Q17.** `Wallet w1 = new Wallet(500); Wallet w2 = w1; Wallet w3 = new Wallet(500);` — how many Wallet objects exist in memory?
**Answer: B — 2**
(w1 and w2 point to the same object; w3 is a separate, second object.)

**Q18.** Same Wallet scenario as Q4 but with explicit `add(int)` method — output after `w2.add(200)`?
**Answer: C — w1 balance: 700, w2 balance: 700**

**Q19.** `Student s1 = new Student("Asha"); Student s2 = new Student("Ravi"); s1.setName("Anu");` — output?
**Answer: D — s1 name: Anu / s2 name: Ravi**
(s1 and s2 are independent objects; changing s1's name doesn't touch s2.)

**Q20.** `static int visitorCount = 0;` incremented in constructor; three `Visitor` objects created — output?
**Answer: C — Total visitors: 3**

---

## Part C — Concept Questions

**Q1. String immutability and its performance impact.**
In Java, a `String` object's internal character data can never be changed after creation — every method that looks like it "modifies" a string (`toUpperCase()`, `concat()`, `replace()`, etc.) actually returns a brand-new `String` object, leaving the original untouched. This matters for performance because repeatedly "modifying" a string in a loop (e.g., building up a long string with `+=`) creates a new object on the heap at every single step, discarding the previous one — for *n* concatenations this is O(n²) work and churns a lot of garbage for the collector. This impact is mitigated by using a mutable buffer class like `StringBuilder` (or `StringBuffer` for thread-safety) for repeated modifications, and only converting to an immutable `String` once, at the end, with `toString()`.

**Q2. The `this` keyword resolving name ambiguity.**
When a constructor parameter has the same name as an instance field (e.g., `public Student(String name) { name = name; }`), an unqualified `name` inside the constructor body refers to the *parameter*, not the field — so `name = name` would just reassign the parameter to itself and leave the field untouched. The `this` keyword disambiguates by explicitly referring to the current object's field: `this.name = name;` assigns the parameter's value into the instance field, while the bare `name` still refers to the parameter. This lets constructor parameters keep natural, readable names that match their corresponding fields instead of needing clumsy prefixes like `pName`.

**Q3. Object vs. reference variable, and what happens when one reference is assigned to another.**
An object is the actual data structure living on the heap — the allocated memory holding a class's fields. A reference variable is not the object itself but a variable that stores the *address* (a pointer, conceptually) of where that object lives in memory. When one reference variable is assigned the value of another (e.g., `Wallet w2 = w1;`), no new object is created — the address stored in `w1` is simply copied into `w2`, so both variables now point to the exact same object. The implication is that any modification made through `w2` (like calling `w2.add(200)`) changes the one shared object, and that change is visible through `w1` too, since there was never a second, independent copy.

**Q4. Static vs. instance variables — when each is appropriate.**
An instance variable belongs to each individual object separately — every object gets its own copy, and changes to one object's instance variable never affect another object's copy of that same variable. A static variable belongs to the class itself, shared by every instance — there is only ever one copy, no matter how many objects exist. A static variable is preferred for data that's meaningfully shared across all objects of a class, such as a running total of how many objects have been created so far (`Visitor.count`) or a constant shared configuration value. An instance variable is more suitable when each object genuinely needs independent state that differs from every other object, such as a `Student`'s own `name` or `marks` — giving every student their own separate copy, rather than one value shared (and overwritten) by the whole class.

**Q5. for, while, and do-while loops — when each is the best fit.**
A `for` loop is best when the number of iterations is known in advance or naturally tied to a counter, such as iterating over an array by index (`for (int i = 0; i < arr.length; i++)`) — the initialization, condition, and increment are all visibly grouped together. A `while` loop is best when iteration should continue based on a condition whose outcome isn't predictable in advance — for example, reading input until a sentinel value appears, or repeatedly halving a number until it reaches 1 (unknown number of iterations up front). A `do-while` loop is best when the loop body must execute at least once regardless of the condition, such as displaying a menu and prompting the user at least one time before checking whether they want to continue — the condition is only checked after the first pass through the body.

**Q6. Pass-by-value in Java, for primitives vs. object references.**
Java is always strictly pass-by-value — but what gets passed differs by type. For a primitive (`int`, `double`, etc.), the actual value is copied into the method's parameter, so any reassignment inside the method (like `n = 10;`) only changes the local copy and has zero effect on the caller's original variable. For an object reference (like an array or a custom object), what gets copied is the *reference itself* (the address) — not the object it points to. This means the method's parameter and the caller's variable point to the same underlying object, so calling a mutating method or changing a field through that reference (e.g., `wallet.add(200)`) *does* affect the original object, visible to the caller. But reassigning the parameter itself inside the method (e.g., `wallet = new Wallet(0);`) only redirects the local copy of the reference, leaving the caller's original variable pointing at the original object, unaffected.

**Q7. Integer division and fractional results.**
When both operands of `/` are integer types (`int`, `long`), Java performs integer division: the result is truncated toward zero, discarding any fractional/remainder part entirely rather than rounding — `7 / 2` yields `3`, not `3.5`. This happens because the `/` operator's result type is determined by its operand types, and if both are integers, the result is computed and stored as an integer. To get a precise floating-point result from an arithmetic expression involving integers, at least one operand must be explicit cast to a floating-point type (e.g., `(double) total / count`) *before* the division happens — casting after the division is too late, since the truncation has already occurred.

**Q8. Encapsulation, and how private + getters/setters enforce it.**
Encapsulation is the principle of bundling an object's data (fields) together with the methods that operate on that data, while restricting direct outside access to the internal state. In Java, declaring fields `private` makes them inaccessible from outside the class entirely — no external code can read or write them directly. Access is instead mediated through public getter methods (to read a value) and setter methods (to write one), which can include validation logic — for example, a setter can reject a negative balance or an invalid value before ever letting it into the field. This enforces data integrity because the class itself fully controls every way its internal state can change, rather than trusting external code to always set valid values, and it also means the internal representation can be changed later without breaking any code that only interacts through the public getters/setters.

**Q9. `==` vs. `.equals()`, and overriding `equals()`.**
The `==` operator, when applied to objects (not primitives), compares *references* — it checks whether two variables point to the exact same object in memory, returning `true` only if they are literally the same object. The `.equals()` method, by default (inherited from `Object`), does the same reference comparison — but it's meant to be *overridden* by a class to instead compare meaningful content. For example, two separate `String` objects holding identical characters are `==`-unequal (different objects) but `.equals()`-equal (same content), because `String` overrides `equals()` to compare character sequences rather than memory addresses. A custom class that doesn't override `equals()` will behave just like `==` when compared, which is often not what's wanted — overriding it to compare relevant fields (e.g., two `Student` objects being "equal" if their roll numbers match) lets object comparisons reflect logical equality rather than strict identity.

**Q10. Method overloading vs. method overriding.**
Method overloading means defining multiple methods in the *same class* with the same name but different parameter lists (different number, types, or order of parameters) — the compiler decides which overload to call based on the arguments at the call site, so this is resolved at **compile time**. Example: `add(int a, int b)` and `add(double a, double b)` in the same class are overloads. Method overriding means a *subclass* providing its own implementation of a method that's already defined in its superclass, with the exact same signature — which version actually runs is decided based on the real runtime type of the object, not the reference type, so this is resolved at **run time**. Example: a `Payment` class declares `pay()`, and a `Card` subclass overrides `pay()` with its own fee-inclusive logic — calling `pay()` through a `Payment`-typed reference pointing at a `Card` object runs `Card`'s version, determined dynamically at runtime.
