package TUF.DP_With_TUF;

public class UniquePath {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(countWays(m, n));
    }

    /*//recur+Memo
    private static int countWays(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countWaysUtil(m - 1, n - 1, dp);
    }

    private static int countWaysUtil(int i, int j, int[][] dp) {
        //base case
        if (i == 0 && j == 0) {
            return 1;//means we have reached destination
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = countWaysUtil(i - 1, j, dp);
        int left = countWaysUtil(i, j - 1, dp);
        return dp[i][j] = up + left;
    }*/

    /*//bottom up
    private static int countWays(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //base case
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }*/

    //space optimize
    private static int countWays(int m, int n) {
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            int temp[] = new int[n];
            for (int j = 0; j < n; j++) {

                //base case
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = prev[j];
                }
                if (j > 0) {
                    left = temp[j - 1];
                }
                temp[j] = up + left;
            }
            prev = temp;
        }

        return prev[n - 1];
    }

}
