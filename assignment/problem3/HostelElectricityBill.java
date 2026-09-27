import java.util.Scanner;

public class HostelElectricityBill {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int roomCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int roomIndex = 0; roomIndex < roomCount; roomIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

            Room room = createRoom(tokens);
            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", tokens[0], bill);
            grandTotal += bill;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Room createRoom(String[] tokens) {
        String roomType = tokens[0];
        int units = Integer.parseInt(tokens[1]);

        switch (roomType) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                int occupants = Integer.parseInt(tokens[2]);
                return new SharedRoom(units, occupants);
            case "AC":
                return new AcRoom(units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
    }
}

abstract class Room {
    protected int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    private static final double RATE_PER_UNIT = 8;

    SingleRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * RATE_PER_UNIT;
    }
}

class SharedRoom extends Room {
    private static final double RATE_PER_UNIT = 6;
    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * RATE_PER_UNIT) / occupants;
    }
}

class AcRoom extends Room {
    private static final double RATE_PER_UNIT = 10;
    private static final double FIXED_CHARGE = 200;

    AcRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * RATE_PER_UNIT + FIXED_CHARGE;
    }
}
