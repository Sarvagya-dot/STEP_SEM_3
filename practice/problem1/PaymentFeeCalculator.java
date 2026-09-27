import java.util.Scanner;

public class PaymentFeeCalculator {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int transactionCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int transactionIndex = 0; transactionIndex < transactionCount; transactionIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String paymentType = tokens[0];
            double amount = Double.parseDouble(tokens[1]);

            Payment payment = createPayment(paymentType);
            double adjustedAmount = payment.calculateAdjustedAmount(amount);

            System.out.printf("%s: %.2f%n", paymentType, adjustedAmount);
            grandTotal += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Payment createPayment(String paymentType) {
        switch (paymentType) {
            case "CARD":
                return new CardPayment();
            case "WALLET":
                return new WalletPayment();
            case "BANKTRANSFER":
                return new BankTransferPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
    }
}

abstract class Payment {
    abstract double calculateAdjustedAmount(double amount);
}

class CardPayment extends Payment {
    private static final double FEE_RATE = 0.02;

    double calculateAdjustedAmount(double amount) {
        return amount * (1 + FEE_RATE);
    }
}

class WalletPayment extends Payment {
    private static final double FEE_RATE = 0.01;

    double calculateAdjustedAmount(double amount) {
        return amount * (1 + FEE_RATE);
    }
}

class BankTransferPayment extends Payment {
    double calculateAdjustedAmount(double amount) {
        return amount;
    }
}
