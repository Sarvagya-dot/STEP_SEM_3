import java.util.Scanner;

public class PrizeTable {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] marks = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            marks[index] = Integer.parseInt(tokens[index]);
        }

        int swapCount = prizeTable(marks);
        System.out.println(toText(marks) + "     swaps = " + swapCount);

        userInputScanner.close();
    }

    // Selection sort (descending). A swap is counted only when the largest mark
    // is not already sitting in the position being filled.
    // Time complexity: O(n^2) comparisons; at most n - 1 swaps.
    // Space complexity: O(1) additional space.
    static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int position = 0; position < marks.length - 1; position++) {
            int largestIndex = position;

            for (int scan = position + 1; scan < marks.length; scan++) {
                if (marks[scan] > marks[largestIndex]) {
                    largestIndex = scan;
                }
            }

            if (largestIndex != position) {
                int temp = marks[position];
                marks[position] = marks[largestIndex];
                marks[largestIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    static String toText(int[] values) {
        StringBuilder text = new StringBuilder("[");
        for (int index = 0; index < values.length; index++) {
            if (index > 0) {
                text.append(", ");
            }
            text.append(values[index]);
        }
        return text.append("]").toString();
    }
}
