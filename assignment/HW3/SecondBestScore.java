import java.util.Scanner;

public class SecondBestScore {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

        int[] scores = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            scores[index] = Integer.parseInt(tokens[index]);
        }

        System.out.println(secondHighest(scores));

        userInputScanner.close();
    }

    // Time complexity: O(n) — a single pass over the array.
    // Space complexity: O(1) additional space.
    // Sorting first would cost O(n log n) time (and O(n) or O(log n) extra space,
    // depending on the sort), so tracking the top two values in one pass is faster
    // and uses less memory than sorting the whole array just to read off two values.
    static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
}
