package com.leet.Apple.easy;
//https://leetcode.com/problems/shuffle-the-array
public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        final int len = nums.length;

        // to store the pair of numbers in right half of the original array
        for(int i = n; i < len; i++) {
            nums[i]=(nums[i] * 1024)+nums[i-n]; // nums[i] is in the range of 1 and 10 power 5. hence max number that can be multiplied is 1024
        }

        int index = 0;
        // to retrive values from the pair of numbers and placing those retrieved value at their desired position
        for(int i = n; i < len; i++, index += 2){
            nums[index] = nums[i] % 1024;  // bcz in the previous step, it was multiplied by 1024 and the number was added. Hence now the reminder will give the same value that it was added after multiplication.
            nums[index + 1] = nums[i] / 1024;// bcz in the previous step, it was multiplied by 1024 . Hence now the reminder will give the same value that it was multiplied with.

        }

        return nums;
    }
}
