import java.util.*;

interface NightService {
    default double night(double fare) { return fare * 1.2; }
}

abstract class Cab {
    abstract double rate();
    double fare(double km) { return Math.max(km * rate(), 100); }
}

class Mini extends Cab {
    double rate() { return 10; }
}

class Sedan extends Cab implements NightService {
    double rate() { return 14; }
}

class Suv extends Cab implements NightService {
    double rate() { return 18; }
}

public class S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double km = Double.parseDouble(t[1]);
            boolean night = t[2].equals("NIGHT");
            Cab c;
            if (t[0].equals("MINI")) c = new Mini();
            else if (t[0].equals("SEDAN")) c = new Sedan();
            else c = new Suv();
            double f = c.fare(km);
            if (night) {
                if (c instanceof NightService) f = ((NightService) c).night(f);
                else {
                    System.out.println(t[0] + ": night service not available");
                    continue;
                }
            }
            System.out.printf("%s: %.2f%n", t[0], f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
