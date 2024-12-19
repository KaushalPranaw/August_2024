package Leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
            } else {
                int diff = Math.abs(map.get(num) - i);
                if (diff <= k) {
                    return true;
                } else {
                    map.put(num, i);
                }
            }
        }
        return true;
    }
}
