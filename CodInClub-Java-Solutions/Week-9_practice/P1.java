import java.util.*;

abstract class Plot {
    String owner;
    Plot(String owner) { this.owner = owner; }
    abstract double area();
    abstract String shape();
}

class Circ extends Plot {
    double r;
    Circ(String o, double r) { super(o); this.r = r; }
    double area() { return Math.PI * r * r; }
    String shape() { return "CIRCLE"; }
}

class Rect extends Plot {
    double l, w;
    Rect(String o, double l, double w) { super(o); this.l = l; this.w = w; }
    double area() { return l * w; }
    String shape() { return "RECTANGLE"; }
}

class Tri extends Plot {
    double b, h;
    Tri(String o, double b, double h) { super(o); this.b = b; this.h = h; }
    double area() { return 0.5 * b * h; }
    String shape() { return "TRIANGLE"; }
}

public class P1 {
    static Plot make(String[] t) {
        switch (t[0]) {
            case "CIRCLE": return new Circ(t[1], Double.parseDouble(t[2]));
            case "RECTANGLE": return new Rect(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3]));
            default: return new Tri(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plot> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(make(sc.nextLine().trim().split("\\s+")));
        double total = 0;
        for (Plot p : list) {
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape(), p.area());
            total += p.area();
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
