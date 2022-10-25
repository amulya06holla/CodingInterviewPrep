package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/bomb-enemy/solution/
public class BombEnemies {
    public int maxKilledEnemies(char[][] grid) {
        int rowHits=0;
        int[] colHits = new int[grid[0].length];
        int maxCount=0;

        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                // reset the hits on the row, if necessary.
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for (int k = j; k < grid[0].length; ++k) {
                        if (grid[i][k] == 'W')
                            // stop the scan when we hit the wall.
                            break;
                        else if (grid[i][k] == 'E')
                            rowHits += 1;
                    }
                }

                // we are using colHits as array because, we are not going over every column for every row. we are going from k=i. hence we need colHits as array
                // reset the hits on the column, if necessary.
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < grid.length; ++k) {
                        if (grid[k][j] == 'W')
                            break;
                        else if (grid[k][j] == 'E')
                            colHits[j] += 1;
                    }
                }

                // run the calculation for the empty cell.
                if (grid[i][j] == '0') {
                    maxCount = Math.max(maxCount, rowHits + colHits[j]);
                }
            }
        }
        return maxCount;
    }
}
