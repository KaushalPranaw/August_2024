package Graph_With_TUF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsOfGraph {
    public static void main(String[] args) {
        int V = 5;// no of vertices
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 2, 4);

        BfsOfGraph obj = new BfsOfGraph();

        System.out.println(obj.bfsOfGraph(V, adjList));
    }

    private List<Integer> bfsOfGraph(int V, List<List<Integer>> adjList) {
        List<Integer> bfs = new ArrayList<>();

        //visited array
        boolean[] visited = new boolean[V];

        //create queue
        Queue<Integer> queue = new LinkedList<>();

        //jb add kro to mark visited
        queue.add(0);//assuming starting point
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);

            for (int neighbour : adjList.get(node)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return bfs;
    }

    private static void addEdge(List<List<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
