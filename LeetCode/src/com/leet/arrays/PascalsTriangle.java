package com.leet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> ans = generate(3);
        for(int i=0; i<ans.size();i++)
            System.out.println(Arrays.toString(ans.get(i).toArray()));

        List<Integer> answer = getRow(3);
        System.out.println(Arrays.toString(answer.toArray()));
    }

    public static List<List<Integer>> generate(int rowIndex) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        if(rowIndex==0) return res;

            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            res.add(ans);
        for (int rowNum = 1; rowNum < rowIndex; rowNum++) {
            ans = new ArrayList<>();
            List<Integer> lastRow = res.get(rowNum-1);
            ans.add(1);
            for(int j=1; j<rowNum;j++){
                int temp =0;
                if(lastRow.get(j)!=null)
                    temp = lastRow.get(j);
                int val = temp+lastRow.get(j-1);
                ans.add(val);

            }
            ans.add(1);
            res.add(ans);
        }


        return res;
    }

    //https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/3234/

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>>  res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<>();
        ans = new ArrayList<>();
        ans.add(1);
        res.add(ans);
        for (int rowNum =1; rowNum <= rowIndex; rowNum++) {
            ans = new ArrayList<>();
            List<Integer> lastRow = res.get(rowNum-1);
            ans.add(1);
            for(int j=1; j<lastRow.size();j++){
                int temp =0;
                if(lastRow.get(j)!=null)
                    temp = lastRow.get(j);
                int val = temp+lastRow.get(j-1);
                ans.add(val);

            }
            ans.add(1);
            res.add(ans);
        }


        return res.get(rowIndex);
    }
}
