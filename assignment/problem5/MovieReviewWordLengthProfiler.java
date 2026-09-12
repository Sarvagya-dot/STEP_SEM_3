import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    private static final int SHORT_WORD_MAX_LENGTH = 4;
    private static final int MEDIUM_WORD_MAX_LENGTH = 8;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.print("Enter a movie review: ");
        String review = userInputScanner.nextLine();

        try {
            classifyWordLengths(review);
        } catch (EmptyReviewException emptyReviewException) {
            System.out.println("Error: " + emptyReviewException.getMessage());
        }

        userInputScanner.close();
    }

    private static void classifyWordLengths(String review) throws EmptyReviewException {
        String trimmedReview = (review == null) ? "" : review.trim();

        if (trimmedReview.isEmpty()) {
            throw new EmptyReviewException("Review text cannot be empty.");
        }

        String[] words = trimmedReview.split("\\s+");

        int shortWordCount = 0;
        int mediumWordCount = 0;
        int longWordCount = 0;

        for (String word : words) {
            int wordLength = word.length();

            if (wordLength <= SHORT_WORD_MAX_LENGTH) {
                shortWordCount++;
            } else if (wordLength <= MEDIUM_WORD_MAX_LENGTH) {
                mediumWordCount++;
            } else {
                longWordCount++;
            }
        }

        System.out.println("Short: " + shortWordCount + " | Medium: " + mediumWordCount + " | Long: " + longWordCount);
    }
}

class EmptyReviewException extends Exception {
    public EmptyReviewException(String message) {
        super(message);
    }
}
