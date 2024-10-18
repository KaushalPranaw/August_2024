package DP_1D.knapsack;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int a[] = {1, 5, 11, 5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(a));

    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 == 0) {
            return subsetSum(nums, sum / 2);
        } else {
            return false;
        }
    }

    private boolean subsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[n][sum];

    }
}
