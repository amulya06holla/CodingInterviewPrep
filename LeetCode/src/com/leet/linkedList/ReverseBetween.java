package com.leet.linkedList;

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode l = new ListNode();
        int arr1[] = new int[]{5};
        ListNode list1 = l.createListFromArray(arr1);
        l.printNodes(list1);
        System.out.println("----------------------------------------");
        list1= reverseBetween(list1, 1, 1);
        l.printNodes(list1);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head; int count =0;
        ListNode n = new ListNode(-1);
        n.next=head;
        ListNode res=n;
        ListNode refLeft = n;
        ListNode refRight =n;
        while(temp!=null){
            count++;
            if(count<left){
                n.next=temp;
                n=n.next;
            }
            if(count==left){
                refLeft = temp;
            }
            if(count==right){

                refRight=temp.next;
                temp.next=null;
                break;
            }
            temp =temp.next;
        }
        ListNode rev= reverseList(refLeft);
        n.next=rev;
        while(rev.next!=null){
            rev=rev.next;
        }
        rev.next=refRight;


        return res.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode p1;
        ListNode p2=null;

        while(head!=null){
            p1=head;
            head=p1.next;
            p1.next=p2;
            p2=p1;
        }
        return p2;
    }
}
