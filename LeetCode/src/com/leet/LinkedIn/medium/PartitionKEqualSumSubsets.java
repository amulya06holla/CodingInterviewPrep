package com.leet.LinkedIn.medium;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
public class PartitionKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums.length<k) return false;
        int sum =0;
        for(int i=0; i<nums.length;i++)
            sum+=nums[i];

        if(sum%k!=0) return false;
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, 0, k, 0, sum/k);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int start, int k, int currSum, int subSetSum) {
        if(k==0) return true;
        if(currSum>subSetSum) return false;
        if(currSum==subSetSum)
            return backtrack(nums,visited,0,k-1,0,subSetSum);  // reduce k to k-1 and start the currsum again from 0.

        for(int i=start;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                if(backtrack(nums, visited, i+1, k, currSum+nums[i], subSetSum)) // moving starting point to i+1 and adding nums[i] to currSum
                    return true;
                visited[i]=false; // backtrack here.
            }
        }
        return false;
    }
}
