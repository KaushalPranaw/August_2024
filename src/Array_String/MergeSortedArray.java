package Array_String;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        //for remaining element in num2 if any
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

    }*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while (i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k--]=nums1[i--];
            }else {
                nums1[k--]=nums2[j--];
            }
        }

        while (j>=0){
            nums1[k--]=nums2[j--];
        }

    }
}
