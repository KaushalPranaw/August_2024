package TUF.DP_With_TUF;

public class DP10_MinPathSumInGrid {
    public static void main(String[] args) {
        // Define the matrix
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(minSumPath(m, n, matrix));
    }

    //recur+Memo
    /*private static int minSumPath(int m, int n, int[][] mat) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minSumPathUtil(m - 1, n - 1, mat, dp);
    }

    private static int minSumPathUtil(int i, int j, int[][] mat, int[][] dp) {
        //base case
        if (i == 0 && j == 0) {
            return mat[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE / 2;//returning larger value
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = mat[i][j] + minSumPathUtil(i - 1, j, mat, dp);
        int left = mat[i][j] + minSumPathUtil(i, j - 1, mat, dp);
        return dp[i][j] = Leetcode.Math.min(up, left);
    }*/

    //bottom up
    /*private static int minSumPath(int m, int n, int[][] mat) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //base case
                if (i == 0 && j == 0) {
                    dp[i][j] = mat[0][0];
                    continue;
                }

                int up = mat[i][j];
                int left = mat[i][j];
                if (i > 0) {
                    up += dp[i - 1][j];
                } else {
                    up += Integer.MAX_VALUE / 2;
                }
                if (j > 0) {
                    left += dp[i][j - 1];
                } else {
                    left += Integer.MAX_VALUE / 2;
                }
                dp[i][j] = Leetcode.Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }*/

    //space optimize
    private static int minSumPath(int m, int n, int[][] mat) {
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {

                //base case
                if (i == 0 && j == 0) {
                    temp[j] = mat[i][j];
                    continue;
                }

                int up = mat[i][j];
                int left = mat[i][j];
                if (i > 0) {
                    up += prev[j];
                } else {
                    up += Integer.MAX_VALUE / 2;
                }
                if (j > 0) {
                    left += temp[j - 1];
                } else {
                    left += Integer.MAX_VALUE / 2;
                }
                temp[j] = Math.min(up, left);
            }
            prev = temp;
        }

        return prev[n - 1];
    }

}
