package Leetcode.Array_String;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    private int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int curProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, curProfit);
        }
        return maxProfit;
    }

    /*public int maxProfit(int[] prices) {
        int maxProfit = 0, minElement = prices[0];
        for (int price : prices) {
            minElement = Leetcode.Math.min(minElement, price);
            maxProfit = Leetcode.Math.max(maxProfit, price - minElement);
        }
        return maxProfit;
    }*/
}
