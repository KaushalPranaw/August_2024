package HashMap;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s, t));

    }

    //Approach 1 using Arrays.sort
    /*public boolean isAnagram(String s, String t) {
        char sa[]=s.toCharArray();
        char ta[]=t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return Arrays.equals(sa, ta);
    }*/

    //Approach 1 using Arrays.sort
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }
        int[] countArray = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            countArray[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            countArray[ch - 'a']--;
        }
        for (int count : countArray) {
            if (count != 0)
                return false;
        }
        return true;
    }
}
