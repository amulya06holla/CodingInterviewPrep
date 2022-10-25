package com.leet.LinkedIn.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-java-oklogk-solution-with-explanation
//The run time complexity is O(kLogk) since que.size <= k and we do at most k loop.

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;

        for(int i=0; i<nums1.length && i<k; i++)
            que.offer(new int[]{nums1[i], nums2[0], 0});

        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            List<Integer> list = new ArrayList();
            list.add(cur[0]);
            list.add(cur[1]);
            res.add(list);
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}
