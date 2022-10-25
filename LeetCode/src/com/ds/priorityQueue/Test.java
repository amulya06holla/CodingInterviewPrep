package com.ds.priorityQueue;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue <Integer> pq = new PriorityQueue <>((n1, n2) -> n2-n1);
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b)->b-a);
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a, b)->b.getValue()-a.getValue());
        pq.add(3);
        pq.add(2);
        pq.add(4);
        System.out.println(pq.poll());
    }
}
