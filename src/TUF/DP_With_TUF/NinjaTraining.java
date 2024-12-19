package TUF.DP_With_TUF;

public class NinjaTraining {
    public static void main(String[] args) {
        /*Problem Statement: A Ninja has an ‘N’ Day training schedule.
        He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day.
        There are merit points associated with performing an activity each day.
        The same activity can’t be performed on two consecutive days.
        We need to find the maximum merit points the ninja can attain in N Days.*/

        // Define the points for each activity on each day
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points));
    }

    //Recur+memorization
    /*private static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(n - 1, 3, points, dp);
    }

    private static int f(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) {
            return dp[day][last];
        }
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task <= 2; task++) {
                if (task != last) {
                    maxi = Leetcode.Math.max(maxi, points[0][task]);
                }
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != last) {
                int point = points[day][task] + f(day - 1, task, points, dp);
                maxi = Leetcode.Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }*/

    /*//tabulation
    private static int ninjaTraining(int n, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[n][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Leetcode.Math.max(points[0][1], points[0][2]);
        dp[0][1] = Leetcode.Math.max(points[0][0], points[0][2]);
        dp[0][2] = Leetcode.Math.max(points[0][0], points[0][1]);
        dp[0][3] = Leetcode.Math.max(points[0][0], Leetcode.Math.max(points[0][1], points[0][2]));

        //iterate for day>0
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int maxi = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        maxi = Leetcode.Math.max(maxi, point);
                    }
                }
                dp[day][last] = maxi;
            }
        }

        return dp[n - 1][3];
    }*/

    //tabulation
    private static int ninjaTraining(int n, int[][] points) {
        int[] prev = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        //iterate for day>0
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                int maxi = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        maxi = Math.max(maxi, point);
                    }
                }
                temp[last] = maxi;
            }
            prev = temp;
        }

        return prev[3];
    }
}
