package com.leet.arrays.easy;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms/
public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int m = 1, n=0;
        while(m!=intervals.length && n!=intervals.length){
            if(startTime[m]< endTime[n]){
                return false;
            }else {
                n++;
                m++;
            }
        }
        return true;
    }
}
