import java.util.Scanner;

public class WeeklyStaffPay {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int staffCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double totalPayroll = 0;

        for (int staffIndex = 0; staffIndex < staffCount; staffIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

            StaffMember staffMember = createStaffMember(tokens);
            double pay = staffMember.calculatePay();

            System.out.printf("%s: %.2f%n", staffMember.getName(), pay);
            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        userInputScanner.close();
    }

    private static StaffMember createStaffMember(String[] tokens) {
        String staffType = tokens[0];
        String name = tokens[1];

        switch (staffType) {
            case "FULLTIME":
                return new FullTimeStaff(name, Double.parseDouble(tokens[2]));
            case "HOURLY":
                return new HourlyStaff(name, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            case "INTERN":
                return new InternStaff(name, Double.parseDouble(tokens[2]));
            default:
                throw new IllegalArgumentException("Unknown staff type: " + staffType);
        }
    }
}

abstract class StaffMember {
    protected String name;

    StaffMember(String name) {
        this.name = name;
    }

    abstract double calculatePay();

    String getName() {
        return name;
    }
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private static final double REGULAR_HOURS_LIMIT = 40;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    private double hours;
    private double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= REGULAR_HOURS_LIMIT) {
            return hours * rate;
        }
        double overtimeHours = hours - REGULAR_HOURS_LIMIT;
        return REGULAR_HOURS_LIMIT * rate + overtimeHours * rate * OVERTIME_MULTIPLIER;
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}
