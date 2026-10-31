import java.util.Scanner;

public class WarehouseBinGridScan {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int rowCount = userInputScanner.nextInt();
        int colCount = userInputScanner.nextInt();

        int[][] grid = new int[rowCount][colCount];
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            for (int colIndex = 0; colIndex < colCount; colIndex++) {
                grid[rowIndex][colIndex] = userInputScanner.nextInt();
            }
        }

        int[] summary = warehouseSummary(grid);
        System.out.println("total = " + summary[0] + ", maxCoordinate = (" + summary[1] + ", " + summary[2] + ")");

        userInputScanner.close();
    }

    // Time complexity: O(m * n) — every bin is visited exactly once.
    // Space complexity: O(1) additional space (a few counters, plus the 3-element result).
    // Strict '>' keeps the first maximum found scanning row by row, left to right.
    static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxValue = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
                int items = grid[rowIndex][colIndex];
                total += items;

                if (items > maxValue) {
                    maxValue = items;
                    maxRow = rowIndex;
                    maxCol = colIndex;
                }
            }
        }

        return new int[]{total, maxRow, maxCol};
    }
}
