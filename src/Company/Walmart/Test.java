package Company.Walmart;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(
                List.of(1, 3),
                List.of(2, 3),
                List.of(3, 6),
                List.of(4, 5),
                List.of(5, 6),
                List.of(0, 1),
                List.of(1, 8)
        );
        /*Map<Integer, Integer> managerCount=new Leetcode.HashMap<>();
        for(List<Integer> pair: input){
            int mgr=pair.get(1);
            managerCount.put(mgr, managerCount.getOrDefault(mgr, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: managerCount.entrySet()){
            System.out.println("Mgr : "+entry.getKey()+", No of emps: " +entry.getValue());
        }*/

        //using stream
        Map<Integer, Long> managerCount =
                input.stream().collect(Collectors.groupingBy(p -> p.get(1), Collectors.counting()));

        managerCount.forEach((mgr, count) -> {
            System.out.println("Mgr : " + mgr + ", No of emps: " + count);
        });
    }
}
