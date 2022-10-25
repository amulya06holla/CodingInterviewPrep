package com.leet.Oracle.easy;

import com.leet.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasSum(root, targetSum, 0);
    }

    private boolean hasSum(TreeNode root, int targetSum, int currSum) {
        if(root==null) return false;
        currSum = currSum+root.val;
        if(root.right==null && root.left==null && currSum==targetSum) return true;
        System.out.println(currSum+ " "+root.val);
        return hasSum(root.left, targetSum, currSum) || hasSum(root.right, targetSum, currSum);
    }

    public List<List <Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        hasSumPath(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }

    private void hasSumPath(TreeNode root, int targetSum, int currSum, List<List<Integer>> result, List<Integer> currList) {
        if(root==null) return;
        currSum = currSum+root.val;
        currList.add(root.val);
        if(root.left==null && root.right==null && targetSum==currSum){
            result.add(currList);
        }
        hasSumPath(root.left, targetSum, currSum, result,new ArrayList <>(currList));
        hasSumPath(root.right, targetSum, currSum, result,new ArrayList <>(currList));
    }

}
