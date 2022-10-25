package com.leet.trees;

public class InorderSuccessor {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(5,3,6,1,4,null,null,null,2);
        TreeNode n = new TreeNode(4);
        TreeNode temp = inorderSuccessor(root, n);
        if(temp==null)
            System.out.println("null");
        else
            System.out.println(temp.val);
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                succ = root;   // when you go to the left of BST, only then there is a possiblity to find
                              // a value lesser than root but greater than p value.(successor)
                root = root.left;
            }
        }
        return succ;
    }

}
