
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

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("\"abcd\" (4 chars) -> " + pc1.getStrength() + " (expected Weak)");

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("\"abcdefgh\" (8 chars) -> " + pc2.getStrength() + " (expected Medium)");

        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println("\"abcdefghijkl\" (12 chars) -> " + pc3.getStrength() + " (expected Strong)");
    }
}
