import java.util.*;

abstract class Trip {
    static final double FEE = 50;
    double km;
    Trip(double km) { this.km = km; }
    abstract double fare();
    double total() { return fare() + FEE; }
}

class Bus extends Trip {
    Bus(double k) { super(k); }
    double fare() { return 2 * km; }
}

class Train extends Trip {
    Train(double k) { super(k); }
    double fare() { return 1.5 * km; }
}

class Flight extends Trip {
    Flight(double k) { super(k); }
    double fare() { return 2500 + 4 * km; }
}

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double k = Double.parseDouble(t[1]);
            Trip b;
            if (t[0].equals("BUS")) b = new Bus(k);
            else if (t[0].equals("TRAIN")) b = new Train(k);
            else b = new Flight(k);
            System.out.printf("%s: %.2f%n", t[0], b.total());
        }
    }
}
