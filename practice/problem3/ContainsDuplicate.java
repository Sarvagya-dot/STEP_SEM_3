public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] firstSample = {1, 2, 3, 1};
        System.out.println(containsDuplicate(firstSample));

        int[] secondSample = {1, 2, 3, 4};
        System.out.println(containsDuplicate(secondSample));
    }

    static boolean containsDuplicate(int[] nums) {
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
                if (nums[firstIndex] == nums[secondIndex]) {
                    return true;
                }
            }
        }
        return false;
    }
}
