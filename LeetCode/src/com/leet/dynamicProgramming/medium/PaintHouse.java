package com.leet.dynamicProgramming.medium;
//https://leetcode.com/problems/paint-house/
public class PaintHouse {
        public int minCost(int[][] costs) {

            if (costs.length == 0) return 0;

            int[] previousRow = costs[costs.length -1];

            for (int n = costs.length - 2; n >= 0; n--) {

                /**
                 * THIS CODE IS VERY IMPORTANT. WE NEED TO CLONE AND NOT SIMPLY ASSIGN THE CURRENT ROW WITH COSTS[N]
                 */
                int[] currentRow = costs[n].clone();

                // Total cost of painting the nth house red.
                currentRow[0] = currentRow[0]+Math.min(previousRow[1], previousRow[2]);
                // Total cost of painting the nth house green.
                currentRow[1] = currentRow[1]+Math.min(previousRow[0], previousRow[2]);
                // Total cost of painting the nth house blue.
                currentRow[2] = currentRow[2]+Math.min(previousRow[0], previousRow[1]);
                previousRow = currentRow;
            }

            return Math.min(Math.min(previousRow[0], previousRow[1]), previousRow[2]);
        }
}
