package com.leet.paypal.medium;
//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r =0, c = matrix[0].length-1;
        while(r<matrix.length && c>=0){
            if(matrix[r][c]==target) return true;
            else if(target>matrix[r][c]){
                r++;
            }else if(target<matrix[r][c]){
                c--;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
