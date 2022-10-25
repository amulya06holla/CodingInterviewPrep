package com.leet.strings.medium;

import java.util.*;

public class topKFrequentWords {
    public static void main(String[] args) {
        topKFrequentWords tw = new topKFrequentWords();
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        System.out.println(Arrays.toString(tw.topKFrequent(words, 2).toArray()));
    }
    public List <String> topKFrequent(String[] words, int k) {
        // Build a Map of words and their corresponding frequencies
        Map<String, Integer> map = new HashMap<>();
        Arrays.asList(words)
                .forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));

        // Define a minHeap that stores elements in -
        // i. ascending order of frequency and
        // ii. reverse alphabetical order of words when frequencies match
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2)) ;

        // Build the minHeap upto K elements
        for(String word: map.keySet()){
            pq.add(word);
            if(pq.size() > k)
                pq.poll();
        }

        // Build the final list
        List<String> result = new ArrayList<>();
        while(!pq.isEmpty())
            result.add(0, pq.poll());

        return result;
    }

}
