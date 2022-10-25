package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/nested-list-weight-sum/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NestedListWeightedSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> nestedList, int depth){
        if(nestedList==null || nestedList.isEmpty()) return 0;
        int res =0;
        for(int i=0; i<nestedList.size();i++){
            NestedInteger ni= nestedList.get(i);
            if(ni.isInteger()){
                res = res + ni.getInteger()*depth;
            }else{
                res = res+ dfs(ni.getList(), depth+1);
            }
        }

        return res;
    }

    public int depthSumBFS(List<NestedInteger> nestedList) {
        Queue <NestedInteger> queue = new LinkedList <>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
