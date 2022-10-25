package com.leet.uber.easy;
//https://leetcode.com/problems/maximum-subarray/
public class MaxContiguousSubArray {
    public static void main(String[] args) {
        MaxContiguousSubArray t = new MaxContiguousSubArray();
        int[] nums = new int[]{1};
        System.out.println(t.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int currSum=nums[0], maxSum=nums[0];
        for(int i=1; i<nums.length;i++){
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSum= Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
