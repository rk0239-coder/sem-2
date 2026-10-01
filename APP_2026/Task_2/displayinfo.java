package Task_2;

import java.util.Scanner;

class student {

    String name;
    String registernumber;
    String department;

    void getdetails() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student name: ");
        name = input.nextLine();

        System.out.print("Enter student register number: ");
        registernumber = input.nextLine();

        System.out.print("Enter student Department:");
        department = input.nextLine();
        input.close();
    }
    void displaydetails() {
        System.out.println("\nStudent details: ");
        System.out.println("Name: " + name);
        System.out.println("Register Number: " + registernumber);
        System.out.println("Department: " + department);
    }
}
public class displayinfo {
    public static void main(String args[]) {
        student s1 = new student();
        s1.getdetails();
        s1.displaydetails();
    }
}