import java.util.Scanner;

class Student {
    private String name;
    private int a, b, c;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) return false;
        this.a = a;
        this.b = b;
        this.c = c;
        return true;
    }

    String getName() {
        return name;
    }

    int getTotal() {
        return a + b + c;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    char getGrade() {
        double avg = getAverage();
        if (avg >= 80) return 'A';
        else if (avg >= 70) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }

    @Override
    public String toString() {
        return String.format("%s total=%d avg=%.2f grade=%c", name, getTotal(), getAverage(), getGrade());
    }
}

public class Problem2_ClassReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] list = new Student[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            Student s = new Student(name);
            if (s.setMarks(a, b, c)) list[count++] = s;
            else System.out.println(name + " skipped: marks must be 0 to 100");
        }
        int passes = 0;
        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < count - 1 - i; j++) {
                if (list[j].getTotal() < list[j + 1].getTotal()) {
                    Student t = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
            passes++;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + list[i]);
        }
        System.out.println("Sorted in " + passes + " passes");
    }
}
