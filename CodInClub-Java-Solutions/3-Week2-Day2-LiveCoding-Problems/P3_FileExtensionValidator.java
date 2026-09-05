public class P3_FileExtensionValidator {
    static String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};
    static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected -- invalid file type";
        }
    String extension = filename.substring(dotIndex + 1);
    for (String accepted : ACCEPTED_EXTENSIONS) {
        if (accepted.equalsIgnoreCase(extension)) {
            return "Accepted";
        }
}
return "Rejected -- invalid file type";
}
public static void main(String[] args) {
    System.out.println("\"Assignment1.PDF\" -> " + validateFileExtension("Assignment1.PDF"));
    System.out.println("Expected: Accepted");
    System.out.println();
    System.out.println("\"notes.txt\" -> " + validateFileExtension("notes.txt"));
    System.out.println("Expected: Rejected -- invalid file type");
}
}
