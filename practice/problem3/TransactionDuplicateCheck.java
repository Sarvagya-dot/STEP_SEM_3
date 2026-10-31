import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TransactionDuplicateCheck {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String line = userInputScanner.hasNextLine() ? userInputScanner.nextLine().trim() : "";
        String[] transactionIds = line.isEmpty() ? new String[0] : line.split("\\s+");

        System.out.println(hasDuplicate(transactionIds));

        userInputScanner.close();
    }

    // Chosen approach: HashSet of IDs seen so far.
    // Time complexity: O(n) average (each add/contains is O(1) on average).
    // Space complexity: O(n) for the set.
    // Runtime is the priority for millions of nightly transactions, so memory is traded for speed.
    static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seenIds = new HashSet<>();

        for (String transactionId : transactionIds) {
            if (!seenIds.add(transactionId)) {
                return true;
            }
        }

        return false;
    }

    // Alternative: sort a copy, then compare neighbours.
    // Time complexity: O(n log n). Space complexity: O(n) for the copy, or O(1) if the input
    // may be sorted in place. A nested-loop check needs O(1) space but costs O(n^2) time.
    // Trade-off: far less (or no) extra memory, but noticeably slower at millions of records.
    static boolean hasDuplicateBySorting(String[] transactionIds) {
        String[] sortedIds = transactionIds.clone();
        Arrays.sort(sortedIds);

        for (int index = 1; index < sortedIds.length; index++) {
            if (sortedIds[index].equals(sortedIds[index - 1])) {
                return true;
            }
        }

        return false;
    }
}
