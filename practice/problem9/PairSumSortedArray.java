import java.util.Scanner;

public class PairSumSortedArray {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] nums = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            nums[index] = Integer.parseInt(tokens[index]);
        }
        int target = Integer.parseInt(userInputScanner.nextLine().trim());

        int[] pair = pairSumSorted(nums, target);
        if (pair == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }

        userInputScanner.close();
    }

    // Two pointers: move the left pointer up when the sum is too small, the right pointer down
    // when it is too large.
    // Time complexity: O(n). Space complexity: O(1).
    // A solution that ignores the sorted order needs O(n^2) time with nested loops (O(1) space),
    // or O(n) time with a hash set but O(n) space. Two pointers gets O(n) time and O(1) space.
    static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
