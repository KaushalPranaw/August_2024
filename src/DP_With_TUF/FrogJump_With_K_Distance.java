package DP_With_TUF;

import java.util.Arrays;

public class FrogJump_With_K_Distance {
    //using recur+memo
    /*public static void main(String[] args) {
        int n = 6;
        int k = 4;
        int[] heights = {4, 8, 3, 10, 4, 5};
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(frogJump(n - 1, heights, k, dp));
    }

    private static int frogJump(int n, int[] heights, int k, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];
        int minStep = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (n - j >= 0) {
                int jump = frogJump(n - j, heights, k, dp) + Math.abs(heights[n] - heights[n - j]);
                minStep = Math.min(minStep, jump);
            }
        }
        return minStep;
    }*/

    //using bottom up
    public static void main(String[] args) {
        int n = 6;
        int k = 4;
        int[] heights = {4, 8, 3, 10, 4, 5};
        System.out.println(frogJump(n - 1, heights, k));
    }

    private static int frogJump(int n, int[] heights, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minStep = Math.min(minStep, jump);
                }
            }
            dp[i] = minStep;
        }
        return dp[n];
    }
}
