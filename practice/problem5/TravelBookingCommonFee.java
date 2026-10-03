import java.util.Scanner;

public class TravelBookingCommonFee {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int bookingCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int bookingIndex = 0; bookingIndex < bookingCount; bookingIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String mode = tokens[0];
            double distanceKm = Double.parseDouble(tokens[1]);

            Booking booking = createBooking(mode, distanceKm);

            System.out.printf("%s: %.2f%n", mode, booking.calculateTotal());
        }

        userInputScanner.close();
    }

    private static Booking createBooking(String mode, double distanceKm) {
        switch (mode) {
            case "BUS":
                return new BusBooking(distanceKm);
            case "TRAIN":
                return new TrainBooking(distanceKm);
            case "FLIGHT":
                return new FlightBooking(distanceKm);
            default:
                throw new IllegalArgumentException("Unknown travel mode: " + mode);
        }
    }
}

abstract class Booking {
    private static final double BOOKING_FEE = 50;

    protected double distanceKm;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    private static final double RATE_PER_KM = 2;

    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return distanceKm * RATE_PER_KM;
    }
}

class TrainBooking extends Booking {
    private static final double RATE_PER_KM = 1.5;

    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return distanceKm * RATE_PER_KM;
    }
}

class FlightBooking extends Booking {
    private static final double BASE_FARE = 2500;
    private static final double RATE_PER_KM = 4;

    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateBaseFare() {
        return BASE_FARE + distanceKm * RATE_PER_KM;
    }
}
