package TUF.Graph_With_TUF;

import java.util.LinkedList;
import java.util.Queue;

public class G10_RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};

        G10_RottenOranges obj = new G10_RottenOranges();
        int ans = obj.orangesRotting(grid);
        System.out.println(ans);
    }

    private int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int visited[][] = new int[m][n];
        int countFresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int count = 0;
        int time = 0;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};

        while (!queue.isEmpty()) {
            int tm = queue.peek().tm;
            int r = queue.peek().row;
            int c = queue.peek().col;

            time = Math.max(time, tm);
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol, tm + 1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if (countFresh != count) {
            return -1;
        }
        return time;

    }

}

class Pair {
    int row, col, tm;

    public Pair(int r, int c, int tm) {
        this.row = r;
        this.col = c;
        this.tm = tm;
    }
}