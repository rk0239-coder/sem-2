
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LibraryItem {
    protected final String title;
    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    protected abstract int getBorrowingDays();

    public LocalDate getDueDate() {
        return CURRENT_DATE.plusDays(getBorrowingDays());
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    protected int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    protected int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    protected int getBorrowingDays() {
        return 3;
    }
}

public class Problem2_LibraryItemDueDateCalculator {

    private static final Pattern LINE_PATTERN = Pattern.compile("^(\\S+)\\s+\"(.*)\"\\s*$");

    static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new DVD(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher m = LINE_PATTERN.matcher(line);
            if (m.matches()) {
                String type = m.group(1);
                String title = m.group(2);
                items.add(createItem(type, title));
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate());
        }
    }
}
