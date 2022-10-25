package com.leet.trees;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val|| root.val==q.val) return root;
        TreeNode leftLCA = lowestCommonAncestorBT(root.left, p , q);
        TreeNode rightLCA = lowestCommonAncestorBT(root.right, p , q);
        if(leftLCA!=null && rightLCA!=null) return root;
        if(leftLCA!=null) return leftLCA;
        if(rightLCA!=null) return rightLCA;
        return null;
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestorBST(root.right, p, q);
        }else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestorBST(root.left, p, q);
        }else if(p.val==root.val || q.val==root.val){
            return root;
        }else if((p.val>root.val && q.val<root.val)||(p.val<root.val && q.val>root.val)){
            return root;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(nodes!=null && nodes.length==1) return nodes[0];
        return findLca4(root, nodes);
    }

    private TreeNode findLca4(TreeNode root, TreeNode[] nodes) {
        if(root==null) return null;
        for(int i=0; i<nodes.length; i++)
            if(root.val==nodes[i].val) return root;
        TreeNode leftLCA = findLca4(root.left, nodes);
        TreeNode rightLCA = findLca4(root.right, nodes);
        if(leftLCA!=null && rightLCA!=null) return root;
        if(leftLCA!=null) return leftLCA;
        if(rightLCA!=null) return rightLCA;
        return null;
    }

    ////https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
    public Node lowestCommonAncestor(Node p, Node q) {
        Set <Integer> visited = new HashSet <>(); // USE SET: BCZ ITS LOOKUP COMPEXITY IS O(1)
        Node node = p;
        while(node!=null){
            visited.add(node.val);
            node = node.parent;
        }
        node = q;
        while(node!=null){
            if(visited.contains(node.val))
                return node;
            node=node.parent;
        }
        return null;
    }

}
