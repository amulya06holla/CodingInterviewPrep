package com.leet.lists;

public class MyHashSet {
        ListNode set = null;
        ListNode head = null;
        public MyHashSet() {
            set = new ListNode();
            head = new ListNode();
            set.next= head;
        }

        public void add(int key) {
            if(!contains(key)){
                ListNode temp = set.next.next;
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next= new ListNode();
                temp.next.val= key;
            }
        }

        public void remove(int key) {
            ListNode h = set.next;
            while(h!=null && h.next!=null){
                if(h.next.val==key){
                    ListNode temp = h.next.next;
                    h.next= temp;
                }
                h=h.next;
            }
        }

        public boolean contains(int key) {
            ListNode h = set.next;
            while(h!=null){
                if(h.val==key) return true;
                h=h.next;
            }
            return false;
        }

    public static void main(String[] args) {
        MyHashSet h = new MyHashSet();
        h.add(1);
        h.add(2);
        h.contains(1);
        h.contains(3);
        h.add(2);
        h.contains(2);
        h.remove(2);
        h.contains(2);
        h.add(1000000);
        System.out.println(h.contains(1000000));
    }
}
