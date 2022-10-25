package com.leet.uber.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/1061013/Uber-OA
public class BoundedSquareSum {
    public static void main(String[] args) {
        BoundedSquareSum t =new BoundedSquareSum();
        int[]a = new int[]{3, -1, 9};
        int[]b = new int[]{100, 5, -2};
        System.out.println(t.countPairs(a,b,7,99));
    }


    public int countPairs(int[] a, int[] b, int lower, int upper) {
        if (a.length > b.length) {
            countPairs(b,a,lower,upper); // let smaller sized array be a.
        }

        for (int i = 0; i < a.length; i++) {// put squares of a into array a.
            a[i] = a[i] * a[i];
        }
        Arrays.sort(a); // sorting the shortest array which now holds the square of its elements.
        if(a[0] > upper) // if the very first element is shorter than the upper value, then there is no way there will be any pair satisfying the condition
            return 0;
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] * b[i] > upper) // if square of b's element itself is greater than upper, no point finding other element from a.
                continue;
            int rightBound = performBinarySearch(a, upper - b[i] * b[i]);// if not, find the matching element in array a.
            // since array a is sorted, its possible to do a binary search on it.
            int leftBound =  performBinarySearch(a, lower - b[i] * b[i]);
            count += rightBound - leftBound;// increment the count by index of the array a. bcz all elements between left and right will be the valid pair combination
        }

        return count;

    }

    public int performBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left + 1 < right) {
            middle = (right - left) / 2 + left;
            if (nums[middle] == target)
                return middle;
            if (nums[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if (target <= nums[left]) return left;
        if (target > nums[left] && target <= nums[right]) return right;
        if (target > nums[right]) return right + 1;
        return -1;
    }

    public int boundedSquareSum2(int[] nums1, int[] nums2, int lower, int upper) {
        if(nums1.length==0 || nums2.length==0 ) return 0;

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> (int)(a[0]+a[1]-b[0]-b[1]));
        int res=0;

        for(int i=0; i<nums1.length ; i++)
            que.offer(new int[]{nums1[i]*nums1[i], nums2[0]*nums2[0], 0});

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int sum = cur[0]+cur[1];
            //System.out.println(sum +" "+cur[0]+" "+cur[1]);
            if(sum>=lower && sum<=upper){
                res++;
            }
            if(cur[2] == nums2.length-1) continue;
           int val =  nums2[(int)cur[2]+1] * nums2[(int)cur[2]+1];
            que.offer(new int[]{cur[0],val, cur[2]+1});
        }
        return res;
    }
}
