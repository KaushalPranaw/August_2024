package Array_String;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minElement = prices[0];
        for (int price : prices) {
            minElement = Math.min(minElement, price);
            maxProfit = Math.max(maxProfit, price - minElement);
        }
        return maxProfit;
    }
}
