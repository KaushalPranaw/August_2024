package Leetcode.TwoPointers;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));

    }

    private boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if (s.length() == index)
                return true;
        }
        return false;
    }
}
