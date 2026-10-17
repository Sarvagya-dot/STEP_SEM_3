import java.util.Scanner;

public class StudentGradeAssignment {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {
            int marks = Integer.parseInt(userInputScanner.nextLine().trim());
            System.out.println("Grade " + assignGrade(marks));
        }

        userInputScanner.close();
    }

    static char assignGrade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
