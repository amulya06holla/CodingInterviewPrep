package com.leet.uber.medium;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/find-right-interval/submissions/
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> starts = new TreeMap <>();
        int res[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            //The function ceilingEntry(Key) returns the element just with its \text{Key}Key larger than the Key(passed as the argument) from amongst the elements of the TreeMap and returns null if no such element exists.
            Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i][1]);
            res[i] = pos == null ? -1 : pos.getValue();
        }
        return res;
    }
}
