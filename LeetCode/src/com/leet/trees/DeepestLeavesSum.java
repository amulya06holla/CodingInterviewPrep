package com.leet.trees;

import java.util.*;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int level = 0; int maxLevel=0; int sum=0;
        List<Integer> output = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null && !output.isEmpty()) {
                maxLevel = Math.max(level, maxLevel);
                if(level==maxLevel){
                    sum=0;
                    for(int i=0; i<output.size();i++){
                        sum = sum+output.get(i);
                    }
                }
                level++;
                output = new LinkedList<>();
                q.offer(null);
            } else {
                if (n != null) {
                    if (n.left != null) {
                        q.offer(n.left);
                    }
                    if (n.right != null) {
                        q.offer(n.right);
                    }
                    output.add(n.val);
                }
            }
        }
        return sum;
    }
}
