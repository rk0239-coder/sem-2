/*
 * ASSIGNMENT PROBLEM 3: The Hostel Electricity Bill
 *
 * Task:
 * A hostel has single rooms, shared rooms, and AC rooms, each calculating
 * its monthly electricity bill differently. For shared rooms, the bill is
 * split equally among occupants, and the amount shown is per occupant.
 * Calculate the bill for every room, display it, then display the total.
 *
 * Input:
 *   Line 1: integer N (number of rooms)
 *   Next N lines: RoomType Units [AdditionalParam]
 *     SINGLE Units
 *     SHARED Units Occupants
 *     AC Units
 *
 * Output:
 *   For each room: "RoomType: BillAmount" (2 decimals)
 *   Finally: "Total: GrandTotal" (2 decimals)
 *
 * Business Rules:
 *   - SINGLE: Rs. 8 per unit.
 *   - SHARED: Rs. 6 per unit, divided equally by the number of occupants.
 *   - AC:     Rs. 10 per unit, plus a fixed charge of Rs. 200.
 *
 * Sample Input:
 *   3
 *   SINGLE 120
 *   SHARED 150 3
 *   AC 100
 *
 * Expected Output:
 *   SINGLE: 960.00
 *   SHARED: 300.00
 *   AC: 1200.00
 *   Total: 2460.00
 *
 * Design note:
 * Each room type is its own class implementing a common Room interface
 * with getBillAmount(). SharedRoom simply carries one extra field
 * (occupants) - the main loop still calls getBillAmount() the same way
 * for every room, with no explicit type checks.
 */

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
