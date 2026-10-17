import java.util.Scanner;

public class FactorialCalculation {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int valueCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int valueIndex = 0; valueIndex < valueCount; valueIndex++) {
            int number = Integer.parseInt(userInputScanner.nextLine().trim());
            System.out.println(calculateFactorial(number));
        }

        userInputScanner.close();
    }

    static long calculateFactorial(int number) {
        long factorial = 1;
        for (int multiplier = 2; multiplier <= number; multiplier++) {
            factorial *= multiplier;
        }
        return factorial;
    }
}
