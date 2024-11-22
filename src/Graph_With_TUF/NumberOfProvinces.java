package Graph_With_TUF;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        // Example graph (adjacency matrix)
        int[][] isConnected = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        System.out.println("Number of Provinces: " + new NumberOfProvinces().numProvinces(isConnected));
    }

    private int numProvinces(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();

        // Convert the adjacency matrix to adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        int count = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfsGraph(i, visited, adjList);
                count++;
            }
        }
        return count;

    }

    private void dfsGraph(int node, int[] visited, List<List<Integer>> adjList) {
        visited[node] = 1;

        for (int neighbour : adjList.get(node)) {
            if (visited[neighbour] == 0) {
                dfsGraph(neighbour, visited, adjList);
            }
        }
    }
}
