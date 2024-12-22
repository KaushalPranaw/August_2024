package Leetcode.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        List<Integer> ans = new ArrayList<>();

        while (left <= right && top <= bottom) {
            //l->r
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            //top->bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;


    }

}
