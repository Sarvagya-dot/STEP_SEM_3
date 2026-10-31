import java.util.HashSet;
import java.util.Scanner;

public class PairWithTargetSum {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] nums = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            nums[index] = Integer.parseInt(tokens[index]);
        }
        int target = Integer.parseInt(userInputScanner.nextLine().trim());

        int[] pair = findPair(nums, target);
        if (pair == null) {
            System.out.println("false");
        } else {
            System.out.println("true (" + pair[0] + " + " + pair[1] + " = " + target + ")");
        }

        userInputScanner.close();
    }

    static boolean hasPairWithSum(int[] nums, int target) {
        return findPair(nums, target) != null;
    }

    // Approach 1 (used): hash set of complements.
    // Time complexity: O(n) average. Space complexity: O(n).
    // "Distinct elements" means two different positions, so duplicates like [3, 3] with
    // target 6 still count, because the first 3 is stored before the second is checked.
    static int[] findPair(int[] nums, int target) {
        HashSet<Integer> seenValues = new HashSet<>();

        for (int value : nums) {
            if (seenValues.contains(target - value)) {
                return new int[]{target - value, value};
            }
            seenValues.add(value);
        }

        return null;
    }

    // Approach 2: brute force over every pair of positions.
    // Time complexity: O(n^2). Space complexity: O(1).
    // Approach 3 (not coded): sort, then two pointers — O(n log n) time, O(1) extra space if
    // sorting in place. The hash set is fastest; brute force and sorting save memory.
    static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        for (int first = 0; first < nums.length; first++) {
            for (int second = first + 1; second < nums.length; second++) {
                if (nums[first] + nums[second] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
