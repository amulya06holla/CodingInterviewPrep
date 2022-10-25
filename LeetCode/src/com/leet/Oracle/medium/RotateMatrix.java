package com.leet.Oracle.medium;
//https://leetcode.com/problems/rotate-image/
public class RotateMatrix {

        public void rotate(int[][] matrix) {
            transpose(matrix);
            reflect(matrix);
        }

        public void transpose(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
        }

        // reflect is reverse each row
        public void reflect(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = tmp;
                }
            }
        }

}