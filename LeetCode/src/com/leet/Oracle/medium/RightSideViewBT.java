package com.leet.Oracle.medium;

import com.leet.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/solution/
public class RightSideViewBT {
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> res =new ArrayList <>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            int val=0;
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                val = node.val;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            res.add(val);
        }
        return res;
    }
}
