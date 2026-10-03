import java.util.Scanner;

public class ElectricityConnectionBilling {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int connectionCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int connectionIndex = 0; connectionIndex < connectionCount; connectionIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String connectionType = tokens[0];
            int units = Integer.parseInt(tokens[1]);

            Connection connection = createConnection(connectionType, units);
            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n", connectionType, bill);
            grandTotal += bill;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Connection createConnection(String connectionType, int units) {
        switch (connectionType) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            case "FACTORY":
                return new FactoryConnection(units);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + connectionType);
        }
    }
}

abstract class Connection {
    protected int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class HomeConnection extends Connection {
    private static final int FIRST_TIER_LIMIT = 100;
    private static final double FIRST_TIER_RATE = 5;
    private static final double SECOND_TIER_RATE = 7;

    HomeConnection(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= FIRST_TIER_LIMIT) {
            return units * FIRST_TIER_RATE;
        }
        int extraUnits = units - FIRST_TIER_LIMIT;
        return FIRST_TIER_LIMIT * FIRST_TIER_RATE + extraUnits * SECOND_TIER_RATE;
    }
}

class ShopConnection extends Connection {
    private static final double RATE_PER_UNIT = 8;
    private static final double FIXED_CHARGE = 100;

    ShopConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return units * RATE_PER_UNIT + FIXED_CHARGE;
    }
}

class FactoryConnection extends Connection {
    private static final double RATE_PER_UNIT = 6;
    private static final double MINIMUM_BILL = 1000;

    FactoryConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * RATE_PER_UNIT, MINIMUM_BILL);
    }
}
