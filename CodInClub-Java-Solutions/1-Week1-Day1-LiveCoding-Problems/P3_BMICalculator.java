public class P3_BMICalculator {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }
static void printWellnessReport(double[] heights, double[] weights) {
    System.out.println("Person   | Height (m) | Weight (kg) | BMI   | Status");
    System.out.println("---------------------------------------------------");
    for (int i = 0; i < heights.length; i++) {
        double bmi = weights[i] / (heights[i] * heights[i]);
        System.out.printf("Person %-2d| %-10.2f | %-11.1f | %-5.2f | %s%n",
        i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
    }
}
public static void main(String[] args) {
    double[] heights = {1.75, 1.60};
    double[] weights = {70, 90};
    printWellnessReport(heights, weights);
}
}
