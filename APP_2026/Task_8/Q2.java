class OrderProcessing extends Thread {
    public void run() {
        System.out.println("Thread: " + getName() + " | Priority: " + getPriority() +
                " | Activity: Processing customer orders");
    }
}

class DeliveryTracking extends Thread {
    public void run() {
        System.out.println("Thread: " + getName() + " | Priority: " + getPriority() +
                " | Activity: Tracking delivery locations");
    }
}

class Notification extends Thread {
    public void run() {
        System.out.println("Thread: " + getName() + " | Priority: " + getPriority() +
                " | Activity: Sending order-status notifications");
    }
}

public class Q2 {
    public static void main(String[] args) {

        OrderProcessing orderProcessing = new OrderProcessing();
        DeliveryTracking deliveryTracking = new DeliveryTracking();
        Notification notification = new Notification();

        orderProcessing.setName("OrderProcessing");
        deliveryTracking.setName("DeliveryTracking");
        notification.setName("Notification");

        orderProcessing.setPriority(Thread.MAX_PRIORITY);
        deliveryTracking.setPriority(Thread.NORM_PRIORITY + 2);
        notification.setPriority(Thread.MIN_PRIORITY);

        orderProcessing.start();
        deliveryTracking.start();
        notification.start();
    }
}
