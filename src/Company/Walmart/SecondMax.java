package Company.Walmart;

public class SecondMax {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(secondMax(arr));
    }

    private static int secondMax(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max2 = num;
            }
        }
        return max2;
    }
}
