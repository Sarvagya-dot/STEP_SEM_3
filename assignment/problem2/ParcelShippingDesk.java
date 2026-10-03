import java.util.Scanner;

public class ParcelShippingDesk {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int parcelCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double grandTotal = 0;

        for (int parcelIndex = 0; parcelIndex < parcelCount; parcelIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");
            String parcelType = tokens[0];
            double weightKg = Double.parseDouble(tokens[1]);
            double declaredValue = Double.parseDouble(tokens[2]);

            Parcel parcel = createParcel(parcelType, weightKg, declaredValue);

            double charge = parcel.calculateCharge();
            double insurance = (parcel instanceof Insurable)
                    ? ((Insurable) parcel).calculateInsurance(declaredValue)
                    : 0;
            double total = charge + insurance;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", parcelType, charge, insurance, total);
            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        userInputScanner.close();
    }

    private static Parcel createParcel(String parcelType, double weightKg, double declaredValue) {
        switch (parcelType) {
            case "STANDARD":
                return new StandardParcel(weightKg, declaredValue);
            case "EXPRESS":
                return new ExpressParcel(weightKg, declaredValue);
            case "FRAGILE":
                return new FragileParcel(weightKg, declaredValue);
            default:
                throw new IllegalArgumentException("Unknown parcel type: " + parcelType);
        }
    }
}

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    private static final double BASE_CHARGE = 40;
    private static final double RATE_PER_KG = 10;

    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return BASE_CHARGE + weightKg * RATE_PER_KG;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    private static final double BASE_CHARGE = 80;
    private static final double RATE_PER_KG = 15;
    private static final double INSURANCE_RATE = 0.02;

    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return BASE_CHARGE + weightKg * RATE_PER_KG;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * INSURANCE_RATE;
    }
}

class FragileParcel extends Parcel implements Insurable {
    private static final double STANDARD_BASE_CHARGE = 40;
    private static final double STANDARD_RATE_PER_KG = 10;
    private static final double HANDLING_FEE = 50;
    private static final double INSURANCE_RATE = 0.02;

    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        double standardCharge = STANDARD_BASE_CHARGE + weightKg * STANDARD_RATE_PER_KG;
        return standardCharge + HANDLING_FEE;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * INSURANCE_RATE;
    }
}
