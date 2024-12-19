package Leetcode.TwoPointers;

import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        //[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Sum3().threeSum(nums));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3)
            return new ArrayList<>(set);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }


        }
        return new ArrayList<>(set);

    }
}
