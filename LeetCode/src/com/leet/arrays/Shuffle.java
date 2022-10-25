package com.leet.arrays;

import java.util.Arrays;

public class Shuffle {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int n=5;
        System.out.println(Arrays.toString(shuffle(nums,n)));
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int j=0;
        for(int i=0; i<res.length; i++){
            if(i%2==0){
                res[i] = nums[j++];
            }else{
                res[i]=nums[n++];
            }
        }
        return res;
    }
}
