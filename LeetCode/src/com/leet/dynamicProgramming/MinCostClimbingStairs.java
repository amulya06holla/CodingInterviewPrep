package com.leet.dynamicProgramming;
//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        for(int i=2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
