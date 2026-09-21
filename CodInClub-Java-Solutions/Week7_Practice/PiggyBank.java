/*
 * PRACTICE PROBLEM 1: The Piggy Bank
 *
 * Scenario:
 * A savings app tracks how much money a kid has put away.
 *
 * Problem Statement:
 * Create a PiggyBank class where money can only be added or removed through
 * specific actions - never set directly to any amount.
 *
 * Requirements:
 * - The savings amount must be private, changed only by deposit and
 *   withdraw methods.
 * - A withdrawal larger than the current savings must be rejected, not
 *   applied.
 * - Give the piggy bank a final ID that's fixed the moment it's created.
 * - Provide a way to check the current savings, but no way to set it
 *   directly.
 *
 * Sample:
 *   PiggyBank pb = new PiggyBank("PB-1");
 *   pb.deposit(100)   -> savings = 100
 *   pb.withdraw(30)   -> savings = 70
 *   pb.withdraw(500)  -> rejected, savings stays 70
 */
public class PiggyBank {

    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
        // else: rejected, savings stays unchanged
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("New piggy bank savings: " + pb.getSavings() + " (expected 0.0)");

        pb.deposit(100);
        System.out.println("After deposit(100): " + pb.getSavings() + " (expected 100.0)");

        pb.withdraw(30);
        System.out.println("After withdraw(30): " + pb.getSavings() + " (expected 70.0)");

        pb.withdraw(500);
        System.out.println("After withdraw(500) [rejected]: " + pb.getSavings() + " (expected 70.0)");
    }
}
