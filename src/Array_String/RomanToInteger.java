package Array_String;

import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "CVIII";
        System.out.println(new RomanToInteger().romanToInt(s));

    }

    /*public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i, j;
        int result = 0;
        for (i = 0, j = 1; j < s.length(); i++, j++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(j))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        result += map.get(s.charAt(i));
        return result;


    }*/

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i, j;
        i = 0;//left wala
        j = 1;//right wala
        int result = 0;
        for (; j < s.length(); i++, j++) {
            int leftWala = map.get(s.charAt(i));
            int rightWala = map.get(s.charAt(j));
            if (leftWala >= rightWala) {
                result += leftWala;
            } else {
                result -= leftWala;
            }
        }
        result += map.get(s.charAt(i));//last element
        return result;


    }
}
