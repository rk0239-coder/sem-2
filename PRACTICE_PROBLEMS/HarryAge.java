package PRACTICE_PROBLEMS;
// Program to calculate Harry's age

class HarryAge {
    public static void main(String[] args) {

        // Creating variables
        String name = "Harry";
        int birthYear = 2000;
        int currentYear = 2024;

        // Calculate age
        int age = currentYear - birthYear;

        // Display result
        System.out.println(name + "'s age in " + currentYear + " is " + age);
    }
}