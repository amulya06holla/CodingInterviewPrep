package com.leet.Oracle.medium;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-words/submissions/
public class TopKFrequent {
    public List <String> topKFrequent(String[] words, int k) {

        List<String> result = new LinkedList <>();
        Map <String, Integer> map = new HashMap <>();
        for(int i=0; i<words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue <Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}
