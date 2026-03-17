# sem-2

This repository contains a simple Java application demonstrating a stepped
refactoring of an "OOPS Banner" program.  The goal is to start with the
most basic use case – printing the string `OOPS` – and then progressively
extend and modularise the implementation:

1. **UC1** – initial program (`UC1.PrintOOPS.JAVA`) simply prints `OOPS` to
   the console.
2. **Banner output** – `OOPSBannerApp.java` builds on the first use case by
   generating a banner version of the word using spaces and asterisks.
3. **Modular refactor** – `PrintBanner.java` encapsulates banner rendering
   logic with helper methods and, later, a dedicated `CharacterPattern`
   class.
4. **Map‑based lookup** – the final `PrintBanner` uses a `Map<Character,
   CharacterPattern>` to store glyph patterns allowing arbitrary text to be
   rendered.

Run `javac *.java && java OOPSBannerApp` to see the output, or play with the
API directly from other classes.