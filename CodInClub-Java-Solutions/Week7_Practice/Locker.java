
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
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        boolean result1 = l.changeCode("1234", "5678");
        System.out.println("changeCode(\"1234\",\"5678\") -> " + result1 + " (expected true)");

        boolean result2 = l.changeCode("0000", "9999");
        System.out.println("changeCode(\"0000\",\"9999\") -> " + result2 + " (expected false)");

        boolean confirm = l.changeCode("5678", "5678");
        System.out.println("Confirming code is still \"5678\": " + confirm + " (expected true)");
    }
}
