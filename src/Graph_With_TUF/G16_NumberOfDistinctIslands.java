package Graph_With_TUF;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G16_NumberOfDistinctIslands {
    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        G16_NumberOfDistinctIslands ob = new G16_NumberOfDistinctIslands();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }

    private int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<List<String>> set = new HashSet<>();
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    List<String> list = new ArrayList<>();
                    dfsUnique(i, j, visited, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private void dfsUnique(int row, int col, int[][] visited, int[][] grid, List<String> list, int row0, int col0) {
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = 1;
        list.add((row - row0) + " " + (col - col0));
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nr = row + delrow[i];
            int nc = col + delcol[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && visited[nr][nc] == 0 && grid[nr][nc] == 1) {
                dfsUnique(nr, nc, visited, grid, list, row0, col0);
            }
        }
    }
}
