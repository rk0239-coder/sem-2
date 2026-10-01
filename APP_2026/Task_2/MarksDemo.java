package Task_2;

class Marks {
    int mark1;
    int mark2;
    int mark3;

    void calculate() {

        int total = mark1 + mark2 + mark3;

        double average = total / 3.0;

        System.out.println("Mark 1: " + mark1);
        System.out.println("Mark 2: " + mark2);
        System.out.println("Mark 3: " + mark3);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
    }
}

public class MarksDemo {
    public static void main(String[] args) {

        Marks m = new Marks();

        m.mark1 = 80;
        m.mark2 = 75;
        m.mark3 = 90;

        m.calculate();
    }
}