package com.leet.uber.easy;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/moving-average-from-data-stream/
public class MovingAverage {
    int size, windowSum = 0, count = 0;
    Deque queue = new ArrayDeque<Integer>();
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        queue.addLast(val);
        int tail = count > size ? (int)queue.removeFirst() : 0;
        windowSum = windowSum - tail + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}
