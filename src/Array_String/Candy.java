package Array_String;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(new Candy().candy(ratings));
    }

    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        //left to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }
        //right to left
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && ans[i] >= ans[i - 1]) {
                ans[i - 1] = ans[i] + 1;
            }
        }

        return Arrays.stream(ans).sum();
    }
}
