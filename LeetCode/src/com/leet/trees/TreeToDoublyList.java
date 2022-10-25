package com.leet.trees;
//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

public class TreeToDoublyList {
    public static void main(String[] args) {
        Node n = new Node();
        //treeToDoublyList(root);
    }
    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inOrder(root);
        last.right = first;
        first.left = last;
        return first;
    }

    static Node first = null;
    static Node last = null;

    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            }
            else {
                first = node;
            }
            last = node;
            inOrder(node.right);
        }
    }
}
