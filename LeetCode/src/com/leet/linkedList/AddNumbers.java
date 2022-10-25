package com.leet.linkedList;

import com.leet.linkedList.hard.ReverseKGroup;

// NOT COMPLETE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class AddNumbers {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ReverseKGroup grp = new ReverseKGroup();
        int arr1[] = new int[]{5,6,3};
        ListNode list1 = l.createListFromArray(arr1);
        int arr2[] = new int[]{8,4,2};
        ListNode list2 = l.createListFromArray(arr2);
        ListNode node = addTwoNumbersSameOrder(list1, list2);
        l.printNodes(node);
    }

    public static ListNode addTwoNumbersSameOrder(ListNode l1, ListNode l2) {

        ListNode n =null;
        return addNums(l1,l2,0, n);
    }

    public static ListNode addNums(ListNode l1, ListNode l2, int carry, ListNode n){
        ListNode curr = new ListNode(0);
        ListNode prev = curr;

        ListNode p = l1; ListNode q = l2;
        if(p.next!=null ||q.next!=null){
            if(p.next!=null){
                p= p.next;
            }
            if(q.next!=null){
                q=q.next;
            }
            addNums(p,q, carry,n);
            int x =0; int y=0;
            if(p!=null)
                x= p.val;
            if(q!=null)
                y=q.val;
            int sum = x+y+carry;
            carry = sum/10;
            sum = sum%10;
            prev = new ListNode(sum);
            prev.next= n;
        }
        return prev;
    }
}
