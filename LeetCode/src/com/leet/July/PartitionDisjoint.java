package com.leet.July;

//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3823/
public class PartitionDisjoint {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};
        System.out.println(partitionDisjoint(nums));
    }
    public static int partitionDisjoint(int[] nums) {
        int aLength = 1;
        int aMax = nums[0];
        int maxEncountered = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEncountered = Math.max(maxEncountered, nums[i]);

            if (nums[i] < aMax) {
                aMax = maxEncountered;
                aLength = i + 1;
            }
        }

        return aLength;
    }
}
