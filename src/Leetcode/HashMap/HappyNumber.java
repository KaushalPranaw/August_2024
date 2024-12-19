package Leetcode.HashMap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(new HappyNumber().isHappy(n));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int current = n;
            int sum = 0;
            while (current != 0) {
                int d = current % 10;
                sum += d * d;
                current /= 10;
            }
            if (set.contains(sum))
                return false;

            set.add(sum);
            n=sum;

        }
        return true;

    }
}
