package com.leet.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MergeTrees {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root1 = tn.newTree(1,3,2,5);
        TreeNode root2 = tn.newTree(2,1,3,null,4,null,7);
        TreeNode printRoot= mergeTrees(root1, root2);
        tn.levelOrder(printRoot);
    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null)
                return root2;
            if (root2 == null)
                return root2;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
