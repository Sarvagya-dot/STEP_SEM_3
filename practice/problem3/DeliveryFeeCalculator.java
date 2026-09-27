import java.util.Scanner;

public class DeliveryFeeCalculator {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int deliveryCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int deliveryIndex = 0; deliveryIndex < deliveryCount; deliveryIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

            Delivery delivery = createDelivery(tokens);
            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n", tokens[0], fee);
            grandTotal += fee;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Delivery createDelivery(String[] tokens) {
        String deliveryType = tokens[0];
        double weight = Double.parseDouble(tokens[1]);
        double distance = Double.parseDouble(tokens[2]);

        switch (deliveryType) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                double customsFee = Double.parseDouble(tokens[3]);
                return new InternationalDelivery(weight, distance, customsFee);
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + deliveryType);
        }
    }
}

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    private static final double BASE_FEE = 5;
    private static final double RATE_PER_KG = 0.50;
    private static final double RATE_PER_KM = 0.10;

    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return BASE_FEE + weight * RATE_PER_KG + distance * RATE_PER_KM;
    }
}

class ExpressDelivery extends Delivery {
    private static final double BASE_FEE = 15;
    private static final double RATE_PER_KG = 1.00;
    private static final double RATE_PER_KM = 0.20;

    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return BASE_FEE + weight * RATE_PER_KG + distance * RATE_PER_KM;
    }
}

class InternationalDelivery extends Delivery {
    private static final double BASE_FEE = 25;
    private static final double RATE_PER_KG = 2.00;
    private static final double RATE_PER_KM = 0.50;
    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return BASE_FEE + weight * RATE_PER_KG + distance * RATE_PER_KM + customsFee;
    }
}
