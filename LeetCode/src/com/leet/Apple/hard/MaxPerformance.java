package com.leet.Apple.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-performance-of-a-team/solution/
public class MaxPerformance {

        public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
            int modulo = (int) Math.pow(10, 9) + 7;
            // build tuples of (efficiency, speed)
            List <int[]> candidates = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                candidates.add(new int[]{efficiency[i], speed[i]});
            }
            // sort the members by their efficiencies
            Collections.sort(candidates, (a,b)->b[0]-a[0]);

            // create a heap to keep the top (k-1) speeds
            PriorityQueue <Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

            long speedSum = 0, perf = 0;
            for (int[] p : candidates) {
                Integer currEfficiency = p[0];
                Integer currSpeed = p[1];
                // maintain a heap for the fastest (k-1) speeds
                if (speedHeap.size() > k - 1) {
                    speedSum -= speedHeap.remove();
                }
                speedHeap.add(currSpeed);

                // calculate the maximum performance with
                // the current member as the least efficient one in the team
                speedSum += currSpeed;
                perf = Math.max(perf, speedSum * currEfficiency);
            }
            return (int) (perf % modulo);
        }

}
