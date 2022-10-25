package com.leet.July;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixReshape {
    public static void main(String[] args) {

    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        Queue<Integer> q = new LinkedList();

        if (mat.length == 0 || r * c != (mat.length * mat[0].length))
            return mat;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                q.add(mat[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = q.remove();
            }
        }
        return res;
    }
}
