/*
 * CODING QUESTION 1: Payment System Fee Calculation
 *
 * Task:
 * A payment processing system handles various transaction types. Each
 * payment method applies a different processing fee. For every
 * transaction, calculate the final amount after applying the applicable
 * fee and display the adjusted amount for each transaction followed by
 * the total amount processed.
 *
 * Input:
 *   Line 1: integer N (number of transactions)
 *   Next N lines: "CARD Amount" | "WALLET Amount" | "BANKTRANSFER Amount"
 *
 * Output:
 *   For each transaction: "PaymentType: AdjustedAmount" (2 decimals)
 *   Finally: "Total: GrandTotal" (2 decimals)
 *
 * Business Rules:
 *   - CARD: 2% processing fee
 *   - WALLET: 1% processing fee
 *   - BANKTRANSFER: no fee
 *
 * Sample Input:
 *   3
 *   CARD 1000
 *   WALLET 500
 *   BANKTRANSFER 2000
 *
 * Expected Output:
 *   CARD: 1020.00
 *   WALLET: 505.00
 *   BANKTRANSFER: 2000.00
 *   Total: 3525.00
 *
 * Design note:
 * Each payment type is modeled as its own class implementing a common
 * Payment interface with one method, getAdjustedAmount(). The main
 * processing loop never checks "if type is CARD" etc. - it simply calls
 * getAdjustedAmount() on whatever Payment object was created, and
 * polymorphism takes care of using the right fee rule.
 */

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
        return amount * 1.02; // 2% processing fee
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
        return amount * 1.01; // 1% processing fee
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
        return amount; // no fee
    }

    @Override
    public String getType() {
        return "BANKTRANSFER";
    }
}

public class Problem1_PaymentSystemFeeCalculation {

    // Factory: the only place that knows about concrete payment types.
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
