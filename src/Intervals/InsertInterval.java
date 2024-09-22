package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        // Example intervals
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        // New interval to be inserted
        int[] newInterval = {2, 5};

        // Call the insert method
        int[][] result = solution.insert(intervals, newInterval);

        // Print the result
        System.out.println("Merged intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result=new ArrayList<>();
        int i=0;

        //inserting all elements before newinterval
        while (i<intervals.length && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        //merge overlapping intervals
        while (i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;

        }

        // Add the merged interval
        result.add(newInterval);

        //insert remaining intervals
        while (i<intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}
