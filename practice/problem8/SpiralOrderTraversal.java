import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrderTraversal {

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

        System.out.println(spiralOrder(grid));

        userInputScanner.close();
    }

    // Time complexity: O(m * n) — each element is collected exactly once.
    // Space complexity: O(m * n) for the output list, O(1) additional space beyond it.
    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0 || grid[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                result.add(grid[top][col]);
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                result.add(grid[row][right]);
            }
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(grid[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(grid[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}
