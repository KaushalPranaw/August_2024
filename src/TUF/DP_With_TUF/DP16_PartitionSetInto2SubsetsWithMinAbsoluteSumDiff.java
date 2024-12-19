package TUF.DP_With_TUF;

public class DP16_PartitionSetInto2SubsetsWithMinAbsoluteSumDiff {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};

        //find totalsum and pass instead of target
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        // Check if there exists a subset with the given target sum
        int minDiff = minSubsetSumDifference(totalSum, arr);
        System.out.println(minDiff);
    }

    //tabulation
    /*private static int minSubsetSumDifference(int k, int[] arr) {
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

        // Find the minimum absolute difference
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= k / 2; s1++) {
            if (dp[n - 1][s1] == true) {
                int s2 = k - s1;
                minDiff = Leetcode.Math.min(minDiff, Leetcode.Math.abs(s2 - s1));
            }
        }
        return minDiff;
    }*/

    //space optimize
    private static int minSubsetSumDifference(int k, int[] arr) {
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

        int min = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= k / 2; s1++) {
            if (prev[s1] == true) {
                int s2 = k - s1;
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }
        return min;
    }
}
