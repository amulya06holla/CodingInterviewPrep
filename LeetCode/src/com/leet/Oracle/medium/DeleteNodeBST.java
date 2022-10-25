package com.leet.Oracle.medium;

import com.leet.trees.TreeNode;

//https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key) root.left= deleteNode(root.left,key);
        else if(root.val<key) root.right= deleteNode(root.right,key);
        else if(root.val==key){
            if(root.left==null && root.right==null) return null;
            if(root.left==null && root.right!=null) return root.right;
            if(root.right==null && root.left!=null) return root.left;
            if(root.right!=null && root.left!=null){
                root.val = findMin(root.right).val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    private TreeNode findMin(TreeNode root) {
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
