package Graph.General;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}}; // Course 1 depends on Course 0
        System.out.println(cs.canFinish(numCourses1, prerequisites1)); // Output: true

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}}; // Circular dependency
        System.out.println(cs.canFinish(numCourses2, prerequisites2)); // Output: false

        // Example 3
        int numCourses3 = 5;
        int[][] prerequisites3 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}}; // Linear dependency
        System.out.println(cs.canFinish(numCourses3, prerequisites3)); // Output: true

        // Example 4
        int numCourses4 = 3;
        int[][] prerequisites4 = {{0, 1}, {1, 2}, {2, 0}}; // Circular dependency
        System.out.println(cs.canFinish(numCourses4, prerequisites4)); // Output: false
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //topo with bfs
        int indegree[] = new int[numCourses];
        for (int i = 0; i < indegree.length; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);//index means node
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        if (topo.size() == numCourses)
            return true;
        return false;


    }
}
