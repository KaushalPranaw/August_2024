package Array_String;

import java.util.Map;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(new TrappingRainWater().trap(height));
    }

    /*Consider arr[] = {3, 0, 2, 0, 4}

Therefore, left[] = {3, 3, 3, 3, 4} and right[] = {4, 4, 4, 4, 4}
Now consider iterating using i from 0 to end

For i = 0:
        => left[0] = 3, right[0] = 4 and arr[0] = 3
        => Water stored = min(left[0], right[0]) – arr[0] = min(3, 4) – 3 = 3 – 3 = 0
        => Total = 0 + 0 = 0

For i = 1:
        => left[1] = 3, right[1] = 4 and arr[1] = 0
        => Water stored = min(left[1], right[1]) – arr[1] = min(3, 4) – 0 = 3 – 0 = 3
        => Total = 0 + 3 = 3

For i = 2:
        => left[2] = 3, right[2] = 4 and arr[2] = 2
        => Water stored = min(left[2], right[2]) – arr[2] = min(3, 4) – 2 = 3 – 2 = 1
        => Total = 3 + 1 = 4

For i = 3:
        => left[3] = 3, right[3] = 4 and arr[3] = 0
        => Water stored = min(left[3], right[3]) – arr[3] = min(3, 4) – 0 = 3 – 0 = 3
        => Total = 4 + 3 = 7

For i = 4:
        => left[4] = 4, right[4] = 4 and arr[4] = 4
        => Water stored = min(left[4], right[4]) – arr[4] = min(4, 4) – 4 = 4 – 4 = 0
        => Total = 7 + 0 = 7

So total rain water trapped = 7*/
    /*public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
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

    }

}
