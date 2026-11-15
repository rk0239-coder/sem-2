import java.util.Scanner;

class Staff {
    protected String name;
    protected double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }

    double getTotal() {
        return baseSalary + getBonus();
    }
}

class Teacher extends Staff {
    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 5000;
    }

    @Override
    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 2000;
    }

    @Override
    String getType() {
        return "LabAssistant";
    }
}

public class Problem1_CampusStaffSalary {
    static String fmt(double x) {
        return x == Math.rint(x) ? String.format("%.1f", x) : Double.toString(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();
            if (type.equals("Teacher")) staff[i] = new Teacher(name, base);
            else if (type.equals("LabAssistant")) staff[i] = new LabAssistant(name, base);
            else staff[i] = new Staff(name, base);
        }
        double grand = 0;
        for (Staff s : staff) {
            System.out.println(s.name + " (" + s.getType() + "): base " + fmt(s.baseSalary)
                    + ", bonus " + fmt(s.getBonus()) + ", total " + fmt(s.getTotal()));
            grand += s.getTotal();
        }
        System.out.println("Grand Total Salary: " + fmt(grand));
    }
}
