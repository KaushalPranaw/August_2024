package Leetcode.TwoPointers;

import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        //[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
        int[] nums = {-1, 0, 1, 2, -4, -2};
        System.out.println(new Sum3().threeSum(nums));
        System.out.println(new Sum3().threeSumUsingMap(nums));

    }

    //this hashmap soln might be wrong
    private List<List<Integer>> threeSumUsingMap(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            //a+b+c=0;
            //b+c=-1
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int rem = target - nums[j];
                if (map.containsKey(rem)) {
                    ans.add(Arrays.asList(nums[i], nums[j], rem));
                }
                map.put(nums[j], j);
            }
        }
        return ans;
    }

    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    /*public List<List<Integer>> threeSum(int[] nums) {
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

    }*/
}
