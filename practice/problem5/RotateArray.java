import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] firstSample = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(firstSample, 3)));

        int[] secondSample = {1, 2};
        System.out.println(Arrays.toString(rotateArray(secondSample, 3)));
    }

    static int[] rotateArray(int[] nums, int k) {
        int arrayLength = nums.length;
        int effectiveShift = k % arrayLength;
        int[] rotatedArray = new int[arrayLength];

        for (int index = 0; index < arrayLength; index++) {
            int newPosition = (index + effectiveShift) % arrayLength;
            rotatedArray[newPosition] = nums[index];
        }

        return rotatedArray;
    }
}
