package TUF.Graph_With_TUF;

import java.util.*;

public class TopologicalDFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }


        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);


        new TopologicalDFS().topoSort(6, adj);
    }

    private void topoSort(int N, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[N];

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, stack);
            }
        }

        int topo[] = new int[N];
        int index = 0;
        while (!stack.isEmpty()) {
            topo[index++] = stack.pop();
        }
        System.out.println(Arrays.toString(topo));
    }

    private void dfs(int node, int[] visited, List<List<Integer>> adj, Stack<Integer> stack) {
        visited[node] = 1;
        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, visited, adj, stack);
            }
        }
        stack.push(node);
    }
}
