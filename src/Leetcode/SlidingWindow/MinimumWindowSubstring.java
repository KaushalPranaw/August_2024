package Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            map.put(tChar, map.getOrDefault(tChar, 0) + 1);
        }

        int l = 0, r = 0;
        int ansIndex = 0;
        int ansLen = Integer.MAX_VALUE;
        int tlen = t.length();
        while (r < s.length()) {
            char rChar = s.charAt(r);
            if (map.containsKey(rChar)) {
                int count = map.get(rChar);
                if (count > 0) {
                    tlen--;
                }
                map.put(rChar, count - 1);
            }
            r++;

            while (tlen == 0)
            {
                if (ansLen > r - l) {
                    ansLen = r - l;
                    ansIndex = l;
                }
                char lChar = s.charAt(l);
                if (map.containsKey(lChar)) {
                    int count = map.get(lChar);
                    if (count == 0) {
                        tlen++;
                    }
                    map.put(lChar, count + 1);
                }
                l++;
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansIndex, ansIndex + ansLen);

    }
}
