package com.leet.weeklyChallenge.Nov13;

import com.leet.linkedList.ListNode;

public class ReverseInEvenGroups {
    public static void main(String[] args) {
        ReverseInEvenGroups r = new ReverseInEvenGroups();
        ListNode head = new ListNode(5);
         head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(1);

        r.printNodes(r.reverseEvenLengthGroups(head));
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) return null;
        ListNode curr = head, temp=head;
        ListNode sentinal = new ListNode();
        sentinal.next = curr;

        int i=0, j=1;
        while(temp!=null){
            while(temp!=null && i!=j){
                if(j%2!=0){
                    temp = temp.next;
                    i++;
                }else{

                }
            }
        }
        return sentinal.next;
    }

    public ListNode reverse(ListNode head, int k){
        ListNode p1=null, p2=null;
        while(head!=null && k!=0){
            p1=head;
            head = p1.next;
            p1.next=p2;
            p2=p1;
            k--;
        }
        return p2;
    }

    public void printNodes(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
            if(head!=null)
                System.out.print("->");
        }
        System.out.println();
    }
}
