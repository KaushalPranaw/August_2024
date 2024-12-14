package Company.Walmart;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Group the anagrams
        List<List<String>> result = groupAnagrams(input);

        // Print the grouped anagrams
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    private static List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : input) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String sortedString = new String(ca);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
