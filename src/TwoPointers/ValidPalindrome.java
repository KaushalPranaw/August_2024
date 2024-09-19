package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));

    }

    /*public boolean isPalindrome(String s) {
     *//*s = "A man, a plan, a canal: Panama"
            s = "a man, a plan, a canal: panama" - after converting all uppercase letters into lowercase letters
            s = "amanaplanacanalpanama" - removing all non-alphanumeric character
            after reverse if same to valid palindrome h
            *//*
        StringBuilder alphaNumericString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c)) {
                alphaNumericString.append(c);
            }
        }
        String result = alphaNumericString.toString();
        result = result.toLowerCase();
        int left = 0, right = result.length() - 1;
        while (left < right) {
            if (result.charAt(left) != result.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;

    }*/

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        return checkPalindrome(sb.toString().toLowerCase());
    }

    private boolean checkPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
