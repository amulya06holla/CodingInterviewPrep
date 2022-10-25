package com.leet.intuit;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/reorganize-string
public class ReorganiseString {
    public String reorganizeString(String str) {
        Map <Character, Integer> freq = new HashMap <>();
        char[] chars = str.toCharArray();

        // Create a frequency Map
        for(char chare: chars) {
            freq.put(chare, freq.getOrDefault(chare, 0) + 1);
        }

        // Create a max heap, give priority acc to frequency
        Queue <Character> maxHeap = new PriorityQueue <>((a, b) -> freq.get(b) - freq.get(a));

        for(char chare: freq.keySet()) {
            maxHeap.offer(chare);
        }

        char[] result = new char[str.length()];
        int index = 0;
        char cached = 0;

        while(!maxHeap.isEmpty()) {
            // letter with max frequency will be on the top
            char ch = maxHeap.poll();
            int f = freq.get(ch) - 1;

            // update the frequency in hashmap
            freq.put(ch, f);
            result[index++] = ch;

            // check if any letter present in cache, then add it again to the queue
            if(cached != 0) {
                maxHeap.offer(cached);
            }

            // Put the current character, removed from the heap, to the cache
            // because we cannot use it as the next element
            // aab is a string, once we use 'a', we cannot use it immediately,
            // so put it the cache and once you use another letter put it back to the queue
            if(f > 0) {
                cached = ch;
            } else {
                cached = 0;
            }
        }

        // if cache is not empty, it means we could not place some letter
        if(cached != 0) {
            return "";
        }

        return new String(result);
    }

    public static void main(String[] args) {
        ReorganiseString r = new ReorganiseString();
        System.out.println(r.reorganizeString("aaaabbbb"));
    }
}
