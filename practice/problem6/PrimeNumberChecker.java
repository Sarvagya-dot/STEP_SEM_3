import java.util.Scanner;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int numberCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int numberIndex = 0; numberIndex < numberCount; numberIndex++) {
            int number = Integer.parseInt(userInputScanner.nextLine().trim());
            boolean prime = isPrime(number);
            System.out.println(number + " is " + (prime ? "prime" : "not prime"));
        }

        userInputScanner.close();
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}
