package DP_With_TUF;

import java.util.Arrays;

public class Fibonacci {
    //Using recur+memo
    public static void main(String[] args) {
        int n = 5;
        //Step 0: initialize dp
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(getFibonacci(n, dp));
    }

    private static int getFibonacci(int n, int[] dp) {
        if (n <= 1)
            return n;

        //Step 2: check after base case if value is already computed, then directly return
        if (dp[n] != -1)
            return dp[n];

        // Step 1: whatever is computed store them in dp
        return dp[n] = getFibonacci(n - 1, dp) + getFibonacci(n - 2, dp);
    }
}
