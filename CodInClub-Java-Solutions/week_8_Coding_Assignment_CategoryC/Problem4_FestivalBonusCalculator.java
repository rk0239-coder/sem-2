
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Employee {
    double getBonus();
    String getName();
}

class FullTimeEmployee implements Employee {
    private final String name;
    private final double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double getBonus() {
        return monthlySalary * 0.10;
    }

    @Override
    public String getName() {
        return name;
    }
}

class PartTimeEmployee implements Employee {
    private final String name;
    private final double monthlySalary;

    public PartTimeEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double getBonus() {
        return monthlySalary * 0.05;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Intern implements Employee {
    private final String name;

    public Intern(String name, double monthlySalary) {
        this.name = name;

    }

    @Override
    public double getBonus() {
        return 2000.0;
    }

    @Override
    public String getName() {
        return name;
    }
}

public class Problem4_FestivalBonusCalculator {

    static Employee createEmployee(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new Intern(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double salary = Double.parseDouble(tokens[2]);
            employees.add(createEmployee(type, name, salary));
        }

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.getBonus();
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
