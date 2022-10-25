package com.leet.uber.medium;

import com.leet.linkedList.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinal = new ListNode();
        ListNode res = new ListNode();
        sentinal.next=res;
        int carry=0;
        while(l1!=null || l2!=null){
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;
            int sum = (val1+val2+carry)%10;
            carry = (val1+val2+carry)/10;
            res.next = new ListNode(sum);
            res=res.next;
            l1=l1.next;
            l2=l2.next;
            l1=l1==null? l1: l1.next;
            l2=l2==null? l2: l2.next;
        }
        if(carry!=0) res.next = new ListNode(carry);
        return sentinal.next.next;
    }
}
