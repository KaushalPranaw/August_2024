package Array_String;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    private int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
    /*public int removeDuplicates(int[] nums) {
        int unique=0;
        for(int i=1;i<nums.length;i++){
            if(nums[unique]!=nums[i]){
                unique++;
                nums[unique]=nums[i];
            }
        }
        //returning total unique elements
        return unique+1;

    }*/
}
