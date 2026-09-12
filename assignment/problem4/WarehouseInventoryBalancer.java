import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        try {
            int[] sectionA = readSectionQuantities(userInputScanner, "Section A");
            int[] sectionB = readSectionQuantities(userInputScanner, "Section B");
            analyzeInventory(sectionA, sectionB);
        } catch (ArraySizeMismatchException sizeMismatchException) {
            System.out.println("Error: " + sizeMismatchException.getMessage());
        }

        userInputScanner.close();
    }

    private static int[] readSectionQuantities(Scanner userInputScanner, String sectionName) {
        System.out.print("Enter number of items in " + sectionName + ": ");
        int itemCount = userInputScanner.nextInt();
        int[] quantities = new int[itemCount];

        for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
            System.out.print(sectionName + " Item " + (itemIndex + 1) + " quantity: ");
            quantities[itemIndex] = userInputScanner.nextInt();
        }
        return quantities;
    }

    private static void analyzeInventory(int[] sectionA, int[] sectionB) throws ArraySizeMismatchException {
        if (sectionA.length != sectionB.length) {
            throw new ArraySizeMismatchException("Section A and Section B must have the same number of items.");
        }

        int sectionATotal = calculateTotalQuantity(sectionA);
        int sectionBTotal = calculateTotalQuantity(sectionB);
        String balanceStatus = (sectionATotal == sectionBTotal) ? "Balanced" : "Not Balanced";

        int highestQuantity = sectionA[0];
        String highestSectionName = "Section A";
        int highestItemNumber = 1;

        for (int itemIndex = 0; itemIndex < sectionA.length; itemIndex++) {
            if (sectionA[itemIndex] > highestQuantity) {
                highestQuantity = sectionA[itemIndex];
                highestSectionName = "Section A";
                highestItemNumber = itemIndex + 1;
            }
            if (sectionB[itemIndex] > highestQuantity) {
                highestQuantity = sectionB[itemIndex];
                highestSectionName = "Section B";
                highestItemNumber = itemIndex + 1;
            }
        }

        System.out.println("Section A Total: " + sectionATotal + " | Section B Total: " + sectionBTotal
                + " | Status: " + balanceStatus + " | Highest Quantity: " + highestQuantity
                + " (" + highestSectionName + ", Item " + highestItemNumber + ")");
    }

    private static int calculateTotalQuantity(int[] sectionQuantities) {
        int total = 0;
        for (int quantity : sectionQuantities) {
            total += quantity;
        }
        return total;
    }
}

class ArraySizeMismatchException extends Exception {
    public ArraySizeMismatchException(String message) {
        super(message);
    }
}
