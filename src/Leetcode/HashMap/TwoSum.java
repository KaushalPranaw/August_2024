package Leetcode.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remender = target - nums[i];
            if (numberToIndex.containsKey(remender)) {
                if (numberToIndex.get(remender) == i)
                    continue;
                else
                    return new int[]{numberToIndex.get(remender), i};
            } else
                numberToIndex.put(nums[i], i);

        }
        return new int[]{};
    }
}
