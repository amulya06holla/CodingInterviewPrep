package com.leet.July;

public class MaximumLengthRepeatedSubarray {
    public static void main(String[] args) {
        int[] nums1= new int[]{1,2,3,2,1};
        int[] nums2= new int[]{3,2,1,4,7};
        System.out.println(findLength(nums1, nums2));
    }
    public static int findLength(int[] nums1, int[] nums2) {
        int res =0;
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i]==nums2[j]){
                    if(i-1>=0 && j-1>=0){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=1;
                    }
                    if(dp[i][j]>res)
                        res=dp[i][j];
                }
            }
        }
        return res;
    }
}
