package TUF.DP_With_TUF;

public class DP19_01Knapsack {
    public static void main(String[] args) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        // Calculate and print the maximum value of items the thief can steal
        System.out.println("The Maximum value of items the thief can steal is " + knapsack(wt, val, n, W));
    }

    /*
    //recur+memo
    private static int knapsack(int[] wt, int[] val, int n, int W) {
        int dp[][] = new int[n][W + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return knapsackUtil(n - 1, W, wt, val, dp);
    }

    private static int knapsackUtil(int ind, int W, int[] wt, int[] val, int[][] dp) {
        //base case
        if (ind == 0) {
            if (wt[0] <= W) {
                return val[0];
            } else return 0;
        }
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }
        int not_take = knapsackUtil(ind - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            take = val[ind] + knapsackUtil(ind - 1, W - wt[ind], wt, val, dp);
        }
        return dp[ind][W] = Leetcode.Math.max(take, not_take);
    }*/


    /*//tab
    private static int knapsack(int[] wt, int[] val, int n, int W) {
        int dp[][] = new int[n][W + 1];

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int cap = 0; cap <= W; cap++) {
                int not_take = dp[i - 1][cap];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= cap) {
                    take = val[i] + dp[i - 1][cap - wt[i]];
                }
                dp[i][cap] = Leetcode.Math.max(take, not_take);
            }
        }
        return dp[n - 1][W];
    }*/
    //space optimize
    private static int knapsack(int[] wt, int[] val, int n, int W) {
        int prev[] = new int[W + 1];
        int[] cur = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int cap = 0; cap <= W; cap++) {
                int not_take = prev[cap];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= cap) {
                    take = val[i] + prev[cap - wt[i]];
                }
                cur[cap] = Math.max(take, not_take);
            }
            prev = cur;
        }
        return prev[W];
    }
}
