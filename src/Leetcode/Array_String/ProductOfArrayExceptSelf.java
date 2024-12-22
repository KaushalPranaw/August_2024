package Leetcode.Array_String;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));
    }

    private int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int cur = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i] * cur;
            cur = cur * nums[i];
        }

        cur = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * cur;
            cur = cur * nums[i];
        }
        return ans;
    }


}
