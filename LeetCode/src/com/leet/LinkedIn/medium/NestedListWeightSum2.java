package com.leet.LinkedIn.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum2 {

    private int maxDepth;
    private void depthFinder(List <NestedInteger> nestedList, int currDepth){
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                if(currDepth > this.maxDepth){
                    this.maxDepth = currDepth;
                }
            }else{
                depthFinder(ni.getList(), currDepth+1);
            }
        }
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue <NestedInteger> queue = new LinkedList <>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;
        depthFinder(nestedList, 1);
        System.out.println(maxDepth);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nested = queue.poll();
                if (nested.isInteger()) {
                    total = total+ ((this.maxDepth- depth)+1)*nested.getInteger();
                } else {
                    queue.addAll(nested.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
