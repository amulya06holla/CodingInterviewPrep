package com.leet.linkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void printNodes(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
            if(head!=null)
                System.out.print("->");
        }
        System.out.println();
    }

    public ListNode createList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next= new ListNode(6);
        return head;
    }

    public ListNode createListFromArray(int[] arr) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for(int i=0; i<arr.length; i++){
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return temp.next;
    }
}
