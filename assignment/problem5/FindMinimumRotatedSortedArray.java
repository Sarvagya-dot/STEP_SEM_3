public class FindMinimumRotatedSortedArray {

    public static void main(String[] args) {
        int[] firstSample = {3, 4, 5, 1, 2};
        System.out.println(findMin(firstSample));

        int[] secondSample = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(secondSample));

        int[] thirdSample = {11, 13, 15, 17};
        System.out.println(findMin(thirdSample));
    }

    static int findMin(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (nums[middleIndex] > nums[rightIndex]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }

        return nums[leftIndex];
    }
}
