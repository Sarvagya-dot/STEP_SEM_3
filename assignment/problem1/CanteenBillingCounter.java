import java.util.Scanner;

public class CanteenBillingCounter {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int billCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int billIndex = 0; billIndex < billCount; billIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String customerType = tokens[0];
            double billAmount = Double.parseDouble(tokens[1]);

            Customer customer = createCustomer(customerType);
            double finalAmount = customer.calculateFinalAmount(billAmount);

            System.out.printf("%s: %.2f%n", customerType, finalAmount);
            grandTotal += finalAmount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Customer createCustomer(String customerType) {
        switch (customerType) {
            case "STUDENT":
                return new StudentCustomer();
            case "STAFF":
                return new StaffCustomer();
            case "GUEST":
                return new GuestCustomer();
            default:
                throw new IllegalArgumentException("Unknown customer type: " + customerType);
        }
    }
}

abstract class Customer {
    abstract double calculateFinalAmount(double billAmount);
}

class StudentCustomer extends Customer {
    private static final double DISCOUNT_RATE = 0.10;

    double calculateFinalAmount(double billAmount) {
        return billAmount * (1 - DISCOUNT_RATE);
    }
}

class StaffCustomer extends Customer {
    private static final double DISCOUNT_RATE = 0.05;

    double calculateFinalAmount(double billAmount) {
        return billAmount * (1 - DISCOUNT_RATE);
    }
}

class GuestCustomer extends Customer {
    private static final double SERVICE_CHARGE = 10;

    double calculateFinalAmount(double billAmount) {
        return billAmount + SERVICE_CHARGE;
    }
}
