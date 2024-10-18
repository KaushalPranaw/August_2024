package DP_1D.knapsack;

import java.util.Map;

public class Knapsack01 {
    public static void main(String[] args) {
        // Sample weights and values
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 10; // Maximum weight capacity of the knapsack
        int n = weights.length; // Number of items

        // Create an instance of Knapsack01
        Knapsack01 knapsack01 = new Knapsack01();

        // Call the knapsack method and print the result
        int maxValue = knapsack01.knapsack(weights, values, capacity, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }

    int knapsack(int wt[], int val[], int W, int n) {
        //base condition
        if (n == 0 || W == 0) {
            return 0;
        }
        //chart diagram
        // Check if the weight of the nth item is less than or equal to W
        if (wt[n - 1] <= W) {
            return Math.max(val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),
                    knapsack(wt, val, W, n - 1));

        } else {
            // If the weight of the nth item is more than W, skip it
            if (wt[n - 1] > W) {
                return knapsack(wt, val, W, n - 1);

            }
        }
        return 0;
    }
}
