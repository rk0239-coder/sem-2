public class BestSingleTradeProfit {
    static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] p1 = {7, 1, 5, 3, 6, 4};
        int[] p2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(p1));
        System.out.println(maxProfit(p2));
    }
}
