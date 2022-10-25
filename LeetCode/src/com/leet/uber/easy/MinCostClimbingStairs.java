package com.leet.uber.easy;
//https://leetcode.com/problems/min-cost-climbing-stairs/solution/
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int downOne = 0;
        int downTwo = 0;
        for (int i = 2; i < cost.length + 1; i++) { // make sure to run loop till cost.length+1
            int temp = downOne;
            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
            downTwo = temp; // in every loop, downOne earlier value needs to be propagated to downTwo.
            // bcz lets say at i=2, downone was i=1 and downTwo was i=0.
            // but for i=3, downOne is i=2 but downTwo is i=1 which is nothing but downOne of previous step
        }

        return downOne;
    }
}
