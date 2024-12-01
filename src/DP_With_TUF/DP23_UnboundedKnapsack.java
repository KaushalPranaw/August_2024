package DP_With_TUF;

public class DP23_UnboundedKnapsack {
    public static void main(String args[]) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack(n, W, val, wt));
    }

    private static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {

    }
}
