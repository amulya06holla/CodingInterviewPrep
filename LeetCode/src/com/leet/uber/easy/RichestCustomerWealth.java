package com.leet.uber.easy;
//https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int val =Integer.MIN_VALUE;
        for(int i=0; i<accounts.length;i++){
            int curr=0;
            for(int j=0; j<accounts[0].length;i++){
                curr=curr+accounts[i][j];
            }
            if(curr>val)val=curr;
        }
        return val;
    }
}
