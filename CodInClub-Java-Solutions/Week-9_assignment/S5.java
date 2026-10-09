import java.util.*;

interface SaverMode {
    default double saved(double units) { return units * 0.75; }
}

abstract class Appl {
    abstract double power();
    double units(double hours) { return power() * hours / 1000; }
}

class Fridge extends Appl {
    double power() { return 150; }
}

class Ac extends Appl implements SaverMode {
    double power() { return 1500; }
}

class Tv extends Appl {
    double power() { return 100; }
}

class Washer extends Appl implements SaverMode {
    double power() { return 500; }
}

public class S5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double h = Double.parseDouble(t[1]);
            boolean saver = t.length > 2 && t[2].equals("SAVER");
            Appl a;
            if (t[0].equals("FRIDGE")) a = new Fridge();
            else if (t[0].equals("AC")) a = new Ac();
            else if (t[0].equals("TV")) a = new Tv();
            else a = new Washer();
            double u = a.units(h);
            if (saver) {
                if (a instanceof SaverMode) u = ((SaverMode) a).saved(u);
                else {
                    System.out.println(t[0] + ": saver mode not supported");
                    continue;
                }
            }
            double cost = u * 8;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", t[0], u, cost);
            total += cost;
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}
