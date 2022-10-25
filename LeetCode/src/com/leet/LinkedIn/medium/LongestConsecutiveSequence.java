package com.leet.LinkedIn.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set <Integer> seen = new HashSet <>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer i : set) {
            if (!seen.contains(i)) {
                int current = 0;
                Stack <Integer> stack = new Stack<>();
                stack.add(i);
                while (!stack.isEmpty()) {
                    Integer dis = stack.pop();
                    seen.add(dis);
                    current++;
                    if (!seen.contains(dis + 1) && set.contains(dis + 1)) {
                        stack.add(dis + 1);
                    }
                    if (!seen.contains(dis - 1) && set.contains(dis - 1)) {
                        stack.add(dis - 1);
                    }
                }
                ans = Math.max(ans, current);
            }
        }
        return ans;
    }
}
