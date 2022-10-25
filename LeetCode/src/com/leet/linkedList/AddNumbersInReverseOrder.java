package com.leet.linkedList;

import com.leet.linkedList.hard.ReverseKGroup;

public class AddNumbersInReverseOrder {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        ReverseKGroup grp = new ReverseKGroup();
        int arr1[] = new int[]{9,2,3};
        ListNode list1 = l.createListFromArray(arr1);
        int arr2[] = new int[]{6,7,8};
        ListNode list2 = l.createListFromArray(arr2);
        ListNode node = addTwoNumbers(list1, list2);
        l.printNodes(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
        int carry = 0;
        while(p!=null || q!=null){
            int x =0; int y=0; int sum =0;
            if(p!=null){
              x =p.val;
              p=p.next;
            }
            if(q!=null){
                y = q.val;
                q=q.next;
            }
            sum = carry+x+y;
            carry = sum/10;
            sum = sum%10;

            curr.next = new ListNode(sum);
            curr = curr.next;

        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}
