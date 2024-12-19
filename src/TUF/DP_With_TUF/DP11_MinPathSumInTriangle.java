package TUF.DP_With_TUF;

public class DP11_MinPathSumInTriangle {
    public static void main(String[] args) {
        int triangle[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};

        int m = triangle.length;
        // Call the minimumPathSum function and print the result
        System.out.println(minimumPathSum(triangle, m));
    }

    //recur+memo
    /*private static int minimumPathSum(int[][] triangle, int m) {
        int[][] dp = new int[m][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // Call the utility function to find the minimum path sum starting from the top
        return minimumPathSumUtil(0, 0, triangle, m, dp);
    }

    private static int minimumPathSumUtil(int i, int j, int[][] triangle, int m, int[][] dp) {
        //base case
        if (i == m - 1) {
            return triangle[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, m, dp);
        int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, m, dp);
        return dp[i][j] = Leetcode.Math.min(down, diagonal);
    }*/

    /*//bottom up
    //As in recursion/memoization, we have moved from 0 to N-1,
    //in tabulation we move from N-1 to 0, i.e the last row to the first one.
    private static int minimumPathSum(int[][] triangle, int m) {
        int[][] dp = new int[m][m];

        //initialize last row since we are moving last to first
        for (int j = 0; j < m; j++) {
            dp[m - 1][j] = triangle[m - 1][j];
        }

        //second last to first row
        for (int i = m - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Leetcode.Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }*/

    //space optimize
    private static int minimumPathSum(int[][] triangle, int m) {
        int front[]=new int[m];// Stores the results for the current row
        int cur[]=new int[m];// Stores the results for the next row

        //initialize last row since we are moving last to first
        for (int j = 0; j < m; j++) {
            front[j] = triangle[m - 1][j];
        }

        //second last to first row
        for (int i = m - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];
                cur[j] = Math.min(down, diagonal);
            }
            front=cur.clone();
        }
        return front[0];
    }
}
