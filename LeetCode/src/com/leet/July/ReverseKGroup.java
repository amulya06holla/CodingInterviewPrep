package com.leet.July;

class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }
        if (count == k) {
            ListNode reversedHead = this.reverse(head, k);
            head.next = this.reverseKGroup(temp, k);
            return reversedHead;
        }
        return head;
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
}
