package com.leet.trees;

import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathSums {

    //https://leetcode.com/problems/binary-tree-paths/
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        rootToLeafPathsSum(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void rootToLeafPathsSum(TreeNode root, int sum, int targetSum, List<Integer> list, List<List<Integer>> res) {
        if(root==null) return;
        sum= sum+root.val;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                res.add(list);
            }
        }
        rootToLeafPathsSum(root.left, sum, targetSum, new ArrayList<>(list), res);
        rootToLeafPathsSum(root.right, sum, targetSum, new ArrayList<>(list), res);
    }

    //https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum = targetSum-root.val;
        if(root.left==null && root.right==null)
            return targetSum == 0;
        return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);

    }



    //https://leetcode.com/problems/path-sum-iii/solution/
    class Solution {
        int count = 0;
        int k;
        HashMap <Integer, Integer> h = new HashMap();

        public void preorder(TreeNode node, int currSum) {
            if (node == null)
                return;

            // current prefix sum
            currSum += node.val;

            // here is the sum we're looking for
            if (currSum == k)
                count++;

            // number of times the curr_sum − k has occured already,
            // determines the number of times a path with sum k
            // has occured upto the current node
            count += h.getOrDefault(currSum - k, 0);

            // add the current sum into hashmap
            // to use it during the child nodes processing
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);

            // process left subtree
            preorder(node.left, currSum);
            // process right subtree
            preorder(node.right, currSum);

            // remove the current sum from the hashmap
            // in order not to use it during
            // the parallel subtree processing
            h.put(currSum, h.get(currSum) - 1);
        }

        public int pathSum(TreeNode root, int sum) {
            k = sum;
            preorder(root, 0);
            return count;
        }
    }
    //https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/1149742/Java-Code-oror-1ms-oror-Prefix-Sum-Technique


}
