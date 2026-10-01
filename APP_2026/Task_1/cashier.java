import java.util.Scanner;

public class cashier {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter price of product 1: ");
        double price1 = input.nextDouble();

        System.out.print("Enter price of product 2: ");
        double price2 = input.nextDouble();

        double total = price1 + price2;
        double difference = price1 - price2;
        double product = price1 * price2;
        double quotient = price1 / price2;
        double remainder = price1 % price2;

        System.out.println("\nResults:");
        System.out.println("Total: " + total);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);

        input.close();
    }
}
