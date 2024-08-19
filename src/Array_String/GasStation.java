package Array_String;

import java.lang.module.FindException;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, totalDiff = 0, fuel = 0, index = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            totalDiff += diff;
            fuel += diff;
            if (fuel < 0) {
                index = i + 1;
                fuel = 0;
            }
        }
        return totalDiff < 0 ? -1 : index;

    }
}
