# Tutorial 8 — Java Programs (VS Code Setup)

This folder contains 6 self-contained Java programs:

| File | Program |
|---|---|
| Q1.java | Hospital Emergency Monitoring System (thread priorities) |
| Q2.java | Food Delivery App (thread priorities) |
| Q3.java | Student Registration System (Swing GUI) |
| Q4.java | User Login System (Swing GUI) |
| Q5.java | Student Course Management System (Swing GUI) |
| Q6.java | Text Editor Application (Swing GUI) |

Each file already has its `public class` matching the filename, so nothing needs
renaming — just open the folder and run.

---

## 1. What to Install

### a) Java Development Kit (JDK)
You need the JDK, not just the JRE — the JRE alone cannot compile code.

- Download JDK 17 or newer (LTS) from either:
  - https://adoptium.net (Eclipse Temurin — recommended, free)
  - https://www.oracle.com/java/technologies/downloads/
- Run the installer for your OS (Windows/macOS/Linux) and accept the defaults.
- Verify the install by opening a terminal and running:
  ```
  java -version
  javac -version
  ```
  Both commands should print a version number (e.g. `21.0.x`). If you get
  "command not found", the JDK's `bin` folder needs to be added to your
  system's PATH environment variable (the installer usually offers to do
  this automatically — on Windows, tick "Add to PATH" during setup).

### b) Visual Studio Code
- Download from https://code.visualstudio.com and install it.

### c) VS Code Java Extensions
Open VS Code → go to the Extensions icon on the left sidebar (or press
`Ctrl+Shift+X` / `Cmd+Shift+X`) → install:
- **Extension Pack for Java** (by Microsoft) — this single pack pulls in
  everything needed: Language Support for Java, Debugger for Java, Test
  Runner, Maven support, and the Project Manager for Java.

That's the only extension pack required; it gives you Run/Debug buttons
directly above every `main()` method.

---

## 2. Opening the Folder

1. Open VS Code.
2. `File → Open Folder...` and select this `Tutorial8` folder.
3. Wait a few seconds — the Java extension will index the files (you'll see
   a small spinner in the bottom status bar).

---

## 3. Running a Program

### Easiest way (VS Code UI)
1. Open any file, e.g. `Q1.java`.
2. You'll see a **Run** link (and a **Debug** link) appear directly above
   `public static void main(String[] args)`. Click **Run**.
3. For Q1/Q2 (console programs), the output appears in the **Terminal**
   panel at the bottom.
4. For Q3–Q6, a Swing window opens when a graphical desktop is available.
  In a headless environment such as this Codespace, they automatically use
  an interactive terminal version; answer the prompts in the VS Code
  terminal.

### Command line way (no VS Code needed)
Open a terminal **inside this folder** and run, for any file `QN.java`:
```bash
javac QN.java
java QN
```
Example for Q1:
```bash
javac Q1.java
java Q1
```
This creates a `Q1.class` file (the compiled bytecode) and then runs it.
Repeat for Q2 through Q6 the same way.

> Note: Q3–Q6 use Swing windows when a graphical display is available. In a
> headless server or Codespace with no display, they run in interactive
> terminal mode instead.

---

## 4. Troubleshooting

- **"javac is not recognized"** → the JDK isn't on your PATH. Reinstall the
  JDK and make sure "Add to PATH" is checked, or add it manually in your
  OS's environment variable settings, then restart VS Code.
- **VS Code shows red squiggly errors but the file looks fine** → open the
  Command Palette (`Ctrl+Shift+P` / `Cmd+Shift+P`) → run
  `Java: Clean Java Language Server Workspace` → reload when prompted.
- **No Run/Debug link appears above main()** → confirm the Extension Pack
  for Java installed correctly (check the Extensions panel), and that the
  file is saved with a `.java` extension.
