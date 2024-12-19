package Leetcode.Array_String;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello Woddddrld";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }

    /*public int lengthOfLastWord(String s) {
        String[] sArray = s.split(" ");
        return sArray[sArray.length - 1].length();
    }*/

    /*public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0)
                    return length;
            }
        }
        return length;
    }*/
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0) {
                    return length;
                }
            }
        }
        return length;
    }
}
