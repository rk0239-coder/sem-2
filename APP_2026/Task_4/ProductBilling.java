package Task_4;

import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        double total = price * quantity;
        double discount;

        if (total >= 5000)
            discount = total * 0.10;
        else
            discount = total * 0.05;

        double finalPrice = total - discount;

        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Price: Rs." + total);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Price: Rs." + finalPrice);
        System.out.println();
    }
}

public class ProductBilling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Product " + (i + 1) + " details:");

            System.out.print("ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            products[i] = new Product(id, name, price, quantity);
        }

        System.out.println("\n--- PRODUCT BILL ---");

        for (int i = 0; i < 5; i++) {
            products[i].display();
        }
    }
}