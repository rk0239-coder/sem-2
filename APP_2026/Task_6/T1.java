class Vehicle {

    protected String vehicleNumber;
    protected String brand;
    protected double speed;

    public Vehicle(String vehicleNumber, String brand, double speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Brand          : " + brand);
        System.out.println("Top Speed      : " + speed + " km/h");
    }
}

class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String vehicleNumber, String brand, double speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("-- Car Details --");
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

class Bike extends Vehicle {

    private boolean hasGear;

    public Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    public void displayDetails() {
        System.out.println("-- Bike Details --");
        super.displayDetails();
        System.out.println("Has Gear       : " + (hasGear ? "Yes" : "No"));
    }
}

public class T1 {
    public static void main(String[] args) {
        Vehicle[] fleet = {
                new Car("KA-01-AB-1234", "Toyota", 180.0, 4),
                new Bike("KA-01-CD-5678", "Royal Enfield", 120.0, true)
        };

        System.out.println("=== Vehicle Rental Fleet ===\n");

        for (Vehicle v : fleet) {
            v.displayDetails();
            System.out.println();
        }
    }
}
