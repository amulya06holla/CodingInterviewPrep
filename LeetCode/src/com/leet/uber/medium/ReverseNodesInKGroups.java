package com.leet.uber.medium;

import com.leet.linkedList.ListNode;

public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head; int count =0;
        while(temp!=null && count!=k){
            temp = temp.next;
            count++;
        }
        if(count==k) {
            ListNode reverseHead=reverse(head, k);
            head.next = reverseKGroup(temp, k);
            return reverseHead;
        }
        return head;
    }

    public ListNode reverse(ListNode head, int k) {
        ListNode p1=null, p2=null;
        while(head!=null && k!=0){
            p1=head;
            head = p1.next;
            p1.next=p2;
            p2=p1;
            k--;
        }
        return p2;
    }
}
