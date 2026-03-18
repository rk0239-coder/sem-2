package PRACTICE_PROBLEMS;

import java.util.Scanner;

class TriangleArea {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter base (cm): ");
        double base = input.nextDouble();

        System.out.print("Enter height (cm): ");
        double height = input.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaInch = areaCm / (2.54 * 2.54);

        System.out.println("Area in sq cm = " + areaCm);
        System.out.println("Area in sq inches = " + areaInch);

        input.close();
    }
}