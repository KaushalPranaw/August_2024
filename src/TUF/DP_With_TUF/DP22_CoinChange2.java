package TUF.DP_With_TUF;

public class DP22_CoinChange2 {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
    }
/*
    //recur+memo
    private static int countWaysToMakeChange(int[] arr, int n, int target) {
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countWaysToMakeChangeUtil(n - 1, target, arr, dp);
    }

    private static int countWaysToMakeChangeUtil(int ind, int target, int[] arr, int[][] dp) {
        //base case
        if (ind == 0) {
            if (target % arr[ind] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int not_take = countWaysToMakeChangeUtil(ind - 1, target, arr, dp);
        int take = 0;
        if (arr[ind] <= target) {
            take = countWaysToMakeChangeUtil(ind, target - arr[ind], arr, dp);
        }
        return dp[ind][target] = not_take + take;
    }*/


    /*//tab
    private static int countWaysToMakeChange(int[] arr, int n, int tar) {
        int[][] dp = new int[n][tar + 1];

        for (int i = 0; i <= tar; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {
                int not_take = dp[ind - 1][target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = dp[ind][target - arr[ind]];
                }
                dp[ind][target] = not_take + take;
            }
        }
        return dp[n - 1][tar];
    }*/

    //space
    private static int countWaysToMakeChange(int[] arr, int n, int tar) {
        int[] prev = new int[tar + 1];

        for (int i = 0; i <= tar; i++) {
            if (i % arr[0] == 0)
                prev[i] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int not_take = prev[target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = cur[target - arr[ind]];
                }
                cur[target] = not_take + take;
            }
            prev=cur;
        }
        return prev[tar];
    }
}
