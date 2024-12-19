package Leetcode.Array_String;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(new RemoveElement().removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    private int removeElement(int[] nums, int val) {
        int nonEqualIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[nonEqualIndex]=nums[i];
                nonEqualIndex++;
            }
        }
        return nonEqualIndex;
    }
}
