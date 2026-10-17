import java.util.Scanner;

public class DutyRosterRotation {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] names = userInputScanner.nextLine().trim().split("\\s+");
        long k = Long.parseLong(userInputScanner.nextLine().trim());

        String[] rotated = rotateRoster(names, k);
        printArray(rotated);

        userInputScanner.close();
    }

    // Time complexity: O(n) — each name is placed into its new position exactly once.
    // Space complexity: O(n) — a new array of the same size holds the rotated result.
    // Rotating one place at a time, k times, costs O(n * k) time in total, since each
    // single-place rotation is itself an O(n) shift; when k can be as large as 10^9,
    // that is far too slow. Reducing k modulo n first removes all "full laps" (which
    // return the roster to its original order and do nothing useful), leaving at most
    // n-1 effective rotations — and placing every name directly at its final index in
    // one O(n) pass avoids repeated shifting entirely.
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int effectiveShift = (int) (k % n);
        String[] rotated = new String[n];

        for (int index = 0; index < n; index++) {
            int newPosition = (index + effectiveShift) % n;
            rotated[newPosition] = names[index];
        }

        return rotated;
    }

    private static void printArray(String[] names) {
        StringBuilder resultBuilder = new StringBuilder("[");
        for (int index = 0; index < names.length; index++) {
            resultBuilder.append(names[index]);
            if (index < names.length - 1) {
                resultBuilder.append(", ");
            }
        }
        resultBuilder.append("]");
        System.out.println(resultBuilder.toString());
    }
}
