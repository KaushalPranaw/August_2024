package TUF.Graph_With_TUF;

import java.util.LinkedList;
import java.util.Queue;

public class G15_NumberOfEnclaves {
    public static void main(String[] args) {
        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        int ans = new G15_NumberOfEnclaves().numberOfEnclaves(grid);
        System.out.println(ans);
    }

    private int numberOfEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];

        Queue<Pairs> queue = new LinkedList<>();
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pairs(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.peek().first();
            int col = queue.peek().second();

            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nr = row + delrow[i];
                int nc = col + delcol[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                    queue.add(new Pairs(nr, nc));
                    visited[nr][nc] = 1;
                }
            }
        }
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

record Pairs(
        int first,
        int second

) {
}
