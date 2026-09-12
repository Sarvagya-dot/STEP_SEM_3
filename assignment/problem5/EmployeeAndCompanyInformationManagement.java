public class EmployeeAndCompanyInformationManagement {

    public static void main(String[] args) {
        Employee firstEmployee = new Employee("Divya", 65000);
        Employee secondEmployee = new Employee("Arjun", 40000);
        Employee thirdEmployee = new Employee("Ravi", 45000);

        Employee.printCompanyInfo();
    }
}

class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
