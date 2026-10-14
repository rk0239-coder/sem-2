
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ParkedVehicle {
    double getCharge();
    String getType();
}

class Bike implements ParkedVehicle {
    private final int hours;

    public Bike(int hours) {
        this.hours = hours;
    }

    @Override
    public double getCharge() {
        return 10.0 * hours;
    }

    @Override
    public String getType() {
        return "BIKE";
    }
}

class Car implements ParkedVehicle {
    private final int hours;

    public Car(int hours) {
        this.hours = hours;
    }

    @Override
    public double getCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }

    @Override
    public String getType() {
        return "CAR";
    }
}

class Truck implements ParkedVehicle {
    private final int hours;

    public Truck(int hours) {
        this.hours = hours;
    }

    @Override
    public double getCharge() {
        double charge = 50.0 * hours;
        return Math.max(charge, 100.0);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }
}

public class Problem2_CampusParkingChargeCalculator {

    static ParkedVehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<ParkedVehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            vehicles.add(createVehicle(tokens[0], Integer.parseInt(tokens[1])));
        }

        double total = 0;
        for (ParkedVehicle v : vehicles) {
            double charge = v.getCharge();
            System.out.printf("%s: %.2f%n", v.getType(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
