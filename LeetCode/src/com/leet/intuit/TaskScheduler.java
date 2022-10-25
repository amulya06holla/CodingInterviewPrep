package com.leet.intuit;
/**
 * same like reorganise string problem. there it was every alternate letter. hence caching was done using variable.
 * but since here its not necessarily alternate letter. hence using queue to cache the repeated letters and pop out whenever it is appropriate.
 */

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // count each char
        HashMap <Character, Integer> map = new HashMap<>();

        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // put each number in priorityqueue, decreasing order
        PriorityQueue <Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for( Map.Entry<Character,Integer> entry : map.entrySet() ) q.add(entry.getValue());

        // queue to help us track time range
        Queue <int[]> coolDown = new LinkedList<>();
        int i = 1;
        while(true){
            // if priority queue is not empty, we remove one from top, -1, then if it > 0, put it in queue with its next time window( i + n )
            if(!q.isEmpty()){
                int cur = q.remove();
                cur--;
                if(cur > 0){
                    int[] temp = new int[]{cur, i + n};
                    coolDown.add(temp);
                }
            }
            // if both queue is empty ,break the loop
            if(q.isEmpty() && coolDown.isEmpty()) break;
            // otherwise, if top value on queue has same time window as i , remove it add back to PriorityQueue
            if(!coolDown.isEmpty() && coolDown.peek()[1] == i) q.add(coolDown.remove()[0]);
            i++;

        }

        return i;

    }
}
