/*
 * CODING QUESTION 5: Public Transport Fare Calculator
 *
 * Task:
 * A public transport system calculates fares for Bus, Train, and Metro
 * journeys based on distance. Each transport type has its own fare
 * structure. Calculate the fare for a list of journeys and the total fare.
 *
 * Input:
 *   Line 1: integer N (number of journeys)
 *   Next N lines: TransportType Distance [AdditionalParam]
 *     BUS Distance
 *     TRAIN Distance
 *     METRO Distance PeakHourFactor
 *
 * Output:
 *   For each journey: "TransportType: CalculatedFare" (2 decimals)
 *   Finally: "Total: GrandTotalFare" (2 decimals)
 *
 * Business Rules:
 *   - BUS:   $2 base + $0.10/km, capped at a maximum fare of $10.
 *   - TRAIN: $3 base + $0.15/km.
 *   - METRO: ($1.50 base + $0.20/km) * PeakHourFactor.
 *
 * Sample Input:
 *   3
 *   BUS 15
 *   TRAIN 50
 *   METRO 10 1.5
 *
 * Expected Output:
 *   BUS: 3.50
 *   TRAIN: 10.50
 *   METRO: 5.25
 *   Total: 19.25
 *
 * Design note:
 * Each transport type is its own class implementing a common Transport
 * interface with getFare(). The main loop calls getFare() polymorphically
 * without ever branching on the transport type itself.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Transport {
    double getFare();
    String getType();
}

class BusTransport implements Transport {
    private final double distance;

    public BusTransport(double distance) {
        this.distance = distance;
    }

    @Override
    public double getFare() {
        double fare = 2 + (0.10 * distance);
        return Math.min(fare, 10); // capped at $10
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class TrainTransport implements Transport {
    private final double distance;

    public TrainTransport(double distance) {
        this.distance = distance;
    }

    @Override
    public double getFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class MetroTransport implements Transport {
    private final double distance;
    private final double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double getFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class Problem5_PublicTransportFareCalculator {

    static Transport createTransport(String[] tokens) {
        String type = tokens[0];
        double distance = Double.parseDouble(tokens[1]);

        switch (type) {
            case "BUS":
                return new BusTransport(distance);
            case "TRAIN":
                return new TrainTransport(distance);
            case "METRO":
                double peakHourFactor = Double.parseDouble(tokens[2]);
                return new MetroTransport(distance, peakHourFactor);
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            journeys.add(createTransport(tokens));
        }

        double total = 0;
        for (Transport t : journeys) {
            double fare = t.getFare();
            System.out.printf("%s: %.2f%n", t.getType(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
