package com.leet.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.createList();
        head = reverseList(head);
        l.printNodes(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode p1=null;
        ListNode p2=null;

        while(head!=null){
            p1=head;
            head=p1.next;
            p1.next=p2;
            p2=p1;
        }
        return p2;
    }
}
