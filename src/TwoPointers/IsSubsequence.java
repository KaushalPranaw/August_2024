package TwoPointers;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));

    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.equals(""))
            return true;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i))
                index++;
            if (index == s.length())
                return true;
        }
        return false;

    }
}