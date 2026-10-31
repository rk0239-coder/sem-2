import java.util.*;

public class DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int r : rolls) count[r]++;
        StringBuilder sb = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) sb.append(v).append(":").append(count[v]).append(" ");
        System.out.println(sb.toString().trim());

        int[] result = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                result[idx++] = v;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
