package com.leet.uber.easy;
//https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSum1dArray {
    public int[] runningSum(int[] nums) {
        for(int i=1; i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;
    }
}
