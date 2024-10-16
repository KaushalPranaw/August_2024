package Graph.BFS;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();

        // Example 1
        String startGene1 = "AACCGGTT";
        String endGene1 = "AACCGGTA";
        String[] bank1 = {"AACCGGTA"};
        System.out.println(mgm.minMutation(startGene1, endGene1, bank1)); // Output: 1

        // Example 2
        String startGene2 = "AACCGGTT";
        String endGene2 = "AACCGGTA";
        String[] bank2 = {"AACCGGTA", "AACCGGTC", "AACCGGTT"};
        System.out.println(mgm.minMutation(startGene2, endGene2, bank2)); // Output: 1

        // Example 3
        String startGene3 = "AACCGGTT";
        String endGene3 = "AAACGGTA";
        String[] bank3 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(mgm.minMutation(startGene3, endGene3, bank3)); // Output: 2

        // Example 4
        String startGene4 = "AACCGGTT";
        String endGene4 = "AAAAAAAT";
        String[] bank4 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(mgm.minMutation(startGene4, endGene4, bank4)); // Output: -1

    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        visited.add(startGene);
        int level = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) {
                    return level;
                }

                for (char ch : "ACGT".toCharArray()) {
                    for (int j = 0; j < curr.length(); j++) {
                        StringBuilder neighbour = new StringBuilder(curr);
                        neighbour.setCharAt(j, ch);
                        String neighbourStr = neighbour.toString();
                        if (!visited.contains(neighbourStr)
                                && bankSet.contains(neighbourStr)) {
                            visited.add(neighbourStr);
                            queue.add(neighbourStr);
                        }
                    }
                }
            }
            level++;
        }
        return -1;

    }
}
