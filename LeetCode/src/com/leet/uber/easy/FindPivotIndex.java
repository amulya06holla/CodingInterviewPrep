package com.leet.uber.easy;
//https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,-1};
        FindPivotIndex t = new FindPivotIndex();
        System.out.println(t.pivotIndex(nums));
    }
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
