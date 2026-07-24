package easyproblems;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + maxProfit(new int[]
                {
                        10, 1, 5, 6, 7, 1
                }));

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + maxProfit(new int[]
                {
                        3, 4, 1
                }));

        System.out.println("\n========================");

        System.out.println("Test Case 3: " + maxProfit(new int[]
                {
                        10, 8, 7, 5, 2
                }));
    }

    public static int maxProfit(int[] prices) {
        int minBuyingPrice = prices[0]; // setting up a base price
        int sellingProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int futurePrice = prices[i];
            int profit = futurePrice - minBuyingPrice;

            if (profit > sellingProfit)
                sellingProfit = profit; // This way we always keep track of highest profit earned in the future.

            if (futurePrice < minBuyingPrice)
                minBuyingPrice = futurePrice; // here we know what could have been the minimum on which we have bought

        }

        // System.out.println("Final Buying Price: " + minBuyingPrice + ", Final Selling Profit: " + sellingProfit);
        return sellingProfit;
    }
}
