package day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.

    public static void main(String[] args) {
        int[] numbs = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i=0;i<numbs.length;i++) {
            int result = target - numbs[i];
            if (resultMap.containsKey(result)) {
                System.out.println(Arrays.toString(new int[]{resultMap.get(result), i}));
            }
            resultMap.put(numbs[i],i);
        }
    }
}
