package com.leet.uber.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {
    public List<List <Integer>> generate(int numRows) {
        List<List <Integer>> res = new ArrayList <>();
        List <Integer> list = new ArrayList <>();
        list.add(1);
        res.add(list);
        if(numRows==1) return res;
        for(int i=1; i<numRows;i++){
            list = new ArrayList <>();
            List<Integer> prev = res.get(i-1);
            list.add(1);
            for(int j=1; j<i;j++){
                list.add(prev.get(j-1)+prev.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
