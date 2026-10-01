/*
 * ASSIGNMENT PROBLEM 4: The Festival Bonus Calculator
 *
 * Task:
 * A company pays a festival bonus to full-time employees, part-time
 * employees, and interns, each in a different way. Calculate the bonus
 * for every employee, display it with their name, then display the total
 * bonus paid.
 *
 * Input:
 *   Line 1: integer N (number of employees)
 *   Next N lines: EmployeeType Name MonthlySalary
 *     FULLTIME Name MonthlySalary
 *     PARTTIME Name MonthlySalary
 *     INTERN Name MonthlySalary
 *
 * Output:
 *   For each employee: "Name: Bonus" (2 decimals)
 *   Finally: "Total Bonus: GrandTotal" (2 decimals)
 *
 * Business Rules:
 *   - FULLTIME: 10% of monthly salary.
 *   - PARTTIME: 5% of monthly salary.
 *   - INTERN:   fixed Rs. 2,000 bonus, regardless of salary.
 *
 * Sample Input:
 *   3
 *   FULLTIME Asha 50000
 *   PARTTIME Ravi 30000
 *   INTERN Neha 15000
 *
 * Expected Output:
 *   Asha: 5000.00
 *   Ravi: 1500.00
 *   Neha: 2000.00
 *   Total Bonus: 8500.00
 *
 * Design note:
 * Each employee type is its own class implementing a common Employee
 * interface with getBonus(). The payroll loop calls getBonus()
 * polymorphically, with no explicit type checks.
 */

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
        // monthlySalary is accepted but irrelevant - interns get a fixed bonus
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
