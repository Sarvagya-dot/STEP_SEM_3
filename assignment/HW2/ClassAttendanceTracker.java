import java.util.Scanner;

public class ClassAttendanceTracker {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

        int[] days = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            days[index] = Integer.parseInt(tokens[index]);
        }

        int[] summary = attendanceSummary(days);
        System.out.println("Present: " + summary[0] + ", Longest streak: " + summary[1]);

        userInputScanner.close();
    }

    // Time complexity: O(n) — a single pass over the array.
    // Space complexity: O(1) additional space (beyond the input and the returned pair).
    // Yes — both the present-day count and the longest streak are found in one pass:
    // a running total increments on every 1, and a running streak grows on every 1
    // and resets on every 0, updating the best-streak-so-far as it goes.
    static int[] attendanceSummary(int[] days) {
        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{presentCount, longestStreak};
    }
}
