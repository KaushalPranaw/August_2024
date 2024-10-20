package Graph;

import java.util.*;

public class GraphAdjListDfsAndBfs {

    private Map<Integer, List<Integer>> adjList;

    public GraphAdjListDfsAndBfs(int vertices) {
        adjList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    //bfs
    public void bfs(int start) {
        boolean visited[] = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adjVertex : adjList.get(vertex)) {
                if (!visited[adjVertex]) {
                    queue.add(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }
    }

    //dfs
    public void dfs(int start) {
        boolean visited[] = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");
            }

            for (int adjVertex : adjList.get(vertex)) {
                if (!visited[adjVertex]) {
                    stack.push(adjVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjListDfsAndBfs graph = new GraphAdjListDfsAndBfs(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.bfs(0);
        System.out.println();
        graph.dfs(0);
    }


}
