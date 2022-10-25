package com.leet.trees;

import java.util.*;

public class PostOrderTraversal {
    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return postOrderTraversalRec(root, res);
    }

    private static List<Integer> postOrderTraversalRec(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        postOrderTraversalRec(root.left, res);
        postOrderTraversalRec(root.right,res);
        res.add(root.val);
        return res;
    }
    // iterative method of solving
    private static List<Integer> postOrderTraversalStack(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;

        res.add(root.val);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val); // this solution is same as preordertraversal. but (addFIRST) here we are adding the values to the front of the list.
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right); // ALSO, WE ARE ADDING LEFT AND THEN RIGHT ELEMENTS INTO THE STACK WHICH IS OPPOSITE IN PREORDER
            }
        }
        return res;
    }

}
