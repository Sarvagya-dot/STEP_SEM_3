import java.util.Scanner;

public class InsertPositionSortedList {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] nums = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            nums[index] = Integer.parseInt(tokens[index]);
        }
        int target = Integer.parseInt(userInputScanner.nextLine().trim());

        System.out.println(searchInsertPosition(nums, target));

        userInputScanner.close();
    }

    // Binary search that returns the first index whose value is >= target.
    // That index is the match if present, or the insertion point otherwise.
    // Time complexity: O(log n). Space complexity: O(1).
    // Appropriate because the array is sorted and lookups are frequent: each one halves the
    // search range instead of scanning, which stays fast even for very large arrays.
    static int searchInsertPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
