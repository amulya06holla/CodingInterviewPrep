package com.leet.linkedList;

public class SwapNodes {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{90,100};
        ListNode list1 = l.createListFromArray(arr1);
        ListNode head = swapNodes(list1, 2);
        l.printNodes(head);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }

        int countEnd = count -k;
        count =0;
        ListNode tempStart = head;
        ListNode tempEnd = head;
        while(countEnd>0){
            tempEnd = tempEnd.next;
            countEnd--;
        }
        while(k-1>0){
            tempStart = tempStart.next;
            k--;
        }
        int t = tempStart.val;
        tempStart.val = tempEnd.val;
        tempEnd.val = t;

        return head;
    }

}
