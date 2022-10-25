package com.leet.trees;

import java.util.*;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(1,null,2,3);
        List<Integer> nodes = preorderTraversal(root);
        System.out.println(Arrays.toString(nodes.toArray()));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res = preOrderTraversalRec(root, res);
        return res;
    }

    // refer https://stackoverflow.com/a/27886144 for recrrsive method explanation
    private static List<Integer> preOrderTraversalRec(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preOrderTraversalRec(root.left, res);
        preOrderTraversalRec(root.right,res);
        return res;
    }

    // iterative method of solving
    private static List<Integer> preOrderTraversalStack(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;

        res.add(root.val);
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return res;
    }

    // morris preorder
    public List<Integer> preorderTraversalMorris(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) { // same as inorder.
                res.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode pre = curr.left;
                while ((pre.right != null) && (pre.right != curr)) {
                    pre = pre.right;
                } // same as inorder

                if (pre.right == null) {
                    res.add(curr.val);
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }

}
