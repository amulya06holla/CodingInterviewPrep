package com.leet.august;
//https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3892/
public class NumArray {
    int[] nums =null;
    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public int sumRange(int left, int right) {
        int res =0;
        for(int i=left; i<=right; i++){
            res = res+nums[i];
        }
        return res;
    }
}
