package TUF.DP_With_TUF;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new ClimbingStairs().climbStairs(n));

    }

    //using recu+memo
    /*public int climbStairs(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        if (n == 0)
            return 1;//means already in bottom

        if (n == 1)
            return 1;// means in 0->1 going so one possible sol is here

        if (dp[n] != -1) {
            return dp[n];
        }

        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);
        return dp[n] = (left + right);
    }*/

    //using bottom up
    /*public int climbStairs(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 1;//means already in bottom
        dp[1] = 1;// means in 0->1 going so one possible sol is here

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }*/

    //using constant space
    public int climbStairs(int n) {

        int prev2 = 1;//means already in bottom
        int prev = 1;// means in 0->1 going so one possible sol is here

        for (int i = 2; i <= n; i++) {
            int cur_i = prev + prev2;
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
}
