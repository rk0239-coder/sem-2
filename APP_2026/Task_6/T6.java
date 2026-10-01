class Account {

    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Account Holder  : " + accountHolderName);
        System.out.println("Balance         : Rs. " + balance);
    }
}

class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails() {
        System.out.println("-- Savings Account --");
        super.displayDetails();
        System.out.println("Interest Rate   : " + interestRate + "%");
    }
}

class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayDetails() {
        System.out.println("-- Current Account --");
        super.displayDetails();
        System.out.println("Overdraft Limit : Rs. " + overdraftLimit);
    }
}

interface OnlineTransaction {}

interface AccountPayment {
    void pay(double amount);
}

interface SecureAccountPayment extends AccountPayment {
    void verifyPayment();
}

class AccountCardPayment implements AccountPayment {

    private String cardNumber;

    public AccountCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Card ending in " +
                cardNumber.substring(cardNumber.length() - 4));
    }
}

class AccountUPIPayment implements SecureAccountPayment, OnlineTransaction {

    private String upiId;

    public AccountUPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using UPI ID: " + upiId);
    }

    @Override
    public void verifyPayment() {
        System.out.println("Verifying UPI payment for " + upiId + " ... Verified successfully.");
    }
}

public class T6 {

    public static void main(String[] args) {

        System.out.println("=== Account Details (Runtime Polymorphism) ===\n");

        Account[] accounts = {
                new SavingsAccount("SAV1001", "Ananya Verma", 25000.0, 4.5),
                new CurrentAccount("CUR2001", "Rohit Sharma", 150000.0, 50000.0)
        };

        for (Account acc : accounts) {
            acc.displayDetails();
            System.out.println();
        }

        System.out.println("=== Processing Payments ===\n");

        AccountPayment cardPayment = new AccountCardPayment("4111222233334444");
        AccountPayment upiPayment = new AccountUPIPayment("ananya@okicici");

        cardPayment.pay(1500.0);
        upiPayment.pay(750.0);

        SecureAccountPayment securePayment = new AccountUPIPayment("rohit@oksbi");
        securePayment.pay(2200.0);
        securePayment.verifyPayment();

        System.out.println();

        System.out.println("=== Identifying Online Transactions ===\n");

        AccountPayment[] payments = {cardPayment, upiPayment, securePayment};

        for (AccountPayment p : payments) {
            String type = p.getClass().getSimpleName();
            if (p instanceof OnlineTransaction) {
                System.out.println(type + " -> Online Transaction");
            } else {
                System.out.println(type + " -> Not an Online Transaction");
            }
        }
    }
}
