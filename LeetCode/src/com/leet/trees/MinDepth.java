package com.leet.trees;

public class MinDepth {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = new TreeNode(2);
        root.left=null;
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);

        System.out.println(minDepth(root));
        //System.out.println(depthOfTreeNode(root,0,Integer.MIN_VALUE));

    }
    // NOTE: this is similar to find the height of the tree.. but cant just replace math.max with math.min
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1; // we are returning 1 only if it is leaf node.
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth); // NOTE: we are calling root.left recurrsively only when root.left!=null
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }

//    public static int depthOfTreeNode(TreeNode root, int level, int maxLevel){
//        if(root==null){
//            return 0;
//        }else if(root.left==null && root.right==null){
//            if(level>maxLevel){
//                maxLevel = level;
//            }
//            return maxLevel;
//        }
//        maxLevel= depthOfTreeNode(root.left, level+1, maxLevel);
//        maxLevel= depthOfTreeNode(root.right, level+1, maxLevel);
//        return maxLevel;
//    }

}
