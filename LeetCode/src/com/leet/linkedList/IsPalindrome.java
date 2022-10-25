package com.leet.linkedList;

import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{1,9,0};
        ListNode list1 = l.createListFromArray(arr1);
        l.printNodes(list1);
        System.out.println("----------------------------------------");
        System.out.println(isPalindrome(list1));
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode fast =head;
        ListNode slow = head;
        Stack<ListNode> s = new Stack<>();
        while(fast!=null){
            s.push(slow);
            if(fast.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
            }else{
                fast = fast.next;
            }

        }
        while(slow!=null){
            if(!s.isEmpty()&& s.pop().val!=slow.val){
                return false;
            }
            slow = slow.next;
        }
        if(!s.isEmpty())
            return false;
        return true;
    }
}
