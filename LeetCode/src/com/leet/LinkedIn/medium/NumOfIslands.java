package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/number-of-islands/
public class NumOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    visited[i][j]=true;
                    result++;
                    findIslands(grid, visited, i,j);
                }
            }
        }
        return result;
    }

    private void findIslands(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                visited[i][j] || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        findIslands(grid, visited,i+1,j);
        findIslands(grid, visited,i-1,j);
        findIslands(grid, visited,i,j+1);
        findIslands(grid, visited,i,j-1);
    }
}
