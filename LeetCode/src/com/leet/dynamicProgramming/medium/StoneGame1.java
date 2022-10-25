package com.leet.dynamicProgramming.medium;

public class StoneGame1 {
    // reliased the algorithm after first writing the recursion for the solution
    // in any subset, starting at i, and ending at j, alex has two choices:
    //1.pick the ith stone and then Lee picks correspondingly in the set (i+1,j]
    //2.pick the jth stone and then Lee picks correspondingly in the set [i,j-)
    // we identify the max sum on the basis of picking either the ith or the jth values
    // The max total of the set [i, j] will be the maximum of the two values above
    public boolean stoneGame(int[] piles) {
        int m =piles.length;
        int findMax[][] = new int[m][m];
        // setting the base condition, when the subset is [i,i], the max value one player can get is piles[i]
        for(int i=0;i<m;i++){
            findMax[i][i] = piles[i];
        }
        // as we increase the length of the subset
        // we can calculate in the bottom up manner the max value for the subset[0,m-1]
        for(int l=2;l<=m;l++){
            for(int i=0;i+l-1<m;i++){
                int j = i+l-1;
                // max sum possible when Alex picks i, minus when Lee picks in the range which remaining
                int a = piles[i] - findMax[i+1][j];
                // max sum possible when Alex picks j, minus when Lee picks in the range which remaining
                int b = piles[j] - findMax[i][j-1];
                // max sum of the subset [i,j]
                findMax[i][j] = Integer.max(a,b);
            }
        }
        return findMax[0][m-1]>0;
    }
}
