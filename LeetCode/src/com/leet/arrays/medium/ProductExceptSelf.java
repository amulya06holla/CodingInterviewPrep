package com.leet.arrays.medium;
//https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {
    public static void main(String[] args) {

    }
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prod =1,  numOfZeros=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0) numOfZeros++;
            else prod = prod*nums[i];
        }
        if(numOfZeros>1) return res;
        for(int i=0; i<nums.length;i++){
            if(numOfZeros>0){
                if (nums[i]!=0){
                    res[i]=0;
                }else{
                    res[i]=prod;
                }
            }else{
                res[i] = prod/nums[i];
            }
        }
        return res;
    }
}
