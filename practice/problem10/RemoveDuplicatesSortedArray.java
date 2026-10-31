import java.util.Scanner;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String line = userInputScanner.hasNextLine() ? userInputScanner.nextLine().trim() : "";

        int[] nums;
        if (line.isEmpty()) {
            nums = new int[0];
        } else {
            String[] tokens = line.split("\\s+");
            nums = new int[tokens.length];
            for (int index = 0; index < tokens.length; index++) {
                nums[index] = Integer.parseInt(tokens[index]);
            }
        }

        int length = removeDuplicates(nums);

        StringBuilder uniqueValues = new StringBuilder("[");
        for (int index = 0; index < length; index++) {
            if (index > 0) {
                uniqueValues.append(", ");
            }
            uniqueValues.append(nums[index]);
        }
        uniqueValues.append("]");

        System.out.println("length = " + length);
        System.out.println("nums[0.." + (length - 1) + "] = " + uniqueValues);

        userInputScanner.close();
    }

    // Two pointers: 'reader' scans every element, 'writer' marks where the next unique value goes.
    // Time complexity: O(n). Space complexity: O(1).
    // It is in-place because it only overwrites the input array using two integer indices; no
    // second array that grows with the input is allocated.
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int writer = 1;
        for (int reader = 1; reader < nums.length; reader++) {
            if (nums[reader] != nums[writer - 1]) {
                nums[writer] = nums[reader];
                writer++;
            }
        }

        return writer;
    }
}
