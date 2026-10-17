import java.util.Scanner;

public class InPlaceArrayReversal {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

        int[] numbers = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            numbers[index] = Integer.parseInt(tokens[index]);
        }

        reverseInPlace(numbers);
        printArray(numbers);

        userInputScanner.close();
    }

    static void reverseInPlace(int[] numbers) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int temp = numbers[leftIndex];
            numbers[leftIndex] = numbers[rightIndex];
            numbers[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }

    private static void printArray(int[] numbers) {
        StringBuilder resultBuilder = new StringBuilder("[");
        for (int index = 0; index < numbers.length; index++) {
            resultBuilder.append(numbers[index]);
            if (index < numbers.length - 1) {
                resultBuilder.append(", ");
            }
        }
        resultBuilder.append("]");
        System.out.println(resultBuilder.toString());
    }
}
