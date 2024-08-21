package Matrix;

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
        List<Integer> ans = new ArrayList<>();

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;

        while (top <= bottom && left <= right) {
            //left to right - (top is constant)
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            //top to bottom - (right is constant)
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                //right to left - (bottom is constant)
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }


            if (left <= right) {
                //bottom to top - (left is constant)
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }
        return ans;


    }

}
