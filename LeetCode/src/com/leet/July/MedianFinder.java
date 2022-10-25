package com.leet.July;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/solution/
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        /* By default Java provides min heap. For max heap, we need to pass in a appropriate comparator */
        maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2.compareTo(i1);
            }
        });
    }
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
            return (double) (maxHeap.peek()+minHeap.peek())*0.5 ;
        else
            return (double) maxHeap.peek();
    }
}
