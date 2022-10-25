package com.leet.LinkedIn.Hard;

import com.leet.trees.TreeNode;

import java.util.*;

//https://leetcode.com/problems/closest-binary-search-tree-value-ii/
public class ClosestKValues {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque <Integer> deque = new LinkedList<>();
        inorder(deque, root, target, k);
        return new ArrayList(deque);
    }

    // following inorder traversal to maintain the increasing order of the elements.
    // that way, we can be sure that elements are added in order into the dequeue.
    private void inorder(Deque<Integer> deque, TreeNode node, double target, int k) {
        if (node == null)
            return;
        inorder(deque, node.left, target, k);
        double val = Double.valueOf(node.val);
        if (deque.size() == k) {
            if (Math.abs(Double.valueOf(deque.peekFirst())-target) > Math.abs(val - target)) {
                deque.pollFirst();
                deque.addLast(node.val);
            } else return;
        } else {
            deque.addLast(node.val);
        }
        inorder(deque, node.right, target, k);
    }
}
