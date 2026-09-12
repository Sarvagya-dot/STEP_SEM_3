import java.util.Scanner;

public class CustomerIdentityVerification {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = userInputScanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        userInputScanner.close();
    }

    static String reverseCustomerName(String customerName) {
        char[] nameCharacters = customerName.toCharArray();
        StringBuilder reversedNameBuilder = new StringBuilder();

        for (int charIndex = nameCharacters.length - 1; charIndex >= 0; charIndex--) {
            reversedNameBuilder.append(nameCharacters[charIndex]);
        }

        return reversedNameBuilder.toString();
    }
}
