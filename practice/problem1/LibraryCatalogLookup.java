import java.util.Scanner;

public class LibraryCatalogLookup {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int bookCount = Integer.parseInt(userInputScanner.nextLine().trim());

        String[][] catalog = new String[bookCount][2];
        for (int bookIndex = 0; bookIndex < bookCount; bookIndex++) {
            String[] parts = userInputScanner.nextLine().trim().split("\\s+", 2);
            catalog[bookIndex][0] = parts[0];
            catalog[bookIndex][1] = parts[1];
        }

        int queryCount = Integer.parseInt(userInputScanner.nextLine().trim());
        for (int query = 0; query < queryCount; query++) {
            String targetIsbn = userInputScanner.nextLine().trim();
            System.out.println("\"" + findBook(catalog, targetIsbn) + "\"");
        }

        userInputScanner.close();
    }

    // Binary search on the ISBN-sorted catalog.
    // Time complexity: O(log n). Space complexity: O(1) (iterative, no extra structures).
    // Why it fits: queries vastly outnumber updates, so the catalog stays sorted at almost no
    // cost, and every lookup pays only log n comparisons instead of the n of a linear scan.
    static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = compareIsbn(catalog[mid][0], targetIsbn);

            if (comparison == 0) {
                return catalog[mid][1];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    // Numeric-string comparison: shorter string is smaller, otherwise compare lexicographically.
    private static int compareIsbn(String first, String second) {
        if (first.length() != second.length()) {
            return first.length() - second.length();
        }
        return first.compareTo(second);
    }
}
