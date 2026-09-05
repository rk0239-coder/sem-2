public class P5_BankTransactionReferenceGeneratorValidator {
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
    String bankCode = trimmed.substring(0, 3).toUpperCase();
    String rest = trimmed.substring(3);
    return bankCode + rest;
}
static String validateAndFormat(String reference) {
    if (reference.length() != 14) {
        return "Invalid: wrong length";
    }
for (int i = 0; i < 3; i++) {
    if (!Character.isLetter(reference.charAt(i))) {
        return "Invalid: bank code must be 3 letters";
    }
}
for (int i = 3; i < 14; i++) {
    if (!Character.isDigit(reference.charAt(i))) {
        return "Invalid: remaining body must be 11 digits";
    }
}
String bankCode = reference.substring(0, 3);
String dd = reference.substring(3, 5);
String mm = reference.substring(5, 7);
String yy = reference.substring(7, 9);
String seq = reference.substring(9, 14);
StringBuilder display = new StringBuilder();
display.append("[").append(bankCode).append("] DATE: ")
.append(dd).append("/").append(mm).append("/").append(yy)
.append(" | SEQ: ").append(seq);
return display.toString();
}
public static void main(String[] args) {
    String raw1 = " hdf03022600042 ";
    String normalized1 = normalizeReference(raw1);
    System.out.println("\"" + raw1 + "\" -> " + validateAndFormat(normalized1));
    System.out.println("Expected: [HDF] DATE: 03/02/26 | SEQ: 00042");
    System.out.println();
    String raw2 = "12F03022600042";
    String normalized2 = normalizeReference(raw2);
    System.out.println("\"" + raw2 + "\" -> " + validateAndFormat(normalized2));
    System.out.println("Expected: Invalid: bank code must be 3 letters");
}
}
