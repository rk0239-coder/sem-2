class TrafficJunction extends Thread {

    private String trafficStatus;
    private long monitoringIntervalMillis;

    public TrafficJunction(String junctionName, String trafficStatus, long monitoringIntervalMillis) {
        super(junctionName);
        this.trafficStatus = trafficStatus;
        this.monitoringIntervalMillis = monitoringIntervalMillis;
    }

    @Override
    public void run() {
        for (int report = 1; report <= 3; report++) {
            System.out.println("[" + getName() + "] " +
                    "Traffic Status Report #" + report + " -> " + trafficStatus);
            try {
                Thread.sleep(monitoringIntervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class P5 {
    public static void main(String[] args) {
        TrafficJunction junctionA = new TrafficJunction("Junction-A-MGRoad", "Heavy Traffic", 1000);
        TrafficJunction junctionB = new TrafficJunction("Junction-B-RingRoad", "Moderate Traffic", 1500);
        TrafficJunction junctionC = new TrafficJunction("Junction-C-Highway", "Light Traffic", 2000);

        System.out.println("=== Smart Traffic Management System Started ===\n");

        junctionA.start();
        junctionB.start();
        junctionC.start();
    }
}
