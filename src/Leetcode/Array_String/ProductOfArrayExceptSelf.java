package Leetcode.Array_String;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));
    }


    //constant space solution
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        //iterate left->right
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            //result[i] will hold the result of result[i-1]
            result[i] = result[i - 1] * nums[i - 1];
        }

        //right pass
        int right_product = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right_product;
            //update right product
            right_product = right_product * nums[i];
        }
        return result;

    }

    /*//using left and right elements
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int result[] = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];

        }
        return result;
    }*/

    //using division
    /*public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int count_zero = 0;
        int product_without_zero = 1;
        int result[] = new int[n];

        for (int num : nums) {
            if (num == 0)
                count_zero++;
            else
                product_without_zero *= num;
        }

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num != 0) {
                if (count_zero > 0) {
                    result[i] = 0;
                } else {
                    result[i] = product_without_zero / num;
                }
            } else { //num==0
                if (count_zero > 1) {//to check more than 1 zeros
                    result[i] = 0;
                } else {
                    result[i] = product_without_zero;
                }
            }
        }
        return result;
    }*/

}
