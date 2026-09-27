# Week 8 — Quiz & Concept Questions (Polymorphism & Inheritance)

## Quiz Questions

**Q1.** A system processes Document objects... What OOP principle eliminates the repeated if-else type checks before calling render()?
**Answer: C — Polymorphism**

**Q2.** Which represent a genuine 'is-a' relationship?
**Answer: A, B**
- A `Car` is a `Vehicle` — genuine is-a.
- A `Rectangle` is a `Shape` — genuine is-a.
- A `DatabaseConnection` is a `NetworkResource` — more of a "uses-a" relationship, not genuine is-a.
- A `HelperUtility` contains a `Calculator` — this is composition ("has-a"), not inheritance.

**Q3.** What mechanism ensures the correct startEngine() implementation runs for each vehicle type in a list of Vehicle references?
**Answer: C — Runtime method dispatch**

**Q4.** Storing various Shape objects in a list and calling calculateArea() on each demonstrates:
**Answer: C — Inheritance-based polymorphism**

**Q5.** Which statements are accurate about the LibraryItem/Book/DVD system?
**Answer: A, C, D**
- A: `Book.getLoanPeriod()` extends inherited behavior — true (adds a rule on top of the base).
- B: false — DVD sets a *fixed* period, which is overriding/specializing, not "shared" behavior.
- C: true — LibraryItem defines the common contract/behavior.
- D: true — a DVD object can be referenced polymorphically as a LibraryItem.

**Q6.** Which statements about Animal/Dog/Cat are correct?
**Answer: A, C**
- A: true — calling makeSound() on an Animal reference pointing to a Dog runs Dog's version (dynamic dispatch).
- B: false — Animal's makeSound() is the general/base behavior, not "specialized".
- C: true — Dog's makeSound() overrides the base implementation.
- D: false — a derived class can add entirely new methods that were never declared in the base class; only *overriding* requires the method to exist in the base.

**Q7.** Primary benefit of PaymentProcessor holding Payment references when adding a new WalletPayment type:
**Answer: C — It allows adding WalletPayment without modifying the existing PaymentProcessor's iteration logic.**

**Q8.** Why is inheritance used solely for superficial code reuse between unrelated classes a poor choice?
**Answer: A — It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid.**

**Q9.** Advantages of inheritance + polymorphism in the Notification system:
**Answer: A, C**
- A: true — a generic NotificationSender can send any notification type without knowing its concrete class.
- B: false — logic isn't centralized into one class; each subclass keeps its own send() logic.
- C: true — adding InAppNotification requires no change to existing sender logic.
- D: false — each channel has its own distinct send() implementation, not "the exact same" one.

**Q10.** Benefits of polymorphic collections:
**Answer: A, B, C**
- A: true — simplifies iterating over related-but-different objects.
- B: true — allows uniform processing while each object still behaves specially.
- C: true — avoids explicit casting in the common processing loop.
- D: false — it makes adding new derived types *easier*, not harder.

---

## Concept Questions

**Q1. How inheritance enables reuse + specialization, with a business example.**
A derived class inherits all the fields and methods of its base class automatically, so common behavior is written once. It can then *override* specific methods to change behavior, or add entirely new methods on top. Example: a base `Employee` class has `calculateSalary()` returning a fixed monthly rate. A `SalesEmployee` subclass overrides `calculateSalary()` to add a commission on top of the base rate — reusing the base salary logic while extending it with commission-specific logic.

**Q2. The 'is-a' relationship and why it matters.**
An 'is-a' relationship means every instance of the subtype genuinely satisfies the definition of the supertype — a `Car` is-a `Vehicle` in every meaningful sense (it can be driven, has an engine, etc.). Getting this right matters because inheritance is meant to model real hierarchical relationships; forcing inheritance onto classes that don't share a true is-a relationship (using it only to reuse a few methods) creates a rigid, confusing hierarchy where the subtype doesn't behave the way callers of the base type would expect (violating the Liskov Substitution Principle).

**Q3. Method overriding, with an Employee salary example.**
Method overriding is when a subclass provides its own implementation of a method that's already defined (with the same signature) in its base class, replacing the inherited behavior when called on that subclass. Example: base class `Employee` defines `calculateSalary()` returning a flat monthly amount. `ManagerEmployee` overrides it to add a fixed management allowance, while `CommissionEmployee` overrides it to add a percentage of sales. Each subclass supplies its own version, but code that just calls `employee.calculateSalary()` doesn't need to know which one it's dealing with.

**Q4. Runtime polymorphism (dynamic dispatch).**
When a method is called through a base-type reference, the JVM doesn't decide which implementation to run based on the reference's declared type — it looks at the actual (runtime) class of the object the reference points to, and calls that class's version of the method. This is why a `Shape shape = new Circle();` calling `shape.calculateArea()` runs `Circle`'s implementation, even though the variable is typed as `Shape`. The JVM maintains a method table per class that resolves the correct override at the moment of the call, not at compile time.

**Q5. Polymorphic collections.**
A polymorphic collection is something like `List<Shape>` or `Shape[]`, where the declared element type is the base class, but each individual element can be an instance of any subclass (`Circle`, `Rectangle`, etc.). Iterating and calling a common method like `calculateArea()` on each element automatically invokes the correct subclass-specific implementation for each object. The advantage is that the processing code doesn't need to know or care which concrete subtypes are present — it can treat a mixed collection of related objects uniformly, and adding a new subtype later requires no change to that processing code.

**Q6. Polymorphism vs. repeated type-based conditional logic.**
With conditional logic, a central method has to check `if (obj instanceof TypeA) ... else if (obj instanceof TypeB) ...` for every operation, and every time a new type is added, every one of those conditional blocks across the codebase needs to be updated. With polymorphism, each type implements the operation itself via an override, and the calling code just invokes the method on the base-type reference — the correct behavior is selected automatically at runtime. Polymorphism is preferred because it keeps type-specific logic localized to each class (open/closed principle: open for extension via new subclasses, closed for modification of existing dispatch code), rather than scattering the same big if-else chain across every place that needs different behavior per type.

**Q7. Adding new types with minimal change, illustrated with a new PaymentMethod.**
Because a processor works only against the base type's contract (e.g., `Payment` with `calculateFee()`), adding a new subtype like `WalletPayment` just means writing a new class that extends `Payment` and implements `calculateFee()` — the existing loop that processes a `List<Payment>` doesn't change at all, since it never needed to know about specific payment types in the first place. The only change needed elsewhere is wherever `WalletPayment` objects get created (e.g., a factory method), not in the iteration/processing logic itself.

**Q8. Inherited vs. overridden behavior.**
Inherited behavior is a method a subclass gets "for free" from its base class without writing any code — it typically inherits a method when the base class's implementation is already exactly what the subclass needs (e.g., a `PartTimeEmployee` might inherit a `getName()` method unchanged from `Employee`). Overridden behavior is when the subclass supplies its own implementation of a method that exists in the base class, because the base behavior doesn't fit — e.g., `PartTimeEmployee` overrides `calculateSalary()` because part-time pay is computed differently (hourly rate × hours) than the base class's monthly-salary logic.

**Q9. Why inheritance purely for code reuse (without a genuine is-a) is a poor choice.**
If two classes aren't truly in an is-a relationship, forcing one to extend the other just to reuse a few methods creates a misleading hierarchy: the subclass will end up inheriting fields/methods that make no sense for it, or will need to override/disable inherited behavior awkwardly. This produces tight, fragile coupling between unrelated concepts, makes the code harder to understand (since the class name and hierarchy imply a relationship that doesn't actually hold), and makes future changes to the "base" class risk breaking unrelated subclasses that only borrowed it for convenience. Composition ("has-a", delegating to a helper object) is the safer tool for pure code reuse.

**Q10. VehicleRental example — common vs. specialized behavior.**
A `VehicleRental` base class can capture behavior shared by every rental — `calculateRentalDuration()`, `getRenterName()`, `getStartDate()` — since every rental, regardless of vehicle, needs these. `CarRental` and `TruckRental` subclasses then each override or add specialized behavior: `CarRental` might override `calculateFee()` with a flat daily rate, while `TruckRental` overrides it to add a per-mile surcharge and a `calculateTowingFee()` method that only makes sense for trucks. Inheritance lets both share the common rental-tracking logic from the base class while each independently defines what makes its own rental type unique, and a `List<VehicleRental>` can process both uniformly wherever only the shared behavior is needed.
