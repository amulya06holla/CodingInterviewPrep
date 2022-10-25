package com.leet.arrays.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class FindKthLargest {
    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums, int k) {
        int res =0;
        Arrays.sort(nums);
        for(int i=nums.length; i>0;i--){
            if(k==0) return res;
            res = nums[i];
        }
        return res;
    }
    public int findKthLargestPriorityQueue(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue <Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
