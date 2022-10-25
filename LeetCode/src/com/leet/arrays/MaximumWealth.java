package com.leet.arrays;

public class MaximumWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1,5},{7,3},{3,5}};
        System.out.println(maximumWealth(accounts));
    }
    public static int maximumWealth(int[][] accounts) {
        int res =0;

        for(int i=0; i<accounts.length; i++){
            int sum =0;
            for(int j=0; j<accounts[0].length;j++){
                sum+=accounts[i][j];
            }
            if(sum>res){
                res =sum;
            }
        }

        return res;
    }
}
