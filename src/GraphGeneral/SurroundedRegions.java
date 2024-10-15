package GraphGeneral;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        System.out.println("Original Board:");
        printBoard(board);

        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(board);

        System.out.println("Board After Solving:");
        printBoard(board);

    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(row);
        }
        System.out.println();
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int visited[][] = new int[rows][cols];

        //Traverse for first row and last row
        for (int col = 0; col < cols; col++) {
            //first row
            if (visited[0][col] == 0 && board[0][col] == 'O') {
                dfs(0, col, visited, board, rows, cols);
            }

            //last row
            if (visited[rows - 1][col] == 0 && board[rows - 1][col] == 'O') {
                dfs(rows - 1, col, visited, board, rows, cols);
            }
        }

        //Traverse for first col and last col
        for (int row = 0; row < rows; row++) {
            //first col
            if (visited[row][0] == 0 && board[row][0] == 'O') {
                dfs(row, 0, visited, board, rows, cols);
            }

            //last col
            if (visited[row][cols - 1] == 0 && board[row][cols - 1] == 'O') {
                dfs(row, cols - 1, visited, board, rows, cols);
            }
        }

        //for remaining unvisited element mark 'O' with X
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col] == 0 && board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

    }

    private void dfs(int row, int col, int[][] visited, char[][] board, int rows, int cols) {
        visited[row][col] = 1;
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, 1, 0, -1};
        //check for top bottom left right
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols
                    && visited[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, visited, board, rows, cols);
            }
        }

    }
}
