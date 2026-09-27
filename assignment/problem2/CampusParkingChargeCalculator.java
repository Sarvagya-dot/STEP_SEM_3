import java.util.Scanner;

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int vehicleCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int vehicleIndex = 0; vehicleIndex < vehicleCount; vehicleIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String vehicleType = tokens[0];
            int hoursParked = Integer.parseInt(tokens[1]);

            Vehicle vehicle = createVehicle(vehicleType);
            double charge = vehicle.calculateCharge(hoursParked);

            System.out.printf("%s: %.2f%n", vehicleType, charge);
            grandTotal += charge;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Vehicle createVehicle(String vehicleType) {
        switch (vehicleType) {
            case "BIKE":
                return new BikeVehicle();
            case "CAR":
                return new CarVehicle();
            case "TRUCK":
                return new TruckVehicle();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}

abstract class Vehicle {
    abstract double calculateCharge(int hoursParked);
}

class BikeVehicle extends Vehicle {
    private static final double RATE_PER_HOUR = 10;

    double calculateCharge(int hoursParked) {
        return hoursParked * RATE_PER_HOUR;
    }
}

class CarVehicle extends Vehicle {
    private static final double FIRST_HOUR_RATE = 30;
    private static final double ADDITIONAL_HOUR_RATE = 20;

    double calculateCharge(int hoursParked) {
        return FIRST_HOUR_RATE + (hoursParked - 1) * ADDITIONAL_HOUR_RATE;
    }
}

class TruckVehicle extends Vehicle {
    private static final double RATE_PER_HOUR = 50;
    private static final double MINIMUM_CHARGE = 100;

    double calculateCharge(int hoursParked) {
        return Math.max(hoursParked * RATE_PER_HOUR, MINIMUM_CHARGE);
    }
}
