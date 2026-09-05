public class P4_LibraryISBNNormalizerValidator {
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
    String publisherCode = trimmed.substring(0, 3).toUpperCase();
    String rest = trimmed.substring(3);
    return publisherCode + rest;
}
static String validateAndFormat(String code) {
    if (code.length() != 13) {
        return "Invalid: wrong length";
    }
for (int i = 0; i < 3; i++) {
    if (!Character.isLetter(code.charAt(i))) {
        return "Invalid: publisher code must be 3 letters";
    }
}
for (int i = 3; i < 13; i++) {
    if (!Character.isDigit(code.charAt(i))) {
        return "Invalid: remaining body must be 10 digits";
    }
}
String publisherCode = code.substring(0, 3);
String year = code.substring(3, 7);
String catalog = code.substring(7, 13);
StringBuilder display = new StringBuilder();
display.append("[").append(publisherCode).append("] YEAR: ")
.append(year).append(" | CATALOG: ").append(catalog);
return display.toString();
}
public static void main(String[] args) {
    String raw1 = " pen2026004251 ";
    String normalized1 = normalizeCode(raw1);
    System.out.println("\"" + raw1 + "\" -> " + validateAndFormat(normalized1));
    System.out.println("Expected: [PEN] YEAR: 2026 | CATALOG: 004251");
    System.out.println();
    String raw2 = "12N2026004251";
    String normalized2 = normalizeCode(raw2);
    System.out.println("\"" + raw2 + "\" -> " + validateAndFormat(normalized2));
    System.out.println("Expected: Invalid: publisher code must be 3 letters");
}
}
