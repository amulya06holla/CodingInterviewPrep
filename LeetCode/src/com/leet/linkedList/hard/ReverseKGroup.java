package com.leet.linkedList.hard;

import com.leet.linkedList.ListNode;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ReverseKGroup grp = new ReverseKGroup();
        int arr1[] = new int[]{1,2,3,4,5,6};
        ListNode list1 = l.createListFromArray(arr1);
        ListNode res = grp.reverseKGroup(list1, 3);
        l.printNodes(res);
    }
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode p2 = null;
        ListNode p1 = null;
        while (k > 0) {
            p1 = head;
            head = p1.next;
            p1.next = p2;
            p2 = p1;
            k--;
        }
        return p2;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode temp = head;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }
        if (count == k) {
            ListNode reversedHead = this.reverseLinkedList(head, k);
            head.next = this.reverseKGroup(temp, k);
            return reversedHead;
        }
        return head;
    }
}
