package com.leet.cruise;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/car-pooling/solution/
public class CarPooling {
        public boolean carPooling(int[][] trips, int capacity) {
            if(capacity==0) return false;
            Map <Integer, Integer> timestamp = new TreeMap <>();

            for (int[] trip : trips) {
                int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
                timestamp.put(trip[1], startPassenger);

                int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
                timestamp.put(trip[2], endPassenger);
            }

            int usedCapacity = 0;
            for (int passengerChange : timestamp.values()) {
                usedCapacity += passengerChange;
                if (usedCapacity > capacity) {
                    return false;
                }
            }
            return true;
        }

        // bucket sort method.
    public boolean carPoolingbucketSort(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int usedCapacity = 0;
        for (int number : timestamp) {
            usedCapacity += number;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
