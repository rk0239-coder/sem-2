import java.util.*;

abstract class Conn {
    double units;
    Conn(double units) { this.units = units; }
    abstract double bill();
}

class Home extends Conn {
    Home(double u) { super(u); }
    double bill() {
        if (units <= 100) return units * 5;
        return 500 + (units - 100) * 7;
    }
}

class Shop extends Conn {
    Shop(double u) { super(u); }
    double bill() { return units * 8 + 100; }
}

class Factory extends Conn {
    Factory(double u) { super(u); }
    double bill() { return Math.max(units * 6, 1000); }
}

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double u = Double.parseDouble(t[1]);
            Conn c;
            if (t[0].equals("HOME")) c = new Home(u);
            else if (t[0].equals("SHOP")) c = new Shop(u);
            else c = new Factory(u);
            System.out.printf("%s: %.2f%n", t[0], c.bill());
            total += c.bill();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
