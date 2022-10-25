package com.leet.uber.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public List <Integer> spiralOrder(int[][] matrix) {
        List <Integer> res = new ArrayList <>();
        int rs =0, cs =0, re=matrix.length-1, ce=matrix[0].length-1;
        while(rs<=re && cs<=ce){
            if(rs<=re && cs<=ce){
                // move left to right
                for(int i=cs;i<=ce;i++){
                    res.add(matrix[rs][i]);
                }
                rs++;
            }
            if(rs<=re && cs<=ce){
                // move top to bottom
                for(int i=rs;i<=re;i++){
                    res.add(matrix[i][ce]);
                }
                ce--;
            }
            if(rs<=re && cs<=ce){
                // move right to left
                for(int i=ce;i>=cs;i--){
                    res.add(matrix[re][i]);
                }
                re--;
            }
            if(rs<=re && cs<=ce){
                // move bottom to top
                for(int i=re;i>=rs;i--){
                    res.add(matrix[i][cs]);
                }
                cs++;
            }
        }
        return res;
    }
}
