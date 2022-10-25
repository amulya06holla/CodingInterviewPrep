package com.leet.uber.medium;

import java.util.Arrays;

//https://leetcode.com/problems/meeting-rooms-ii/
public class MinMeetingRooms {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {

            // Check for the base case. If there are no intervals, return 0
            if (intervals.length == 0) {
                return 0;
            }

            Integer[] start = new Integer[intervals.length];
            Integer[] end = new Integer[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }

            Arrays.sort(end , (a1,a2)->a1-a2);
            Arrays.sort(start, (a1,a2)->a1-a2 );

            int startPointer = 0, endPointer = 0;
            int usedRooms = 0;

            // Iterate over intervals.
            while (startPointer < intervals.length) {

                // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
                if (start[startPointer] >= end[endPointer]) {
                    usedRooms -= 1;
                    endPointer += 1;
                }
                usedRooms += 1;
                startPointer += 1;

            }

            return usedRooms;
        }
    }
}
