package com.leet.uber.easy;
//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
public class ProductSumDifference {
    public int subtractProductAndSum(int n) {
        if(n==0) return 0;
        int sum=0;
        long prod=1;
        while(n!=0){
            int t=n%10;
             n= n/10;
             prod=prod*t;
             sum=sum+t;
        }
        int diff =(int) (prod-sum);
        return diff;
    }
}
