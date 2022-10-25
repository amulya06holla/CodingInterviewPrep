package com.leet.linkedList;

public class Partition {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{2,1};
        ListNode list1 = l.createListFromArray(arr1);
        l.printNodes(list1);
        System.out.println("----------------------------------------");
        list1= partition(list1, 2);
        l.printNodes(list1);
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode temp = new ListNode(-1);
        temp.next=head;
        ListNode prev = temp;
        ListNode curr = temp.next;
        while(curr!=null && curr.val<x){
            prev.next = curr;
            prev=curr;
            curr = curr.next;
        }
        ListNode t = curr;

        while(curr!=null){
            if(curr.next!=null && curr.next.val<x) {
                prev.next = curr.next;
                prev = curr.next;
                curr.next=curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        prev.next=t;

        return temp.next;
    }
}
