package Graph_With_TUF;

import java.util.*;

public class TopologicalBFS {
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


        System.out.println(new TopologicalBFS().isCyclic(6, adj));
    }

    private boolean isCyclic(int N, List<List<Integer>> adj) {
        int[] topo = new int[N];
        int[] indegree = new int[N];

        //find indegree
        for (int i = 0; i < N; i++) {
            for (int neightbour : adj.get(i)) {
                indegree[neightbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int index = 0, count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[index++] = node;
            count++;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        System.out.println(Arrays.toString(topo));
        if (count == N)
            return false;
        else return true;
    }
}
