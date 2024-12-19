package TUF.DP_With_TUF;

public class DP24_RodCuttingProblem {
    public static void main(String args[]) {
        int N = 8; // Total rod length
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20}; // Prices for lengths 1 to N

        System.out.println("Maximum revenue: " + rodCutting(N, price));
    }
/*
    //recur+memo
    private static int rodCutting(int length, int[] price) {
        int n = price.length;
        int dp[][]=new int[n][length+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return rodCuttingUtil(n - 1, length, price, dp);
    }

    private static int rodCuttingUtil(int ind, int length, int[] price, int[][] dp) {
        //base case
        if (ind == 0) {
            return length * price[0];
        }
        if(dp[ind][length]!=-1){
            return dp[ind][length];
        }

        int not_take = rodCuttingUtil(ind - 1, length, price, dp);

        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= length) {
            take = price[ind] + rodCuttingUtil(ind, length - rodLength, price, dp);
        }
        return dp[ind][length]=Leetcode.Math.max(take, not_take);
    }*/


    /*
    //tab
    private static int rodCutting(int N, int[] price) {
        int n = price.length;
        int dp[][] = new int[n][N + 1];

        //base case
        for (int i = 0; i <= N; i++) {
            dp[0][i] = i * price[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int length = 0; length <= N; length++) {
                int not_take = dp[ind - 1][length];

                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= length) {
                    take = price[ind] + dp[ind][length - rodLength];
                }
                dp[ind][length] = Leetcode.Math.max(take, not_take);
            }
        }

        return dp[n - 1][N];
    }*/

    //space
    private static int rodCutting(int N, int[] price) {
        int n = price.length;
        int prev[] = new int[N + 1];

        //base case
        for (int i = 0; i <= N; i++) {
            prev[i] = i * price[0];
        }

        for (int ind = 1; ind < n; ind++) {
            int cur[] = new int[N + 1];
            for (int length = 0; length <= N; length++) {
                int not_take = prev[length];

                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= length) {
                    take = price[ind] + cur[length - rodLength];
                }
                cur[length] = Math.max(take, not_take);
            }
            prev = cur;
        }

        return prev[N];
    }
}
