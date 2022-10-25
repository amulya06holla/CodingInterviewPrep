package com.leet.Apple.hard;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = findSmallAround(i, j, matrix, cache, Integer.MIN_VALUE);
                max = Math.max(length, max);
            }
        }
        return max;
    }
    private int findSmallAround(int i, int j, int[][] matrix, int[][] cache, int pre) {
        // check if it is safe move:::: if out of bond OR current cell value lesser or equal to  previous cell value.
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) {
            return 0;
        }
        // if calculated before, no need to do it again
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            // else go to up, down, right and left and see which direction will give more number of increasing numbers
            int cur = matrix[i][j];
            int u = findSmallAround(i - 1, j, matrix, cache, cur);
            int d = findSmallAround(i + 1, j, matrix, cache, cur);
            int l = findSmallAround(i, j - 1, matrix, cache, cur);
            int r = findSmallAround(i, j + 1, matrix, cache, cur);
            int result = 1+Math.max(Math.max(d,u), Math.max(l,r));
            cache[i][j] = result;
            return result;
        }
    }
}
