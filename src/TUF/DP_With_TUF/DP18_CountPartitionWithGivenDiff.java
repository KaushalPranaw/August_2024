package TUF.DP_With_TUF;

import java.util.Arrays;

public class DP18_CountPartitionWithGivenDiff {
    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 4};
        int n = arr.length;
        int d = 3;

        System.out.println("The number of subsets found are " + countPartitions(n, d, arr));
    }

    private static int countPartitions(int n, int d, int[] arr) {
        int totalSum = Arrays.stream(arr).sum();

        //Checking for edge cases
        if (totalSum - d < 0) return 0;
        if ((totalSum - d) % 2 == 1) return 0;

        int s2 = (totalSum - d) / 2;
        return findWays(arr, s2);
    }

    /*//handle if array having multiple zero {0, 0, 1} and k=1 then base case need to be changes
    private static int findWays(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return findWaysUtil(n - 1, arr, k, dp);
    }

    private static int findWaysUtil(int ind, int[] arr, int target, int[][] dp) {
        //base case

        //this will fail
        *//*if (target == 0) {
            return 1;
        }*//*

        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;//take and not_take 2 choice both will give true

            if (target == 0 || target == arr[0])
                return 1;

            return 0;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int not_taken = findWaysUtil(ind - 1, arr, target, dp);
        int taken = 0;
        if (arr[ind] <= target) {
            taken += findWaysUtil(ind - 1, arr, target - arr[ind], dp);
        }
        return dp[ind][target] = not_taken + taken;
    }*/

    /*//tabulation
    private static int findWays(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];

        //base case
        if (arr[0] == 0) {
            dp[0][0] = 2;
            //take + not_take dono me true to answer is 2
        } else {
            dp[0][0] = 1;
            //means arr[0]!=0 to we have one choice only not_take
        }

        if (arr[0] != 0 && arr[0] <= k) {
            dp[0][arr[0]] = 1;
        }

        //other case
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
                int not_taken = dp[ind - 1][target];
                int taken = 0;
                if (arr[ind] <= target) {
                    taken += dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = not_taken + taken;
            }
        }
        return dp[n - 1][k];
    }*/

    //optimize space
    private static int findWays(int[] arr, int k) {
        int n = arr.length;
        int[] prev = new int[k+1];
        int[] cur = new int[k+1];

        //base case
        if (arr[0] == 0) {
            prev[0] = 2;
            //take + not_take dono me true to answer is 2
        } else {
            prev[0] = 1;
            //means arr[0]!=0 to we have one choice only not_take
        }

        if (arr[0] != 0 && arr[0] <= k) {
            prev[arr[0]] = 1;
        }

        //other case
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= k; target++) {
                int not_taken = prev[target];
                int taken = 0;
                if (arr[ind] <= target) {
                    taken += prev[target - arr[ind]];
                }
                cur[target] = not_taken + taken;
            }
            prev=cur;
        }
        return prev[k];
    }
}
