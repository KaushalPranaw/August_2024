package Leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }

    /*Approach
    First, you calculate the length of each word and the total length of all words combined.
    Then, you iterate over the string s, checking substrings of the combined length.
    For each substring, check if it can be broken down into words that match the ones in words.
    Use a sliding window technique to move through s and a Leetcode.HashMap to track the frequency of words.*/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        // Map to store frequency of words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Iterate through the string
        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;

            // Check the substring of length `totalLength`
            while (j < wordCount) {
                int wordStartIndex = i + j * wordLength;
                String word = s.substring(wordStartIndex, wordStartIndex + wordLength);

                // If word is not in the list, break the loop
                if (!wordMap.containsKey(word)) {
                    break;
                }

                // Count the occurrences of the word
                seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                // If the word count exceeds the required frequency, break the loop
                if (seenWords.get(word) > wordMap.get(word)) {
                    break;
                }

                j++;
            }

            // If all words are found with exact frequency, add the start index to result
            if (j == wordCount) {
                result.add(i);
            }
        }

        return result;
    }
}
