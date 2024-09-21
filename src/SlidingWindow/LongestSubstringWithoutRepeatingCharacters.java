package SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (set.contains(ch)) {

                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
