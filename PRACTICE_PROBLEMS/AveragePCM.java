package PRACTICE_PROBLEMS;
// Program to calculate Sam's average marks in PCM

class AveragePCM {
    public static void main(String[] args) {

        // Creating variables for marks
        String name = "Sam";
        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;

        int totalMarks = mathsMarks + physicsMarks + chemistryMarks;
        double averageMarks = totalMarks / 3.0;

        // Display result
        System.out.println(name + "'s average mark in PCM is " + averageMarks);
    }
}