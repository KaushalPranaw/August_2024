package TUF.Graph_With_TUF;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };

        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    private int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        int count = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (visited[row][col] == 0 && grid[row][col] == '1') {
                    bfs(row, col, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, int[][] visited, char[][] grid) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = 1;

        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            // traverse in the neighbours and mark them if its a land
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nRow = pair.row + delrow;
                    int nCol = pair.col + delcol;

                    // check if neighbour row and column is valid, and is an unvisited land
                    if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n
                            && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                        queue.add(new Pair(nRow, nCol));
                        visited[nRow][nCol] = 1;
                    }
                }
            }
        }

    }

    record Pair(int row, int col) {
    }
}
