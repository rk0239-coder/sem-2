class Employee5 {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_EmployeeCompany {
    public static void main(String[] args) {
        Employee5 e1 = new Employee5("Ravi", 40000);
        Employee5 e2 = new Employee5("Anitha", 45000);
        Employee5 e3 = new Employee5("Karthik", 50000);

        Employee5.printCompanyInfo();
    }
}
