import java.util.Scanner;

public class swap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter roll number of student 1: ");
        int roll1 = input.nextInt();

        System.out.print("Enter roll number of student 2: ");
        int roll2 = input.nextInt();

        int temp = roll1;
        roll1 = roll2;
        roll2 = temp;

        System.out.println("\nAfter swapping using temporary variable:");
        System.out.println("Student 1 roll number: " + roll1);
        System.out.println("Student 2 roll number: " + roll2);

        System.out.print("\nEnter new roll number of student 1: ");
        int a = input.nextInt();

        System.out.print("Enter new roll number of student 2: ");
        int b = input.nextInt();

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("\nAfter swapping without temporary variable:");
        System.out.println("Student 1 roll number: " + a);
        System.out.println("Student 2 roll number: " + b);

        input.close();
    }
}
