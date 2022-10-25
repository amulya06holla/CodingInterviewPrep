package com.leet.dds;
//https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length;j++){
                area = Math.max(area, findArea(i, j, grid, 0));
            }
        }
        return area;
    }

    private int findArea(int i, int j, int[][] grid, int area) {
        if(i<0|| i>=grid.length || j<0 || j>=grid[0].length|| grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+ findArea(i-1, j, grid, area) + findArea(i+1, j, grid, area)+ findArea(i, j-1, grid, area) + findArea(i, j+1, grid, area);
    }
}
