package Graph.General;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        Map<String, List<Pair>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            //in case of absent
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            //now fil
            adjList.get(u).add(new Pair(v, val));
            adjList.get(v).add(new Pair(u, 1.0 / val));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            double[] ans = {-1.0};
            double product = 1.0;

            if (adjList.containsKey(src)) {
                Set<String> visited = new HashSet<>();
                dfs(adjList, src, dest, visited, product, ans);
            }
            res[i] = ans[0];
        }
        return res;
    }

    private void dfs(Map<String, List<Pair>> adjList, String src, String dest, Set<String> visited, double product, double[] ans) {
        if (visited.contains(src))
            return;
        visited.add(src);

        if (src.equals(dest)) {
            ans[0] = product;
            return;
        }


        for (Pair pair : adjList.get(src)) {
            String neighbourVertex = pair.vertex;
            double neighbourVal = pair.value;
            dfs(adjList, neighbourVertex, dest, visited, product * neighbourVal, ans);
        }
    }

    private static class Pair {
        String vertex;
        double value;

        Pair(String vertex, double value) {
            this.vertex = vertex;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        EvaluateDivision evalDiv = new EvaluateDivision();

        // Sample equations
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        // Corresponding values
        double[] values = {2.0, 3.0};

        // Sample queries
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "y"));

        // Call the calcEquation method
        double[] results = evalDiv.calcEquation(equations, values, queries);

        // Print the results
        for (double result : results) {
            System.out.println(result);
        }

    }
}
