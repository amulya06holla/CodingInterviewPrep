package com.leet.uber.easy;

import com.leet.trees.TreeNode;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val==root.val || q.val==root.val) return root;
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor (root.right, p, q);
        }else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor (root.left, p, q);
        }else if((p.val>root.val && q.val<root.val) || (p.val<root.val && q.val>root.val)){
            return root;
        }
        return null;
    }
}
