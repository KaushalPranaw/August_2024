package Leetcode.Array_String;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {2, 1, 5, 3, 1, 0, 4};
        System.out.println(new TrappingRainWater().trap(height));
    }

    //brute force
    //for each element check left bar and right bar
    //then min (left, right) then
    //difference between smaller and height of current bar
    /*private int trap(int[] height) {
        int n = height.length;
        int trap = 0;
        for (int i = 1; i < n; i++) {
            int left = height[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            int right = height[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, height[j]);
            }
            int cur = Math.min(left, right) - height[i];
            trap += cur;
        }
        return trap;
    }*/

    //using left and right array
    /*public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Leetcode.Math.max(left[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Leetcode.Math.max(right[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Leetcode.Math.min(left[i], right[i]) - height[i];
        }
        return water;
    }*/

    /*Consider ar[] = {3, 0, 2, 0, 4}
left = 0, right = 4, l_max = 0, r_max = 0.

left = 0, right = 4:
        => l_max = r_max.
        => water added = 0
        => r_max = 4, l_max = 0
        => right = 3, left = 0

left = 0, right = 3:
        => l_max < r_max.
        => water added = 0
        => r_max = 4, l_max = 3
        => right = 3, left = 1

left = 1, right = 3:
        => l_max < r_max.
        => water added = 3 – 0 = 3
        => r_max = 4, l_max = 3
        => right = 3, left = 2
        => Water trapped = 0 + 3 = 3

left = 2, right = 3:
        => l_max < r_max.
        => water added = 3 – 2 = 1
        => r_max = 4, l_max = 3
        => right = 3, left = 2
        => Water trapped = 3 + 1 = 4

left = 3, right = 3:
        => l_max < r_max.
        => water added = 3 – 0 = 3
        => r_max = 4, l_max = 3
        => right = 3, left = 4
        => Water trapped = 4 + 3 = 7

So total water trapped = 7*/
    public int trap(int[] height) {
        int n = height.length;
        int trap = 0;
        int left = 0, right = n - 1;
        int left_max = height[left], right_max = height[right];
        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
                left_max = Math.max(left_max, height[left]);
                trap += left_max - height[left];
            } else {
                right--;
                right_max = Math.max(right_max, height[right]);
                trap += right_max - height[right];
            }
        }
        return trap;
    }









    /*public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = height[0], rightMax = height[n - 1];
        int water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];

            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;

    }*/

}
