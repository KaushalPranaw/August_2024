package Graph_With_TUF;

import java.util.ArrayList;
import java.util.List;

public class DfsGraph {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(1).add(5);
        adj.get(2).add(4);
        adj.get(2).add(1);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(4).add(2);
        adj.get(5).add(1);
        List<Integer> ans = dfsOfGraph(5, adj);
        System.out.println(ans);

    }

    private static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V+1];

        //If you are starting from node 2, then i should start from 2.
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, ans);
            }
        }
        return ans;

    }

    private static void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> ans) {
        ans.add(node);
        visited[node] = true;

        for (int neighboour : adj.get(node)) {
            if (!visited[neighboour]) {
                dfs(neighboour, visited, adj, ans);
            }
        }
    }
}
