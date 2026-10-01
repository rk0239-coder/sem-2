class TransactionProcessing implements Runnable {

    @Override
    public void run() {
        for (int count = 1; count <= 3; count++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " +
                    "Activity: Processing Transaction | Execution Count: " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class BalanceUpdating implements Runnable {

    @Override
    public void run() {
        for (int count = 1; count <= 3; count++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " +
                    "Activity: Updating Account Balance | Execution Count: " + count);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class SMSNotification implements Runnable {

    @Override
    public void run() {
        for (int count = 1; count <= 3; count++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " +
                    "Activity: Sending SMS Notification | Execution Count: " + count);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class P4 {
    public static void main(String[] args) {
        Thread transactionThread = new Thread(new TransactionProcessing());
        transactionThread.setName("Transaction-Thread");

        Thread balanceThread = new Thread(new BalanceUpdating());
        balanceThread.setName("BalanceUpdate-Thread");

        Thread smsThread = new Thread(new SMSNotification());
        smsThread.setName("SMS-Thread");

        System.out.println("=== Banking Application Started ===\n");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}
