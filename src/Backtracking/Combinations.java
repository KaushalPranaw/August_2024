package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> wrapList = new ArrayList<>();
        combine(wrapList, new ArrayList<Integer>(), 1, n, k);
        return wrapList;

    }

    private void combine(List<List<Integer>> wrapList, ArrayList<Integer> list, int start, int n, int k) {
        if (k == 0) {
            wrapList.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            combine(wrapList, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
