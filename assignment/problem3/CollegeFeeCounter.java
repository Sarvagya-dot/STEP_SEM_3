import java.util.Scanner;

public class CollegeFeeCounter {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double totalCollected = 0;

        for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String studentType = tokens[0];
            String name = tokens[1];

            Student student = createStudent(studentType, name);

            double fee = student.calculateTuition();
            if (student instanceof UsesBus) {
                fee += ((UsesBus) student).getTransportFee();
            }

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        userInputScanner.close();
    }

    private static Student createStudent(String studentType, String name) {
        switch (studentType) {
            case "DAY_SCHOLAR":
                return new DayScholarStudent(name);
            case "HOSTELLER":
                return new HostellerStudent(name);
            case "SCHOLAR":
                return new ScholarshipStudent(name);
            default:
                throw new IllegalArgumentException("Unknown student type: " + studentType);
        }
    }
}

interface UsesBus {
    double TRANSPORT_FEE = 12000;

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();
}

class DayScholarStudent extends Student implements UsesBus {
    private static final double TUITION = 40000;

    DayScholarStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return TUITION;
    }
}

class HostellerStudent extends Student {
    private static final double TUITION = 40000;
    private static final double HOSTEL_FEE = 60000;

    HostellerStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return TUITION + HOSTEL_FEE;
    }
}

class ScholarshipStudent extends Student implements UsesBus {
    private static final double TUITION = 20000;

    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return TUITION;
    }
}
