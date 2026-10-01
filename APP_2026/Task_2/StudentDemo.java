package Task_2;

class Student {
    String name;
    int rollNo;

    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
}

public class StudentDemo {
    public static void main(String[] args) {

        Student s = new Student();

        s.name = "Rahul";
        s.rollNo = 101;

        s.display();
    }
}