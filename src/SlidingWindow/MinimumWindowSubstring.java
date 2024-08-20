package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0)
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int charTLeft = t.length();
        int ansIndex = 0, ansLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (map.containsKey(rChar)) {
                int count = map.get(rChar);
                if (count > 0) {
                    charTLeft--;
                }
                map.put(rChar, count - 1);
            }
            right++;
        }

        while (charTLeft == 0) {
            if (ansLen > right - left) {
                ansLen = right - left;
                ansIndex = left;
            }
            char lChar = s.charAt(left);
            if (map.containsKey(lChar)) {
                int count = map.get(lChar);
                if (count == 0) {
                    charTLeft++;
                }
                map.put(lChar, count + 1);
            }
            left++;
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansIndex, ansIndex + ansLen);
    }
}
