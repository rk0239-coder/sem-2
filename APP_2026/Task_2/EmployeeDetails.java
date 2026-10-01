package Task_2;

class Employee {
    int id;
    String name;
    double salary;

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: Rs." + salary);
        System.out.println();
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {

        Employee e1 = new Employee();

        e1.id = 101;
        e1.name = "Rahul";
        e1.salary = 30000;

        Employee e2 = new Employee();

        e2.id = 102;
        e2.name = "Priya";
        e2.salary = 40000;

        e1.display();
        e2.display();
    }
}