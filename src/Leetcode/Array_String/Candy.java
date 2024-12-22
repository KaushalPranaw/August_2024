package Leetcode.Array_String;

import java.util.Arrays;
import java.util.Map;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(new Candy().candy(ratings));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        //l->r
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }

        //r->l
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i + 1] + 1, ans[i]);
            }
        }

        return Arrays.stream(ans).sum();
    }
}
