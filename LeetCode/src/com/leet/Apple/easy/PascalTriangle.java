package com.leet.Apple.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {
    public List<List <Integer>> generate(int numRows) {
        List<List <Integer>> res = new ArrayList <>();
        for(int i=1; i<=numRows; i++){
            List <Integer> list = new ArrayList <>();
            if(i==1){
                list.add(1);
                res.add(list);
            }else if(i==2){
                list.add(1);
                list.add(1);
                res.add(list);
            }else{
                list.add(1);
                for(int j=0; j<res.get(i-2).size()-1;j++){
                    list.add(res.get(i-2).get(j)+res.get(i-2).get(j+1));
                }
                list.add(1);
                res.add(list);
            }
        }
        return res;
    }
}
