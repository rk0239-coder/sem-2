package PRACTICE_PROBLEMS;
// Program to convert kilometers to miles

class KmToMiles {
    public static void main(String[] args) {

        // Creating variables
        double distanceKm = 10.8;
        double kmPerMile = 1.6;

        // Convert km to miles
        double distanceMiles = distanceKm / kmPerMile;

        // Display result
        System.out.println("The distance " + distanceKm + " km in miles is " + distanceMiles);
    }
}