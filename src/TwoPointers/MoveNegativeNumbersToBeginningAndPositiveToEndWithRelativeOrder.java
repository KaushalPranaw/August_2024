package TwoPointers;

import java.util.Arrays;

public class MoveNegativeNumbersToBeginningAndPositiveToEndWithRelativeOrder {
    public static void main(String[] args) {
        int nums[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        new MoveNegativeNumbersToBeginningAndPositiveToEndWithRelativeOrder().rearrange(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void rearrange(int[] nums) {
        int n = nums.length;
        int negativeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                if (i != negativeIndex) {
                    int temp = nums[i];
                    nums[i] = nums[negativeIndex];
                    nums[negativeIndex] = temp;
                }
                negativeIndex++;
            }
        }
    }

}
