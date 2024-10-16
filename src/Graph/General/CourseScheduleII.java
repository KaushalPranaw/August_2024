package Graph.General;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}}; // Course 1 depends on Course 0
        System.out.println(java.util.Arrays.toString(cs.findOrder(numCourses1, prerequisites1))); // Output: [0, 1]

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}}; // Circular dependency
        System.out.println(java.util.Arrays.toString(cs.findOrder(numCourses2, prerequisites2))); // Output: []

        // Example 3
        int numCourses3 = 5;
        int[][] prerequisites3 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}}; // Linear dependency
        System.out.println(java.util.Arrays.toString(cs.findOrder(numCourses3, prerequisites3))); // Output: [1, 2, 3, 4, 0]

        // Example 4
        int numCourses4 = 3;
        int[][] prerequisites4 = {{0, 1}, {1, 2}, {2, 0}}; // Circular dependency
        System.out.println(java.util.Arrays.toString(cs.findOrder(numCourses4, prerequisites4))); // Output: []
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //form a graph
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1])
                    .add(prerequisites[i][0]);
        }

        //topological sort with bfs
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        //O(V+e)
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        if (topo.size() == numCourses) {
            return topo.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];

    }
}
