package Leetcode.Matrix;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

    }
    //constant space
    /*public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;

        // Check if the first row needs to be zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        // Check if the first column needs to be zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        // Use the first row and column to mark zero rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out cells based on marks in the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (isFirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (isFirstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }*/

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return;

        boolean isFirstRow = false;
        boolean isFirstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                isFirstRow = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstCol = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isFirstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
