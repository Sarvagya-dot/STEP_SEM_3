import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] firstArr = {1, 3, 5};
        int[] firstArr2 = {2, 4, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(firstArr, firstArr2)));

        int[] secondArr = {};
        int[] secondArr2 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(secondArr, secondArr2)));
    }

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedResult = new int[arr1.length + arr2.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int resultPointer = 0;

        while (firstPointer < arr1.length && secondPointer < arr2.length) {
            if (arr1[firstPointer] <= arr2[secondPointer]) {
                mergedResult[resultPointer] = arr1[firstPointer];
                firstPointer++;
            } else {
                mergedResult[resultPointer] = arr2[secondPointer];
                secondPointer++;
            }
            resultPointer++;
        }

        while (firstPointer < arr1.length) {
            mergedResult[resultPointer] = arr1[firstPointer];
            firstPointer++;
            resultPointer++;
        }

        while (secondPointer < arr2.length) {
            mergedResult[resultPointer] = arr2[secondPointer];
            secondPointer++;
            resultPointer++;
        }

        return mergedResult;
    }
}
