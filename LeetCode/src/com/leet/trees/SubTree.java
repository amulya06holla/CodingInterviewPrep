package com.leet.trees;

public class SubTree {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root1 = tn.newTree(1,1);
        TreeNode root2 = tn.newTree(1);
        System.out.println(isSubtreeOfEachOther(root1, root2));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverse(root,subRoot );
    }

    public static boolean traverse(TreeNode s,TreeNode t) {
        return  s!=null && ( isSubtreeOfEachOther(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
    public static boolean isSubtreeOfEachOther(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        return root.val==subRoot.val && isSubtreeOfEachOther(root.left, subRoot.left) && isSubtreeOfEachOther(root.right, subRoot.right);
    }
}
