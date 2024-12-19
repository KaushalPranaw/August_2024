package TUF.DP_With_TUF;

public class Fibonacci {
    //Using recur+memo
    /*public static void main(String[] args) {
        int n = 5;
        //Step 0: initialize dp
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(getFibonacci(n, dp));
    }

    private static int getFibonacci(int n, int[] dp) {
        if (n <= 1)
            return n;

        //Step 2: check after base case if value is already computed, then directly return
        if (dp[n] != -1)
            return dp[n];

        // Step 1: whatever is computed store them in dp
        return dp[n] = getFibonacci(n - 1, dp) + getFibonacci(n - 2, dp);
    }*/

    //using bottom up (tabulation)
    /*public static void main(String[] args) {
        int n = 5;

        //Step 0: initialize dp
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(getFibonacci_using_BottomUp(n, dp));

    }

    private static int getFibonacci_using_BottomUp(int n, int[] dp) {
        //base case
        dp[0] = 0;
        dp[1] = 1;

        //if value is greater than 1
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }*/

    //Using constant space
    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFibonacci_using_BottomUp(n));
    }

    private static int getFibonacci_using_BottomUp(int n) {
        //base case
        int prevOfPrev = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int cur_i = prev + prevOfPrev;
            prevOfPrev = prev;
            prev = cur_i;
        }

        return prev;
    }
}
