package HashMap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int longestStreak = 1;

        for (int num : nums) {
            int cur = num;
            int streak = 1;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                    streak++;
                }
            }
            longestStreak = Math.max(longestStreak, streak);
        }
        return longestStreak;

    }
}
