package TUF.Graph_With_TUF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsCycleDetection {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(2).add(3);
        adjList.get(1).add(3);
        adjList.get(2).add(4);
        BfsCycleDetection obj = new BfsCycleDetection();
        boolean ans = obj.isCycle(V, adjList);
        if (ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private boolean isCycle(int V, List<List<Integer>> adjList) {

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkForCycle(adjList, i, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean checkForCycle(List<List<Integer>> adjList, int s, boolean[] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s, -1));
        visited[s] = true;

        while (!queue.isEmpty()) {
            int cur = queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();

            for (int neighbour : adjList.get(cur)) {
                if (!visited[neighbour]) {
                    queue.add(new Node(neighbour, cur));
                    visited[neighbour] = true;
                } else {
                    // If the neighbour is visited and not the parent, a cycle exists
                    if (parent != neighbour) {
                        return true;// so cycle exists here
                    }
                }

            }
        }
        return false;
    }

    class Node {
        int first;
        int second;

        Node(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }


}
