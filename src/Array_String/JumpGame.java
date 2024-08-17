package Array_String;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGame().canJump(nums));

    }

    //tricky solution: linear solution
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;
        for (int i = 0; i < n; i++) {
            if (maxReachable == n - 1)
                return true;
            if (i > maxReachable)
                return false;
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }

    //bottom up
    /*private boolean canJump(int[] nums) {
        //define state
        //dp[i]==true means we can reach to index of i
        //dp[i]==false means we can not reach to index of i

        //ab check kr lege for dp[i] koi banda hume waha tk phucha skta h ya ni
        //we can check this thing using prev element
        //means j=i-1 we can assume and j can move to till j=0 means j will lie between 0 to i-1
        //if(j+nums[j]>=i)
        //0+2 >= 1 means we can reach to dp[i] ko true kr dege

        //so we are doing basically
        // if(dp[j]==true and j+nums[j]>=i)
        //    dp[i]=true; break;
        //so for n=5 we will check dp[n-1] if true to return kr dege

        int n = nums.length;
        boolean[] dp = new boolean[n];
        //dp[i]==true; means mai i tk pahuch skta hu
        //dp[i]==false: means ni pahuch skta hu
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == true && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }*/

    //recur+Memo
    /*boolean dp[];

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int idx = 0;
        dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        return solve(nums, idx, n, dp);
    }

    private boolean solve(int[] nums, int idx, int n, boolean[] dp) {
        if (idx == n - 1)
            return true;
        if (dp[idx])
            return dp[idx];
        for (int i = 1; i <= nums[idx]; i++) {
            if (solve(nums, idx + i, n, dp))
                return dp[idx] = true;
        }
        return dp[idx] = false;
    }*/


}
