package com.leet.intuit;

import com.leet.lists.ListNode;
public class MyCircularQueue {
    int size;
    ListNode head, tail;
    int currSize;
    public MyCircularQueue(int k) {
        size=k;
        currSize=0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        ListNode node = new ListNode(value);
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            tail.next= node;
            tail=node;
        }
        currSize++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;

        this.head = this.head.next;
        currSize--;
        return true;
    }

    public int Front() {
        if(!isEmpty()){
            return head.val;
        }
        return -1;
    }

    public int Rear() {
        if(!isEmpty()){
            return tail.val;
        }
        return -1;
    }

    public boolean isEmpty() {
        if(currSize==0) return true;
        return false;
    }

    public boolean isFull() {
        if(currSize==size) return true;
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        System.out.println(q.Rear());
        System.out.println(q.isFull());
        q.deQueue();
        q.enQueue(4);
        System.out.println(q.Rear());
    }
}
