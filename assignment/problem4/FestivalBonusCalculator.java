import java.util.Scanner;

public class FestivalBonusCalculator {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int employeeCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int employeeIndex = 0; employeeIndex < employeeCount; employeeIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String employeeType = tokens[0];
            String employeeName = tokens[1];
            double monthlySalary = Double.parseDouble(tokens[2]);

            Employee employee = createEmployee(employeeType, employeeName, monthlySalary);
            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", employeeName, bonus);
            grandTotal += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Employee createEmployee(String employeeType, String name, double salary) {
        switch (employeeType) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new InternEmployee(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + employeeType);
        }
    }
}

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    private static final double BONUS_RATE = 0.10;

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * BONUS_RATE;
    }
}

class PartTimeEmployee extends Employee {
    private static final double BONUS_RATE = 0.05;

    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * BONUS_RATE;
    }
}

class InternEmployee extends Employee {
    private static final double FIXED_BONUS = 2000;

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return FIXED_BONUS;
    }
}
