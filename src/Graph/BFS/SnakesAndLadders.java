package Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public static void main(String[] args) {
        // Example board configuration
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {14, -1, -1, -1, -1, -1},
                {-1, -1, -1, 25, -1, -1}
        };

        // Create an instance of SnakesAndLadders
        SnakesAndLadders game = new SnakesAndLadders();

        // Calculate the minimum number of moves to reach the end
        int result = game.snakesAndLadders(board);

        // Print the result
        System.out.println("Minimum number of moves to reach the end: " + result);
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean visited[][] = new boolean[n][n];
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[n - 1][0] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                if (x == n * n)
                    return steps;

                for (int k = 1; k <= 6; k++) {
                    if (x + k > n * n) {
                        break;
                    }
                    int pos[] = findCoordinates(x + k, n);
                    int r = pos[0];
                    int c = pos[1];
                    if (visited[r][c])
                        continue;
                    visited[r][c] = true;
                    if (board[r][c] == -1) {
                        queue.add(x + k);
                    } else {
                        queue.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private int[] findCoordinates(int cur, int n) {
        int r = n - ((cur - 1) / n) - 1;
        int c = (cur - 1) % n;
        if (r % 2 == n % 2) {
            return new int[]{r, n - 1 - c};
        } else {
            return new int[]{r, c};
        }

    }
}
