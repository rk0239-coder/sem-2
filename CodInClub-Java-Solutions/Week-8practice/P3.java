import java.util.*;

abstract class Item {
    String title;
    int days;
    Item(String title, int days) { this.title = title; this.days = days; }
    abstract double fine();
}

class Book extends Item {
    Book(String t, int d) { super(t, d); }
    double fine() { return 2.0 * days; }
}

class Dvd extends Item {
    Dvd(String t, int d) { super(t, d); }
    double fine() { return Math.min(5.0 * days, 50.0); }
}

class Mag extends Item {
    Mag(String t, int d) { super(t, d); }
    double fine() { return 1.0 * days; }
}

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            int d = Integer.parseInt(t[2]);
            Item it;
            if (t[0].equals("BOOK")) it = new Book(t[1], d);
            else if (t[0].equals("DVD")) it = new Dvd(t[1], d);
            else it = new Mag(t[1], d);
            System.out.printf("%s: %.2f%n", it.title, it.fine());
            total += it.fine();
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
