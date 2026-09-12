import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] firstSample = {-1, 0, 1, 2, -1, -4};
        printTriplets(threeSum(firstSample));

        int[] secondSample = {0, 0, 0};
        printTriplets(threeSum(secondSample));
    }

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();
        int elementCount = nums.length;

        for (int firstIndex = 0; firstIndex < elementCount - 2; firstIndex++) {
            if (firstIndex > 0 && nums[firstIndex] == nums[firstIndex - 1]) {
                continue;
            }

            int leftPointer = firstIndex + 1;
            int rightPointer = elementCount - 1;

            while (leftPointer < rightPointer) {
                int currentSum = nums[firstIndex] + nums[leftPointer] + nums[rightPointer];

                if (currentSum == 0) {
                    triplets.add(new int[]{nums[firstIndex], nums[leftPointer], nums[rightPointer]});

                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++;
                    }
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--;
                    }

                    leftPointer++;
                    rightPointer--;
                } else if (currentSum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return triplets.toArray(new int[0][]);
    }

    private static void printTriplets(int[][] triplets) {
        StringBuilder outputBuilder = new StringBuilder("[");
        for (int tripletIndex = 0; tripletIndex < triplets.length; tripletIndex++) {
            outputBuilder.append(Arrays.toString(triplets[tripletIndex]));
            if (tripletIndex < triplets.length - 1) {
                outputBuilder.append(", ");
            }
        }
        outputBuilder.append("]");
        System.out.println(outputBuilder.toString());
    }
}
