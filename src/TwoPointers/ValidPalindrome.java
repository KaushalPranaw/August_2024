package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));

    }

    public boolean isPalindrome(String s) {
          /*s = "A man, a plan, a canal: Panama"
            s = "a man, a plan, a canal: panama" - after converting all uppercase letters into lowercase letters
            s = "amanaplanacanalpanama" - removing all non-alphanumeric character
            after reverse if same to valid palindrome h
            */
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

    }

}
