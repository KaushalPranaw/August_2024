package Company.Walmart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SafePairsOptimized {
    public static void main(String[] args) {
        // Sample input
        List<Integer> numbers = Arrays.asList(1, 9, 3, 7, 2, 8, 5, 5);

        // Call the function to find the safe pairs
        int result = findSafePairs(numbers);

        // Output the result
        System.out.println("Number of safe pairs: " + result);
    }

    private static int findSafePairs(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : numbers) {
            int rem = num % 10;
            int complement = (10 - rem) % 10;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
