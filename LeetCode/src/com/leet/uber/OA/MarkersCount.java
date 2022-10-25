package com.leet.uber.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/discuss/interview-question/1416830/Uber-or-Sr-Software-Engineer-(Architect)-Backend-or-OA-or-2021-or-Off-Campus-or-Code-Signal
public class MarkersCount {
    public int easyCountUber(int[][] intervals){
        int res=0;
        List <int[]> mergedIntervals = new ArrayList <>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList <int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        for(int i=0; i<merged.size();i++){
            res = res+(merged.get(i)[1]-merged.get(i)[0])+1;
        }
        return res;
    }
}
