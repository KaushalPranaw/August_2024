package TUF.DP_With_TUF;

import java.util.Arrays;

public class DP15_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};

        int totalSum = 0;
        totalSum = Arrays.stream(arr).sum();
        if (totalSum % 2 != 0) {
            System.out.println(false);
        } else {
            int k = totalSum / 2;

            // Check if there exists a subset with the given target sum
            if (subsetSumToK(k, arr))
                System.out.println(true);
            else
                System.out.println(false);
        }

    }

    /*//recur+memo
    private static boolean subsetSumToK(int k, int[] arr) {
        int n = arr.length;
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][k + 1];
        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return subsetSumToKUtils(n - 1, k, arr, dp);

    }

    private static boolean subsetSumToKUtils(int ind, int k, int[] arr, int[][] dp) {
        //base case
        if (k == 0)
            return true;
        if (ind == 0) {
            return k == arr[ind];
        }

        if (dp[ind][k] != -1)
            return dp[ind][k] == 0 ? false : true;

        boolean not_take = subsetSumToKUtils(ind - 1, k, arr, dp);
        boolean take = false;
        if (k - arr[ind] >= 0) {
            take = subsetSumToKUtils(ind - 1, k - arr[ind], arr, dp);
        }
        boolean ans = (not_take || take);
        dp[ind][k] = ans ? 1 : 0;
        return ans;
    }*/

    /*//tabulation
    private static boolean subsetSumToK(int k, int[] arr) {
        int n = arr.length;
        // Create a DP table with dimensions [n][k+1]
        boolean dp[][] = new boolean[n][k + 1];

        //base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; //means target is 0 to first col is always 0
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean not_take = dp[ind - 1][target];
                boolean take = false;
                if (target - arr[ind] >= 0) {
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = (not_take || take);
            }
        }
        return dp[n - 1][k];
    }*/

    //space optimize
    private static boolean subsetSumToK(int k, int[] arr) {
        int n = arr.length;

        boolean[] prev = new boolean[k + 1];
        boolean[] cur = new boolean[k + 1];

        prev[0] = true;
        cur[0] = true;

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean not_take = prev[target];
                boolean take = false;
                if (target - arr[ind] >= 0) {
                    take = prev[target - arr[ind]];
                }
                cur[target] = (not_take || take);
            }
            prev = cur;
        }
        return prev[k];
    }
}
