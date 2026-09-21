/*
 * PRACTICE PROBLEM 5: The Attendance Sheet
 *
 * Scenario:
 * A teacher marks which students are present in class today.
 *
 * Problem Statement:
 * Design an AttendanceSheet class that stores present students internally
 * but only reveals a count and a yes/no lookup - never the full list.
 *
 * Requirements:
 * - Store the names of present students in a private array (fixed size is
 *   fine - assume a maximum class size).
 * - Provide a method to mark a student present.
 * - Provide a method that returns how many students are present, and
 *   another that checks whether one specific name is present.
 * - There should be no method that returns the whole array of names.
 *
 * Sample:
 *   AttendanceSheet sheet = new AttendanceSheet(30);
 *   sheet.markPresent("Ana"); sheet.markPresent("Ben"); sheet.markPresent("Ana");
 *   sheet.getPresentCount() -> 2
 *   sheet.isPresent("Ben") -> true
 */
public class AttendanceSheet {

    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return; // already marked present, avoid duplicates
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = name;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    // Deliberately no method returns the presentStudents array itself.

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate, should not be counted twice

        System.out.println("Present count: " + sheet.getPresentCount() + " (expected 2)");
        System.out.println("isPresent(\"Ben\"): " + sheet.isPresent("Ben") + " (expected true)");
        System.out.println("isPresent(\"Chen\"): " + sheet.isPresent("Chen") + " (expected false)");
    }
}
