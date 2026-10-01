/*
 * ASSIGNMENT PROBLEM 1: The Canteen Billing Counter
 *
 * Task:
 * A college canteen serves students, staff, and guests. Each pays a
 * different final amount for the same bill. Calculate the final amount
 * for every bill, display it, then display the total amount collected.
 *
 * Input:
 *   Line 1: integer N (number of bills)
 *   Next N lines: "STUDENT Amount" | "STAFF Amount" | "GUEST Amount"
 *
 * Output:
 *   For each bill: "CustomerType: FinalAmount" (2 decimals)
 *   Finally: "Total: GrandTotal" (2 decimals)
 *
 * Business Rules:
 *   - STUDENT: 10% discount
 *   - STAFF:   5% discount
 *   - GUEST:   full amount + Rs. 10 service charge
 *
 * Sample Input:
 *   3
 *   STUDENT 200
 *   STAFF 300
 *   GUEST 150
 *
 * Expected Output:
 *   STUDENT: 180.00
 *   STAFF: 285.00
 *   GUEST: 160.00
 *   Total: 625.00
 *
 * Design note:
 * Each customer type is its own class implementing a common Customer
 * interface with getFinalAmount(). The billing loop calls getFinalAmount()
 * polymorphically, with no if-else chain checking customer type.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Customer {
    double getFinalAmount();
    String getType();
}

class StudentCustomer implements Customer {
    private final double amount;

    public StudentCustomer(double amount) {
        this.amount = amount;
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.90; // 10% discount
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer implements Customer {
    private final double amount;

    public StaffCustomer(double amount) {
        this.amount = amount;
    }

    @Override
    public double getFinalAmount() {
        return amount * 0.95; // 5% discount
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer implements Customer {
    private final double amount;

    public GuestCustomer(double amount) {
        this.amount = amount;
    }

    @Override
    public double getFinalAmount() {
        return amount + 10; // full amount + Rs. 10 service charge
    }

    @Override
    public String getType() {
        return "GUEST";
    }
}

public class Problem1_CanteenBillingCounter {

    static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new StudentCustomer(amount);
            case "STAFF":
                return new StaffCustomer(amount);
            case "GUEST":
                return new GuestCustomer(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            bills.add(createCustomer(tokens[0], Double.parseDouble(tokens[1])));
        }

        double total = 0;
        for (Customer c : bills) {
            double finalAmount = c.getFinalAmount();
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
