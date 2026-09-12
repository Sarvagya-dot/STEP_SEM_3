import java.util.Scanner;
import java.util.InputMismatchException;

public class DuplicateSeatChecker {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        int[] seatNumbers = readSeatNumbers(userInputScanner);
        checkDuplicateSeats(seatNumbers);

        userInputScanner.close();
    }

    private static int[] readSeatNumbers(Scanner userInputScanner) {
        int[] seatNumbers = new int[0];

        try {
            System.out.print("Enter the number of seat entries:\t");
            int totalSeats = userInputScanner.nextInt();
            seatNumbers = new int[totalSeats];

            System.out.println("Enter " + totalSeats + " seat numbers one by one:");
            for (int seatIndex = 0; seatIndex < totalSeats; seatIndex++) {
                System.out.print("Seat[" + seatIndex + "]: ");
                seatNumbers[seatIndex] = userInputScanner.nextInt();
            }
        } catch (InputMismatchException invalidInputException) {
            System.out.println("Invalid input detected. Please enter whole numbers only.");
            seatNumbers = new int[0];
        }

        return seatNumbers;
    }

    private static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int firstIndex = 0; firstIndex < seatNumbers.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < seatNumbers.length; secondIndex++) {
                if (seatNumbers[firstIndex] == seatNumbers[secondIndex]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[firstIndex]);
                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound && seatNumbers.length > 0) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
