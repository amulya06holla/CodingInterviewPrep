package com.leet.matrix.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
    }
    public static List <Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList <>();
        int rows =matrix.length;
        int columns=matrix[0].length;
        int rs=0,cs=0, re=matrix.length-1, ce=matrix[0].length-1;
        while(rs<=re && cs<=ce) {
            if(rs<=re && cs<=ce) {
                for(int i=cs; i<=ce; i++) {
                    res.add(matrix[rs][i]);
                }
                rs++;
            }
            if(rs<=re && cs<=ce) {
                for(int j=rs; j<=re; j++) {
                    res.add(matrix[j][ce]);
                }
                ce--;
            }
            if(rs<=re && cs<=ce) {
                for(int i=ce; i>=cs; i--) {
                    res.add(matrix[re][i]);
                }
                re--;
            }
            if(rs<=re && cs<=ce) {
                for(int j=re; j>=rs; j--) {
                    res.add(matrix[j][cs]);
                }
                cs++;
            }
        }
        return res;
    }
}
