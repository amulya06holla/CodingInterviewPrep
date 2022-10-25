package com.leet.trees;
//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
public class SecondMinValue {
    public int secondMin = Integer.MAX_VALUE;
    public int firstMin = Integer.MAX_VALUE;
    public boolean found = false;
    public int findSecondMinimumValue(TreeNode root) {
        findSecondMin(root);
        if (!found) return -1;
        return secondMin;
    }

    public void findSecondMin(TreeNode root){
        if(root!=null){
            firstMin= Math.min(firstMin, root.val);
            if(firstMin!=Integer.MAX_VALUE && root.val!=firstMin){
                if(root.val<=secondMin){
                    secondMin = root.val;
                    found=true;
                }
            }
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
    }
}
