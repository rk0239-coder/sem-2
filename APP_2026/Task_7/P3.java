class RemainingTimeDisplay implements Runnable {

    private int totalMinutes;

    public RemainingTimeDisplay(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    @Override
    public void run() {
        int remaining = totalMinutes;
        for (int i = 0; i < 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " +
                    "Activity: Displaying remaining time -> " + remaining + " minute(s) left");
            remaining--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class AutoSaveAnswers implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " +
                    "Activity: Auto-saving student answers... (save #" + i + ")");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class NetworkChecker implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " +
                    "Activity: Checking network connection... Status: Connected (check #" + i + ")");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class P3 {
    public static void main(String[] args) {
        Thread timerThread = new Thread(new RemainingTimeDisplay(60));
        timerThread.setName("Timer-Thread");

        Thread autoSaveThread = new Thread(new AutoSaveAnswers());
        autoSaveThread.setName("AutoSave-Thread");

        Thread networkThread = new Thread(new NetworkChecker());
        networkThread.setName("NetworkCheck-Thread");

        System.out.println("=== Online Examination System Started ===\n");

        timerThread.start();
        autoSaveThread.start();
        networkThread.start();
    }
}
