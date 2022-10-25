package com.leet.dds;


import com.leet.trees.TreeNode;

/**
 *              10
 *             /  \
 *            1    5
 *           / \
 *          3   4
 */
//https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/603423/Python-Recursion-stack-thinking-process-diagram
public class BinaryTreeMaxPath {
    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0); // we want the sum to be positive. hence we are choosing between whatever is the sum or zero.
        int right_gain = Math.max(max_gain(node.right), 0);
        System.out.println(left_gain +" "+right_gain);
        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path. you have to consider either right subpath or left.
        // you cant choose both while u are in recurrsion.
        // for example in the diagram above, you can either consider 1+3 as the path or 1+4 path to add that to the above 10 parent.
        // you cant consider both to be in the path.
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
}
