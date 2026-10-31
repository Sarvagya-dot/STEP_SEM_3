import java.util.Scanner;

public class QueueInOrder {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String line = userInputScanner.hasNextLine() ? userInputScanner.nextLine().trim() : "";

        int[] tokens;
        if (line.isEmpty()) {
            tokens = new int[0];
        } else {
            String[] parts = line.split("\\s+");
            tokens = new int[parts.length];
            for (int index = 0; index < parts.length; index++) {
                tokens[index] = Integer.parseInt(parts[index]);
            }
        }

        System.out.println(firstBreak(tokens));

        userInputScanner.close();
    }

    // Single pass comparing each token with the one just before it.
    // Equal neighbours are allowed, so only a strictly smaller token is a break.
    // Time complexity: O(n). Space complexity: O(1).
    static int firstBreak(int[] tokens) {
        for (int position = 1; position < tokens.length; position++) {
            if (tokens[position] < tokens[position - 1]) {
                return position;
            }
        }
        return -1;
    }
}
