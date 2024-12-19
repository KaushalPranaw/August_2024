package Leetcode.Array_String;

import java.util.Arrays;

/*@author KaushalPranaw*/
public class RemoveDuplicatesfromSortedArrayII {
    /*Given an integer array nums sorted in non-decreasing order,
    remove some duplicates in-place such that each unique element appears at most twice.
    The relative order of the elements should be kept the same.*/
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new RemoveDuplicatesfromSortedArrayII().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    /*public int removeDuplicates(int[] nums) {
        int i=0;
        for(int num: nums){
            if(i<2 || nums[i-2]<num){
                nums[i]=num;
                i++;
            }
        }
        return i;
    }*/
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || nums[i - 2] < num) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}
