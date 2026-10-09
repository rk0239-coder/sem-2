import java.util.*;

interface BusUser {
    double TRANSPORT = 12000;
}

abstract class Student {
    String name;
    Student(String name) { this.name = name; }
    abstract double tuition();
}

class Day extends Student implements BusUser {
    Day(String n) { super(n); }
    double tuition() { return 40000; }
}

class Host extends Student {
    Host(String n) { super(n); }
    double tuition() { return 40000 + 60000; }
}

class Schol extends Student implements BusUser {
    Schol(String n) { super(n); }
    double tuition() { return 20000; }
}

public class S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            Student s;
            if (t[0].equals("DAY_SCHOLAR")) s = new Day(t[1]);
            else if (t[0].equals("HOSTELLER")) s = new Host(t[1]);
            else s = new Schol(t[1]);
            double fee = s.tuition() + (s instanceof BusUser ? BusUser.TRANSPORT : 0);
            System.out.printf("%s: %.2f%n", s.name, fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
