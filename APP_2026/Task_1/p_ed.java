import java.util.Scanner;

public class p_ed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the playground: ");
        double length = input.nextDouble();

        System.out.print("Enter the breadth of the playground: ");
        double breadth = input.nextDouble();

        double area = length * breadth;

        System.out.println("\nArea of the rectangular playground: " + area);

        input.close();
    }
}
