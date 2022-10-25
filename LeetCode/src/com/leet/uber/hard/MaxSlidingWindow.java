package com.leet.uber.hard;

import java.util.ArrayDeque;

//https://leetcode.com/problems/sliding-window-maximum/
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        ArrayDeque<Integer> q = new ArrayDeque();
        int max= Integer.MIN_VALUE, maxPos=0, index=0;
        for(int i=0; i<k;i++){
            if(max<nums[i]){
                max=nums[i];
                maxPos=i;
            }
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()])
                q.pollLast();
            q.offerLast(i);
        }
        res[index++]=max;

        for(int i=k;i<nums.length;i++){
            while(!q.isEmpty() && q.peekFirst()<=(i-k))
                q.pollFirst();
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()])
                q.pollLast();
            q.offerLast(i);
            int val = nums[q.peekFirst()];
            res[index++]=val;

        }
        return res;
    }
}
