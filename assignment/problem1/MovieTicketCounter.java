import java.util.Scanner;

public class MovieTicketCounter {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int bookingCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int bookingIndex = 0; bookingIndex < bookingCount; bookingIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String seatType = tokens[0];
            int count = Integer.parseInt(tokens[1]);

            Seat seat = createSeat(seatType);
            double amount = seat.calculateAmount(count);

            System.out.printf("%s: %.2f%n", seatType, amount);
            grandTotal += amount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Seat createSeat(String seatType) {
        switch (seatType) {
            case "REGULAR":
                return new RegularSeat();
            case "PREMIUM":
                return new PremiumSeat();
            case "RECLINER":
                return new ReclinerSeat();
            default:
                throw new IllegalArgumentException("Unknown seat type: " + seatType);
        }
    }
}

abstract class Seat {
    private static final double CONVENIENCE_FEE = 20;

    abstract double getPricePerTicket();

    final double calculateAmount(int count) {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularSeat extends Seat {
    double getPricePerTicket() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    double getPricePerTicket() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    double getPricePerTicket() {
        return 400;
    }
}
