package com.leet.paypal.medium;

public class MinPathSum {
    public static void main(String[] args) {
        MinPathSum path = new MinPathSum();
        int[][] grid = new int[][]{{1,2,3},
                {4,5,6}};
        path.minPathSum(grid);
    }
    public int minPathSum(int[][] grid) {
        for(int j=grid[0].length-2; j>=0; j--){
            grid[grid.length-1][j]=grid[grid.length-1][j+1]+grid[grid.length-1][j];
        }
        for(int i=grid.length-2; i>=0; i--){
            grid[i][grid[i].length-1] = grid[i+1][grid[i].length-1]+grid[i][grid[i].length-1];
        }

        for(int i=grid.length-2; i>=0; i--){
            for(int j=grid[i].length-2; j>=0; j--){
                grid[i][j] = Math.min(grid[i+1][j], grid[i][j+1]) +grid[i][j];
            }
        }
        return grid[0][0];
    }
}
