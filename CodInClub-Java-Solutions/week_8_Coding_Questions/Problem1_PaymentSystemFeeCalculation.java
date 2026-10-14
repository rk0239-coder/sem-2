
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Payment {
    double getAdjustedAmount();
    String getType();
}

class CardPayment implements Payment {
    private final double amount;

    public CardPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.02;
    }

    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {
    private final double amount;

    public WalletPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.01;
    }

    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment implements Payment {
    private final double amount;

    public BankTransferPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAdjustedAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class Problem1_PaymentSystemFeeCalculation {

    static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double amount = Double.parseDouble(tokens[1]);
            payments.add(createPayment(type, amount));
        }

        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.getAdjustedAmount();
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
