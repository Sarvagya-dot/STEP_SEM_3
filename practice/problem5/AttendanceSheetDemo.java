public class AttendanceSheetDemo {

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}

class AttendanceSheet {
    private String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (isPresent(studentName)) {
            return;
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = studentName;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String studentName) {
        for (int index = 0; index < presentCount; index++) {
            if (presentStudents[index].equals(studentName)) {
                return true;
            }
        }
        return false;
    }
}
