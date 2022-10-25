package com.leet.LinkedIn.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList <>();

        if(intervals.length == 0){
            res.add(newInterval);
        }

        int newBegin = newInterval[0];
        int newEnd = newInterval[1];

        for(int i = 0; i < intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(newBegin > currentEnd){//current range is less than new range
                res.add(new int[]{currentStart,currentEnd});
            }
            else if(newBegin >= currentStart){//Start point of merge
                newBegin = Math.min(currentStart,newBegin);
                newEnd = Math.max(currentEnd,newEnd);

            }else if(newEnd >= currentStart){//Continue merging by updating end
                newEnd = Math.max(currentEnd,newEnd);

            }else if(newEnd < currentStart){// At the end of merge, add both intervals, current and new merged range
                res.add(new int[]{newBegin,newEnd});
                res.add(new int[]{currentStart,currentEnd});
                newBegin = Integer.MAX_VALUE;//Once merged, after elements will be added without any check, as array is sorted
            }

            //If its a last element, we dont wanna skip
            if(i == intervals.length - 1 && newBegin != Integer.MAX_VALUE){
                res.add(new int[]{newBegin,newEnd});
            }


        }

        return res.toArray(new int[0][]);
    }
}
