
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Room {
    double getBillAmount();
    String getType();
}

class SingleRoom implements Room {
    private final double units;

    public SingleRoom(double units) {
        this.units = units;
    }

    @Override
    public double getBillAmount() {
        return 8.0 * units;
    }

    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {
    private final double units;
    private final int occupants;

    public SharedRoom(double units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    @Override
    public double getBillAmount() {
        return (6.0 * units) / occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }
}

class ACRoom implements Room {
    private final double units;

    public ACRoom(double units) {
        this.units = units;
    }

    @Override
    public double getBillAmount() {
        return (10.0 * units) + 200.0;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

public class Problem3_HostelElectricityBill {

    static Room createRoom(String[] tokens) {
        String type = tokens[0];
        double units = Double.parseDouble(tokens[1]);

        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                int occupants = Integer.parseInt(tokens[2]);
                return new SharedRoom(units, occupants);
            case "AC":
                return new ACRoom(units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            rooms.add(createRoom(tokens));
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.getBillAmount();
            System.out.printf("%s: %.2f%n", r.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
