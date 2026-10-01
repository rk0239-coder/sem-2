package Task_4;

import java.util.Scanner;

class Patient {
    String name;
    double fee;

    Patient(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    double calculateFinalAmount(double discountRate) {
        double discount = fee * discountRate;
        return fee - discount;
    }

    void display() {

        double discountRate;

        if (fee >= 2000)
            discountRate = 0.10;
        else
            discountRate = 0.05;

        double discount = fee * discountRate;
        double finalAmount = calculateFinalAmount(discountRate);

        System.out.println("Patient Name: " + name);
        System.out.println("Original Fee: Rs." + fee);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Amount: Rs." + finalAmount);
        System.out.println();
    }
}

public class HospitalBilling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Patient[] patients = new Patient[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("Enter Patient " + (i + 1) + " details:");

            System.out.print("Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();

            sc.nextLine();

            patients[i] = new Patient(name, fee);
        }

        System.out.println("\n--- CONSULTATION BILL ---");

        for (int i = 0; i < 5; i++) {
            patients[i].display();
        }
    }
}