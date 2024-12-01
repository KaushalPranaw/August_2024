package DP_With_TUF;

import java.util.Arrays;

public class DP21_TargetSum {
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 1};
        int target = 3;

        int n = arr.length;

        // Call the targetSum function and print the result
        System.out.println("The number of ways found is " + targetSum(n, target, arr));
    }
/*
    //recur+memo
    private static int targetSum(int n, int target, int[] arr) {
        int totSum = 0;
        // Calculate the total sum of elements in the array
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }
        // Checking for edge cases
        if (totSum - target < 0)
            return 0;
        if ((totSum - target) % 2 == 1)
            return 0;
        // Calculate the second sum based on the total sum and the target
        int s2 = (totSum - target) / 2;

        int[][] dp = new int[n][s2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return targetSumUtil(n - 1, s2, arr, dp);
    }

    private static int targetSumUtil(int ind, int target, int[] arr, int[][] dp) {

        // Base case: If we have reached the first element
        if (ind == 0) {
            // Check if the target is 0 and the first element is also 0
            if (target == 0 && arr[0] == 0)
                return 2;//one for pick and one for not pick
            // Check if the target is equal to the first element or 0
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int not_take = targetSumUtil(ind - 1, target, arr, dp);
        int take = 0;
        if (arr[ind] <= target) {
            take = targetSumUtil(ind - 1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = not_take + take;
    }*/

/*
    //tabulation
    private static int targetSum(int n, int target, int[] arr) {
        int totSum = 0;
        // Calculate the total sum of elements in the array
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }
        // Checking for edge cases
        if (totSum - target < 0)
            return 0;
        if ((totSum - target) % 2 == 1)
            return 0;
        // Calculate the second sum based on the total sum and the target
        int s2 = (totSum - target) / 2;

        int[][] dp = new int[n][s2 + 1];

        return targetSumUtil(s2, arr, dp);
    }

    private static int targetSumUtil(int sum, int[] arr, int[][] dp) {

        // Base case: If we have reached the first element
        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }
        int n = arr.length;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= sum; target++) {
                int not_take = dp[ind - 1][target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = not_take + take;
            }
        }
        return dp[n - 1][sum];


    }*/

    //space optimize
    private static int targetSum(int n, int target, int[] arr) {
        int totSum = 0;
        // Calculate the total sum of elements in the array
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }
        // Checking for edge cases
        if (totSum - target < 0)
            return 0;
        if ((totSum - target) % 2 == 1)
            return 0;
        // Calculate the second sum based on the total sum and the target
        int s2 = (totSum - target) / 2;

        int[] prev = new int[s2 + 1];

        return targetSumUtil(s2, arr, prev);
    }

    private static int targetSumUtil(int sum, int[] arr, int[] prev) {

        // Base case: If we have reached the first element
        if (arr[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= sum) {
            prev[arr[0]] = 1;
        }
        int n = arr.length;

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[sum + 1];
            for (int target = 0; target <= sum; target++) {
                int not_take = prev[target];
                int take = 0;
                if (arr[ind] <= target) {
                    take = prev[target - arr[ind]];
                }

                cur[target] = not_take + take;
            }
            prev = cur;
        }
        return prev[sum];


    }
}
