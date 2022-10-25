package com.leet.lists;

import java.util.Arrays;
import java.util.List;

public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode ref = new ListNode();
        ref.next = head;
        revList(ref.next,reverseList(middleNode(head)));
    }
    public static ListNode middleNode(ListNode head) {
        ListNode fast =head, slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode p1 = null, p2=null;
        while(head!=null){
            p1=head;
            head=p1.next;
            p1.next=p2;
            p2=p1;
        }
        return p2;
    }
    private static ListNode revList(ListNode head, ListNode lastNode) {
        ListNode p1=head;
        while(lastNode!=null){
            ListNode tempHead = head.next;
            ListNode tempLast = lastNode.next;
            head.next = lastNode;
            lastNode =lastNode.next;
            head= tempHead.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4};
        ListNode l = new ListNode();
        List <Integer> arrList = Arrays.asList(arr);
        ListNode head = l.createList(arrList);
        l.printList(head);
        reorderList(head);;
        l.printList(head);
    }
}
