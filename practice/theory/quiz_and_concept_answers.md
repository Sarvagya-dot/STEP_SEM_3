# Week 9 — Quiz & Concept Questions (Abstraction, Interfaces, Class vs. Interface)

## Part B — Quiz

**Q1.** Which best describes abstraction in OOP?
**Answer: C — Hiding how an object performs its operations and showing only what it does**

**Q2.** Which statement about an abstract class is true?
**Answer: C — It cannot be instantiated directly**

**Q3.** A concrete class extends an abstract class but fails to implement an inherited abstract method. Consequence?
**Answer: B — The class must be declared abstract, or the code will not compile**

**Q4.** Which modifier is NOT allowed for an abstract method?
**Answer: C — private**
(An abstract method must be overridden by a subclass, which is impossible if it's private — private members aren't inherited/visible to subclasses at all.)

**Q5.** Fields declared within a Java interface are implicitly:
**Answer: C — public, static, and final**

**Q6.** How many interfaces can a single Java class implement?
**Answer: C — Any number of interfaces**

**Q7.** If a class implements an interface, what access modifier must it use for the implemented methods?
**Answer: D — public**

**Q8.** Why does Java allow implementing multiple interfaces but extending only one class?
**Answer: C — Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**

**Q9.** Two interfaces both provide a default method with the same signature; the implementing class doesn't override it. What happens?
**Answer: D — A compile-time error occurs until the class overrides the method**

**Q10.** Which is true regarding constructors in Java?
**Answer: B — Abstract classes can have constructors that run when a subclass object is created**

---

## Part C — Concept Questions

**Q1. Abstraction, in your own words, with a real-life example.**
Abstraction means exposing only the essential operations an object offers while hiding the internal steps that make them work. A real-life example: a washing machine's control panel shows a "Start" button and a cycle dial — that's all the user needs. What's hidden is the sequence of valve openings, drum rotation timings, water-level sensing, and heating-element control that actually gets the clothes washed; the user never needs to understand or interact with any of that to get clean laundry.

**Q2. Primary difference between abstraction and encapsulation, and how they work together.**
Abstraction is about *what* is shown — deciding which operations and details are relevant to expose to the outside world and which internal mechanics to leave out. Encapsulation is about *how* that hiding is enforced — bundling data and the methods that operate on it together, and restricting direct access to the internal state (typically via private fields and public methods). In a single class, abstraction decides the public interface (e.g., `calculateFine()`), while encapsulation protects the fields that make that calculation possible (e.g., a private `daysLate` field that external code can't directly overwrite) — together they let a class present a simple, safe contract to the world while keeping its internal implementation free to change.

**Q3. Why an abstract class might have a constructor, and when it runs.**
Even though an abstract class can't be instantiated on its own, its constructor is still responsible for initializing the fields that every subclass inherits — for example, setting a shared `name` or `owner` field. This constructor runs automatically whenever a concrete subclass object is created, because every subclass constructor implicitly (or explicitly, via `super(...)`) calls the abstract base class's constructor first, as part of the normal object-construction chain.

**Q4. Why an abstract method can't be private, static, or final.**
- `private`: a private method isn't visible to or inherited by subclasses at all, so there would be nothing for a subclass to override — defeating the entire purpose of declaring it abstract.
- `static`: static methods belong to the class itself and are resolved at compile time based on the reference type, not dispatched polymorphically per-instance — but an abstract method exists precisely to be overridden and resolved polymorphically at runtime, which static binding doesn't support.
- `final`: `final` explicitly means "cannot be overridden by a subclass," which directly contradicts the purpose of an abstract method, whose entire point is that a subclass *must* override it.

**Q5. The 'diamond problem', and how Java's single-inheritance-of-classes/multiple-interfaces design avoids it.**
The diamond problem arises when a class inherits from two parent classes that both define a field or a conflicting implementation of the same method, leaving the compiler unable to decide which version the subclass should actually get (classic C++ multiple-inheritance ambiguity). Java sidesteps this by allowing a class to extend only one parent class, so there is only ever one line of inherited instance state and implementation to resolve. Interfaces, by contrast, carry no instance fields (only constants) and, even when two interfaces provide the same default method signature, Java simply forces the implementing class to explicitly resolve the conflict by overriding that method — so there's never silent, ambiguous state inheritance to worry about.
