import java.util.*;

public class PrizeTable {
    static int prizeTable(int[] marks) {
        int n = marks.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) maxIdx = j;
            }
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] m1 = {45, 90, 60, 75};
        int s1 = prizeTable(m1);
        System.out.println(Arrays.toString(m1) + " swaps = " + s1);

        int[] m2 = {80, 70, 60};
        int s2 = prizeTable(m2);
        System.out.println(Arrays.toString(m2) + " swaps = " + s2);
    }
}
