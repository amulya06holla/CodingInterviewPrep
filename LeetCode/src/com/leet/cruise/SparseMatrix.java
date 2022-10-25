package com.leet.cruise;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/sparse-matrix-multiplication/
//https://github.com/SCIN/Facebook-Interview-Coding-1/blob/master/Sparce%20Matrix%20Multiplication.java
public class SparseMatrix {
    public int[][] sparseMatrixMultiplication(int[][] mat1, int[][] mat2) {

        if (mat1.length == 0 || mat1[0].length == 0 || mat2.length == 0 || mat2[0].length == 0)
            return new int[][]{};

        int m = mat1.length, n = mat2.length, d = mat2[0].length;

        // with matrix multiplication, (m*n) X (n*d) = (m*d)
        int[][] res = new int[m][d];
        // because it is sparse matrix, most values in it will be zero.
        // so firstly to reduce storing it in 2 d array, we are using hashmap to store the value of ONE of the arrays.
        Map<Integer, Map <Integer, Integer>> map = new HashMap <>();
        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int j = 0; j < n; j++)
                if (mat1[i][j] != 0)     temp.put(j, mat1[i][j]);
            map.put(i, temp);
        }

        for (int key1 : map.keySet()) {
            for (int i = 0; i < d; i++) {
                for (int key2 : map.get(key1).keySet()) {
                    res[key1][i] += map.get(key1).get(key2) * mat2[key2][i];
                }
            }
        }
        return res;
    }
}
