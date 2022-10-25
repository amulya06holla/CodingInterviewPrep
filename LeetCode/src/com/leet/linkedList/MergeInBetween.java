package com.leet.linkedList;

public class MergeInBetween {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{0,1,2,3,4,5};
        int arr2[] = new int[]{1000000,1000001,1000002};
        ListNode list1 = l.createListFromArray(arr1);
        ListNode list2 = l.createListFromArray(arr2);
        ListNode head =mergeInBetween(list1, 3,3,list2);
        l.printNodes(head);
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = new ListNode();
        ListNode curr = list1;
        res.next = list1;
        ListNode prev = res;
        int count =0;
        while(curr!=null){

            if(count==a){
                prev.next = list2;
                while(list2.next!=null){
                    list2 = list2.next;
                }
            }
            if(count==b){
                list2.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }
        return res.next;
    }
}
