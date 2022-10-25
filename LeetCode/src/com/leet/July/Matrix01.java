package com.leet.July;
//https://leetcode.com/problems/01-matrix/
public class Matrix01 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,0,0,1,0,0,1,1,0},
 {1,0,0,1,0,1,1,1,1,1},
 {1,1,1,0,0,1,1,1,1,0},
 {0,1,1,1,0,1,1,1,1,1},
 {0,0,1,1,1,1,1,1,1,0},
 {1,1,1,1,1,1,0,1,1,1},
 {0,1,1,1,1,1,1,0,0,1},
 {1,1,1,1,1,0,0,1,1,1},
 {0,1,0,1,1,0,1,1,1,1},
 {1,1,1,0,1,0,1,1,1,1}
        };
        updateMatrix(mat);
    }
    public static int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];

        for(int i=0; i<mat.length;i++){
            for(int j=0; j<mat[i].length; j++){
                    res[i][j]=Integer.MAX_VALUE-1;
            }
        }

        for(int i=0; i<mat.length;i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j]==0) res[i][j]=0;
                else{
                    if (i > 0)
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    if (j > 0)
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }

        for(int i=mat.length-1; i>=0;i--){
            for(int j=mat[i].length-1; j>=0; j--){
                    if (i < mat.length-1)
                        res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    if (j < mat[i].length-1)
                        res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
            }
        }
        return res;
    }
}
