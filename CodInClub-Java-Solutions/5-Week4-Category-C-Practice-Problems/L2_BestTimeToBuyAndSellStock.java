import java.util.Arrays;
public class L2_BestTimeToBuyAndSellStock {
    static int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPriceSoFar) {
                minPriceSoFar = price;
            } else if (price - minPriceSoFar > maxProfit) {
            maxProfit = price - minPriceSoFar;
        }
}
return maxProfit;
}
public static void main(String[] args) {
    int[] test1 = {7, 1, 5, 3, 6, 4};
    System.out.println("prices = " + Arrays.toString(test1));
    System.out.println("Output: " + maxProfit(test1) + " (Expected: 5)");
    System.out.println();
    int[] test2 = {7, 6, 4, 3, 1};
    System.out.println("prices = " + Arrays.toString(test2));
    System.out.println("Output: " + maxProfit(test2) + " (Expected: 0)");
}
}
