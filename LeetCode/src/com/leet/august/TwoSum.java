package com.leet.august;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
                int t = target - nums[i];
            System.out.println(t +" "+nums[i]);
                if(map.containsKey(t) && map.get(t)!=i){
                    res[0]=i;
                    res[1]= map.get(t);
                    return res;
            }
        }
        return res;
    }
}
