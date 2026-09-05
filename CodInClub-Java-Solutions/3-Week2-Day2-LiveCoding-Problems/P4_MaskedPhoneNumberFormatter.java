public class P4_MaskedPhoneNumberFormatter {
    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
    for (int i = 0; i < phone.length(); i++) {
        if (!Character.isDigit(phone.charAt(i))) {
            return "Invalid phone number";
        }
}
String lastFour = phone.substring(phone.length() - 4);
StringBuilder masked = new StringBuilder("XXXXXX");
masked.append("-").append(lastFour);
return masked.toString();
}
public static void main(String[] args) {
    System.out.println("\"9876543210\" -> " + maskPhoneNumber("9876543210"));
    System.out.println("Expected: XXXXXX-3210");
    System.out.println();
    System.out.println("\"98765\" -> " + maskPhoneNumber("98765"));
    System.out.println("Expected: Invalid phone number");
}
}
