/*
 * PRACTICE PROBLEM 4: The Locker Code
 *
 * Scenario:
 * A gym locker has a combination code that members can change.
 *
 * Problem Statement:
 * Design a Locker class where the combination can be changed, but never
 * read back directly from outside the class.
 *
 * Requirements:
 * - The combination code must be private, with no getter at all.
 * - Provide a method to change the code that requires the current code to
 *   be entered correctly first.
 * - If the wrong current code is given, the change must be rejected and
 *   the code must stay the same.
 * - Give the locker a final locker number, fixed at creation.
 *
 * Sample:
 *   Locker l = new Locker(101, "1234");
 *   l.changeCode("1234", "5678") -> success
 *   l.changeCode("0000", "9999") -> rejected, code is still "5678"
 */
public class Locker {

    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }
        return false; // wrong current code -> rejected, code unchanged
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    // Deliberately no getter for the code - it's write-only from outside.

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        boolean result1 = l.changeCode("1234", "5678");
        System.out.println("changeCode(\"1234\",\"5678\") -> " + result1 + " (expected true)");

        boolean result2 = l.changeCode("0000", "9999");
        System.out.println("changeCode(\"0000\",\"9999\") -> " + result2 + " (expected false)");

        // There is no getter, so the only way to confirm the code is "5678"
        // is to try changing it with that as the current code.
        boolean confirm = l.changeCode("5678", "5678");
        System.out.println("Confirming code is still \"5678\": " + confirm + " (expected true)");
    }
}
