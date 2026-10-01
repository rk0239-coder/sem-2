package Task_5;

class Employee {
    String name;
    int id;
    double basicSalary;

    Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }
}

class Professor extends Employee {

    Professor(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 10000;
    }
}

class LabAssistant extends Employee {

    LabAssistant(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 5000;
    }
}

class AdministrativeStaff extends Employee {

    AdministrativeStaff(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + 3000;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {

        Employee e1 =
                new Professor("Arun", 101, 50000);

        Employee e2 =
                new LabAssistant("Rahul", 102, 30000);

        Employee e3 =
                new AdministrativeStaff("Priya", 103, 25000);

        System.out.println("Professor Salary: Rs."
                + e1.calculateSalary());

        System.out.println("Lab Assistant Salary: Rs."
                + e2.calculateSalary());

        System.out.println("Administrative Staff Salary: Rs."
                + e3.calculateSalary());
    }
}