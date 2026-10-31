import java.util.Scanner;

public class DiceThrowTally {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] rolls = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            rolls[index] = Integer.parseInt(tokens[index]);
        }

        int[] sortedRolls = diceSort(rolls);
        System.out.println("Sorted: " + toText(sortedRolls));

        userInputScanner.close();
    }

    // Counting sort for values 1 to 6; no two throws are ever compared.
    // Time complexity: O(n + k) with k = 6, so O(n).
    // Space complexity: O(k + n) for the count array and the returned result.
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }

        StringBuilder countLine = new StringBuilder("Counts:");
        for (int face = 1; face <= 6; face++) {
            countLine.append(" ").append(face).append(":").append(count[face]);
        }
        System.out.println(countLine);

        int[] result = new int[rolls.length];
        int writeIndex = 0;
        for (int face = 1; face <= 6; face++) {
            for (int repeat = 0; repeat < count[face]; repeat++) {
                result[writeIndex++] = face;
            }
        }
        return result;
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
