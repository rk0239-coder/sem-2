package Task_4;

import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int[] marks = new int[3];
    double attendance;

    Student(int rollNo, String name, int m1, int m2, int m3, double attendance) {
        this.rollNo = rollNo;
        this.name = name;
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
        this.attendance = attendance;
    }

    double getAverage() {
        int total = 0;

        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }

        return total / 3.0;
    }

    void display() {
        int total = 0;

        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }

        double average = total / 3.0;

        String result = average >= 50 ? "Pass" : "Fail";

        String scholarship =
                (average >= 75 && attendance >= 80)
                ? "Eligible"
                : "Not Eligible";

        String performance =
                average >= 85 ? "Excellent" : "Good";

        System.out.println("Roll Number: " + rollNo);
        System.out.println("Student Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Result: " + result);
        System.out.println("Scholarship: " + scholarship);
        System.out.println("Performance: " + performance);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println();
    }
}

public class StudentPerformance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("Enter Student " + (i + 1) + " details:");

            System.out.print("Roll Number: ");
            int roll = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Mark 1: ");
            int m1 = sc.nextInt();

            System.out.print("Mark 2: ");
            int m2 = sc.nextInt();

            System.out.print("Mark 3: ");
            int m3 = sc.nextInt();

            System.out.print("Attendance: ");
            double attendance = sc.nextDouble();

            students[i] =
                    new Student(roll, name, m1, m2, m3, attendance);
        }

        double highestAverage = students[0].getAverage();
        int highestIndex = 0;

        System.out.println("\n--- STUDENT DETAILS ---");

        for (int i = 0; i < 5; i++) {

            students[i].display();

            if (students[i].getAverage() > highestAverage) {
                highestAverage = students[i].getAverage();
                highestIndex = i;
            }
        }

        System.out.println("--- HIGHEST AVERAGE ---");
        System.out.println("Student: " + students[highestIndex].name);
        System.out.println("Average: " + highestAverage);
    }
}