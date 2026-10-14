
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
        return amount * 0.90;
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
        return amount * 0.95;
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
        return amount + 10;
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
