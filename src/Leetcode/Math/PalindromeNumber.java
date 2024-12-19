package Leetcode.Math;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(new PalindromeNumber().isPalindrome(x));

    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int temp = x;
        int reverse = 0;
        while (temp != 0) {
            int d = temp % 10;
            reverse = reverse * 10 + d;
            temp = temp / 10;
        }
        return x == reverse;

    }
}
