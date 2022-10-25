package com.leet.Apple.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-profit-in-job-scheduling/solution/
public class JobScheduling {

    class Solution {

        private int findMaxProfit(List<int[]> jobs) {

            // sort the input based on start time
            jobs.sort((a,b)->a[0]-b[0]);

            int n = jobs.size(), maxProfit = 0;

            // min heap : sorted with endtime
            //min heap hold int[]: [starttime, endtime, profittillnow]
            PriorityQueue <int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

            for (int i = 0; i < n; i++) {
                int start = jobs.get(i)[0], end = jobs.get(i)[1], profit = jobs.get(i)[2];

                // calculate profit based on the
                while (!pq.isEmpty() && start >= pq.peek()[1]) {
                    maxProfit = Math.max(maxProfit+profit, pq.peek()[2]+profit);
                    pq.poll();
                }

                // add only the last element with updated maxProfit.
                int[] combinedJob = new int[]{start, end, maxProfit};

                // push the job with combined profit
                // if no non-conflicting job is present maxProfit will be 0
                pq.add(combinedJob);
            }

            // update the value of maxProfit by comparing with
            // profit of jobs that exits in the heap
            while (!pq.isEmpty()) {
                maxProfit = Math.max(maxProfit, pq.peek()[2]);
                pq.remove();
            }

            return maxProfit;
        }

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            List<int[]> jobs = new ArrayList<>();

            // storing job's details into one list
            // this will help in sorting the jobs while maintaining the other parameters
            int length = profit.length;
            for (int i = 0; i < length; i++) {
               int[] arr = new int[]{startTime[i], endTime[i], profit[i]};
                jobs.add(arr);
            }

            return findMaxProfit(jobs);
        }
    }
}
