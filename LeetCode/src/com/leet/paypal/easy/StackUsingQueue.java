package com.leet.paypal.easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    LinkedList<Integer> q;
    public StackUsingQueue() {
        q = new LinkedList();
    }

    public void push(int x) {
        q.addFirst(x);
    }

    public int pop() {
        if(!q.isEmpty())
            return q.pollFirst();
        return -1;
    }

    public int top() {
        return q.peekFirst();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
