package DP_With_TUF;

import java.util.Arrays;

public class DP20_Minimum_Coins {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int T = 7;

        // Call the minimumElements function and print the result
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElements(arr, T));
    }

    /*
    //recur+memo
    private static int minimumElements(int[] arr, int T) {
        int n = arr.length - 1;

        int dp[][] = new int[n][T + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumElementsUtils(n - 1, T, arr, dp);
    }

    private static int minimumElementsUtils(int ind, int T, int[] arr, int[][] dp) {
        //base condition
        if (ind == 0) {
            if (T % arr[0] == 0) {
                return T / arr[0];
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (dp[ind][T] != -1) {
            return dp[ind][T];
        }

        int not_take = 0 + minimumElementsUtils(ind - 1, T, arr, dp);
        int take = Integer.MAX_VALUE;
        if (arr[ind] <= T) {
            int res = minimumElementsUtils(ind, T - arr[ind], arr, dp);
            if (res != Integer.MAX_VALUE) {  // Only consider valid results
                take = 1 + res;
            }
        }
        return dp[ind][T] = Math.min(not_take, take);
    }*/
/*
    //tab
    private static int minimumElements(int[] arr, int T) {
        int n = arr.length - 1;

        int dp[][] = new int[n][T + 1];
        //base condition
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int not_take = 0 + dp[ind - 1][target];
                int take = Integer.MAX_VALUE;
                if (arr[ind] <= target) {
                    int res = dp[ind][target - arr[ind]];
                    if (res != Integer.MAX_VALUE) {  // Only consider valid results
                        take = 1 + res;
                    }
                }
                dp[ind][target] = Math.min(not_take, take);
            }
        }

        return dp[n - 1][T] == Integer.MAX_VALUE ? -1 : dp[n - 1][T];
    }*/


    //tab
    private static int minimumElements(int[] arr, int T) {
        int n = arr.length - 1;

        int prev[] = new int[T + 1];
        int cur[] = new int[T + 1];
        //base condition
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0) {
                prev[i] = i / arr[0];
            } else {
                prev[i] = Integer.MAX_VALUE;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int not_take = 0 + prev[target];
                int take = Integer.MAX_VALUE;
                if (arr[ind] <= target) {
                    int res = cur[target - arr[ind]];
                    if (res != Integer.MAX_VALUE) {  // Only consider valid results
                        take = 1 + res;
                    }
                }
                cur[target] = Math.min(not_take, take);
            }
            prev = cur;
        }

        return prev[T] == Integer.MAX_VALUE ? -1 : prev[T];
    }
}
