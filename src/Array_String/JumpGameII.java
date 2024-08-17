package Array_String;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGameII().jump(nums));
    }

    //linear solution
    public int jump(int[] nums) {
        int jumps = 0, l = 0, r = 0;
        //l will be places a heaf of r
        //r will be placed farthest i can jump
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;

        }
        return jumps;
    }


    //recursion + memo
    /*public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0, memo);
    }

    int helper(int[] nums, int index, int[] memo) {
        if (index >= nums.length - 1)
            return 0;

        if (memo[index] != -1) {
            return memo[index];
        }

        int minimum = Integer.MAX_VALUE;
        int maxJump = nums[index];

        for (int i = 1; i <= maxJump; i++) {
            int jumps = helper(nums, index + i, memo);
            if (jumps != Integer.MAX_VALUE) {
                minimum = Math.min(minimum, jumps + 1);
            }
        }
        return memo[index] = minimum;
    }*/
}
