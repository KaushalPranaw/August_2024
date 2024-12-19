package Leetcode.DP_1D.knapsack;

import java.util.Arrays;

public class Knapsack01_Memo {
    int dp[][] = new int[102][1002];

    public static void main(String[] args) {
        // Sample weights and values
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 10; // Maximum weight capacity of the knapsack
        int n = weights.length; // Number of items

        // Create an instance of Knapsack01
        Knapsack01_Memo knapsack01 = new Knapsack01_Memo();

        // Initialize DP array with -1 using Arrays.fill
        for (int i = 0; i < n; i++) {
            Arrays.fill(knapsack01.dp[i], -1);
        }

        // Call the knapsack method and print the result
        int maxValue = knapsack01.knapsack(weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }

    int knapsack(int wt[], int val[], int W, int n) {
        //base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        //check if exist in dp
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        //chart diagram
        // Check if the weight of the nth item is less than or equal to W
        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),
                    knapsack(wt, val, W, n - 1));

        } else {
            // If the weight of the nth item is more than W, skip it
            if (wt[n - 1] > W) {
                return dp[n][W] = knapsack(wt, val, W, n - 1);

            }
        }
        return 0;
    }
}
