package Leetcode.DP_1D.knapsack;

public class Knapsack01_TopDown {
    public static void main(String[] args) {
        // Sample weights and values
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 10; // Maximum weight capacity of the knapsack
        int n = weights.length; // Number of items

        // Create an instance of Knapsack01
        Knapsack01_TopDown knapsack01 = new Knapsack01_TopDown();

        // Call the knapsack method and print the result
        int maxValue = knapsack01.knapsack(weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }

    int knapsack(int wt[], int val[], int W, int n) {

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}
