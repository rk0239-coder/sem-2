
public class AttendanceSheet {

    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
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

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount() + " (expected 2)");
        System.out.println("isPresent(\"Ben\"): " + sheet.isPresent("Ben") + " (expected true)");
        System.out.println("isPresent(\"Chen\"): " + sheet.isPresent("Chen") + " (expected false)");
    }
}
