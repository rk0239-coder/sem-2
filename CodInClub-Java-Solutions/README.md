# CodInClub Java Practice Solutions

Java solutions for all CodInClub / BridgeLabz STEP-SEM3 problem sets, organized into
one folder per problem sheet. Every problem is its own `.java` file containing:

- A header comment with the **full problem statement** (scenario, task, constraints).
- A clean, working solution using the suggested method signature.
- A `main()` method that runs the sample input(s) from the sheet and prints the
  actual output next to the expected output, so you can verify correctness at a glance.

Every file has been executed and its output verified against the sample I/O given in
the original problem sheets.

## How to run any file

Each file is self-contained (Java 11+ single-file source launch):

```bash
java FolderName/FileName.java
```

Example:

```bash
java "01-Week4-Category-C-Assignment-Problems/A1_ProductExceptSelf.java"
```

Or compile and run the traditional way:

```bash
javac FileName.java
java FileName
```

## Folder Guide

| Folder | Source Sheet | Problems |
|---|---|---|
| `01-Week4-Category-C-Assignment-Problems` | Array Week 4 – Category C Assignment | A1–A5: Product Except Self, Maximum Subarray, 3Sum, Subarray Sum Equals K, Find Min in Rotated Sorted Array |
| `02-Week4-Category-C-Practice-Problems` | Array Week 4 – Category C Practice | L1–L5: Two Sum, Best Time to Buy/Sell Stock, Contains Duplicate, Merge Two Sorted Arrays, Rotate Array |
| `03-Week1-Day1-LiveCoding-Problems` | STEP-SEM-3 Week 1 Problems (Day 1 Live Coding) | Rock-Paper-Scissors, Palindrome Checker (3 ways), BMI Calculator, First Non-Repeating Character, Reverse Customer Name |
| `04-Week5-Category-C-Assignment-Problems` | Week 5 Java Arrays & Methods – Category C Assignment | Fantasy Team Score Multiplier, Duplicate Player Pick Checker, Top Performer Tracker, Match Day Grid Analyzer, Fantasy League Auto-Draft Ranking Engine |
| `05-Week5-Category-C-Practice-Problems` | Week 5 Java Arrays & Methods – Category C Practice | Hackathon Score Curve Booster, Duplicate Team Name Finder, Top-3 Podium Finder, Hackathon Seating Grid Optimizer, Placement Drive Shortlisting & Ranking Engine |
| `06-Week2-Assignment-Problems` | STEP-SEM3 Week 2 Assignment | ATM PIN Length Validator, Word Reversal Encoder, Product Inventory CSV Parser, Library ISBN Normalizer & Validator, Stop-Word-Filtered Word Frequency Report |
| `07-Week2-Day2-LiveCoding-Problems` | STEP-SEM3 Week 2 Practice (Day 2 Live Coding) | Vowel & Consonant Counter, CSV Student Record Parser, File Extension Validator, Masked Phone Number Formatter, Bank Transaction Reference Generator & Validator |
| `08-Week1-Assignment-Problems` | STEP-SEM-3 Week 1 Problems Assignment | Exam Hall Seat Duplication Checker, Typing Speed Test Accuracy Checker, Traffic Signal Streak Analyzer, Warehouse Inventory Balancer, Movie Review Word Length Profiler |

## Notes

- Files are named `P#_ProblemName.java` (or `A#_.../L#_...` for the LeetCode-style
  sheets) matching the problem number in the original PDF.
- Java class names can't start with a digit, so numbered problems use a `P` prefix
  (e.g. `P1_...`, `P2_...`).
- No external dependencies — pure core Java (`java.util` collections/Arrays only).
