import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] firstSample = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(firstSample)));

        int[] secondSample = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(secondSample)));
    }

    static int[] productExceptSelf(int[] nums) {
        int elementCount = nums.length;
        int[] answer = new int[elementCount];

        answer[0] = 1;
        for (int index = 1; index < elementCount; index++) {
            answer[index] = answer[index - 1] * nums[index - 1];
        }

        int runningRightProduct = 1;
        for (int index = elementCount - 1; index >= 0; index--) {
            answer[index] = answer[index] * runningRightProduct;
            runningRightProduct = runningRightProduct * nums[index];
        }

        return answer;
    }
}
