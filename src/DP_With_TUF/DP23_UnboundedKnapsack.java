package DP_With_TUF;

import java.util.Arrays;

public class DP23_UnboundedKnapsack {
    public static void main(String args[]) {
        int wt[] = {2, 4, 6};
        int val[] = {5, 11, 13};
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));
    }
/*
    //recur+memo
    private static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return unboundedKnapsackUtil(n - 1, W, val, wt, dp);

    }

    private static int unboundedKnapsackUtil(int ind, int W, int[] val, int[] wt, int[][] dp) {
        //base case
        if (ind == 0) {
            return W / wt[0] * val[0];
        }
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int not_pick = 0 + unboundedKnapsackUtil(ind - 1, W, val, wt, dp);
        int pick = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            pick = val[ind] + unboundedKnapsackUtil(ind, W - wt[ind], val, wt, dp);
        }
        return dp[ind][W] = Math.max(pick, not_pick);
    }*/


    /*//tab
    private static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n][W + 1];

        //base case
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = (int) (i / wt[0] * val[0]);
        }
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                int not_pick = 0 + dp[ind - 1][cap];
                int pick = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    pick = val[ind] + dp[ind][cap - wt[ind]];
                }
                dp[ind][cap] = Math.max(pick, not_pick);
            }
        }
        return dp[n - 1][W];

    }*/

    //space
    private static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        int[] prev = new int[W + 1];

        //base case
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = (int) (i / wt[0] * val[0]);
        }
        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[W + 1];
            for (int cap = 0; cap <= W; cap++) {
                int not_pick = 0 + prev[cap];
                int pick = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    pick = val[ind] + cur[cap - wt[ind]];
                }
                cur[cap] = Math.max(pick, not_pick);
            }
            prev = cur;
        }
        return prev[W];

    }
}
