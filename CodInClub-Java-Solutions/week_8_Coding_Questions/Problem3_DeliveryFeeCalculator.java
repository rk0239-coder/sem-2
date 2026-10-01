/*
 * CODING QUESTION 3: Delivery Fee Calculator
 *
 * Task:
 * A delivery service offers Standard, Express, and International delivery.
 * Each type has its own rule for calculating the fee based on weight and
 * distance. Calculate the total fee for a list of delivery requests.
 *
 * Input:
 *   Line 1: integer N (number of delivery requests)
 *   Next N lines: DeliveryType Weight Distance [AdditionalParam]
 *     STANDARD Weight Distance
 *     EXPRESS Weight Distance
 *     INTERNATIONAL Weight Distance CustomsFee
 *
 * Output:
 *   For each delivery: "DeliveryType: CalculatedFee" (2 decimals)
 *   Finally: "Total: GrandTotalFee" (2 decimals)
 *
 * Business Rules:
 *   - STANDARD:      $5 base + $0.50/kg + $0.10/km
 *   - EXPRESS:       $15 base + $1.00/kg + $0.20/km
 *   - INTERNATIONAL: $25 base + $2.00/kg + $0.50/km + CustomsFee
 *
 * Sample Input:
 *   3
 *   STANDARD 10 50
 *   EXPRESS 5 20
 *   INTERNATIONAL 20 100 30
 *
 * Expected Output:
 *   STANDARD: 15.00
 *   EXPRESS: 29.00
 *   INTERNATIONAL: 155.00
 *   Total: 199.00
 *
 * Design note:
 * Each delivery type is its own class implementing a common Delivery
 * interface with getFee(). The main loop calls getFee() polymorphically,
 * with no type-specific branching outside of the factory that builds the
 * objects from the input line.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Delivery {
    double getFee();
    String getType();
}

class StandardDelivery implements Delivery {
    private final double weight;
    private final double distance;

    public StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    @Override
    public double getFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery implements Delivery {
    private final double weight;
    private final double distance;

    public ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    @Override
    public double getFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery implements Delivery {
    private final double weight;
    private final double distance;
    private final double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    @Override
    public double getFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class Problem3_DeliveryFeeCalculator {

    static Delivery createDelivery(String[] tokens) {
        String type = tokens[0];
        double weight = Double.parseDouble(tokens[1]);
        double distance = Double.parseDouble(tokens[2]);

        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                double customsFee = Double.parseDouble(tokens[3]);
                return new InternationalDelivery(weight, distance, customsFee);
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            deliveries.add(createDelivery(tokens));
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.getFee();
            System.out.printf("%s: %.2f%n", d.getType(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
