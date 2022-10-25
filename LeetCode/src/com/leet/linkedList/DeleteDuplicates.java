package com.leet.linkedList;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.createList();
        l.printNodes(head);
        System.out.println("----------------------------------------");
        head= deleteDuplicates(head);
        l.printNodes(head);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp!=null){
            while(temp.next!=null&&temp.next.val==temp.val) {
                temp.next = temp.next.next;
            }
                temp = temp.next;
        }
        return head;
    }
}
