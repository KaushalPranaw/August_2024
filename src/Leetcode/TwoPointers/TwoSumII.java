package Leetcode.TwoPointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        /*int[] numbers = {2, 7, 11, 15};
        int target = 9;*/
        int[] numbers = {2,3,4};
        int target = 6;
        System.out.println(Arrays.toString(new TwoSumII().twoSum(numbers, target)));
    }

    private int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
    /*

    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;

    }*/
}
