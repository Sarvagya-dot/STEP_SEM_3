public class BmiCalculatorTeam {

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60};
        double[] weights = {70, 90};

        printWellnessReport(heights, weights);
    }

    static double calculateBmi(double height, double weight) {
        return weight / (height * height);
    }

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");

        for (int personIndex = 0; personIndex < heights.length; personIndex++) {
            double bmi = calculateBmi(heights[personIndex], weights[personIndex]);
            double roundedBmi = Math.round(bmi * 100.0) / 100.0;
            String status = getBmiStatus(bmi);

            System.out.println("Person " + (personIndex + 1) + " | " + heights[personIndex] + " | "
                    + weights[personIndex] + " | " + roundedBmi + " | " + status);
        }
    }
}
