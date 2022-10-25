package com.leet.uber.easy;

import com.leet.linkedList.ListNode;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false;
        if(head.next==null) return true;
        ListNode mid = findMid(head);
        ListNode rev = reverseList(mid);
        while( rev!=null){
            if(head.val!=rev.val) return false;
            rev = rev.next;
            head=head.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast =head, slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p1=null, p2=null;
        while(head!=null){
            p1=head;
            head = p1.next;
            p1.next=p2;
            p2=p1;
        }
        return p2;
    }
}
