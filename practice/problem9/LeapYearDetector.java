import java.util.Scanner;

public class LeapYearDetector {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int yearCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int yearIndex = 0; yearIndex < yearCount; yearIndex++) {
            int year = Integer.parseInt(userInputScanner.nextLine().trim());
            System.out.println(isLeapYear(year) ? "Leap year" : "Not a leap year");
        }

        userInputScanner.close();
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
