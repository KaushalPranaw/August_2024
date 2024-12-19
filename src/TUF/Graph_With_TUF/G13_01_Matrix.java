package TUF.Graph_With_TUF;

import java.util.LinkedList;
import java.util.Queue;

public class G13_01_Matrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        G13_01_Matrix obj = new G13_01_Matrix();
        int[][] ans = obj.nearest(grid);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int[m][n];
        int distance[][] = new int[m][n];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0;
                }
            }
        }

        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int r = queue.peek().r;
            int c = queue.peek().c;
            int steps = queue.peek().step;
            queue.poll();
            distance[r][c] = steps;

            for (int i = 0; i < 4; i++) {
                int nr = r + delrow[i];
                int nc = c + delcol[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    queue.add(new Node(nr, nc, steps + 1));
                }
            }
        }
        return distance;
    }
}

class Node {
    int r, c, step;

    public Node(int r, int c, int step) {
        this.r = r;
        this.c = c;
        this.step = step;
    }
}
