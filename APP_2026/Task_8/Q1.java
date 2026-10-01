class EmergencyAlert extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName() + " | Priority: " + getPriority());
        System.out.println("Activity: Monitoring and raising critical patient alerts");
    }
}

class VitalMonitor extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName() + " | Priority: " + getPriority());
        System.out.println("Activity: Continuously checking patient vital signs");
    }
}

class ReportGenerator extends Thread {
    public void run() {
        System.out.println("Thread Name: " + getName() + " | Priority: " + getPriority());
        System.out.println("Activity: Preparing routine hospital reports");
    }
}

public class Q1 {
    public static void main(String[] args) {

        EmergencyAlert emergencyAlert = new EmergencyAlert();
        VitalMonitor vitalMonitor = new VitalMonitor();
        ReportGenerator reportGenerator = new ReportGenerator();

        emergencyAlert.setName("EmergencyAlert");
        vitalMonitor.setName("VitalMonitor");
        reportGenerator.setName("ReportGenerator");

        emergencyAlert.setPriority(Thread.MAX_PRIORITY);
        vitalMonitor.setPriority(Thread.NORM_PRIORITY);
        reportGenerator.setPriority(Thread.MIN_PRIORITY);

        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();
    }
}
