
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
