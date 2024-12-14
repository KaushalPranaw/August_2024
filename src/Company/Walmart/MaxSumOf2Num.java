package Company.Walmart;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxSumOf2Num {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 4, 3, 6, 7, 2, 8, 5};
        IntStream stream = Arrays.stream(nums);
        // Get the max sum of two numbers
        OptionalInt maxSum = getMaxSumOfTwo(stream);

        if (maxSum.isPresent()) {
            System.out.println("Max sum of two numbers: " + maxSum.getAsInt());
        } else {
            System.out.println("Not enough data to compute max sum");
        }
    }

    private static OptionalInt getMaxSumOfTwo(IntStream intStream) {
        return intStream.boxed()
                .sorted(Collections.reverseOrder())
                .limit(2)
                .mapToInt(Integer::intValue)
                .reduce((a, b) -> a + b);
    }
}
