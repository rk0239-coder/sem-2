import java.util.Scanner;

public class Problem5_WeeklyRainfall {
    static String fmt(double x) {
        return x == Math.rint(x) ? String.format("%.1f", x) : Double.toString(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rain = new double[7];
        for (int i = 0; i < 7; i++) rain[i] = sc.nextDouble();

        double total = 0;
        int wettest = 0, dry = 0;
        StringBuilder sb = new StringBuilder("Rainfall (mm):");
        for (int i = 0; i < 7; i++) {
            sb.append(' ').append(fmt(rain[i]));
            total += rain[i];
            if (rain[i] > rain[wettest]) wettest = i;
            if (rain[i] == 0) dry++;
        }
        System.out.println(sb);
        System.out.println();
        System.out.println("Total Rainfall: " + fmt(total) + " mm");
        System.out.printf("Average Rainfall: %.2f mm%n", total / 7);
        System.out.println("Wettest Day: Day " + (wettest + 1) + " (" + fmt(rain[wettest]) + " mm)");
        System.out.println("Total Dry Days: " + dry);
    }
}
