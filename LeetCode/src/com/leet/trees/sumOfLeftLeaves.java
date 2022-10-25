package com.leet.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class sumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(3,9,20,null,null,15,7);
       // System.out.println(sumOfLeftLeaves(root));
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int total = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode subRoot = stack.pop();
            // Check if the left node is a leaf node.
            if (isLeaf(subRoot.left)) {
                total += subRoot.left.val;
            }
            // If the right node exists, put it on the stack.
            if (subRoot.right != null) {
                stack.push(subRoot.right);
            }
            // If the left node exists, put it on the stack.
            if (subRoot.left != null) {
                stack.push(subRoot.left);
            }
        }

        return total;
    }
}
