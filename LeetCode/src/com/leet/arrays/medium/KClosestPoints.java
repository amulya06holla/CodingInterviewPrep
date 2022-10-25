package com.leet.arrays.medium;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosestPoints {
    public static void main(String[] args) {

    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue <int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        for(int i=0; i<points.length; i++){

            int x = points[i][0];
            int y = points[i][1];

            int dist = x*x + y*y;

            pq.add(new int[]{dist,x, y});

            if(pq.size() > k)
                pq.remove();
        }

        int count = 0;
        int res[][] = new int[k][2];
        while(!pq.isEmpty()){
            int aa[] = pq.poll();
            res[count][0] = aa[1];
            res[count][1] = aa[2];
            count++;
        }
        return res;
    }
}
