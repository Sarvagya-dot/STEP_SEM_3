public class MaximumSubarray {

    public static void main(String[] args) {
        int[] firstSample = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(firstSample));

        int[] secondSample = {-3, -1, -2};
        System.out.println(maxSubArray(secondSample));
    }

    static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int index = 1; index < nums.length; index++) {
            currentSum = Math.max(nums[index], currentSum + nums[index]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
