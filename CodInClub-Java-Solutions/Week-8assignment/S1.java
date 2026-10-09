import java.util.*;

abstract class Seat {
    static final double FEE = 20;
    int count;
    Seat(int count) { this.count = count; }
    abstract double price();
    double amount() { return count * (price() + FEE); }
}

class Reg extends Seat {
    Reg(int c) { super(c); }
    double price() { return 150; }
}

class Prem extends Seat {
    Prem(int c) { super(c); }
    double price() { return 250; }
}

class Recl extends Seat {
    Recl(int c) { super(c); }
    double price() { return 400; }
}

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            int c = Integer.parseInt(t[1]);
            Seat s;
            if (t[0].equals("REGULAR")) s = new Reg(c);
            else if (t[0].equals("PREMIUM")) s = new Prem(c);
            else s = new Recl(c);
            System.out.printf("%s: %.2f%n", t[0], s.amount());
            total += s.amount();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
