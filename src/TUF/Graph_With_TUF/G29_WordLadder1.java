package TUF.Graph_With_TUF;

import java.util.*;

public class G29_WordLadder1 {

    record Pair(String first, int second) {
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        G29_WordLadder1 obj = new G29_WordLadder1();
        int ans = obj.wordLadderLength(startWord, targetWord, wordList);

        System.out.print(ans);
    }

    private int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        //bfs
        Queue<Pair> queue = new LinkedList<>();

        Set<String> set = new HashSet<>();
        Collections.addAll(set, wordList);

        queue.add(new Pair(startWord, 1));

        while (!queue.isEmpty()) {
            String word = queue.peek().first;
            int steps = queue.peek().second;
            queue.remove();
            if (word.endsWith(targetWord)) {
                return steps;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = ch;
                    String replaced = new String(replacedArray);
                    if (set.contains(replaced)) {
                        set.remove(replaced);
                        queue.add(new Pair(replaced, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
