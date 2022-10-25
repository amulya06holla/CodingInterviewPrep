package com.leet.Apple.medium;

import java.util.*;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/solution/
public class FindCheapestFlights {

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

            //basic creation of a map with <source, <destination, cost>>
            Map<Integer, Map <Integer, Integer>> prices = new HashMap <>();
            for (int[] f : flights) {
                if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
                prices.get(f[0]).put(f[1], f[2]);
            }

            // take a priorityQueue to solve this as dikstra's : its a min heap for with prices.
            // priorityqueue will have an array[price, city, numberofstops (max is k+1)]
            Queue <int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
            pq.add(new int[] {0, src, K + 1}); // bcz we can have atmost k+1 stops. not exactly k stops

            while (!pq.isEmpty()) {

                int[] top = pq.remove();
                int price = top[0];
                int city = top[1];
                int stops = top[2];

                if (city == dst) return price;

                if (stops > 0) {
                    Map<Integer, Integer> detinationWithPricesMap = prices.getOrDefault(city, new HashMap<>());
                    for (int a : detinationWithPricesMap.keySet()) {
                        pq.add(new int[] {price + detinationWithPricesMap.get(a), a, stops - 1});
                    }
                }
            }
            return -1;
        }

}
