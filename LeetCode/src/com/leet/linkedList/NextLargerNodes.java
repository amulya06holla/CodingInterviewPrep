package com.leet.linkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextLargerNodes {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{1, 7, 5, 1, 9, 2, 5, 1};
        ListNode list1 = l.createListFromArray(arr1);
        l.printNodes(list1);
        System.out.println(Arrays.toString(nextLargerNodes(list1)));
    }

    public static int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int[] res = new int[count];
//        int[] nums = new int[count];
//        temp = head; int n=0;
//        while (temp != null) {
//            nums[n++]= temp.val;
//            temp = temp.next;
//        }
//        for (int j = nums.length - 1; j >= 0; j--) {
//            while (!s.empty() && nums[s.peek()] <= nums[j]) {
//                s.pop();
//            }
//            if (!s.empty()) {
//                res[j] = nums[s.peek()];
//            }
//            s.push(j);
//        }
        return res;
    }
}

