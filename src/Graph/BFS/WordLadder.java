package Graph.BFS;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        // Example input
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        // Create an instance of WordLadder
        WordLadder wl = new WordLadder();

        // Calculate the length of the shortest transformation sequence
        int result = wl.ladderLength(beginWord, endWord, wordList);

        // Print the result
        System.out.println("Length of shortest transformation sequence: " + result);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        //mark visited
        wordList.remove(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.peek().first;
            int level = queue.peek().second;
            queue.poll();
            if (word.equals(endWord)) {
                return level;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    //it exist in wordlist
                    if (wordList.contains(replacedWord)) {
                        wordList.remove(replacedWord);//marked visited
                        queue.add(new Pair(replacedWord, level + 1));
                    }
                }
            }
        }
        return 0;

    }

    class Pair {
        String first;
        int second;

        Pair(String f, int s) {
            this.first = f;
            this.second = s;
        }
    }
}
