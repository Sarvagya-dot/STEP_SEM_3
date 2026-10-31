# Week 11 — Data Structures Practice: Quiz & Concept Answers

## Part B — Quiz

**Q1.** What is the primary purpose of a data structure?
**Answer: B — To define how data is organized, stored, and accessed efficiently for specific operations.**
(A data structure does not guarantee speed in every case, fix execution time, or limit memory by itself; it is about organizing data so the operations you care about are efficient.)

**Q2.** Which describes a non-primitive data structure?
**Answer: D — Is built by combining primitive types and stores a collection of values.**
(Arrays, lists and maps are built from primitives and hold many values; options A and C describe primitive types.)

**Q3.** Time complexity of accessing an element at a known index in a 1D array?
**Answer: C — O(1)**
(The address is computed directly from the base address and the index.)

**Q4.** A loop nested inside another loop, both iterating n times?
**Answer: C — O(n²)**
(n iterations of the outer loop, each doing n iterations of the inner loop.)

**Q5.** One loop of m iterations over listA, then an independent loop of n iterations over listB?
**Answer: B — O(m + n)**
(Sequential, independent loops add their costs.)

**Q6.** Common operations on data structures (select all that apply).
**Answer: A, C, D — Deletion, Traversal, Updating**
(Debugging and compilation are development activities, not data structure operations.)

**Q7.** Array sorted by date, frequent date-range queries, new records only added at day end — what is prioritized?
**Answer: C — O(log n) search for date ranges.**
(Sorting enables binary search to locate the range boundaries; the occasional end-of-day insert is cheap by comparison.)

**Q8.** Best structure for frequent searches and rare inserts/deletes where order must be maintained?
**Answer: D — Sorted Array**
(It supports O(log n) binary search and keeps order; the O(n) insert/delete cost is acceptable because updates are rare. A hash-based structure does not maintain order.)

**Q9.** The two-pointer technique is most effective on arrays that are:
**Answer: C — Sorted or have an exploitable ordering property, to avoid brute-force comparisons.**

**Q10.** Primary benefit of the sliding window technique?
**Answer: C — It avoids redundant recomputation for overlapping subproblems, often reducing time from O(n × k) or O(n²) to O(n).**
(Each step reuses the previous window's result and only adds the new element and removes the old one.)

## Part C — Concept Questions

**Question 1 — Primitive vs non-primitive data structures**
A primitive data structure holds a single basic value and is built into the language, for example a `boolean` or a `float`. A non-primitive data structure is built from primitives (or other structures) and holds a collection of values, with operations defined over the whole collection, for example a stack or a hash map. The key difference is that primitives are the basic building blocks with fixed language-defined representation, while non-primitives are composed from them to organize many values.

**Question 2 — Is a linked list non-linear because it is not contiguous?**
The reasoning is incorrect because linear versus non-linear describes the logical arrangement of elements, not their physical layout in memory. In a linked list each element has exactly one predecessor and one successor and is reached by moving through the sequence one after another, so it is a linear structure. A non-linear structure, such as a tree or graph, lets one element connect to several others, creating hierarchies or networks. Non-contiguous storage only affects how nodes are located in memory (via pointers), not the one-after-another structure of the data.

**Question 3 — O(m + n) versus nested loops**
Two independent loops run one after the other, so the total work is the sum of their work: m + n steps, giving O(m + n). When a loop over listA (m iterations) is nested inside a loop over listB (n iterations), the inner loop runs fully for every iteration of the outer loop, so the work multiplies: m × n steps, giving O(m × n). The rule is that sequential blocks add their costs, while nested blocks multiply them.

**Question 4 — Trading memory for time**
A web application that shows product pages looks up the same product details many thousands of times per second. Instead of querying the database each time, it keeps recently used products in an in-memory cache (a hash map). Each lookup becomes O(1) on average instead of a slow disk or network query. Here memory (space) is traded for lookup time (speed): extra RAM is spent to avoid repeating expensive work, which is worthwhile because the read operation is very frequent.

**Question 5 — Hash map vs sorted array for employee records**
A hash map gives O(1) average access, search, insert and delete by key (employee ID), but does not keep records in order and uses extra memory for the table; worst case with many collisions is O(n). A sorted array gives O(1) access by index and O(log n) search by binary search, and keeps records in order for range queries and ordered reports, but insert and delete are O(n) because elements must be shifted. If the main operations are frequent ID lookups with regular additions and removals, a hash map is preferred. If the data is mostly read, searched, and needs ordering or range queries with rare updates, a sorted array is preferred.
