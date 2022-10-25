package com.leet.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumIdenticalPairs {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int res =0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else {
                res+=map.get(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
