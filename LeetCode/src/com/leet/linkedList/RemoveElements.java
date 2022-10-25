package com.leet.linkedList;

/**
 * NOTE: KEEP PREV AND CURR NODE REFERENCE FOR THIS KIND OF PROBLEMS.
 * ALSO KEEP A TEMP NODE WHICH ACTS AS THE BEGINNING AND REMAINS IN THE BEGINNING. THIS WILL HELP TO REMOVE THE VALUES WHEN THE VALUES ARE THE HEAD NODE.
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.createList();
        l.printNodes(head);
        head = removeElements(head,6);
        l.printNodes(head);
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode();
        temp.next=head;
        ListNode curr = head;
        ListNode prev=temp;
        while(curr!=null){
            if(curr.val==val){
                prev.next=curr.next;
            }
            else
                prev=curr;
            curr=curr.next;
        }
        return temp.next;
    }
}
