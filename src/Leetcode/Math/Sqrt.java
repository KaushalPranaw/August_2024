package Leetcode.Math;

public class Sqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(new Sqrt().mySqrt(x));

    }

    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
