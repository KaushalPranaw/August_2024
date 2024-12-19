package Leetcode.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
    }

    /*public boolean isIsomorphic(String s, String t) {
        if (t.length() != s.length())
            return false;

        // Maps to store character mappings from s -> t and t -> s
        Map<Character, Character> mapS = new Leetcode.HashMap<>();
        Map<Character, Character> mapT = new Leetcode.HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check if sChar is already mapped to some character
            if (mapS.containsKey(sChar)) {
                if (mapS.get(sChar) != tChar) {
                    return false; // Inconsistent mapping
                }
            } else {
                mapS.put(sChar, tChar);
            }

            // Check if tChar is already mapped to some character
            if (mapT.containsKey(tChar)) {
                if (mapT.get(tChar) != sChar) {
                    return false; // Inconsistent mapping
                }
            } else {
                mapT.put(tChar, sChar);
            }
        }
        return true;

    }*/

    //Using Array
    public boolean isIsomorphic(String s, String t) {
        if (t.length() != s.length())
            return false;

        // Maps to store character mappings from s -> t and t -> s
        int[] mapS = new int[256]; // maps characters from s -> t
        int[] mapT = new int[256]; // maps characters from t -> s

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // If this character has been mapped before, check consistency
            if (mapS[sChar] == 0 && mapT[tChar] == 0) {
                // Set the mapping of sChar to tChar and vice versa
                mapS[sChar] = tChar;
                mapT[tChar] = sChar;
            } else {
                if (mapS[sChar] != tChar || mapT[tChar] != sChar) {
                    // Inconsistent mapping found
                    return false;
                }
            }
        }
        return true;

    }
}
