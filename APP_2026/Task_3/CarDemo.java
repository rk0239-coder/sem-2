package Task_3;
class Car {
    String model;
    double price;

    // Default constructor
    Car() {
        model = "Not Entered";
        price = 0;
    }

    // One parameter constructor
    Car(String model) {
        this.model = model;
        price = 0;
    }

    // Two parameter constructor
    Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    void display() {
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
        System.out.println();
    }
}

public class CarDemo {
    public static void main(String[] args) {

        Car c1 = new Car();

        Car c2 = new Car("Swift");

        Car c3 = new Car("Creta", 1500000);

        System.out.println("Car 1");
        c1.display();

        System.out.println("Car 2");
        c2.display();

        System.out.println("Car 3");
        c3.display();
    }
}