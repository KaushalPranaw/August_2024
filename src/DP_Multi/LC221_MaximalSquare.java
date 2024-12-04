package DP_Multi;

import java.util.Arrays;

public class LC221_MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        LC221_MaximalSquare obj = new LC221_MaximalSquare();

        System.out.println("Maximum square size is: " + obj.maximalSquare(matrix));
    }



    /*
    //recur+Memo
    int maxi = 0;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        maximalSquareUtil(matrix, 0, 0, dp);
        return maxi * maxi;
    }

    private int maximalSquareUtil(char[][] matrix, int i, int j, int[][] dp) {
        int m = matrix.length;
        int n = matrix[0].length;

        //base case
        if (i >= m || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = maximalSquareUtil(matrix, i, j + 1, dp);
        int diagonal = maximalSquareUtil(matrix, i + 1, j + 1, dp);
        int down = maximalSquareUtil(matrix, i + 1, j, dp);

        if (matrix[i][j] == '1') {

            int ans = 1 + Math.min(right, Math.min(diagonal, down));
            maxi = Math.max(maxi, ans);
            return dp[i][j] = ans;

        } else {
            return dp[i][j] = 0;
        }
    }*/

    /*//tab
    int maxi = 0;

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int right = dp[i][j + 1];
                int diagonal = dp[i + 1][j + 1];
                int down = dp[i + 1][j];

                if (matrix[i][j] == '1') {

                    int ans = 1 + Math.min(right, Math.min(diagonal, down));
                    maxi = Math.max(maxi, ans);
                    dp[i][j] = ans;

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxi * maxi;
    }*/

    //space optimized O(n*n) -> O(n)
    int maxi = 0;

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] cur=new int[n+1];
        int[] next=new int[n+1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int right = cur[j + 1];
                int diagonal = next[j + 1];
                int down = next[j];

                if (matrix[i][j] == '1') {

                    int ans = 1 + Math.min(right, Math.min(diagonal, down));
                    maxi = Math.max(maxi, ans);
                    cur[j] = ans;

                } else {
                    cur[j] = 0;
                }
            }
            // Swap cur and next arrays
            int[] temp = next;
            next = cur;
            cur = temp;
        }

        return maxi * maxi;
    }
}
