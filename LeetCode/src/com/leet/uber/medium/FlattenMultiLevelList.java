package com.leet.uber.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
public class FlattenMultiLevelList {

    public Node flatten(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node curr, prev = pseudoHead;

        Deque <Node> stack = new ArrayDeque <>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null)
                stack.push(curr.next); // NOTE:::::::always put next pointer value first into the stack
            if (curr.child != null) {
                stack.push(curr.child); // always put child pointer value after next pointer value into stack
                // important!!!!!!!!!! don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        // detach the pseudo node from the result
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
}
