import java.util.Scanner;

public class LibraryBookShelf {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
        int[] books = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            books[index] = Integer.parseInt(tokens[index]);
        }

        shelf(books);

        userInputScanner.close();
    }

    // Insertion sort: each new book slides left into its correct place.
    // Time complexity: O(n^2) worst case, O(n) when the shelf is already ordered.
    // Space complexity: O(1) additional space.
    static void shelf(int[] books) {
        for (int bookIndex = 1; bookIndex < books.length; bookIndex++) {
            int newBook = books[bookIndex];
            int gap = bookIndex - 1;

            while (gap >= 0 && books[gap] > newBook) {
                books[gap + 1] = books[gap];
                gap--;
            }
            books[gap + 1] = newBook;

            System.out.println("After placing " + newBook + ": " + toText(books));
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
