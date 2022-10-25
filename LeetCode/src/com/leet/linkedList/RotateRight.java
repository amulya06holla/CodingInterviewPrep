package com.leet.linkedList;

public class RotateRight {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{1,2,3,4,5};
        ListNode list1 = l.createListFromArray(arr1);
        l.printNodes(list1);
        list1 = rotateRight(list1,10);
        l.printNodes(list1);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==0)
            return head;
        ListNode l = new ListNode();
        l.next = head; int count =0;

        ListNode prev =l;
        ListNode curr = l.next;
        ListNode temp = head;

        while(temp!=null){
            temp = temp.next;
            count++;
        }
        if(count==k){
            return head;
        }
        while(k>count){
            k=k-count;
        }
        count-=k;
        if(count==0){
            return head;
        }
        while(count!=0){
            prev = curr;
            curr = curr.next;
            count--;
        }
        l.next = curr;
        while(curr!=null && curr.next!=null){
            curr=curr.next;
        }
        curr.next = head;
        prev.next=null;

        return l.next;
    }
}
