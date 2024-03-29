package com.leet.arrays.monotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;

//https://leetcode.com/problems/sliding-window-maximum/
public class MaxInSlidingWindow {
    public static void main(String[] args) {
        MaxInSlidingWindow sw = new MaxInSlidingWindow();
        int[] nums=new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(sw.maxSlidingWindow(nums, 3)));
    }
        ArrayDeque <Integer> deq = new ArrayDeque<Integer>();
        int [] nums;

        public void clean_deque(int i, int k) {
            // remove indexes of elements not from sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            // remove INDEXES from dequeue if the elements of that index is smaller than the current index
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
                deq.removeLast();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            for (int i = 0; i < k; i++) {
               // clean_deque(i, k);
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) max_idx = i;
            }
            int [] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i  = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }

}
