/*
 * ASSIGNMENT PROBLEM 4: The Traffic Light
 *
 * Scenario:
 * A traffic light cycles through red, green, and yellow, in order.
 *
 * Problem Statement:
 * Design a TrafficLight class where the color can only move forward
 * through its cycle, never be set to an arbitrary color directly.
 *
 * Requirements:
 * - The current color must be private, changed only by a next() method
 *   that moves red -> green -> yellow -> red, in that order.
 * - There must be no method that sets the color directly to any value.
 * - Provide a read-only way to check the current color.
 * - Give the light a final ID, fixed when it's created.
 *
 * Sample:
 *   TrafficLight t = new TrafficLight("TL-9");
 *   t.getColor() -> "RED"
 *   t.next() -> "GREEN"
 *   t.next() -> "YELLOW"
 *   t.next() -> "RED"
 */
public class TrafficLight {

    private static final String RED = "RED";
    private static final String GREEN = "GREEN";
    private static final String YELLOW = "YELLOW";

    private final String id;
    private String currentColor;

    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = RED; // every light starts on red
    }

    public String next() {
        if (currentColor.equals(RED)) {
            currentColor = GREEN;
        } else if (currentColor.equals(GREEN)) {
            currentColor = YELLOW;
        } else { // currentColor.equals(YELLOW)
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
