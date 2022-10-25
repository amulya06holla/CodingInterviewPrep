package com.leet.linkedList;

/**
 * NOTE: you need to keep a dummy object in the begining of the node in the tempHead that is taken to return.
 * so that when the first object has to be removed, it becomes easier.
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode t = removeNthFromEnd(head,2);
        t.printNodes(t);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(); int count =0;
        tempHead.next=head;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        temp=tempHead;
        int removenode=count-n;
        while(removenode>0){
            removenode--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return tempHead.next;
    }

}
