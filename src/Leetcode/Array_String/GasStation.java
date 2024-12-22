package Leetcode.Array_String;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

    private int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalKamai = 0;
        int totalKharcha = 0;
        for (int i = 0; i < n; i++) {
            totalKharcha += cost[i];
            totalKamai += gas[i];
        }
        if (totalKharcha > totalKamai) {
            return -1;
        }

        int total = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                index = i + 1;
                total = 0;
            }
        }
        return index;
    }

    //brute force
    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i])
                continue;

            int j = (i + 1) % n;//gola ghumne k liye
            int costForMovingThisStation = cost[i];
            int gasEarnedFromStationJ = gas[j];

            int curGas = gas[i] - costForMovingThisStation + gasEarnedFromStationJ;
            while (j != i) {
                if (curGas < cost[j])
                    break;

                int costForMovingFromThisJ = cost[j];
                j = (j + 1) % n;
                int gasEarnedInNextStationJ = gas[j];

                curGas = curGas - costForMovingFromThisJ + gasEarnedInNextStationJ;
            }
            if (i == j)
                return j;

        }
        return -1;

    }*/


}
