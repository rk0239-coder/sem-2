import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basicSalary = sc.nextDouble();

        System.out.print("Enter allowance: ");
        double allowance = sc.nextDouble();

        double totalSalary = basicSalary + allowance;

        System.out.println("Total Salary: " + totalSalary);
    }
}