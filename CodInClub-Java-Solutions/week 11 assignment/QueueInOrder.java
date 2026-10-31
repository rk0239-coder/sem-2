public class QueueInOrder {
    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 5, 5, 8, 6, 9};
        int[] t2 = {1, 2, 2, 7};
        System.out.println(firstBreak(t1));
        System.out.println(firstBreak(t2));
    }
}
