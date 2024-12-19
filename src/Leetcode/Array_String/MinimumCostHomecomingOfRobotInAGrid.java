package Leetcode.Array_String;

public class MinimumCostHomecomingOfRobotInAGrid {
    public static void main(String[] args) {
        int[] startPos = {1, 0};
        int[] homePos = {2, 3};
        int[] rowCosts = {15, 4, 3};
        int[] colCosts = {8, 2, 6, 7};
        System.out.println(new MinimumCostHomecomingOfRobotInAGrid().minCost(startPos, homePos, rowCosts, colCosts));

    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans = 0;
        //talking about row
        if (homePos[0] >= startPos[0]) {
            for (int i = startPos[0] + 1; i <= homePos[0]; i++) {
                ans += rowCosts[i];
            }
        } else {
            for (int i = startPos[0] - 1; i >= homePos[0]; i--) {
                ans += rowCosts[i];
            }
        }

        //check for column now
        if (homePos[1] >= startPos[1]) {
            for (int i = startPos[1] + 1; i <= homePos[1]; i++) {
                ans += colCosts[i];
            }

        } else {
            for (int i = startPos[1] - 1; i >= homePos[1]; i--) {
                ans += colCosts[i];
            }
        }
        return ans;

    }
}
