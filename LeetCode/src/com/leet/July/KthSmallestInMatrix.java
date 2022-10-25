package com.leet.July;

import com.leet.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        System.out.println(kthSmallest(grid, 8));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int res =0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer lhs, Integer rhs) {
                if (lhs > rhs) return +1;
                if (lhs.equals(rhs)) return 0;
                return -1;
            }
        });
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                pq.offer(matrix[i][j]);
            }
        }
       // System.out.println("----------");
        Integer val =0;
        int t=0;
        while( (val = pq.poll()) != null) {
            if(t+1==k) res=val;
            //System.out.println(val);
            t++;
        }
        return res;
    }
}
