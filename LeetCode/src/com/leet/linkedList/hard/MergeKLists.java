package com.leet.linkedList.hard;

import com.leet.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{1,2,3,4,5};
        ListNode list1 = l.createListFromArray(arr1);
        int arr2[] = new int[]{1,2,3};
        ListNode list2 = l.createListFromArray(arr2);
        int arr3[] = new int[]{4,5};
        ListNode list3 = l.createListFromArray(arr3);
        int arr4[] = new int[]{1,2,3,4,5,6,7,8,9};
        ListNode list4 = l.createListFromArray(arr4);
        ListNode[] list = new ListNode[]{list1, list2, list3, list4};
        mergeKLists(list);

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();

        PriorityQueue<ListNode> pq
                = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b)
                    {
                        return a.val - b.val;
                    }
                });

        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(lists[i]);


        return result;
    }
}
