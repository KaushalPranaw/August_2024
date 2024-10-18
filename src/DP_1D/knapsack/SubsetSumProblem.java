package DP_1D.knapsack;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int a[] = {2, 3, 7, 8, 10};
        int sum = 11;
        System.out.println(subSetSum(a, sum));
    }

    private static boolean subSetSum(int[] a, int sum) {
        //top down
        int n = a.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // Sum 0 can always be achieved with no elements
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false; // No elements means sum can't be achieved
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                //choice diagram wala code
                if (a[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - a[i - 1]] || dp[i - 1][j];
                } else {
                    if (a[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }
}
