import java.util.Scanner;

public class BusiestBusRow {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int rowCount = Integer.parseInt(userInputScanner.nextLine().trim());

        int[][] grid = new int[rowCount][];
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            int[] row = new int[tokens.length];
            for (int colIndex = 0; colIndex < tokens.length; colIndex++) {
                row[colIndex] = Integer.parseInt(tokens[colIndex]);
            }
            grid[rowIndex] = row;
        }

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);

        userInputScanner.close();
    }

    // Time complexity: O(r * c) — every seat in the grid is visited exactly once.
    // Space complexity: O(1) additional space (beyond the input grid and the returned pair).
    static int[] busiestRow(int[][] grid) {
        int bestRowIndex = 0;
        int bestRowTotal = Integer.MIN_VALUE;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            int rowTotal = 0;
            for (int seatCount : grid[rowIndex]) {
                rowTotal += seatCount;
            }

            if (rowTotal > bestRowTotal) {
                bestRowTotal = rowTotal;
                bestRowIndex = rowIndex;
            }
        }

        return new int[]{bestRowIndex, bestRowTotal};
    }
}
