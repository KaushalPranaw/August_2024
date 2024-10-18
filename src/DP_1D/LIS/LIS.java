package DP_1D.LIS;

public class LIS {
    public static void main(String[] args) {
        int nums[]={10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LIS().lengthOfLIS(nums));

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, -1, nums, n, dp);

    }

    private int helper(int index, int prev_index, int[] nums, int n, int[][] dp) {
        if (index == n) {
            return 0;
        }
        if (dp[index][prev_index + 1] != -1) {
            return dp[index][prev_index + 1];
        }

        int len = 0 + helper(index + 1, prev_index, nums, n, dp);
        if (prev_index == -1 || nums[index] > nums[prev_index]) {
            len = Math.max(len, 1 + helper(index + 1, index, nums, n, dp));
        }
        return dp[index][prev_index + 1] = len;
    }
}
