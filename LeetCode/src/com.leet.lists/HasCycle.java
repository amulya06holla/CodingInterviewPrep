package com.leet.lists;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode f = head, s =head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
            if(s==f) return true;
        }
        return false;
    }
}
