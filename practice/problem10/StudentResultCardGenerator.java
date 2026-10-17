import java.util.Scanner;

public class StudentResultCardGenerator {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int studentIndex = 0; studentIndex < studentCount; studentIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String name = tokens[0];
            int[] marks = new int[3];
            marks[0] = Integer.parseInt(tokens[1]);
            marks[1] = Integer.parseInt(tokens[2]);
            marks[2] = Integer.parseInt(tokens[3]);

            Student student = new Student(name, marks);
            System.out.println(student.getResultCard());
        }

        userInputScanner.close();
    }
}

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    String assignGrade(double average) {
        if (average >= 75) {
            return "B";
        } else if (average >= 40 && average <= 59) {
            return "D";
        } else if (average >= 60) {
            return "C";
        } else {
            return "F";
        }
    }

    String getResultCard() {
        double average = calculateAverage();
        String grade = assignGrade(average);
        return name.toUpperCase() + ": Average " + String.format("%.1f", average) + ", Grade " + grade;
    }
}
