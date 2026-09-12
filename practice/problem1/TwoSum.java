import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] firstSample = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(firstSample, 9)));

        int[] secondSample = {3, 2, 4};
        System.out.println(Arrays.toString(twoSum(secondSample, 6)));
    }

    static int[] twoSum(int[] nums, int target) {
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                if (nums[firstIndex] + nums[secondIndex] == target) {
                    return new int[]{firstIndex, secondIndex};
                }
            }
        }
        return new int[0];
    }
}
