package DP_With_TUF;

import java.util.Arrays;

public class DP12_MaximumFallingPathSum {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};

        // Call the getMaxPathSum function and print the result
        System.out.println(getMaxPathSum(matrix));

    }

    //recur + memo
    /*private static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            maxi = Math.max(maxi, getMaxPathSumUtil(m - 1, j, n, matrix, dp));
        }
        return maxi;
    }

    private static int getMaxPathSumUtil(int i, int j, int n, int[][] matrix, int[][] dp) {
        //base case
        if (j < 0 || j >= n) {
            return Integer.MIN_VALUE;
        }

        if (i == 0) {
            return matrix[0][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = matrix[i][j] + getMaxPathSumUtil(i - 1, j, n, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMaxPathSumUtil(i - 1, j - 1, n, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMaxPathSumUtil(i - 1, j + 1, n, matrix, dp);

        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }*/

    /*//bottom up
    private static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        // Initializing the first row - base condition
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += Integer.MIN_VALUE;
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += Integer.MIN_VALUE;
                }
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row of dp
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            maxi = Math.max(maxi, dp[m - 1][j]);
        }

        return maxi;
    }*/

    //space optimize
    private static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prev = new int[n];
        int[] cur = new int[n];

        // Initializing the first row - base condition
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + prev[j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev[j - 1];
                } else {
                    leftDiagonal += Integer.MIN_VALUE;
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += prev[j + 1];
                } else {
                    rightDiagonal += Integer.MIN_VALUE;
                }
                cur[j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
            prev = cur.clone();
        }

        // Find the maximum value in the last row of dp
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            maxi = Math.max(maxi, prev[j]);
        }

        return maxi;
    }

}
