import java.util.Scanner;

public class student_details {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter student name: ");
            String name = input.nextLine();

            System.out.println("Enter student register number: ");
            String registerNumber = input.nextLine();

            System.out.println("Enter student department: ");
            String department = input.nextLine();

            System.out.println("Enter student year of study: ");
            int yearofstudy = input.nextInt();

            System.out.println("Enter student college name: ");
            String collegename = input.nextLine();

            System.out.println("Student Details: ");
            System.out.println("Name: " + name);
            System.out.println("Register Number:" + registerNumber);
            System.out.println("Student Department: " + department);
            System.out.println("Year of study: " + yearofstudy);
            System.out.println("College Name: " + collegename);
            input.close();
        }
    }

}