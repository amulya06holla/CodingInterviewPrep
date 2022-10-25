package com.leet.Oracle.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords t = new TopKFrequentWords();
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        System.out.println(t.topKFrequent(words,3));
    }
    public List<String> topKFrequent(String[] words, int k) {
        List <String> res = new ArrayList <>();
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        return res;
    }
}
