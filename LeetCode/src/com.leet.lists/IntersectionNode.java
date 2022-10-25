package com.leet.lists;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        if(len1>len2){
            int d = len1-len2;
            while(d!=0){
                headA= headA.next;
                d--;
            }
            while(headA!=headB){
                headA= headA.next;
                headB=headB.next;
            }
            res = headA;
        }else if(len2>len1){
            int d = len2-len1;
            while(d!=0){
                headB= headB.next;
                d--;
            }
            while(headA!=headB){
                headA= headA.next;
                headB=headB.next;
            }
            res = headA;
        }
        return res;
    }

    private int getLen(ListNode h) {
        int c =0;
        while(h!=null){
            c++;
            h=h.next;
        }
        return c;
    }

    public static void main(String[] args) {

    }
}
