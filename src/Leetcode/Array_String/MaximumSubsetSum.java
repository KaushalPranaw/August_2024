package Leetcode.Array_String;

import java.util.List;

public class MaximumSubsetSum {
    public static void main(String[] args) {
        // Test the function with an example list
        List<Integer> arr = List.of(-2, 1, 3, -4, 5);

        // Output the maximum subset sum of non-adjacent elements
        System.out.println("The maximum subset sum is: " + maxSubsetSum(arr));  // Output: 8
    }

    private static int maxSubsetSum(List<Integer> list) {
        if (list.isEmpty() || list == null) {
            return 0;
        }

        if (list.size() == 1)
            return list.get(0);

        // Initialize the first two base cases
        int valueMinus1 = 0;
        int valueMinus2 = 0;
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= 0) {
                valueMinus1 = Math.max(valueMinus1, valueMinus2);
                valueMinus2 = Math.max(valueMinus1, valueMinus2);
            } else {
                max = Math.max(valueMinus1, valueMinus2 + list.get(i));
                valueMinus2 = valueMinus1;
                valueMinus1 = max;
            }
        }
        return max;

    }
}
