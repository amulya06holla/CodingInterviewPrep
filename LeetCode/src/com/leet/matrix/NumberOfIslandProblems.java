package com.leet.matrix;


import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslandProblems {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
    //static int[][] visited = null;
    public static int numIslands(char[][] grid) {
        int[][] visited  = new int[grid.length][grid[0].length];
        int noOfIslands =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(visited[i][j]!=1 && grid[i][j]=='1') {
                    findIslands(i,j,grid, visited);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private static void findIslands(int i, int j, char[][] grid, int[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                visited[i][j]==1 || grid[i][j] == '0')
            return;
        visited[i][j] = 1;
        findIslands(i+1, j, grid, visited);
        findIslands(i-1, j, grid, visited);
        findIslands(i, j-1, grid, visited);
        findIslands(i, j+1, grid, visited);
    }

//https://leetcode.com/problems/number-of-closed-islands/
    /**
     * The goal is to count the number of time the dfs function is called, this will be the number of islands that exits.
     * Similar to this problem: https://leetcode.com/problems/number-of-islands/.
     *
     * The catch here is that if the island of 0's is connected to a boundary 0. i.e i =0 || j=0 || i=length-1 || j=length-1 that island will not be considered since that would mean that this island is not completely surrounded by water i.e 1's on all sides.
     */

    boolean flag = true;
    public void dfs(int[][]grid, int i, int j) {

        if( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1)
            return;

        //If other 0's are connected to border then dont increase ans
        if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) && grid[i][j]==0)
            flag = false;

        grid[i][j]=1;

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }

    public int closedIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==0)
                {
                    dfs(grid,i,j);

                    //check if 0 isn't border/connected to border
                    if(flag)
                        ans+=1;
                    flag = true;
                }
            }
        }
        return ans;
    }

//https://leetcode.com/problems/number-of-distinct-islands/
    StringBuilder sb;
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    sb = new StringBuilder();
                    helper("X", grid, i, j);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    public void helper(String path, int grid[][], int row, int col) {
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 1) {
            grid[row][col] = 0;
            sb.append(path);
            helper("D", grid, row + 1, col);
            helper("U", grid, row - 1, col);
            helper("L", grid, row, col - 1);
            helper("R", grid, row, col + 1);
            sb.append("X"); //NOTE: DONT FORGET THIS!! ELSE SOME USECASES WHERE THERE IS BACKTRACKING HAPPENED, WILL FAIL.
        }
    }

}
