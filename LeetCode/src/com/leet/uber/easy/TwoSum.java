package com.leet.uber.easy;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap <>();
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[0]=i;
                res[1]=map.get(temp);
                return res;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
