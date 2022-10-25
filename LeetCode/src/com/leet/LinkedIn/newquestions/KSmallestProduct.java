package com.leet.LinkedIn.newquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//https://leetcode.com/discuss/interview-question/302028/linkedin-smallest-k-products-of-two-sorted-array
//https://stackoverflow.com/questions/56382653/how-to-get-the-k-smallest-products-from-pairs-from-two-sorted-arrays
public class KSmallestProduct {
    public static PriorityQueue<List <Integer>> res_queue = new PriorityQueue <>(
            (a,b) -> a.get(0)*a.get(1) - (b.get(0)*b.get(1))
    );

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a,b) -> a[0]*a[1] - (b[0]*b[1])
        );

        List<List<Integer>> result = new ArrayList <>();
        if(nums1.length == 0 || nums2.length == 0 || k==0){
            return result;
        }

        // Adding all the nums1 and nums2 first element to the array
        for(int i=0; i<nums1.length && i<k; i++){
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k-- > 0 && !queue.isEmpty()){
            int[] cur = queue.poll();

            List<Integer> tempList = new ArrayList<>();
            tempList.add(cur[0]);
            tempList.add(cur[1]);
            res_queue.add(tempList);


            if(cur[2] == nums2.length - 1){
                continue;
            }

            queue.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {-2, -1, 0, 1, 2};
        int[] num2 = {-3, -1, 2, 4, 5};

        int[] num1_pos = {0, 1, 2};
        int[] num1_neg = {-1, -2};
        int[] num2_pos = { 2, 4, 5};
        int[] num2_neg = {-1, -3};

        // F(A+, B+)
        // F(A+, reverse(B-))
        // F(reverse(A-), B+)
        // F(reverse(A-), reverse(B-))


        kSmallestPairs(num1_pos, num2_pos, 3);
        kSmallestPairs(num1_pos, num2_neg, 3);

        kSmallestPairs(num1_neg, num2_pos, 3);
        kSmallestPairs(num1_neg, num2_neg, 3);

        System.out.println(res_queue.poll().toString());
        System.out.println(res_queue.poll().toString());
        System.out.println(res_queue.poll().toString());
    }
}
