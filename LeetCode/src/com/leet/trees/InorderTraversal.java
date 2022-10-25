package com.leet.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(1,null,2,3);
        List<Integer> nodes = inorderTraversal(root);
        System.out.println(Arrays.toString(nodes.toArray()));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return inOrderRec(root, list);
    }

    private static List<Integer> inOrderRec(TreeNode root, List<Integer> list) {
        if(root==null) return list;
        inOrderRec(root.left,list);
        list.add(root.val);
        inOrderRec(root.right,list);
        return list;
    }

    public List < Integer > inorderTraversalIterative(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // Morris tree : it is based on threaded binary tree concept.

    public List < Integer > inorderTraversalMorris(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            // there can be only 2 cases. either the left child is null or it is not null.
            if (curr.left == null) {
                res.add(curr.val); /////////////This is where the value gets printed or gets added to output list.
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

}
