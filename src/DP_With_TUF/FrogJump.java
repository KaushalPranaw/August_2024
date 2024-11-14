package DP_With_TUF;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FrogJump {

    //using recur+memo
    /*public static void main(String[] args) {
        int n = 6;
        int[] heights = {4, 8, 3, 10, 4, 4};
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(frogJump(n - 1, heights, dp));
    }
    static int frogJump(int n, int[] heights, int[] dp) {
        if (n == 0)
            return 0;// means 0 waste of energy
        if (dp[n] != -1) {
            return dp[n];
        }
        int left = frogJump(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = frogJump(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }
        return dp[n] = Math.min(left, right);
    }*/

    //using recur+memo
    /*public static void main(String[] args) {
        int n = 6;
        int[] heights = {4, 8, 3, 10, 4, 4};
        System.out.println(frogJump_using_tab(n, heights));
    }

    static int frogJump_using_tab(int n, int[] heights) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(fs, ss);
        }

        return dp[n-1];
    }*/

    //using space optimization
    public static void main(String[] args) {
        int n = 6;
        int[] heights = {4, 8, 3, 10, 4, 4};
        System.out.println(frogJump_using_tab(n, heights));
    }

    static int frogJump_using_tab(int n, int[] heights) {

        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int cur_i = Math.min(fs, ss);
            prev2 = prev;
            prev = cur_i;
        }

        return prev;
    }
}
