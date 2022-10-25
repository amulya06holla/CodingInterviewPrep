package com.leet.uber.hard;
import java.util.*;
//https://leetcode.com/problems/bus-routes/
/**
 * It shoudl be similar to that of a regular BFS. Basically, we are visiting each bus-route once and in doing so, we are also visiting each bus stop for a given route.
 * So, it should be O(V+E), where V is the total number of bus routes and E is the total number of bus stops.
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> visited = new HashSet<>(); // this is to make sure that we are not stuck in a loop
        Queue<Integer> q = new LinkedList<>(); // queue to simulate bfs kind of logic
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // map which holds every bus stop and buses that pass that bus stop
        int ret=0;
        if (S==T) return 0; // if source and destination are same, just return 0.

        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> busesForthisStop = map.getOrDefault(routes[i][j], new ArrayList<>());
                busesForthisStop.add(i);
                map.put(routes[i][j], busesForthisStop); //  <busStop, <list of buses that pass through this stop>>
            }
        }

        q.offer(S); // queue holds the bus stop
        while (!q.isEmpty()) {
            int len = q.size(); // queue keeps getting new element while in the loop. so better to know the size till which it has to be looped before starting the loop
            ret++; // this gives the number of buses.
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                ArrayList<Integer> bussesToThisStop = map.get(cur); // for each stop, get all the busses that connects to this stop.
                for (int bus: bussesToThisStop) { // run loop for all the busses in the arraylist
                    if (visited.contains(bus)) continue; // if already visited, then continue
                    visited.add(bus); // else first add the stop into visited
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return ret;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
