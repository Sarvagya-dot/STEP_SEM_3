import java.util.Scanner;

public class DigitSumNumberReversal {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int number = Integer.parseInt(userInputScanner.nextLine().trim());

        int digitSum = calculateDigitSum(number);
        int reversedNumber = reverseDigits(number);

        System.out.println("Sum of digits: " + digitSum);
        System.out.println("Reverse: " + reversedNumber);

        userInputScanner.close();
    }

    static int calculateDigitSum(int number) {
        int sum = 0;
        int remaining = number;

        while (remaining > 0) {
            sum += remaining % 10;
            remaining /= 10;
        }

        return sum;
    }

    static int reverseDigits(int number) {
        int reversed = 0;
        int remaining = number;

        while (remaining > 0) {
            int lastDigit = remaining % 10;
            reversed = reversed * 10 + lastDigit;
            remaining /= 10;
        }

        return reversed;
    }
}
