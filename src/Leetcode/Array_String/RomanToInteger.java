package Leetcode.Array_String;

import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "CVIII";
        System.out.println(new RomanToInteger().romanToInt(s));

    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0, prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int cur = map.get(c);
            if (cur < prev) {
                res -= cur;
            } else {
                res += cur;
            }
            prev = cur;
        }
        return res;


    }
}
