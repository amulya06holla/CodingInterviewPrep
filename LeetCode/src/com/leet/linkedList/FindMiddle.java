package com.leet.linkedList;

public class FindMiddle {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.createList();
        head = middleNode(head);
        System.out.println(head.val);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
