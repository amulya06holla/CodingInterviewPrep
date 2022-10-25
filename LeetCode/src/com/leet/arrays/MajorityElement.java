package com.leet.arrays;
//https://leetcode.com/problems/majority-element/
//Boyer-Moore Voting Algorithm
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{10,10,5,10,10,5,5,10,5,5,5,5,5};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
