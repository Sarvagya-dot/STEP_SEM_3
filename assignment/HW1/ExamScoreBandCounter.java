import java.util.Scanner;

public class ExamScoreBandCounter {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

        int[] scores = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            scores[index] = Integer.parseInt(tokens[index]);
        }

        int low = Integer.parseInt(userInputScanner.nextLine().trim());
        int high = Integer.parseInt(userInputScanner.nextLine().trim());

        System.out.println(countInBand(scores, low, high));

        userInputScanner.close();
    }

    // Time complexity: O(log n) per query — two binary searches over the sorted array.
    // Space complexity: O(1) additional space.
    // A linear scan would be O(n) time and O(1) space; with the array queried very
    // often, O(log n) per query is far better for large, repeatedly-queried data.
    static int countInBand(int[] scores, int low, int high) {
        int firstAtLeastLow = lowerBound(scores, low);
        int firstGreaterThanHigh = upperBound(scores, high);
        return firstGreaterThanHigh - firstAtLeastLow;
    }

    // Finds the first index whose value is >= target.
    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Finds the first index whose value is > target.
    private static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
