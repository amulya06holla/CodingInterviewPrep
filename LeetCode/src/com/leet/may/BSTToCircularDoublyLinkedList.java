package com.leet.may;

import java.util.Stack;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class BSTToCircularDoublyLinkedList {
    public static void main(String[] args) {

    }

    // iterative way of solving
    public Node treeToDoublyList(Node root) {
        if( root == null) return root;
        Node dummy = new Node(0);
        Node prev = dummy;
        Stack<Node> stack = new Stack();
        Node curr = root;

        while(!stack.isEmpty()|| curr != null){
            while(curr!= null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            prev.right = curr;
            curr.left = prev; // not sure why we are doing this!?
            prev = curr;
            curr = curr.right;
        }
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }

    //recursive way of solving
    Node first = null;
    Node last = null;

    public void helper(Node node) {
        if (node != null) {
            // left
            helper(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }
            else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;
            // right
            helper(node.right);
        }
    }

    public Node treeToDoublyListRec(Node root) {
        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }
}
