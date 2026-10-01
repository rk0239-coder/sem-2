interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Rs. " + amount + " paid using Credit Card ending in " +
                cardNumber.substring(cardNumber.length() - 4));
    }
}

class UPIPayment implements Payment {

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Rs. " + amount + " paid using UPI ID: " + upiId);
    }
}

class NetBankingPayment implements Payment {

    private String bankName;

    public NetBankingPayment(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Rs. " + amount + " paid using Net Banking via " + bankName);
    }
}

public class T2 {
    public static void main(String[] args) {
        Payment[] paymentMethods = {
                new CreditCardPayment("4111222233334444"),
                new UPIPayment("shopper@okhdfc"),
                new NetBankingPayment("State Bank of India")
        };

        System.out.println("=== Processing Order Payments ===\n");

        double[] amounts = {2499.0, 899.5, 15999.0};

        for (int i = 0; i < paymentMethods.length; i++) {
            paymentMethods[i].pay(amounts[i]);
        }
    }
}
