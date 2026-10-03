import java.util.Scanner;

public class CityCabFareMeter {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int tripCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int tripIndex = 0; tripIndex < tripCount; tripIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String cabType = tokens[0];
            double km = Double.parseDouble(tokens[1]);
            String timeOfDay = tokens[2];

            Cab cab = createCab(cabType);
            double fare = cab.calculateFare(km);

            if (timeOfDay.equals("NIGHT")) {
                if (cab instanceof NightServiceCapable) {
                    fare = ((NightServiceCapable) cab).applyNightSurcharge(fare);
                    System.out.printf("%s: %.2f%n", cabType, fare);
                    grandTotal += fare;
                } else {
                    System.out.println(cabType + ": night service not available");
                }
            } else {
                System.out.printf("%s: %.2f%n", cabType, fare);
                grandTotal += fare;
            }
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Cab createCab(String cabType) {
        switch (cabType) {
            case "MINI":
                return new MiniCab();
            case "SEDAN":
                return new SedanCab();
            case "SUV":
                return new SuvCab();
            default:
                throw new IllegalArgumentException("Unknown cab type: " + cabType);
        }
    }
}

interface NightServiceCapable {
    double NIGHT_SURCHARGE_MULTIPLIER = 1.2;

    default double applyNightSurcharge(double fare) {
        return fare * NIGHT_SURCHARGE_MULTIPLIER;
    }
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100;

    abstract double getRatePerKm();

    final double calculateFare(double km) {
        return Math.max(km * getRatePerKm(), MINIMUM_FARE);
    }
}

class MiniCab extends Cab {
    double getRatePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightServiceCapable {
    double getRatePerKm() {
        return 14;
    }
}

class SuvCab extends Cab implements NightServiceCapable {
    double getRatePerKm() {
        return 18;
    }
}
