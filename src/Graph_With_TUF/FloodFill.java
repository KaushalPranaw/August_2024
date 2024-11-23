package Graph_With_TUF;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        // sr = 1, sc = 1, newColor = 2
        FloodFill obj = new FloodFill();
        int[][] ans = obj.floodFill(image, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        int[][] ans = image;

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};

        return dfsFlood(sr, sc, image, ans, delrow, delcol, newColor, initialColor);
    }

    private int[][] dfsFlood(int row, int col, int[][] image, int[][] ans,
                             int[] delrow, int[] delcol, int newColor, int initialColor) {
        ans[row][col] = newColor;
        int m = image.length;
        int n = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == initialColor && ans[nrow][ncol] != newColor) {
                dfsFlood(nrow, ncol, image, ans, delrow, delcol, newColor, initialColor);
            }
        }
        return ans;
    }
}
