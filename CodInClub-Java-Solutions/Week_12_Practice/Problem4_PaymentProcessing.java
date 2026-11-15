import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);

    double getFee(double amount);

    String getName();
}

class CashPayment implements PaymentMode {
    public double getFee(double amount) {
        return 0;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getName() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {
    public double getFee(double amount) {
        return amount * 0.02;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getName() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {
    public double getFee(double amount) {
        return 0;
    }

    public double processPayment(double amount) {
        return amount + getFee(amount);
    }

    public String getName() {
        return "UPI";
    }
}

public class Problem4_PaymentProcessing {
    static String fmt(double x) {
        return x == Math.rint(x) ? String.format("%.1f", x) : Double.toString(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentMode[] modes = new PaymentMode[n];
        double[] amounts = new double[n];
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();
            if (mode.equalsIgnoreCase("Card")) modes[i] = new CardPayment();
            else if (mode.equalsIgnoreCase("UPI")) modes[i] = new UpiPayment();
            else modes[i] = new CashPayment();
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double processed = modes[i].processPayment(amounts[i]);
            System.out.println(modes[i].getName() + ": amount " + fmt(amounts[i])
                    + ", fee " + fmt(modes[i].getFee(amounts[i])) + ", processed " + fmt(processed));
            total += processed;
        }
        System.out.println("Total Amount Processed: " + fmt(total));
    }
}
