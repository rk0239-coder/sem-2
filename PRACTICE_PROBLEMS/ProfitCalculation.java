package PRACTICE_PROBLEMS;
// Program to calculate profit and profit percentage

class ProfitCalculation {
    public static void main(String[] args) {

        // Creating variables
        int costPrice = 129;
        int sellingPrice = 191;

        // Calculations
        int profit = sellingPrice - costPrice;
        double profitPercentage = (double) profit / costPrice * 100;

        // Display output
        System.out.println("The Cost Price is INR " + costPrice +
                " and Selling Price is INR " + sellingPrice +
                "\nThe Profit is INR " + profit +
                " and the Profit Percentage is " + profitPercentage);
    }
}