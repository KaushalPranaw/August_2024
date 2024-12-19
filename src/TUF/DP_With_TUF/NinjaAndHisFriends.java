package TUF.DP_With_TUF;

public class NinjaAndHisFriends {
    public static void main(String[] args) {
        int grid[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(maxChocolates(grid, m, n));
    }

    /*//recur+memo
    private static int maxChocolates(int[][] grid, int m, int n) {
        int[][][] dp = new int[m][n][n];
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        int i = 0, j1 = 0, j2 = m - 1;
        return maxChocolatesUtil(i, j1, j2, grid, m, n, dp);
    }

    private static int maxChocolatesUtil(int i, int j1, int j2, int[][] grid, int m, int n, int[][][] dp) {
        //base case
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= n) {
            return Integer.MIN_VALUE;
        }

        if (i == m - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        //other case
        //we have nine options
        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                if (j1 == j2) {
                    ans = grid[i][j1] + maxChocolatesUtil(i + 1, j1 + di, j2 + dj, grid, m, n, dp);
                } else {
                    ans = grid[i][j1] + grid[i][j2] + maxChocolatesUtil(i + 1, j1 + di, j2 + dj, grid, m, n, dp);
                }
                max = Leetcode.Math.max(max, ans);
            }
        }
        return dp[i][j1][j2] = max;
    }*/

    /*//bottom up
    private static int maxChocolates(int[][] grid, int m, int n) {
        int[][][] dp = new int[m][n][n];

        //last row condition
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        //other row means m-2 to 0
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int max = Integer.MIN_VALUE;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2) {
                                ans = grid[i][j1];
                            } else {
                                ans = grid[i][j1] + grid[i][j2];
                            }
                            // Check if the indices are valid
                            if ((j1 + di) < 0 || (j1 + di) >= m || (j2 + dj) < 0 || (j2 + dj) >= m) {
                                ans += Integer.MIN_VALUE;
                            } else {
                                ans += dp[i + 1][j1 + di][j2 + dj];
                            }
                            max = Leetcode.Math.max(max, ans);
                        }
                    }
                    // Store the result in the dp array
                    dp[i][j1][j2] = max;

                }
            }
        }
        return dp[0][0][n - 1];
    }*/

    //space optimize
    private static int maxChocolates(int[][] grid, int m, int n) {
        int[][] front = new int[n][n];
        int[][] cur = new int[n][n];

        //last row condition
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    front[j1][j2] = grid[m - 1][j1];
                } else {
                    front[j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        //other row means m-2 to 0
        for (int i = m - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int max = Integer.MIN_VALUE;

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2) {
                                ans = grid[i][j1];
                            } else {
                                ans = grid[i][j1] + grid[i][j2];
                            }
                            // Check if the indices are valid
                            if ((j1 + di) < 0 || (j1 + di) >= m || (j2 + dj) < 0 || (j2 + dj) >= m) {
                                ans += Integer.MIN_VALUE;
                            } else {
                                ans += front[j1 + di][j2 + dj];
                            }
                            max = Math.max(max, ans);
                        }
                    }
                    // Store the result in the dp array
                    cur[j1][j2] = max;

                }
            }
            for (int a = 0; a < n; a++) {
                front[a] = cur[a].clone();
            }
        }
        return front[0][n - 1];
    }
}
