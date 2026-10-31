import java.util.Scanner;

public class HeightLineUp {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] heights = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            heights[index] = Integer.parseInt(tokens[index]);
        }

        lineUp(heights);

        userInputScanner.close();
    }

    // Bubble sort with an early-exit flag.
    // Time complexity: O(n^2) worst case, O(n) when the line is already in order.
    // Space complexity: O(1) additional space.
    static void lineUp(int[] heights) {
        int studentCount = heights.length;

        for (int sweep = 1; sweep <= studentCount - 1; sweep++) {
            boolean swapped = false;

            for (int position = 0; position < studentCount - sweep; position++) {
                if (heights[position] > heights[position + 1]) {
                    int temp = heights[position];
                    heights[position] = heights[position + 1];
                    heights[position + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + sweep + ": " + toText(heights));

            if (!swapped) {
                break;
            }
        }
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
