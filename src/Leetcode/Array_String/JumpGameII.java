package Leetcode.Array_String;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGameII().jump(nums));
    }

    //linear solution
    public int jump(int[] nums) {
        //initially we need 3 elements
        //minJumps jo ki humara output hoga mena kitne min jumps lgege last index pahuchne me
        //l aur r humari boundaries ko bata raha h
        // l means left boundary for particular index
        // r means right boundary for particular index
        // for nums[i]=3 to l=0 & r=3 to l se r tk kood skta h (range)
        int minJumps = 0, l = 0, r = 0;

        //jab tk r chota h last index se
        while (r < nums.length-1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            //update l & r
            l = r + 1;
            r = farthest;
            minJumps++;
        }
        return minJumps;
    }
    /*public int jump(int[] nums) {
        int jumps = 0, l = 0, r = 0;
        //l will be places a heaf of r
        //r will be placed farthest i can jump
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Leetcode.Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;

        }
        return jumps;
    }*/


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
                minimum = Leetcode.Math.min(minimum, jumps + 1);
            }
        }
        return memo[index] = minimum;
    }*/
}
