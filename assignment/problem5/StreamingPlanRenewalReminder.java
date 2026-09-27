import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int subscriberCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int subscriberIndex = 0; subscriberIndex < subscriberCount; subscriberIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String planType = tokens[0];
            String subscriberName = tokens[1];
            LocalDate startDate = LocalDate.parse(tokens[2]);

            Plan plan = createPlan(planType);
            LocalDate renewalDate = startDate.plusDays(plan.getValidityDays());

            System.out.println(subscriberName + ": " + renewalDate);
        }

        userInputScanner.close();
    }

    private static Plan createPlan(String planType) {
        switch (planType) {
            case "BASIC":
                return new BasicPlan();
            case "STANDARD":
                return new StandardPlan();
            case "PREMIUM":
                return new PremiumPlan();
            default:
                throw new IllegalArgumentException("Unknown plan type: " + planType);
        }
    }
}

abstract class Plan {
    abstract int getValidityDays();
}

class BasicPlan extends Plan {
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    int getValidityDays() {
        return 365;
    }
}
