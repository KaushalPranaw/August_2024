package TUF.DP_With_TUF;

public class DP25_LongestCommonSubsequence {
    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
    }
/*
    //recur+memo
    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m][n];
        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        return lcsUtil(s1, s2, m - 1, n - 1, dp);
    }

    private static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        //base case
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        // If the result for this subproblem has already been calculated, return it
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcsUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
        } else {
            return dp[ind1][ind2] = Leetcode.Math.max(lcsUtil(s1, s2, ind1 - 1, ind2, dp),
                    lcsUtil(s1, s2, ind1, ind2 - 1, dp));
        }
    }*/

/*
    //tabulation
    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        //base case
        //since ind1 & ind2 can't be negative so we will shift here
        //ind1==0 || ind2==0 then return 0
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= m; ind1++) {
            for (int ind2 = 1; ind2 <= n; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Leetcode.Math.max(dp[ind1][ind2 - 1], dp[ind1 - 1][ind2]);
                }
            }
        }

        return dp[m][n];
    }*/


    //space
    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] prev = new int[n + 1];

        for (int ind1 = 1; ind1 <= m; ind1++) {
            int[] cur = new int[n + 1];
            for (int ind2 = 1; ind2 <= n; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    cur[ind2] = 1 + prev[ind2 - 1];
                } else {
                    cur[ind2] = Math.max(cur[ind2 - 1], prev[ind2]);
                }
            }
            prev=cur;
        }

        return prev[n];
    }
}
