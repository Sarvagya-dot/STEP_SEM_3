import java.util.Scanner;

public class PublicTransportFareCalculator {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int journeyCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int journeyIndex = 0; journeyIndex < journeyCount; journeyIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

            Transport transport = createTransport(tokens);
            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", tokens[0], fare);
            grandTotal += fare;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Transport createTransport(String[] tokens) {
        String transportType = tokens[0];
        double distance = Double.parseDouble(tokens[1]);

        switch (transportType) {
            case "BUS":
                return new BusTransport(distance);
            case "TRAIN":
                return new TrainTransport(distance);
            case "METRO":
                double peakHourFactor = Double.parseDouble(tokens[2]);
                return new MetroTransport(distance, peakHourFactor);
            default:
                throw new IllegalArgumentException("Unknown transport type: " + transportType);
        }
    }
}

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class BusTransport extends Transport {
    private static final double BASE_FARE = 2;
    private static final double RATE_PER_KM = 0.10;
    private static final double MAX_FARE = 10;

    BusTransport(double distance) {
        super(distance);
    }

    double calculateFare() {
        double fare = BASE_FARE + distance * RATE_PER_KM;
        return Math.min(fare, MAX_FARE);
    }
}

class TrainTransport extends Transport {
    private static final double BASE_FARE = 3;
    private static final double RATE_PER_KM = 0.15;

    TrainTransport(double distance) {
        super(distance);
    }

    double calculateFare() {
        return BASE_FARE + distance * RATE_PER_KM;
    }
}

class MetroTransport extends Transport {
    private static final double BASE_FARE = 1.50;
    private static final double RATE_PER_KM = 0.20;
    private double peakHourFactor;

    MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (BASE_FARE + distance * RATE_PER_KM) * peakHourFactor;
    }
}
