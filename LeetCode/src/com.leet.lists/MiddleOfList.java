package com.leet.lists;

public class MiddleOfList {
    public static ListNode middleNode(ListNode head) {
        ListNode fast =head, slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
