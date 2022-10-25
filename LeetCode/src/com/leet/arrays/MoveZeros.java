package com.leet.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int zero=-1; int i=0;
        while(i!=nums.length){
            if(zero<0 && nums[i]==0){
                zero=i;
            }else{
                if(nums[i]!=0 && zero>=0){
                    int t = nums[i];
                    nums[zero]=t;
                    nums[i]=0;
                    if(i-zero!=1){
                        zero++;
                    }else{
                        zero=i;
                    }
                }
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
