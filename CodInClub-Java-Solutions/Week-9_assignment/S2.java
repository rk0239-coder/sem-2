import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double kg, value;
    Parcel(double kg, double value) { this.kg = kg; this.value = value; }
    abstract double charge();
}

class Std extends Parcel {
    Std(double k, double v) { super(k, v); }
    double charge() { return 40 + 10 * kg; }
}

class Exp extends Parcel implements Insurable {
    Exp(double k, double v) { super(k, v); }
    double charge() { return 80 + 15 * kg; }
    public double insurance() { return 0.02 * value; }
}

class Frag extends Std implements Insurable {
    Frag(double k, double v) { super(k, v); }
    double charge() { return super.charge() + 50; }
    public double insurance() { return 0.02 * value; }
}

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double k = Double.parseDouble(t[1]);
            double v = Double.parseDouble(t[2]);
            Parcel p;
            if (t[0].equals("STANDARD")) p = new Std(k, v);
            else if (t[0].equals("EXPRESS")) p = new Exp(k, v);
            else p = new Frag(k, v);
            double ins = p instanceof Insurable ? ((Insurable) p).insurance() : 0;
            double tot = p.charge() + ins;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", t[0], p.charge(), ins, tot);
            grand += tot;
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
