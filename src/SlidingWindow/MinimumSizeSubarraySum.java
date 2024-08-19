package SlidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(target, nums));

    }

    //algo
    //left =0, right=0
    //left with 1 size window from extreme left
    //increment right till u achieve target specified in
    //once u achieve the target by minimizing window
    //keep increasing right till you get (sum>=target)
    //then update minLen
    //and try to increase left pointer if check sum>=target
    //this way we can find minimum length
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
