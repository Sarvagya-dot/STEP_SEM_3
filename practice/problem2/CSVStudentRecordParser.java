import java.util.Scanner;

public class CSVStudentRecordParser {

    private static final int EXPECTED_FIELD_COUNT = 3;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter CSV line: ");
        String csvLine = userInputScanner.nextLine();

        parseStudentRecord(csvLine);

        userInputScanner.close();
    }

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != EXPECTED_FIELD_COUNT) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0];
        String rollNumber = fields[1];
        String department = fields[2];

        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }
}
