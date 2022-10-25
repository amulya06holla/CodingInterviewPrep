package com.leet.LinkedIn.medium;
//https://leetcode.com/problems/flatten-nested-list-iterator/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator <Integer> {
    private List<Integer> integers = new ArrayList <Integer>();
    int pos;
    public NestedIterator(List <NestedInteger> nestedList) {
        flattenList( nestedList);
        this.pos =0;
    }

    private void flattenList(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                integers.add(nestedInteger.getInteger());
            } else {
                flattenList(nestedInteger.getList());
            }
        }
    }
    @Override
    public Integer next() {
        if(!hasNext()) return -1;
        return integers.get(pos++);
    }

    @Override
    public boolean hasNext() {
        return !(pos==0);
    }
}
