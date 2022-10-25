package com.leet.dynamicProgramming;
//https://leetcode.com/problems/maximum-subarray/

// NOTE: ALSO CHECK KADANE'S ALGORITHM

public class MaxSubArray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            curr_max = Math.max(nums[i], curr_max+nums[i]); // you can either consider previous sum or not consider previous sum and start adding from current index
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}
