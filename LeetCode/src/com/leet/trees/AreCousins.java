package com.leet.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/
public class AreCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean sameLevel=false;
        int parentx=-1, parenty=-1;

        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int level=0;
        List<Integer> output = new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n==null && !output.isEmpty()){
                // System.out.println(Arrays.toString(output.toArray())+" level="+level++);
                if(output.contains(x) && output.contains(y)){
                    sameLevel = true;
                    break;
                }
                output = new LinkedList<>();
                q.offer(null);
            }
            else{
                if(n!=null) {
                    if (n.left != null) {
                        q.offer(n.left);
                        if(n.left.val==x) parentx = n.val;
                        if(n.left.val==y) parenty = n.val;
                    }
                    if (n.right != null) {
                        q.offer(n.right);
                        if(n.right.val==x) parentx = n.val;
                        if(n.right.val==y) parenty = n.val;
                    }
                    output.add(n.val);
                }
            }
        }
        if(sameLevel && parentx!=parenty) return true;
        return false;
    }
}
