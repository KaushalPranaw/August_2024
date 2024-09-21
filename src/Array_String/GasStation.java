package Array_String;

import java.lang.module.FindException;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*n: The number of gas stations (gas.length).
          totalDiff: Keeps track of the total difference between the gas available and the gas cost across all stations. It helps check if a solution is possible.
          fuel: Tracks the amount of fuel left as we simulate traveling from one station to the next.
          index: This is the potential starting station index. Initially set to 0.*/

        int startIndex = 0, n = gas.length, fuel = 0, totalDiff = 0;
        //if totalDiff is coming negative then we can return -1
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            totalDiff += diff;

            fuel += diff;
            if (fuel < 0) {
                startIndex = i + 1;
                fuel = 0;
            }
        }

        if (totalDiff < 0) {
            return -1;
            //means no output
        } else {
            return startIndex;
        }

    }
}
