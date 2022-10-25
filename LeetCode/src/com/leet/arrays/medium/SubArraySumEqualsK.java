package com.leet.arrays.medium;

import java.util.HashMap;
import java.util.Map;

// prefix-sum algo
//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = new int[] {6,3,-2,2};
        System.out.println(subarraySum(nums, 9));
    }
    public static int subarraySum(int[] nums, int k) {
        int res =0;
        int sum =0;
       Map <Integer, Integer> occuranceOfSumMap = new HashMap <>();
        occuranceOfSumMap.put(0,1);
       for(int i=0; i<nums.length; i++){
            sum = sum+nums[i];
            if(occuranceOfSumMap.containsKey(sum-k)){
                res += occuranceOfSumMap.get(sum - k);
            }
           occuranceOfSumMap.put(sum, occuranceOfSumMap.getOrDefault(sum,0)+1);
       }
        return res;
    }
}
