package com.leet.uber.easy;

import com.leet.linkedList.ListNode;
//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinal = new ListNode(-1);
        ListNode res = new ListNode(-1);
        sentinal.next = res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                res.next=l1;
                l1 = l1.next;
            }else{
                res.next=l2;
                l2 = l2.next;
            }
            res=res.next;
        }
        while(l1!=null){
            res.next=l1;
            l1=l1.next;
            res = res.next;
        }
        while(l2!=null){
            res.next=l2;
            l2=l2.next;
            res = res.next;
        }
        return sentinal.next.next;
    }
}
