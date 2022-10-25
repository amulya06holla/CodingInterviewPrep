package com.leet.matrix.medium;
//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rows =n;
        int columns=n;
        int rs=0,cs=0, re=n-1, ce=n-1; int count =1;
        while(rs<=re && cs<=ce) {
            if(rs<=re && cs<=ce) {
                for(int i=cs; i<=ce; i++) {
                    matrix[rs][i]=count++;
                }
                rs++;
            }
            if(rs<=re && cs<=ce) {
                for(int j=rs; j<=re; j++) {
                    matrix[j][ce]=count++;
                }
                ce--;
            }
            if(rs<=re && cs<=ce) {
                for(int i=ce; i>=cs; i--) {
                    matrix[re][i]=count++;
                }
                re--;
            }
            if(rs<=re && cs<=ce) {
                for(int j=re; j>=rs; j--) {
                    matrix[j][cs]=count++;
                }
                cs++;
            }
        }
        return matrix;
    }
}
