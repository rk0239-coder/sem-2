
public class TrafficLight {

    private static final String RED = "RED";
    private static final String GREEN = "GREEN";
    private static final String YELLOW = "YELLOW";

    private final String id;
    private String currentColor;

    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = RED;
    }

    public String next() {
        if (currentColor.equals(RED)) {
            currentColor = GREEN;
        } else if (currentColor.equals(GREEN)) {
            currentColor = YELLOW;
        } else {
            currentColor = RED;
        }
        return currentColor;
    }

    public String getColor() {
        return currentColor;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Starting color: " + t.getColor() + " (expected RED)");

        System.out.println("next() -> " + t.next() + " (expected GREEN)");
        System.out.println("next() -> " + t.next() + " (expected YELLOW)");
        System.out.println("next() -> " + t.next() + " (expected RED)");
        System.out.println("next() -> " + t.next() + " (expected GREEN, cycle repeats)");
    }
}
