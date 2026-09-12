import java.util.Scanner;

public class ProductInventoryCSVParser {

    private static final int EXPECTED_FIELD_COUNT = 3;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter CSV line: ");
        String csvLine = userInputScanner.nextLine();

        parseInventoryRecord(csvLine);

        userInputScanner.close();
    }

    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != EXPECTED_FIELD_COUNT) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0];
        String sku = fields[1];
        String quantity = fields[2];

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }
}
