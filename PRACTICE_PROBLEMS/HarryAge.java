package PRACTICE_PROBLEMS;
// Program to calculate Harry's age

class HarryAge {
    public static void main(String[] args) {

        // Creating variables
        String name = "Harry";
        int birthYear = 2008;
        int currentYear = 2026;

        // Calculate age
        int age = currentYear - birthYear;

        // Display result
        System.out.println(name + "'s age in " + currentYear + " is " + age);
    }
}