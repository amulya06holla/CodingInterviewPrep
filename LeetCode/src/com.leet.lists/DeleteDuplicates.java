package com.leet.lists;

public class DeleteDuplicates {
        public ListNode deleteDuplicates(ListNode head){
            ListNode sentinal = new ListNode();
            sentinal.next=head;
            while(head!=null && head.next!=null){
                if( head.val==head.next.val){
                    ListNode temp = head.next.next;
                    head.next = temp;
                }else
                    head= head.next;
            }
            return sentinal.next;
        }
}
