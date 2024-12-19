package Leetcode.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazine_counter = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            magazine_counter[ch - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (magazine_counter[ch - 'a'] == 0) {
                return false;
            }
            magazine_counter[ch - 'a']--;
        }
        return true;
    }
}
