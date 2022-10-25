package com.leet.lists;

import java.util.Arrays;
import java.util.List;

public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode sentinal = new ListNode();
        sentinal.next=res;
        while(list1!=null && list2!=null){
            if( list1.val<=list2.val){
                res.next= list1;
                list1=list1.next;
            }else{
                res.next=list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        while(list1!=null){
            res.next= list1;
            list1=list1.next;
            res =res.next;
        }
        while(list2!=null){
            res.next= list2;
            list2=list2.next;
            res =res.next;
        }
        return sentinal.next.next;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-9,3};
        Integer[] arr2= new Integer[]{5,7};
        ListNode l = new ListNode();
        List <Integer> arrList = Arrays.asList(arr);
        List <Integer> arrList2 = Arrays.asList(arr2);
        ListNode head = l.createList(arrList);
        ListNode head2 = l.createList(arrList2);
       // l.printList(head);
        //l.printList(head2);
        l.printList(mergeTwoLists(head, head2));;
    }
}
