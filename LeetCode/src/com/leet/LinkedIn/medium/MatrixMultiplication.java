package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/sparse-matrix-multiplication/
public class MatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
//        System.out.println(mat1.length +" "+mat1[0].length);
//        System.out.println(mat2.length +" "+mat2[0].length);
        int[][] res = new int[mat1.length][mat2[0].length];

        for (int i = 0; i<mat1.length; ++i)
        {
            for (int k = 0; k<mat1[0].length; ++k)
            {
                if(mat1[i][k]!=0)
                {
                    for (int j = 0; j<mat2[0].length; ++j)
                    {
                        if(mat2[k][j]!=0)
                            res[i][j]+=mat1[i][k]*mat2[k][j];
                    }
                }
            }
        }
        return res;
    }
}
