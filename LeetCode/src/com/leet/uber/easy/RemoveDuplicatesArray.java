package com.leet.uber.easy;

public class RemoveDuplicatesArray {
    public int removeDuplicates(int[] nums) {
        int  loc =0;
        if(nums.length==1) return loc+1;
        for(int i=1; i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[loc++]=nums[i];
            }
        }
        return loc+1;
    }
}
