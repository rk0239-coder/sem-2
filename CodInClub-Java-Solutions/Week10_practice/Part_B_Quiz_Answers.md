# Part B — Quiz Answers

| Q | Answer | Why |
|---|--------|-----|
| 1 | D | `new String` makes two objects, so `==` is false; `equals` compares content, so true. |
| 2 | B | "Java Lab" reversed is "baL avaJ". |
| 3 | B | `Student(String)` is called directly; it then chains to the two-arg constructor via `this(...)`. |
| 4 | D | `w1` and `w2` refer to the same object, so both show 700. |
| 5 | C | Static `count` is shared and incremented 3 times. |
| 6 | A | Loop covers indices 0 to length-1: `45 78 92 60 85`. |
| 7 | B | `continue` skips printing when i == 3: `1 2 4 5`. |
| 8 | A | Java passes primitives by value; `x` stays 5. |
| 9 | C | `250 / 3.0` is a double: `83.33333333333333`. |
| 10 | B | Fee is 10.0, so `Paid 510.0 by card` (runtime polymorphism). |
| 11 | B | Strings are immutable; `toUpperCase()` returns a new object. |
| 12 | B | One pooled "hello" (s1, s2) plus one heap object (s3). |
| 13 | A | "Campus" has length 6; index 2 is 'm'. |
| 14 | A | `@` is at index 4. |
| 15 | B | Default constructor sets title "Unknown", price 0.0. |
| 16 | A | `Title: Java Programming, Price: 450.0`. |
| 17 | B | `w1` and `w2` share one object; `w3` is a second. |
| 18 | C | Both references see the same object: 700 and 700. |
| 19 | C | `s1` changes to Anu; `s2` is a separate object and stays Ravi. |
| 20 | C | Static counter incremented once per object: 3. |
