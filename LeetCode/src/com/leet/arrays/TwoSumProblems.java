package com.leet.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSumProblems {
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        // here input is sorted. hence can use two pointers and find the answer.
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }

    //https://leetcode.com/problems/two-sum/solution/
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap <>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] =i;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    //https://leetcode.com/problems/two-sum-less-than-k/
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0, j= nums.length-1;
        int maxSum=-1;
        while(i!=nums.length-1 &&j!=0 && i<j){
            int t= nums[i]+nums[j];
            if(t >= k) j--;
            else if(t<=k){
                if(t>maxSum) maxSum= t;
                i++;
            }
        }
        return maxSum;
    }
}
