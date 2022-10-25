package com.leet.uber.easy;
//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfArraySorted {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i=0, j=0;
        while(i<nums.length && nums[i]<0){
            i++;
        }
        int index=0;
        j=i-1;
        // System.out.println("j="+j+" i="+i);
        while(j>=0&& i<=nums.length-1){
            if(nums[i]<Math.abs(nums[j])){
                res[index++]=nums[i]*nums[i];
                i++;
            }else{
                res[index++]=nums[j]*nums[j];
                j--;
            }
        }
        while(j>=0){
            res[index++]=nums[j]*nums[j];
            j--;
        }
        while(i<=nums.length-1){
            res[index++]=nums[i]*nums[i];
            i++;
        }
        return res;
    }
}
