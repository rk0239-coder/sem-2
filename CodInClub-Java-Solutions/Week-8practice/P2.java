import java.util.*;

abstract class Staff {
    String name;
    Staff(String name) { this.name = name; }
    abstract double pay();
}

class Full extends Staff {
    double salary;
    Full(String n, double s) { super(n); salary = s; }
    double pay() { return salary; }
}

class Hourly extends Staff {
    double hours, rate;
    Hourly(String n, double h, double r) { super(n); hours = h; rate = r; }
    double pay() {
        if (hours <= 40) return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;
    Intern(String n, double s) { super(n); stipend = s; }
    double pay() { return stipend; }
}

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            Staff s;
            if (t[0].equals("FULLTIME")) s = new Full(t[1], Double.parseDouble(t[2]));
            else if (t[0].equals("HOURLY")) s = new Hourly(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3]));
            else s = new Intern(t[1], Double.parseDouble(t[2]));
            System.out.printf("%s: %.2f%n", s.name, s.pay());
            total += s.pay();
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
