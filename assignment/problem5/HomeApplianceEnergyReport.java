import java.util.Scanner;

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int applianceCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double totalCost = 0;

        for (int applianceIndex = 0; applianceIndex < applianceCount; applianceIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String applianceType = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean saverRequested = tokens.length > 2 && tokens[2].equals("SAVER");

            Appliance appliance = createAppliance(applianceType);
            double units = appliance.calculateUnits(hours);

            if (saverRequested) {
                if (appliance instanceof SaverModeCapable) {
                    units = ((SaverModeCapable) appliance).applySaverMode(units);
                } else {
                    System.out.println(applianceType + ": saver mode not supported");
                    continue;
                }
            }

            double cost = units * Appliance.COST_PER_UNIT;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", applianceType, units, cost);
            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        userInputScanner.close();
    }

    private static Appliance createAppliance(String applianceType) {
        switch (applianceType) {
            case "FRIDGE":
                return new FridgeAppliance();
            case "AC":
                return new AcAppliance();
            case "TV":
                return new TvAppliance();
            case "WASHER":
                return new WasherAppliance();
            default:
                throw new IllegalArgumentException("Unknown appliance type: " + applianceType);
        }
    }
}

interface SaverModeCapable {
    double SAVER_REDUCTION_RATE = 0.25;

    default double applySaverMode(double units) {
        return units * (1 - SAVER_REDUCTION_RATE);
    }
}

abstract class Appliance {
    static final double COST_PER_UNIT = 8;

    abstract double getPowerWatts();

    final double calculateUnits(double hours) {
        return (getPowerWatts() * hours) / 1000;
    }
}

class FridgeAppliance extends Appliance {
    double getPowerWatts() {
        return 150;
    }
}

class AcAppliance extends Appliance implements SaverModeCapable {
    double getPowerWatts() {
        return 1500;
    }
}

class TvAppliance extends Appliance {
    double getPowerWatts() {
        return 100;
    }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    double getPowerWatts() {
        return 500;
    }
}
