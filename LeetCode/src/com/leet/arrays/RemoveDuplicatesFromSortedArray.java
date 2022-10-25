package com.leet.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int res = nums.length; int currPos=-1;
        for(int i=1; i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                res--;
                if(currPos==-1){
                    currPos=i;
                }
            }else{
                if(currPos!=-1)
                nums[currPos++]=nums[i];
            }
        }
        return res;
    }
}
