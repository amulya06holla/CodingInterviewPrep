package com.leet.lists;

public class ReverseList {
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
}
