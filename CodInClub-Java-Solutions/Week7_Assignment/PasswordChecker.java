/*
 * ASSIGNMENT PROBLEM 3: The Password Checker
 *
 * Scenario:
 * A signup form checks how strong your chosen password is.
 *
 * Problem Statement:
 * Design a PasswordChecker class that accepts a password once and reveals
 * only its strength rating - never the password itself.
 *
 * Requirements:
 * - Take the password as a string in the constructor and store it
 *   privately, with no getter that returns it.
 * - Provide a method that returns a strength label - "Weak" (under 6
 *   characters), "Medium" (6-9 characters), or "Strong" (10+ characters).
 * - The password itself must never be changeable after the object is
 *   created.
 * - Use the String length (and any other simple check you like) to decide
 *   the rating.
 *
 * Sample:
 *   PasswordChecker pc = new PasswordChecker("abcd");
 *   pc.getStrength() -> "Weak"
 *   PasswordChecker pc2 = new PasswordChecker("abcdefghij");
 *   pc2.getStrength() -> "Strong"
 */
public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    // Deliberately no getter returns the actual password text.

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("\"abcd\" (4 chars) -> " + pc1.getStrength() + " (expected Weak)");

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("\"abcdefgh\" (8 chars) -> " + pc2.getStrength() + " (expected Medium)");

        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println("\"abcdefghijkl\" (12 chars) -> " + pc3.getStrength() + " (expected Strong)");
    }
}
