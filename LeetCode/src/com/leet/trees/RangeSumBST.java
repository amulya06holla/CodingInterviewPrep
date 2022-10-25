package com.leet.trees;


public class RangeSumBST {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode root = tn.newTree(10,5,15,3,7,13,18,1,null,6);
        System.out.println(rangeSumBST(root,6,10));
    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        int res=0;
        res= calculateResult(root, low, high);
        return res;
    }
    private static int calculateResult(TreeNode root, int low, int high)
    {
        if (root == null)
            return 0;
        if(root.val>=low && root.val<=high) {
            return (root.val + calculateResult(root.left, low, high) +
                    calculateResult(root.right, low, high));
        }else{
            return (calculateResult(root.left, low, high) +
                    calculateResult(root.right, low, high));
        }
    }
}
