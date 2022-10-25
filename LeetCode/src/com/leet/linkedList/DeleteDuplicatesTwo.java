package com.leet.linkedList;

public class DeleteDuplicatesTwo {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{1,1};
        ListNode list1 = l.createListFromArray(arr1);
        l.printNodes(list1);
        System.out.println("----------------------------------------");
        list1= deleteDuplicates(list1);
        l.printNodes(list1);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next=head;
        ListNode prev = temp;
        ListNode curr = temp.next;
        while(curr!=null && curr.next!=null) {
            if (curr.val == curr.next.val){
                while (curr!=null && curr.next!=null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next= curr.next;
                curr = curr.next;
        }else {
                prev.next = curr;
                prev = prev.next;
                curr = curr.next;
            }
        }
        return temp.next;
    }
}
