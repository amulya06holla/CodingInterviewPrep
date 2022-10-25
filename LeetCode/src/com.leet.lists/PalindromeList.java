package com.leet.lists;

import java.util.Arrays;
import java.util.List;

public class PalindromeList {
    public static boolean isPalindrome(ListNode head) {
        ListNode mid = MiddleOfList.middleNode(head);
        ListNode secondHead = ReverseList.reverseList(mid);
        while(secondHead!=null && head!=null){
            if(secondHead.val!=head.val){
                return false;
            }
            secondHead = secondHead.next;
            head=head.next;
        }
        return true;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,1};
        ListNode l = new ListNode();
        List <Integer> arrList = Arrays.asList(arr);
        ListNode head = l.createList(arrList);
        l.printList(head);
        System.out.println(isPalindrome(head));;
    }
}
