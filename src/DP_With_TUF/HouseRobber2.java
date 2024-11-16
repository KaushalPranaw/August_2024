package DP_With_TUF;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 9};
        int[] temp1 = new int[a.length];
        int[] temp2 = new int[a.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != 0) {
                temp1[index1++] = a[i];
            }
            if (i != a.length - 1) {
                temp2[index2++] = a[i];
            }
        }
        System.out.println(Math.max(rob(temp1), rob(temp2)));
    }

    //using recur+memo
    /*private static int rob(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(n - 1, a, dp);
    }

    private static int f(int ind, int[] a, int[] dp) {
        if (ind == 0)
            return a[ind];

        if (ind < 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int pick = a[ind] + f(ind - 2, a, dp);
        int not_pick = 0 + f(ind - 1, a, dp);
        return dp[ind] = Math.max(pick, not_pick);
    }*/

    //using tabulation
    /*private static int rob(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = a[0];

        int neg = 0;//not required

        for (int i = 1; i < n; i++) {
            int pick = a[i];
            if (i > 1)
                pick += dp[i - 2];
            int not_pick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, not_pick);
        }
        return dp[n-1];
    }*/

    //using constant space
    private static int rob(int[] a) {
        int n = a.length;
        int prev = a[0];
        int prev2 = 0;//not required

        for (int i = 1; i < n; i++) {
            int pick = a[i];
            if (i > 1)
                pick += prev2;
            int not_pick = 0 + prev;
            int cur_i = Math.max(pick, not_pick);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
}
