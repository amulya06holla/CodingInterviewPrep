package com.leet.Backtracking;

//https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class SubsetXORSum {
   static int sum = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,6};
        subsetXORSum(nums);
    }
    public static int subsetXORSum(int[] nums) {
        findSum(nums, 0, sum);
        return sum;
    }

    public static void findSum(int[] nums, int start, int prevSum) {
        if(start >= nums.length) {
            return ;
        }

        for(int i = start; i < nums.length ; i++) {
            int currentSum = prevSum ^ nums[i];
            sum += currentSum;
            findSum(nums, i + 1, currentSum);
        }
    }
}
