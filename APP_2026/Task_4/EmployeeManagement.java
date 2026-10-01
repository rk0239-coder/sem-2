package Task_4;

import java.util.Scanner;

class Employee {
    int id;
    String name;
    double monthlySalary;

    Employee(int id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    double annualSalary() {
        return monthlySalary * 12;
    }

    double calculateBonus() {
        if (monthlySalary >= 30000)
            return annualSalary() * 0.10;
        else
            return 0;
    }

    void display() {
        double annual = annualSalary();
        double bonus = calculateBonus();

        String eligibility =
                monthlySalary >= 30000 ? "Eligible" : "Not Eligible";

        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: Rs." + monthlySalary);
        System.out.println("Annual Salary: Rs." + annual);
        System.out.println("Bonus: Rs." + bonus);
        System.out.println("Bonus Eligibility: " + eligibility);
        System.out.println();
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("Enter Employee " + (i + 1) + " details:");

            System.out.print("ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Monthly Salary: ");
            double salary = sc.nextDouble();

            employees[i] =
                    new Employee(id, name, salary);
        }

        System.out.println("\n--- EMPLOYEE DETAILS ---");

        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }
    }
}