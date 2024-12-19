package Leetcode.Graph.General;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands islandCounter = new NumberOfIslands();

        // Sample grid
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'}
        };

        int numberOfIslands = islandCounter.numIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);

    }

    private int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }

    /*public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];

        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && visited[row][col] == 0) {
                    count++;
                    bfs(row, col, visited, grid, rows, cols);
                }

            }
        }
        return count;
    }

    private void bfs(int row, int col, int[][] visited, char[][] grid, int rows, int cols) {
        Queue<Pair> queue = new Leetcode.LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = 1;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int first = current.first;
            int second = current.second;

            //found neighbours
            *//*for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = first + delrow;
                    int ncol = second + delcol;

                    if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols
                            && grid[nrow][ncol] == '1'
                            && visited[nrow][ncol] == 0) {
                        visited[nrow][ncol] = 1;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }*//*

            //but in questions it is not considering diagonally
            //so delrow and delcol will be change little bit
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            //found neighbours
            for (int i = 0; i < directions.length; i++) {
                int nrow = first + directions[i][0];
                int ncol = second + directions[i][1];

                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols
                        && grid[nrow][ncol] == '1'
                        && visited[nrow][ncol] == 0) {
                    visited[nrow][ncol] = 1;
                    queue.add(new Pair(nrow, ncol));
                }
            }

        }

    }

    class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }*/
}
