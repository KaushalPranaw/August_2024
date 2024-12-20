package Leetcode.Array_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

    //Using Sort()
    /*private int majorityElement(int[] nums) {

        //Using sorting
        //if array is sorted and element is more than half
        //then middle wala element majority element hoga
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n/2];

    }*/

    //using hashmap count occurences of each element
    /*private int majorityElement(int[] nums) {

        Map<Integer, Integer> map=new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int n=nums.length;
        n=n/2;
        for(var entry: map.entrySet()){
            if(entry.getValue()>n){
                return entry.getKey();
            }
        }
        return -1;

    }*/

    //Using moore voting algorithm
    private int majorityElement(int[] nums) {
        //The intuition behind the Moore's Voting Algorithm is based on the fact
        // that if there is a majority element in an array,
        // it will always remain in the lead,
        // even after encountering other elements.

        int count = 0, candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
