package com.leet.uber.OA;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/discuss/1471265/Java-Sort-%2B-sliding-window-(faster-than-94)
//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
public class MinOperationsToSortArray {
    public int minOperations(int[] nums) {

        /**
         * Sort the Array First, so that we can utilise the given property of contiguous which is
         *  "The difference between the maximum element and the minimum element in nums equals nums.length - 1."
         */
        Arrays.sort(nums);

        int length = nums.length;
        int maxWindowSize = 0;

        // Will use this queue to hold the numbers of elements for a window
        Deque<Integer> queue = new ArrayDeque<>();

        for (int num : nums) {
            /**
             * If the queue is not empty and the num value is not adhere to the property of contiguous.
             * i.e - "The difference between the maximum element and the minimum element in nums equals nums.length - 1."
             * Meaning if the array is [1 , 2 , 3 , 4, 5 , 6]
             * So smallest element is : 1
             * so, a element can be considered as contagious if the length of array is greater than current element - smallest element.
             * i.e 4 - 1 = 3 which is less than length 6
             *
             * In those cases We will remove the values from first from the queue.
             */
            while (!queue.isEmpty() && num - queue.peekFirst() >= length) {
                queue.pollFirst();
            }

            /**
             * If queue is empty or the last element is not same as current element. To avoid duplicate element.
             * Note : Here all the elements will be in the range of smallest element and (nums length - 1 + smallest element).
             * Other cases is taken care as part of the previous condition
             */
            if (queue.isEmpty() || queue.peekLast() != num) {
                queue.add(num);
            }

            /**
             * Keep tracking of the maximum size of the queue
             */
            maxWindowSize = Math.max(maxWindowSize, queue.size());
        }

        /**
         * If there are n element and m was the size of the window the no of elements needed is (n - m)
         */
        return length - maxWindowSize;
    }
}
