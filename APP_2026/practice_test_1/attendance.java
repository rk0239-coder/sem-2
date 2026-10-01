package practice_test_1;

public class attendance {
   public static String getGrade(int marks, int attendance) 
    {
        if (attendance < 75) {
            return "Detained";
        }
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else {
            return "D";
        }
    }
    public static void main(String[] args) 
    {
        int[][] testCases = {
            {95, 80},
            {95, 60},
            {65, 90},
            {40, 100}
        };


        for (int i = 0; i < testCases.length; i++) {
           int marks = testCases[i][0];
           int attendance = testCases[i][1];
           System.out.println("Marks = " + marks + ", Attendance = " + attendance + " -> " + getGrade(marks, attendance));
        }
    }
}
