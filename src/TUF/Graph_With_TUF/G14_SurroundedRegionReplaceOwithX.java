package TUF.Graph_With_TUF;

public class G14_SurroundedRegionReplaceOwithX {
    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        // m = 5, n = 4
        char[][] ans = new G14_SurroundedRegionReplaceOwithX().fill(5, 4, mat);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char[][] fill(int m, int n, char[][] mat) {
        int visited[][] = new int[m][n];

        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        //check for first and last row
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 'O' && visited[0][j] == 0) {
                dfsMat(0, j, visited, mat, delrow, delcol);
            }

            if (mat[m - 1][j] == 'O' && visited[m - 1][j] == 0) {
                dfsMat(m - 1, j, visited, mat, delrow, delcol);
            }
        }

        //check for first and last col
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 'O' && visited[i][0] == 0) {
                dfsMat(i, 0, visited, mat, delrow, delcol);
            }

            if (mat[i][n - 1] == 'O' && visited[i][n - 1] == 0) {
                dfsMat(i, n - 1, visited, mat, delrow, delcol);
            }
        }

        //unvisited Os replace with X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'O' && visited[i][j] == 0) {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;

    }

    private void dfsMat(int row, int col, int[][] visited, char[][] mat, int[] delrow, int[] delcol) {
        visited[row][col] = 1;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                    && visited[nrow][ncol] == 0 && mat[nrow][ncol] == 'O')
                dfsMat(nrow, ncol, visited, mat, delrow, delcol);
        }
    }
}
