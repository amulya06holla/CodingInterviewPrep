package com.leet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class MissingNumList {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        System.out.println(Arrays.toString(findDisappearedNumbers(nums).toArray()));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])-1]>0)
            nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1]*-1;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
