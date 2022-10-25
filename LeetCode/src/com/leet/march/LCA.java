package com.leet.march;

import com.leet.trees.TreeNode;
import com.leet.trees.TreesPractise;

public class LCA {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(3,5,1,6,2,0,8,null,null,7,4);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p|| root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null && right!=null) return right;
        if(left!=null && right==null) return left;
        if(left!=null && right!=null) return root;
        return null;
    }
}
