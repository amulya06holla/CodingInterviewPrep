package com.leet.lists;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode createList(List <Integer> nodeVals){
        ListNode sentinal = new ListNode();
        ListNode head = new ListNode();
        sentinal.next = head;
        for(int nodeVal: nodeVals){
            head.next = new ListNode(nodeVal);
            head = head.next;
        }
        return sentinal.next.next;
    }

    public void printList(ListNode node){
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}
