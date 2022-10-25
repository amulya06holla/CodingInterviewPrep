package com.leet.arrays.medium;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms-ii/
public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        int res =0;
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int m = 1, n=0; res++; int meetingRoomNeeded=1;
        while(m!=intervals.length && n!=intervals.length){
            if(startTime[m]<= endTime[n]){
                meetingRoomNeeded++;
                m++;
            }else {
                meetingRoomNeeded--;
                n++;

            }
            if(meetingRoomNeeded>res) res=meetingRoomNeeded;
        }
        return res;
    }
}
