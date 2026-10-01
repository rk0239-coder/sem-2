/*
 * CODING QUESTION 2: Library Item Due Date Calculator
 *
 * Task:
 * A library manages different types of items (Books, DVDs, Magazines).
 * Each item type has a specific borrowing duration. Calculate each
 * borrowed item's due date from the "current date".
 *
 * Input:
 *   Line 1: integer N (number of borrowed items)
 *   Next N lines: ItemType "ItemTitle"
 *     BOOK "The Great Gatsby"
 *     DVD "Inception"
 *     MAGAZINE "National Geographic Jan 2023"
 *
 * Output:
 *   For each item: "ItemTitle: DueDate" (DueDate as YYYY-MM-DD)
 *
 * Business Rules:
 *   - BOOK: 14 days
 *   - DVD: 7 days
 *   - MAGAZINE: 3 days
 *   - "Current date" is fixed at 2023-10-26 for this exercise.
 *
 * Sample Input:
 *   3
 *   BOOK "1984"
 *   DVD "The Matrix"
 *   MAGAZINE "Forbes Issue 500"
 *
 * Expected Output:
 *   1984: 2023-11-09
 *   The Matrix: 2023-11-02
 *   Forbes Issue 500: 2023-10-29
 *
 * Design note:
 * Each item type is its own class extending an abstract LibraryItem that
 * stores the title and exposes getDueDate(). Each subclass only needs to
 * supply its own borrowing period; the main loop calls getDueDate()
 * polymorphically without ever checking the item's concrete type.
 */

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

    // Matches: TYPE "quoted title (may contain spaces)"
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
