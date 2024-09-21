package TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            int lh = height[left];
            int rh = height[right];
            int minHeight = Math.min(lh, rh);
            int area = minHeight * (right - left);
            maxArea = Math.max(maxArea, area);

            if (lh < rh) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }
}
