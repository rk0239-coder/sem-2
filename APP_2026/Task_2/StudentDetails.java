package Task_2;

class Student1 {
    String name;
    int age;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }
}

public class StudentDetails {
    public static void main(String[] args) {

        Student1 s1 = new Student1();
        s1.name = "Arun";
        s1.age = 18;

        Student1 s2 = new Student1();
        s2.name = "Priya";
        s2.age = 19;

        s1.display();
        s2.display();
    }
}