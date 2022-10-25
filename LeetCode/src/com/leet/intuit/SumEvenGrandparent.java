package com.leet.intuit;

import com.leet.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class SumEvenGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        int result = 0;
        if(root == null)return result;
        if(root.left == null && root.right ==null)return 0;

        Queue <TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode node = q.poll();
                if(node.left !=null)q.offer(node.left);
                if(node.right !=null)q.offer(node.right);

                if(node.val%2 == 0){
                    if(node.left !=null){
                        if(node.left.left !=null ) result+=node.left.left.val;
                        if(node.left.right!=null) result+=node.left.right.val;

                    }
                    if(node.right!=null){
                        if(node.right.left !=null)result+=node.right.left.val;
                        if(node.right.right!=null)result+=node.right.right.val;

                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val= 6;
        node.left = new TreeNode();
        node.left.val = 7;
        node.left.left = new TreeNode();
        node.left.left.val = 2;
        node.left.right = new TreeNode();
        node.left.right.val = 7 ;
        node.right = new TreeNode();
    }
}
