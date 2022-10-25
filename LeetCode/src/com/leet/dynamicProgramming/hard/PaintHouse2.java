package com.leet.dynamicProgramming.hard;

import java.util.Arrays;

public class PaintHouse2 {
    public static void main(String[] args) {
        int[][] costs = new int[][]{
                {8,16,12,18,9},
                {19,18,8,2,8},
                {8,5,5,13,4},
                {15,9,3,19,2},
                {8,7,1,8,17},
                {8,2,8,15,5},
                {8,17,1,15,3},
                {8,8,5,5,16},
                {2,2,18,2,9},
        };
        PaintHouse2 ph = new PaintHouse2();
        System.out.println(ph.minCostII(costs));
    }
    public int minCostII(int[][] costs) {
        int min =Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        if(costs.length==0) return 0;
        int minLoc=0;
        for(int i=0; i<costs[0].length;i++){
            if(costs[0][i]<min){
                minLoc = i;
                secondMin = min;
                min= costs[0][i];
            }
            if(costs[0][i]<secondMin && minLoc!=i){
                secondMin= costs[0][i];
            }
        }
        if(costs.length==1) return min;
        // System.out.println(min+" "+secondMin);
        // System.out.println("---------------");
        for(int houses=1; houses<costs.length; houses++){
            int curMin =Integer.MAX_VALUE, curSecondMin = Integer.MAX_VALUE, curMinLoc=0;
            // System.out.println("basic "+min+" "+secondMin+ " "+minLoc);
            for(int colors =0; colors<costs[houses].length;colors++){
                int total =0;

                if(colors!=minLoc){
                    total = costs[houses][colors]+ min;
                }else{
                    total = costs[houses][colors]+ secondMin;
                }
                if(total<curMin){
                    curMinLoc = colors;
                    if(curMin!=Integer.MAX_VALUE) curSecondMin=curMin;
                    curMin= total;

                }
                if(total<curSecondMin && curMinLoc !=colors){
                    curSecondMin= total;
                }
            }
            // System.out.println(curMin+" "+curSecondMin+ " "+curMinLoc);
            min = curMin;
            secondMin= curSecondMin;
            minLoc = curMinLoc;
        }
        return min;
    }
}
