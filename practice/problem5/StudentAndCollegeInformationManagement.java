public class StudentAndCollegeInformationManagement {

    public static void main(String[] args) {
        Student firstStudent = new Student("Ravi", 92.5);
        Student secondStudent = new Student("Anitha", 88.0);

        Student.printCollegeInfo();
    }
}

class Student {
    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}
