package Graph_With_TUF;

import java.util.*;

public class G30_WordLadder2 {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        G30_WordLadder2 obj = new G30_WordLadder2();
        List<List<String>> ans = obj.findSequences(startWord, targetWord, wordList);
        System.out.println(ans);

    }

    private List<List<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, wordList);

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(startWord)));

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        int level = 0;
        List<List<String>> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<String> ls = queue.peek();
            queue.remove();

            // Now, erase all words that have been
            // used in the previous levels to transform
            if (ls.size() > level) {
                level++;
                for (String s : usedOnLevel) {
                    set.remove(s);
                }
            }

            String word = ls.get(ls.size() - 1);

            if (word.equals(targetWord)) {
                if (ans.size() == 0) {
                    ans.add(ls);
                } else {
                    if (ans.get(0).size() == ls.size()) {
                        ans.add(ls);
                    }
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = ch;
                    String replaced = new String(replacedArray);

                    if (set.contains(replaced)) {
                        ls.add(replaced);
                        List<String> temp = new ArrayList<>(ls);
                        queue.add(temp);
                        usedOnLevel.add(replaced);
                        ls.remove(ls.size() - 1);
                    }
                }
            }


        }
        return ans;
    }
}
