package Leetcode.TwoPointers;

import java.util.Arrays;

public class MoveNegativeNumbersToBeginningAndPositiveToEnd {
    public static void main(String[] args) {
        int nums[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        new MoveNegativeNumbersToBeginningAndPositiveToEnd().moveNegativeNumbersToBeginningAndPositiveToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void moveNegativeNumbersToBeginningAndPositiveToEnd(int[] nums) {
        int n = nums.length;
        int negCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negCount++;
            }
        }

        int i = 0;
        int j = negCount;
        while (i < negCount && j < n) {
            if (nums[i] < 0) {
                i++;
            } else if (nums[j] > 0) {
                j++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
    }

}
