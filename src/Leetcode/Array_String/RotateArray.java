package Leetcode.Array_String;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        new RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }

    private void rotate(int[] nums, int k) {
        //if k >nums.length
        k = k % nums.length;

        //check if size is 1
        if (nums.length == 1 || k == 0)
            return;

        //reverse all elements
        reverse(nums, 0, nums.length-1);

        //reverse k elements
        reverse(nums, 0, k-1);

        //reverse n-k elements
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }

    /*public void rotate(int[] nums, int k) {
        // Handle cases where k is larger than array length
        k = k % nums.length;

        // No need to rotate if k is 0 or array length is 1
        if (k == 0 || nums.length == 1) {
            return;
        }

        //reverse all element
        int left = 0, right = nums.length - 1;
        reverse(nums, left, right);

        //reverse k elements
        left = 0;
        right = k-1;
        reverse(nums, left, right);

        //reverse remaining n-k elements
        left = k;
        right = nums.length - 1;
        reverse(nums, left, right);
    }

    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }*/
}
