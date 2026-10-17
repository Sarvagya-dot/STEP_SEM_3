import java.util.Scanner;

public class EvenOddCounter {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

        int[] numbers = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            numbers[index] = Integer.parseInt(tokens[index]);
        }

        countEvenOdd(numbers);

        userInputScanner.close();
    }

    static void countEvenOdd(int[] numbers) {
        int evenCount = 0;
        int oddCount = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}
